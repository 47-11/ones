import { HorseControllerApi, HorseDto as Horse } from "@/openapi/generated";
import { action, createModule, createProxy } from "vuex-class-component";
import { UserStore } from "./user.vuex";

const VuexModule = createModule({
    namespaced: "horses",
    strict: false
});

export class HorseStore extends VuexModule {
    private _horses: Horse[] = [];

    get list(): Horse[] {
        return this._horses;
    }

    private get controller() {
        return new HorseControllerApi({
            accessToken: createProxy(this.$store, UserStore).token || "",
            isJsonMime: () => true
        });
    }

    @action
    async fetch(): Promise<void> {
        const response = await this.controller.getMyHorses();
        this._horses = response.data;
    }
}
