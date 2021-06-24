import { HorseControllerApi } from "@/openapi/generated";
import { HorseStore } from "@/store/horse.vuex";
import { createLocalVue } from "@vue/test-utils";
import axios from "axios";
import Vuex, { Store } from "vuex";
import { createProxy } from "vuex-class-component";
import { ProxyWatchers } from "vuex-class-component/dist/interfaces";
import { clearProxyCache, createTestStore, Resolved } from "./util";

jest.mock("axios");

type MyHorsesResponse = Partial<Resolved<ReturnType<HorseControllerApi["getMyHorses"]>>>;

describe("HorseStore", () => {
    let store: Store<unknown>;
    let horseStore: HorseStore & ProxyWatchers;
    let axiosMock: jest.Mocked<typeof axios>;
    let localVue;

    beforeEach(() => {
        localVue = createLocalVue();
        localVue.use(Vuex);
        store = createTestStore();

        horseStore = createProxy(store, HorseStore);
        axiosMock = axios as jest.Mocked<typeof axios>;

        axiosMock.request.mockReset();
    });

    afterEach(() => {
        clearProxyCache(HorseStore);
    });

    it("fetches the horses", async () => {
        const horses = [
            { uuid: "42", name: "Jolly Jumper", lifeNumber: "123" }
        ];
        axiosMock.request.mockResolvedValue({
            data: horses
        } as MyHorsesResponse);

        await horseStore.fetch();

        const requestOptions = axiosMock.request.mock.calls[0][0];
        expect(requestOptions.url).toContain("/horse/my");
    });

    it("lists the horses", async () => {
        const horses = [
            { uuid: "42", name: "Jolly Jumper", lifeNumber: "123" }
        ];
        axiosMock.request.mockResolvedValue({
            data: horses
        } as MyHorsesResponse);

        await horseStore.fetch();

        expect(horseStore.list).toEqual(horses);
    });
});
