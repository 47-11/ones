import { HorseControllerApi, HorseDto as Horse } from "@/openapi/generated";
import { getApi } from "@/store/api";
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

    @action
    async fetch(): Promise<void> {
        const response = await getApi().horses.getMyHorses();
        this._horses = response.data;
    }
}
