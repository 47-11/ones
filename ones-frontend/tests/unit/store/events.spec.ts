import { EventControllerApi, FullContestDto as FullContest, FullContestDtoContestTypeEnum, FullEventDto as FullEvent, SimpleEventDto as SimpleEvent, SimpleEventDto } from "@/openapi/generated";
import { EventsStore, FirstPage, SortDirection } from "@/store/events.vuex";
import { createLocalVue } from "@vue/test-utils";
import axios from "axios";
import Vuex, { Store } from "vuex";
import { createProxy } from "vuex-class-component";
import { ProxyWatchers } from "vuex-class-component/dist/interfaces";
import { clearProxyCache, createTestStore, escaped, Resolved } from "./util";

jest.mock("axios");

type FindAllResponse = Partial<Resolved<ReturnType<EventControllerApi["findAll"]>>>;

const EmptyFindAllResponse: FindAllResponse = {
    data: { elements: [] }
};

describe("Events-Store", () => {
    let store: Store<unknown>;
    let eventsStore: EventsStore & ProxyWatchers;
    let axiosMock: jest.Mocked<typeof axios>;
    let localVue;

    beforeEach(() => {
        localVue = createLocalVue();
        localVue.use(Vuex);
        store = createTestStore();

        eventsStore = createProxy(store, EventsStore);
        axiosMock = axios as jest.Mocked<typeof axios>;

        axiosMock.request.mockReset();
    });

    afterEach(() => {
        clearProxyCache(EventsStore);
    });

    it("fetches events with default values", async () => {
        axiosMock.request.mockResolvedValue({ data: [] as Event[] });

        await eventsStore.fetch();

        const requestOptions = axiosMock.request.mock.calls[0][0];
        expect(requestOptions.url).toContain("event");
        expect(requestOptions.url).toContain(`page=${FirstPage}`);
        expect(requestOptions.url).toContain(`pageSize=${10}`);
        expect(requestOptions.url).toContain("sortBy=start");
        expect(requestOptions.url).toContain("sortDirection=ASCENDING");
    });

    it("fetches events when setting filter", async () => {
        axiosMock.request.mockResolvedValue({ data: [] as Event[] });
        const filter = {
            from: "2021-11-15",
            regions: ["Nowhere", "Buxtehude"]
        };

        await eventsStore.addFilter(filter);

        const requestOptions = axiosMock.request.mock.calls[0][0];
        expect(requestOptions.url).toContain("event");
        expect(requestOptions.url).toContain(`from=${escaped(filter.from)}`);
        expect(requestOptions.url).toContain(`regions=${filter.regions[0]}`);
        expect(requestOptions.url).toContain(`regions=${filter.regions[1]}`);
    });

    it("lists fetched events", async () => {
        const events = [
            { uuid: "42", title: "Olympic games" },
            { uuid: "43", title: "Paralympics" }
        ] as SimpleEvent[];
        axiosMock.request.mockResolvedValue({
            data: {
                elements: events
            }
        });

        await eventsStore.fetch();

        expect(eventsStore.list).toEqual(events);
    });

    it("fetches events contests when event is set", async () => {
        const contests = [
            { contestType: FullContestDtoContestTypeEnum.MultipleDayRide },
            { contestType: FullContestDtoContestTypeEnum.IntroductionDrive }
        ] as FullContest[];
        axiosMock.request.mockResolvedValue({
            data: contests
        });
        const eventId = "5";

        await eventsStore.fetchEvent(eventId);

        const requestOptions = axiosMock.request.mock.calls[0][0];
        expect(requestOptions.url).toContain(`${eventId}/contests`);
        expect(eventsStore.eventContests).toEqual(contests);
    });

    it("fetches an events details when an event is selected", async () => {
        const details = {
            organizerName: "Olympic committee"
        } as FullEvent;
        axiosMock.request.mockResolvedValue({
            data: details
        });
        const eventId = "5";

        await eventsStore.fetchEvent(eventId);

        const requestOptions = axiosMock.request.mock.calls[0][0];
        expect(requestOptions.url).toContain(`event/${eventId}`);
        expect(eventsStore.eventDetails).toEqual(details);
    });

    it("fetches the selected page", async () => {
        axiosMock.request.mockResolvedValue(EmptyFindAllResponse);
        const pageToSelect = 5;

        await eventsStore.selectPage(pageToSelect);

        const requestOptions = axiosMock.request.mock.calls[0][0];
        expect(requestOptions.url).toContain(`page=${pageToSelect}`);
    });

    it("fetches the next page", async () => {
        axiosMock.request.mockResolvedValue(EmptyFindAllResponse);
        const currentPage = FirstPage;

        await eventsStore.nextPage();

        const requestOptions = axiosMock.request.mock.calls[0][0];
        expect(requestOptions.url).toContain(`page=${currentPage + 1}`);
    });

    it("fetches the previous page", async () => {
        axiosMock.request.mockResolvedValue(EmptyFindAllResponse);
        const currentPage = 5;
        await eventsStore.selectPage(currentPage);
        axiosMock.request.mockClear();

        await eventsStore.prevPage();

        const requestOptions = axiosMock.request.mock.calls[0][0];
        expect(requestOptions.url).toContain(`page=${currentPage - 1}`);
    });

    it("fetches with the selected page size", async () => {
        axiosMock.request.mockResolvedValue(EmptyFindAllResponse);
        const selectedPageSize = 20;

        await eventsStore.selectPageSize(selectedPageSize);

        const requestOptions = axiosMock.request.mock.calls[0][0];
        expect(requestOptions.url).toContain(`pageSize=${selectedPageSize}`);
    });

    it("fetches with the selected sort criterion", async () => {
        axiosMock.request.mockResolvedValue(EmptyFindAllResponse);
        const criterion = "title";

        await eventsStore.sortBy(criterion);

        const requestOptions = axiosMock.request.mock.calls[0][0];
        expect(requestOptions.url).toContain(`sortBy=${criterion}`);
    });

    it("resets the page to 0 when the sort criterion is changed", async () => {
        axiosMock.request.mockResolvedValue(EmptyFindAllResponse);
        await eventsStore.selectPage(5);
        axiosMock.request.mockClear();
        const criterion = "title";

        await eventsStore.sortBy(criterion);

        const requestOptions = axiosMock.request.mock.calls[0][0];
        expect(requestOptions.url).toContain(`page=${FirstPage}`);
    });

    it("fetches with the selected sort criterion", async () => {
        axiosMock.request.mockResolvedValue(EmptyFindAllResponse);
        const direction = SortDirection.Descending;

        await eventsStore.sortInDirection(direction);

        const requestOptions = axiosMock.request.mock.calls[0][0];
        expect(requestOptions.url).toContain(`sortDirection=${direction}`);
    });

    it("resets the page to 0 when the sort direction is changed", async () => {
        axiosMock.request.mockResolvedValue(EmptyFindAllResponse);
        await eventsStore.selectPage(5);
        axiosMock.request.mockClear();
        const direction = SortDirection.Descending;

        await eventsStore.sortInDirection(direction);

        const requestOptions = axiosMock.request.mock.calls[0][0];
        expect(requestOptions.url).toContain(`page=${FirstPage}`);
    });

    it("fetches the total amount of elements", async () => {
        axiosMock.request.mockResolvedValue({
            data: {
                elements: [
                    { uuid: "3" }
                ] as SimpleEventDto[],
                totalElements: 3
            }
        } as FindAllResponse);
        await eventsStore.selectPage(FirstPage + 1);

        expect(eventsStore.totalElementCount).toBe(3);
    });

    it("calculates fitting page boundaries for not full last page", async () => {
        axiosMock.request.mockResolvedValue({
            data: {
                elements: [
                    { uuid: "3" }
                ] as SimpleEventDto[],
                totalElements: 3
            }
        } as FindAllResponse);
        await eventsStore.selectPageSize(2);
        await eventsStore.selectPage(FirstPage + 1);

        expect(eventsStore.pageCount).toBe(2);
        expect(eventsStore.firstElementIndex).toBe(2);
        expect(eventsStore.lastElementIndex).toBe(2);
        expect(eventsStore.hasNextPage).toBe(false);
        expect(eventsStore.hasPrevPage).toBe(true);
    });

    it("signs up for a contest", async () => {
        const contestToSignUpTo = "3";
        const horseIdToSignUp = "5";
        axiosMock.request.mockResolvedValue(undefined);

        await eventsStore.signUp({
            contestUuid: contestToSignUpTo,
            horseUuids: [horseIdToSignUp]
        });

        expect(axiosMock.request).toHaveBeenCalledWith(expect.objectContaining({
            url: `/api/v1/event/contest/${contestToSignUpTo}/signup`,
            data: expect.stringContaining(`"horseUuids":["${horseIdToSignUp}"]`)
        }));
    });
});
