import { getApi } from "@/store/api";
import { action, createModule } from "vuex-class-component";

const VuexModule = createModule({
    namespaced: "app",
    strict: false
});

export class AppStore extends VuexModule {
    public isOffline = false;

    @action
    public async checkOnlineState(): Promise<void> {
        try {
            await getApi().connection.testConnection();
            this.isOffline = false;
        } catch (error) {
            this.isOffline = true;
        }
    }
}
