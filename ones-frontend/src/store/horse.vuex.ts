import { FullHorseDto, FullHorseDto as Horse } from "@/openapi/generated";
import { getApi } from "@/store/api";
import { action, createModule } from "vuex-class-component";

const VuexModule = createModule({
    namespaced: "horses",
    strict: false
});

export class HorseStore extends VuexModule {
    private _horses: Horse[] = [];
    private _breeds: string[] = [];
    private _colors: string[] = [];

    get list(): Horse[] {
        return this._horses;
    }

    @action
    async fetch(): Promise<void> {
        const response = await getApi().horses.getMyHorses();
        this._horses = response.data;

        if (this.colors.length === 0 || this.breeds.length === 0) {
            await this.fetchProperties();
        }
    }

    @action
    async fetchProperties(): Promise<void> {
        const responses = await Promise.all([
            getApi().horses.getAllBreeds(),
            getApi().horses.getAllColors()
        ]);
        this._breeds = responses[0].data;
        this._colors = responses[1].data;
    }

    get breeds(): string[] {
        return this._breeds;
    }

    get colors(): string[] {
        return this._colors;
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
