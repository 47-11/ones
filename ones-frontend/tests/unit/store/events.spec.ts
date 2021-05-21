import { FullContestDto as FullContest, FullContestDtoContestTypeEnum, FullEventDto as FullEvent, SimpleEventDto as SimpleEvent } from "@/openapi/generated";
import { BASE_PATH } from "@/openapi/generated/base";
import { EventsStore } from "@/store/events.vuex";
import { UserStore } from "@/store/userStore.vuex";
import { createLocalVue } from "@vue/test-utils";
import axios from "axios";
import Vuex, { Store } from "vuex";
import { createProxy, extractVuexModule } from "vuex-class-component";
import { ProxyWatchers, VuexModuleConstructor, VuexModule } from "vuex-class-component/dist/interfaces";

jest.mock("axios");

const url = (path: string) => {
    return expect.objectContaining({
        url: `${BASE_PATH}/api/v1/${path.trim()}`
    });
};

/**
 * This function is used to clear the proxy cache of the handed vuex module
 * to prevent the reuse of a vuex store between the tests.
 * Unfortunately, the original clearProxyCache function has no implementation.
 * This implementation was taken from
 * https://github.com/Glandos/vuex-class-component/commit/a22dd89513b7f292cd3e62cd3883da1316938963
 * A corresponding issue has been opened at
 * https://github.com/michaelolof/vuex-class-component/issues/101
 * @param cls The vuex module to clear the cache for.
 */
function clearProxyCache<T extends typeof VuexModule>(cls: T) {
    // eslint-disable-next-line @typescript-eslint/ban-ts-comment
    // @ts-ignore
    const VuexClass = cls as VuexModuleConstructor;
    delete VuexClass.prototype.__vuex_module_cache__;
    delete VuexClass.prototype.__vuex_proxy_cache__;
    delete VuexClass.prototype.__store_cache__;
    delete VuexClass.prototype.__vuex_local_proxy_cache__;
    for (const submodule of Object.values(VuexClass.prototype.__submodules_cache__)) {
        clearProxyCache(submodule);
    }
}

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

        expect(axiosMock.request).toHaveBeenCalledWith(url("event"));
    });

    it("fetches events when setting filter", async () => {
        axiosMock.request.mockResolvedValue({ data: [] as Event[] });

        await eventsStore.addFilter({
            titleContains: "Olympic games",
            organizerId: 42
        });

        expect(axiosMock.request).toHaveBeenCalledWith(expect.objectContaining({
            url: "/api/v1/event?titleContains=Olympic+games&organizerId=42"
        }));
    });

    it("lists fetched events", async () => {
        const events = [
            { uuid: "42", title: "Olympic games" },
            { uuid: "43", title: "Paralympics" }
        ] as SimpleEvent[];
        axiosMock.request.mockResolvedValue({
            data: events
        });

        await eventsStore.fetch();

        expect(eventsStore.list).toEqual(events);
    });

    it("fetches an events contests", async () => {
        const contests = [
            { contestType: FullContestDtoContestTypeEnum.MultipleDayRide },
            { contestType: FullContestDtoContestTypeEnum.IntroductionDrive }
        ] as FullContest[];
        axiosMock.request.mockResolvedValue({
            data: contests
        });
        const eventId = "5";

        const fetchedContests = await eventsStore.getContestsOf(eventId);

        expect(axiosMock.request).toHaveBeenCalledWith(url(`event/${eventId}/contests`));
        expect(fetchedContests).toEqual(contests);
    });

    it("fetches an events details", async () => {
        const details = {
            organizerName: "Olympic committee"
        } as FullEvent;
        axiosMock.request.mockResolvedValue({
            data: details
        });
        const eventId = "5";

        const fetchedContests = await eventsStore.getDetailsOf(eventId);

        expect(axiosMock.request).toHaveBeenCalledWith(url(`event/${eventId}`));
        expect(fetchedContests).toEqual(details);
    });
});
