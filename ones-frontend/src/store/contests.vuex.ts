import { action, createModule, createProxy, mutation } from 'vuex-class-component';
import { ContestControllerApi, ContestDto as Contest } from '@/openapi/generated/api';
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
    namespaced: 'contests',
    strict: false
});

export class ContestsStore extends VuexModule {
    private contests: Contest[] = [];
    private filter = {} as FilterType;

    get list (): Contest[] {
        return this.contests;
    }

    private get controller (): ContestControllerApi {
        return new ContestControllerApi({
            accessToken: createProxy(this.$store, UserStore).token || '',
            isJsonMime: () => true
        });
    }

    @action
    async fetch (): Promise<void> {
        const fetchResponse = await this.controller.findAll(...this.filterAsArray);
        this.contests = fetchResponse.data;
    }

    private get filterAsArray (): Parameters<ContestControllerApi['findAll']> {
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
        const newFilter = Object.assign({}, this.filter);
        for (const [key, value] of Object.entries(modification)) {
            newFilter[key as keyof FilterType] = value;
        }
        this.filter = newFilter;
    }

    @mutation
    removeFilter (...filterPropsToClear: Array<keyof FilterType>): void {
        for (const filterProp of filterPropsToClear) {
            this.filter[filterProp] = undefined;
        }
    }

    @action
    async byId (id: number): Promise<Contest> {
        return (await this.controller.findOneById(id)).data;
    }
}
