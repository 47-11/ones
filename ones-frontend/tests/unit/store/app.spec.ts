import { AppStore } from "@/store/app.vuex";
import { createLocalVue } from "@vue/test-utils";
import axios from "axios";
import Vuex, { Store } from "vuex";
import { createProxy } from "vuex-class-component";
import { ProxyWatchers } from "vuex-class-component/dist/interfaces";
import { clearProxyCache, createTestStore } from "./util";

jest.mock("axios");

describe("AppStore", () => {
    let store: Store<unknown>;
    let appStore: AppStore & ProxyWatchers;
    let axiosMock: jest.Mocked<typeof axios>;
    let localVue;

    beforeEach(() => {
        localVue = createLocalVue();
        localVue.use(Vuex);
        store = createTestStore();

        appStore = createProxy(store, AppStore);
        axiosMock = axios as jest.Mocked<typeof axios>;
        axiosMock.request.mockReset();
    });

    afterEach(() => {
        clearProxyCache(AppStore);
    });

    it("tries to reach online state endpoint", async () => {
        axiosMock.request.mockResolvedValue(undefined);

        await appStore.checkOnlineState();

        expect(axiosMock.request).toHaveBeenCalledWith(expect.objectContaining({ url: "/api/v1/connection-test" }));
    });

    it("sets isOffline to false when online check succeeds", async () => {
        axiosMock.request.mockResolvedValue(undefined);

        await appStore.checkOnlineState();

        expect(appStore.isOffline).toBe(false);
    });

    it("sets isOffline to true when online check fails", async () => {
        axiosMock.request.mockRejectedValue(new Error("Network Error"));

        await appStore.checkOnlineState();

        expect(appStore.isOffline).toBe(true);
    });
});
