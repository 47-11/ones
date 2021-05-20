import { action, createModule, createProxy } from "vuex-class-component";
import { ResultControllerApi, ResultDto as Result } from "@/openapi/generated/api";
import { UserStore } from "./userStore.vuex";

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

    private get controller(): ResultControllerApi {
        return new ResultControllerApi({
            accessToken: createProxy(this.$store, UserStore).token || "",
            isJsonMime: () => true
        });
    }

    @action
    async fetchOwn(): Promise<void> {
        const fetchResponse = await this.controller.getMyResults();
        this.ownResults = fetchResponse.data.results || [];
        this._averageSpeed = fetchResponse.data.averageSpeed;
        this._totalDistance = fetchResponse.data.totalDistance;
    }
}
