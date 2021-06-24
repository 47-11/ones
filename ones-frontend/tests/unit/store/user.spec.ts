import { UserControllerApi, UserDto } from "@/openapi/generated";
import { UserStore } from "@/store/user.vuex";
import { createLocalVue } from "@vue/test-utils";
import axios from "axios";
import Vuex, { Store } from "vuex";
import { clearProxyCache, createProxy } from "vuex-class-component";
import { ProxyWatchers } from "vuex-class-component/dist/interfaces";
import { createTestStore, Resolved } from "./util";

jest.mock("axios");

type GetCurrentUserResponse = Partial<Resolved<ReturnType<UserControllerApi["getCurrentUser"]>>>;

const sampleUser: UserDto = {
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
const sampleResponse: GetCurrentUserResponse = { data: sampleUser };

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
        axiosMock.request.mockResolvedValue(sampleResponse);

        await userStore.fetchCurrent();

        const requestOptions = axiosMock.request.mock.calls[0][0];
        expect(requestOptions.url).toContain("/user/me");
        expect(userStore.current).toEqual(sampleUser);
    });

    it("sets personal data", async () => {
        axiosMock.request.mockResolvedValue({});
        const personalData = {
            firstName: "Lucky",
            lastName: "Luke"
        };

        await userStore.setPersonalData(personalData);

        const requestOptions = axiosMock.request.mock.calls[0][0];
        expect(JSON.parse(requestOptions.data)).toEqual(personalData);
    });
});
