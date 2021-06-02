import { EventControllerApi, FullContestDto as FullContest, FullEventDto as FullEvent, SimpleEventDto as SimpleEvent } from "@/openapi/generated/api";
import { action, createModule, createProxy, mutation } from "vuex-class-component";
import { UserStore } from "./userStore.vuex";

interface FilterType {
    titleContains?: string;
    descriptionContains?: string;
    startsBefore?: string;
    startsAfter?: string;
    endsBefore?: string;
    endsAfter?: string;
    organizerId?: number;
}

const VuexModule = createModule({
    namespaced: "events",
    strict: false
});

export class EventsStore extends VuexModule {
    private events: SimpleEvent[] = [];
    private filter = {} as FilterType;
    private contests: FullContest[] = [];
    private details: FullEvent | null = null;

    get list(): SimpleEvent[] {
        return this.events;
    }

    get eventContests(): FullContest[] {
        return this.contests;
    }

    get eventDetails(): FullEvent | null {
        return this.details;
    }

    private get controller(): EventControllerApi {
        return new EventControllerApi({
            accessToken: createProxy(this.$store, UserStore).token || "",
            isJsonMime: () => true
        });
    }

    @action
    async fetch(): Promise<void> {
        const fetchResponse = await this.controller.findAll(...this.filterAsArray);
        this.events = fetchResponse.data.elements || [];
    }

    private get filterAsArray(): Parameters<EventControllerApi["findAll"]> {
        return [
            this.filter.titleContains,
            this.filter.descriptionContains,
            this.filter.startsBefore,
            this.filter.startsAfter,
            this.filter.endsBefore,
            this.filter.endsAfter,
            this.filter.organizerId,
            0
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
}
