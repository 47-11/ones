import { action, createModule, createProxy, mutation } from 'vuex-class-component';
import { ResultControllerApi, ResultDto as Result } from '@/openapi/generated/api';
import { UserStore } from './userStore.vuex';

interface FilterType {
    titleContains?: string;
    descriptionContains?: string;
    startsBefore?: string;
    startsAfter?: string;
    endsBefore?: string;
    endsAfter?: string;
    organizerId?: number;
}

const VuexModule = createModule({
    namespaced: 'results',
    strict: false
});

export class ResultsStore extends VuexModule {
    private ownResults: Result[] = [];

    get listOwn (): Result[] {
        return this.ownResults;
    }

    private get controller (): ResultControllerApi {
        return new ResultControllerApi({
            accessToken: createProxy(this.$store, UserStore).token || '',
            isJsonMime: () => true
        });
    }

    @action
    async fetchOwn (): Promise<void> {
        const fetchResponse = await this.controller.getMyResults();
        this.ownResults = fetchResponse.data;
    }
}
