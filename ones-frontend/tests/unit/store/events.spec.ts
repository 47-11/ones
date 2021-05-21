import { ContestDto as Contest, ContestDtoContestTypeEnum, EventDetailDto, EventDto as Event } from "@/openapi/generated";
import { EventsStore } from "@/store/events.vuex";
import { UserStore } from "@/store/userStore.vuex";
import { createLocalVue } from "@vue/test-utils";
import axios from "axios";
import Vuex, { Store } from "vuex";
import { clearProxyCache, createProxy, extractVuexModule } from "vuex-class-component";
import { ProxyWatchers } from "vuex-class-component/dist/interfaces";

jest.mock("axios");

describe("Events-Store", () => {
    let store: Store<unknown>;
    let eventsStore: EventsStore & ProxyWatchers;
    let axiosMock: jest.Mocked<typeof axios>;
    let localVue;

    beforeEach(() => {
        localVue = createLocalVue();
        localVue.use(Vuex);
        store = new Vuex.Store({
            modules: {
                ...extractVuexModule(EventsStore),
                ...extractVuexModule(UserStore)
            }
        });

        eventsStore = createProxy(store, EventsStore);
        axiosMock = axios as jest.Mocked<typeof axios>;

        axiosMock.request.mockReset();
    });

    afterEach(() => {
        clearProxyCache(EventsStore);
    });

    it("fetches events unfiltered", async () => {
        axiosMock.request.mockResolvedValue({ data: [] as Event[] });

        await eventsStore.fetch();

        expect(axiosMock.request).toHaveBeenCalledWith(expect.objectContaining({ url: "/api/v1/event" }));
    });

    it("fetches events filtered", async () => {
        axiosMock.request.mockResolvedValue({ data: [] as Event[] });
        eventsStore.addFilter({
            titleContains: "Olympic games",
            organizerId: 42
        });

        await eventsStore.fetch();

        expect(axiosMock.request).toHaveBeenCalledWith(expect.objectContaining({
            url: "/api/v1/event?titleContains=Olympic+games&organizerId=42"
        }));
    });

    it("lists fetched events", async () => {
        const events = [
            { uuid: "42", title: "Olympic games" },
            { uuid: "43", title: "Paralympics" }
        ] as Event[];
        axiosMock.request.mockResolvedValue({
            data: events
        });

        await eventsStore.fetch();

        expect(eventsStore.list).toEqual(events);
    });

    it("fetches an events contests", async () => {
        const contests = [
            { contestType: ContestDtoContestTypeEnum.Mdr },
            { contestType: ContestDtoContestTypeEnum.Efr }
        ] as Contest[];
        axiosMock.request.mockResolvedValue({
            data: contests
        });
        const eventId = "5";

        const fetchedContests = await eventsStore.getContestsOf(eventId);

        expect(axiosMock.request).toHaveBeenCalledWith(expect.objectContaining({
            url: `/api/v1/event/${eventId}/contests`
        }));
        expect(fetchedContests).toEqual(contests);
    });

    it("fetches an events details", async () => {
        const details = {
            organizerName: "Olympic committee"
        } as EventDetailDto;
        axiosMock.request.mockResolvedValue({
            data: details
        });
        const eventId = "5";

        const fetchedContests = await eventsStore.getDetailsOf(eventId);

        expect(axiosMock.request).toHaveBeenCalledWith(expect.objectContaining({
            url: `/api/v1/event/${eventId}`
        }));
        expect(fetchedContests).toEqual(details);
    });
});
