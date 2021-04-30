import { action, createModule } from 'vuex-class-component';
import { ContestControllerApi, ContestDto as Contest } from '@/openapi/generated/api';
import { vxm } from '.';

const VuexModule = createModule({
    namespaced: 'contests',
    strict: false
});

export class ContestsStore extends VuexModule {
    private contests: Contest[] = [];

    get all (): Contest[] {
        return this.contests;
    }

    @action
    async fetch (): Promise<void> {
        const fetchResponse = await new ContestControllerApi({
            accessToken: vxm.user.token || '',
            isJsonMime: () => true
        }).findAll();
        this.contests = fetchResponse.data;
    }
}
