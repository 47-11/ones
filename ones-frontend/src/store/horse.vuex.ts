import { FullHorseDto as Horse, FullHorseDto } from "@/openapi/generated";
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
    async add(horse: FullHorseDto): Promise<void> {
        await getApi().horses.createHorse(horse);
        await this.fetch();
    }

    @action
    async update(horse: FullHorseDto): Promise<void> {
        // eslint-disable-next-line @typescript-eslint/no-non-null-assertion
        await getApi().horses.updateHorse(horse.uuid!, horse);
        await this.fetch();
    }
}
