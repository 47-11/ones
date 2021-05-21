import { action, createModule, createProxy, mutation } from "vuex-class-component";
import { ContestDto as Contest, EventControllerApi, EventDetailDto as EventDetail, EventDto as Event } from "@/openapi/generated/api";
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
    private events: Event[] = [];
    private filter = {} as FilterType;

    get list(): Event[] {
        return this.events;
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
        this.events = fetchResponse.data;
    }

    private get filterAsArray(): Parameters<EventControllerApi["findAll"]> {
        return [
            this.filter.titleContains,
            this.filter.descriptionContains,
            this.filter.startsBefore,
            this.filter.startsAfter,
            this.filter.endsBefore,
            this.filter.endsAfter,
            this.filter.organizerId
        ];
    }

    @mutation
    addFilter(modification: FilterType): void {
        const newFilter = Object.assign({}, this.filter);
        for (const [key, value] of Object.entries(modification)) {
            newFilter[key as keyof FilterType] = value;
        }
        this.filter = newFilter;
    }

    @mutation
    removeFilter(...filterPropsToClear: Array<keyof FilterType>): void {
        for (const filterProp of filterPropsToClear) {
            this.filter[filterProp] = undefined;
        }
    }

    @action
    async getContestsOf(eventId: string): Promise<Contest[]> {
        return (await this.controller.getContests(eventId)).data;
    }

    @action
    async getDetailsOf(eventId: string): Promise<EventDetail> {
        return (await this.controller.getDetails(eventId)).data;
    }
}
