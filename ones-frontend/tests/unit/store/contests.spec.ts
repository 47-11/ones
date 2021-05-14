import { ContestDto as Contest, LoginControllerApi, LoginControllerApiFactory } from '@/openapi/generated';
import { ContestsStore } from '@/store/contests.vuex';
import { UserStore } from '@/store/userStore.vuex';
import { createLocalVue } from '@vue/test-utils';
import axios from 'axios';
import Vuex, { Store } from 'vuex';
import { clearProxyCache, createProxy, extractVuexModule } from 'vuex-class-component';
import { ProxyWatchers, VuexModule } from 'vuex-class-component/dist/interfaces';

jest.mock('axios');

describe('Contests-Store', () => {
    let store: Store<unknown>;
    let contestStore: ContestsStore & ProxyWatchers;
    let axiosMock: jest.Mocked<typeof axios>;
    let localVue;

    beforeEach(() => {
        localVue = createLocalVue();
        localVue.use(Vuex);
        store = new Vuex.Store({
            modules: {
                ...extractVuexModule(ContestsStore),
                ...extractVuexModule(UserStore)
            }
        });

        contestStore = createProxy(store, ContestsStore);
        axiosMock = axios as jest.Mocked<typeof axios>;
    });

    afterEach(() => {
        clearProxyCache(ContestsStore);
    });

    it('fetches contests unfiltered', async () => {
        axiosMock.request.mockResolvedValue({ data: [] as Contest[] });

        await contestStore.fetch();

        expect(axiosMock.request).toHaveBeenCalledWith(expect.objectContaining({ url: '/api/v1/contest' }));
    });

    it('fetches contests filtered', async () => {
        axiosMock.request.mockResolvedValue({ data: [] as Contest[] });
        contestStore.addFilter({
            titleContains: 'Olympic games',
            organizerId: 42
        });

        await contestStore.fetch();

        expect(axiosMock.request).toHaveBeenCalledWith(expect.objectContaining({
            url: '/api/v1/contest?titleContains=Olympic+games&organizerId=42'
        }));
    });

    it('lists fetched contests', async () => {
        const contests = [
            { id: 42, title: 'Olympic games' },
            { id: 43, title: 'Paralympics' }
        ] as Contest[];
        axiosMock.request.mockResolvedValue({
            data: contests
        });

        await contestStore.fetch();

        expect(contestStore.list).toEqual(contests);
    });
});
