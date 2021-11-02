import { HorseDto as Horse, HorseDto } from "@/openapi/generated";
import { getApi } from "@/store/api";
import { action, createModule } from "vuex-class-component";

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

    @action
    async add(horse: HorseDto): Promise<void> {
        await getApi().horses.createHorse(horse);
    }
}
