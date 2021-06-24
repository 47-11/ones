import { UserControllerApi, UserDto } from "@/openapi/generated";
import { UserStore } from "@/store/userStore.vuex";
import { createLocalVue } from "@vue/test-utils";
import axios from "axios";
import Vuex, { Store } from "vuex";
import { clearProxyCache, createProxy } from "vuex-class-component";
import { ProxyWatchers } from "vuex-class-component/dist/interfaces";
import { createTestStore, Resolved } from "./util";

jest.mock("axios");

type GetCurrentUserResponse = Partial<Resolved<ReturnType<UserControllerApi["getCurrentUser"]>>>;

describe("UserStore", () => {
    let store: Store<unknown>;
    let userStore: UserStore & ProxyWatchers;
    let axiosMock: jest.Mocked<typeof axios>;
    let localVue;

    beforeEach(() => {
        localVue = createLocalVue();
        localVue.use(Vuex);
        store = createTestStore();

        userStore = createProxy(store, UserStore);
        axiosMock = axios as jest.Mocked<typeof axios>;
        axiosMock.request.mockReset();
    });

    afterEach(() => {
        clearProxyCache(UserStore);
    });

    it("requests the user's data", async () => {
        const userData: UserDto = {
            name: "Lucky Luke",
            address: {
                locationName: "Where he wants",
                street: "Around the corner",
                city: "Hot city",
                region: "Wild West",
                zipCode: "12345",
                country: "'Murica"
            }
        };
        axiosMock.request.mockResolvedValue({
            data: userData
        } as GetCurrentUserResponse);

        await userStore.fetchCurrent();

        const requestOptions = axiosMock.request.mock.calls[0][0];
        expect(requestOptions.url).toContain("/user/me");
    });

    it("showsCurrent", async () => {
        const userData: UserDto = {
            name: "Lucky Luke",
            address: {
                locationName: "Where he wants",
                street: "Around the corner",
                city: "Hot city",
                region: "Wild West",
                zipCode: "12345",
                country: "'Murica"
            }
        };
        axiosMock.request.mockResolvedValue({
            data: userData
        } as GetCurrentUserResponse);

        await userStore.fetchCurrent();

        expect(userStore.current).toEqual(userData);
    });
});
