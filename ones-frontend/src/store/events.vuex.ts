import { EventControllerApi, FullContestDto as FullContest, FullEventDto as FullEvent, SimpleEventDto as SimpleEvent } from "@/openapi/generated/api";
import { action, createModule, createProxy, mutation } from "vuex-class-component";
import { UserStore } from "./userStore.vuex";
import { Paginateable } from "@/components/pagination/paginateable";
import { Sortable } from "@/components/table/sortable";

interface FilterType extends Record<string, string | boolean | string[] | undefined> {
    from?: string;
    until?: string;
    isCountryChampionship?: boolean;
    isInternational?: boolean;
    isCard?: boolean;
    regions: string[];
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
    private filter = {} as FilterType;
    private contests: FullContest[] = [];
    private details: FullEvent | null = null;
    private _totalCount = 0;
    private selectedPage = FirstPage;
    private selectedPageSize = 10;
    private selectedSortCriterion: keyof SimpleEvent = "start";
    private selectedSortDirection: SortDirection = SortDirection.Ascending;
    private _selectedContest: string | null = null;

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

    private get controller(): EventControllerApi {
        return new EventControllerApi({
            accessToken: createProxy(this.$store, UserStore).token || "",
            isJsonMime: () => true
        });
    }

    @action
    async fetch(): Promise<void> {
        const fetchResponse = await this.controller.findAll(...this.optionsAsArray);
        this.events = fetchResponse.data.elements || [];
        this._totalCount = fetchResponse.data.totalElements || 0;
    }

    private get optionsAsArray(): Parameters<EventControllerApi["findAll"]> {
        return [
            this.filter.from,
            this.filter.until,
            this.filter.isCountryChampionship,
            this.filter.isInternational,
            this.filter.isCard,
            this.filter.regions,
            this.selectedPage,
            this.selectedPageSize,
            this.selectedSortCriterion,
            this.selectedSortDirection
        ];
    }

    @action
    async addFilter(modification: FilterType): Promise<void> {
        const newFilter = Object.assign({}, this.filter);
        for (const [key, value] of Object.entries(modification)) {
            newFilter[key as keyof FilterType] = value;
        }
        this.filter = newFilter;
        await this.fetch();
    }

    @mutation
    removeFilter(...filterPropsToClear: Array<keyof FilterType>): void {
        for (const filterProp of filterPropsToClear) {
            this.filter[filterProp] = undefined;
        }
    }

    @action
    private async fetchContestsOf(eventId: string): Promise<void> {
        const response = await this.controller.getFullContests(eventId);
        this.contests = response.data;
    }

    @action
    private async fetchDetailsOf(eventId: string): Promise<void> {
        const response = await this.controller.getFullEvent(eventId);
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
        await this.controller.signUp(payload.contestUuid, payload);
    }

    @mutation
    selectContest(contestId: string | null): void {
        this._selectedContest = contestId;
    }
}
