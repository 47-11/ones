import { ResultDto as Result } from "@/openapi/generated/api";
import { getApi } from "@/store/api";
import { action, createModule } from "vuex-class-component";

const VuexModule = createModule({
    namespaced: "results",
    strict: false
});

export class ResultsStore extends VuexModule {
    private ownResults: Result[] = [];
    private _averageSpeed: number | undefined;
    private _totalDistance: number | undefined;

    get list(): Result[] {
        return this.ownResults;
    }

    public get averageSpeed(): number | undefined {
        return this._averageSpeed;
    }

    public get totalDistance(): number | undefined {
        return this._totalDistance;
    }

    @action
    async fetchOwn(): Promise<void> {
        const fetchResponse = await getApi().results.getMyResults();
        this.ownResults = fetchResponse.data.results || [];
        this._averageSpeed = fetchResponse.data.averageSpeed;
        this._totalDistance = fetchResponse.data.totalDistance;
    }
}
