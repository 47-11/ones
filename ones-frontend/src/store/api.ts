import { Configuration, ConnectionTestControllerApi, EventControllerApi, ForgotPasswordControllerApi, HorseControllerApi, LoginControllerApi, RegistrationControllerApi, ResultControllerApi, UserControllerApi } from "@/openapi/generated";
import { vxm } from "@/store";
import { UserStore } from "@/store/user.vuex";
import { createProxy } from "vuex-class-component";

export class API {
    get connection(): ConnectionTestControllerApi {
        return new ConnectionTestControllerApi(this.configNoToken);
    }

    get login(): LoginControllerApi {
        return new LoginControllerApi(this.configNoToken);
    }

    get registration(): RegistrationControllerApi {
        return new RegistrationControllerApi(this.configNoToken);
    }

    get forgotPassword(): ForgotPasswordControllerApi {
        return new ForgotPasswordControllerApi(this.configNoToken);
    }

    get user(): UserControllerApi {
        return new UserControllerApi(this.configWithToken);
    }

    get events(): EventControllerApi {
        return new EventControllerApi(this.configWithToken);
    }

    get horses(): HorseControllerApi {
        return new HorseControllerApi(this.configWithToken);
    }

    get results(): ResultControllerApi {
        return new ResultControllerApi(this.configWithToken);
    }

    private get configWithToken(): Configuration {
        const bareConfig = this.configNoToken;
        bareConfig.accessToken = createProxy(vxm, UserStore).token;
        return bareConfig;
    }

    private get configNoToken(): Configuration {
        return {
            basePath: (process.env.VUE_APP_API_BASE_URL as string).replace(/\/+$/, ""),
            isJsonMime: () => true
        };
    }
}

let instance: API | undefined;
export function getApi(): API {
    if (instance) {
        return instance;
    } else {
        instance = new API();
        return instance;
    }
}
