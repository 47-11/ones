import { Paginateable } from "@/components/pagination/paginateable";
import { Sortable } from "@/components/table/sortable";
import { ContestCategory, EventControllerApi, FullContestDto as FullContest, FullEventDto as FullEvent, SimpleEventDto as SimpleEvent } from "@/openapi/generated/api";
import { getApi } from "@/store/api";
import moment from "moment";
import { action, createModule, mutation } from "vuex-class-component";

export interface FilterType extends Record<string, string | boolean | string[] | undefined> {
    from: string;
    until?: string;
    isCountryChampionship?: boolean;
    isInternational?: boolean;
    isCard?: boolean;
    regions: string[];
    categories: string[],
    alreadySignedUp?: boolean
}

export enum SortDirection {
    Ascending = "ASCENDING",
    Descending = "DESCENDING"
}

export const FirstPage = 0;

const VuexModule = createModule({
    namespaced: "events",
    strict: false
});

export class EventsStore extends VuexModule implements Paginateable, Sortable {
    private events: SimpleEvent[] = [];
    private _filter: FilterType = { from: moment().toISOString(), categories: [], regions: [] };
    private contests: FullContest[] = [];
    private details: FullEvent | null = null;
    private _totalCount = 0;
    private selectedPage = FirstPage;
    private selectedPageSize = 10;
    private selectedSortCriterion: keyof SimpleEvent = "start";
    private selectedSortDirection: SortDirection = SortDirection.Ascending;
    private _selectedContest: string | null = null;
    private _categories: ContestCategory[] = [];
    private _regions: string[] = [];
    private dynamicOptionsFetched = false;
    private loadingCounter = 0;

    get isLoading(): boolean {
        return this.loadingCounter > 0;
    }

    get list(): SimpleEvent[] {
        return this.events;
    }

    get eventContests(): FullContest[] {
        return this.contests;
    }

    get eventDetails(): FullEvent | null {
        return this.details;
    }

    get page(): number {
        return this.selectedPage;
    }

    get pageSize(): number {
        return this.selectedPageSize;
    }

    get sortCriterion(): keyof SimpleEvent {
        return this.selectedSortCriterion;
    }

    get sortDirection(): SortDirection {
        return this.selectedSortDirection;
    }

    get totalElementCount(): number {
        return this._totalCount;
    }

    get hasNextPage(): boolean {
        return this.selectedPage + 1 < this.pageCount;
    }

    get hasPrevPage(): boolean {
        return this.selectedPage > 0;
    }

    get pageCount(): number {
        return Math.ceil(this.totalElementCount / this.selectedPageSize);
    }

    get firstElementIndex(): number {
        return this.selectedPage * this.selectedPageSize;
    }

    get lastElementIndex(): number {
        return this.firstElementIndex + this.list.length - 1;
    }

    get selectedContest(): FullContest | null {
        return this.contests.find(contest => contest.uuid === this._selectedContest) || null;
    }

    get categories(): ContestCategory[] {
        return this._categories;
    }

    get regions(): string[] {
        return this._regions;
    }

    get filter(): FilterType {
        return this._filter;
    }

    @action
    async fetch(): Promise<void> {
        this.loadingCounter++;
        await this.assureDynamicOptionsFetched();
        const fetchResponse = await getApi().events.findAll(...await this.optionsAsArray);
        this.events = fetchResponse.data.elements || [];
        this._totalCount = fetchResponse.data.totalElements || 0;
        this.loadingCounter--;
    }

    @action
    private async assureDynamicOptionsFetched(): Promise<void> {
        if (!this.dynamicOptionsFetched) {
            await this.fetchDynamicOptions();
            this.modifyFilter({
                regions: this.regions,
                // eslint-disable-next-line @typescript-eslint/no-non-null-assertion
                categories: this.categories.map(category => category.code!)
            });
        }
    }

    private get optionsAsArray(): Parameters<EventControllerApi["findAll"]> {
        return [
            this._filter.from.substring(0, 10),
            this._filter.until?.substring(0, 10),
            this._filter.regions,
            this._filter.categories,
            this._filter.isCard,
            this._filter.isCountryChampionship,
            this._filter.isInternational,
            this._filter.alreadySignedUp,
            this.selectedPage,
            this.selectedPageSize,
            this.selectedSortCriterion,
            this.selectedSortDirection
        ];
    }

