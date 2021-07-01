import { ConnectionTestControllerApi } from "@/openapi/generated";
import { createModule, action } from "vuex-class-component";

const VuexModule = createModule({
    namespaced: "app",
    strict: false
});

export class AppStore extends VuexModule {
    public isOffline = false;

    @action
    public async checkOnlineState(): Promise<void> {
        try {
            await new ConnectionTestControllerApi().testConnection();
            this.isOffline = false;
        } catch (error) {
            this.isOffline = true;
        }
    }
}
