import { action, createModule, mutation } from 'vuex-class-component';
import { ContestControllerApi, ContestDto as Contest } from '@/openapi/generated/api';
import { vxm } from '.';

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
    namespaced: 'contests',
    strict: false
});

export class ContestsStore extends VuexModule {
    private contests: Contest[] = [];
    private filter = {} as FilterType;

    get all (): Contest[] {
        return this.contests;
    }

    @action
    async fetch (): Promise<void> {
        const fetchResponse = await new ContestControllerApi({
            accessToken: vxm.user.token || '',
            isJsonMime: () => true
        }).findAll(...this.getFilterAsArray());
        this.contests = fetchResponse.data;
    }

    private getFilterAsArray (): Parameters<ContestControllerApi['findAll']> {
        return [
            this.filter.titleContains,
            this.filter.descriptionContains,
            this.filter.startsBefore,
            this.filter.startsAfter,
            this.filter.endsBefore,
            this.filter.endsAfter,
            this.filter.organizerId
        ];
    }

    @mutation
    addFilter (modification: FilterType): void {
        this.filter = Object.assign(this.filter, modification);
    }

    @mutation
    removeFilter (...filterPropsToClear: Array<keyof FilterType>): void {
        for (const filterProp of filterPropsToClear) {
            this.filter[filterProp] = undefined;
        }
    }
}