    @action
    async addFilter(modification: Partial<FilterType>): Promise<void> {
        this.modifyFilter(modification);
        await this.fetch();
    }

    @mutation
    private modifyFilter(modification: Partial<FilterType>): void {
        const newFilter = Object.assign({}, this._filter);
        for (const [key, value] of Object.entries(modification)) {
            newFilter[key as keyof FilterType] = value;
        }
        this._filter = newFilter;
    }

    @action
    async resetFilter(): Promise<void> {
        this._filter = {
            from: moment().toISOString(),
            // eslint-disable-next-line @typescript-eslint/no-non-null-assertion
            categories: this.categories.map(c => c.code!),
            regions: this.regions
        };
        await this.fetch();
    }

    @action
    async removeFilter(...filterPropsToClear: Array<keyof FilterType>): Promise<void> {
        if (this._filter) {
            for (const filterProp of filterPropsToClear) {
                this._filter[filterProp] = undefined;
            }
        }
        await this.fetch();
    }

    @action
    public async resetCategories(): Promise<void> {
        // eslint-disable-next-line @typescript-eslint/no-non-null-assertion
        await this.addFilter({ categories: this.categories.map(c => c.code!) });
    }

    @action
    public async resetRegions(): Promise<void> {
        // eslint-disable-next-line @typescript-eslint/no-non-null-assertion
        await this.addFilter({ regions: this.regions });
    }

    @action
    private async fetchContestsOf(eventId: string): Promise<void> {
        const response = await getApi().events.getFullContests(eventId);
        this.contests = response.data;
    }

    @action
    private async fetchDetailsOf(eventId: string): Promise<void> {
        const response = await getApi().events.getFullEvent(eventId);
        this.details = response.data;
    }

    @action
    async fetchEvent(eventId: string): Promise<void> {
        await Promise.all([
            this.fetchContestsOf(eventId),
            this.fetchDetailsOf(eventId)
        ]);
    }

    @action
    async selectPage(page: number): Promise<void> {
        this.selectedPage = page;
        await this.fetch();
    }

    @action
    async nextPage(): Promise<void> {
        await this.selectPage(this.selectedPage + 1);
    }

    @action
    async prevPage(): Promise<void> {
        await this.selectPage(this.selectedPage - 1);
    }

    @action
    async selectPageSize(pageSize: number): Promise<void> {
        this.selectedPageSize = pageSize;
        await this.fetch();
    }

    @action
    async sortBy(criterion: keyof SimpleEvent): Promise<void> {
        this.selectedPage = FirstPage;
        this.selectedSortCriterion = criterion;
        await this.fetch();
    }

    @action
    async sortInDirection(direction: SortDirection): Promise<void> {
        this.selectedPage = FirstPage;
        this.selectedSortDirection = direction;
        await this.fetch();
    }

    @action
    async toggleSortDirection(): Promise<void> {
        this.selectedPage = FirstPage;

        this.selectedSortDirection = this.selectedSortDirection === SortDirection.Ascending
            ? SortDirection.Descending
            : SortDirection.Ascending;

        await this.fetch();
    }

    @action
    async signUp(payload: { contestUuid: string, horseUuids: string[] }): Promise<void> {
        await getApi().events.signUp(payload.contestUuid, payload);
    }

    @mutation
    selectContest(contestId: string | null): void {
        this._selectedContest = contestId;
    }

    @action
    private async fetchDynamicOptions(): Promise<void> {
        await Promise.all([
            this.fetchCategories(),
            this.fetchRegions()
        ]);
        this.dynamicOptionsFetched = true;
    }

    @action
    private async fetchCategories(): Promise<void> {
        const response = await getApi().events.getAllCategories();
        this._categories = response.data || [];
    }

    @action
    private async fetchRegions(): Promise<void> {
        const response = await getApi().events.getAllRegions();
        this._regions = response.data || [];
    }
}
