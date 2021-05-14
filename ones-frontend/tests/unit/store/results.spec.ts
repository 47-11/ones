import { ResultDto as Result } from '@/openapi/generated';
import { ContestsStore } from '@/store/contests.vuex';
import { ResultsStore } from '@/store/results.vuex';
import { UserStore } from '@/store/userStore.vuex';
import { createLocalVue } from '@vue/test-utils';
import axios from 'axios';
import Vuex, { Store } from 'vuex';
import { extractVuexModule, createProxy, clearProxyCache } from 'vuex-class-component';
import { ProxyWatchers } from 'vuex-class-component/dist/interfaces';

jest.mock('axios');

describe('ResultsStore', () => {
    let store: Store<unknown>;
    let resultsStore: ResultsStore & ProxyWatchers;
    let axiosMock: jest.Mocked<typeof axios>;
    let localVue;

    beforeEach(() => {
        localVue = createLocalVue();
        localVue.use(Vuex);
        store = new Vuex.Store({
            modules: {
                ...extractVuexModule(ContestsStore),
                ...extractVuexModule(UserStore),
                ...extractVuexModule(ResultsStore)
            }
        });

        resultsStore = createProxy(store, ResultsStore);
        axiosMock = axios as jest.Mocked<typeof axios>;
    });

    afterEach(() => {
        clearProxyCache(ResultsStore);
    });

    it('fetches own results', async () => {
        axiosMock.request.mockResolvedValue({ data: [] as Result[] });

        await resultsStore.fetchOwn();

        expect(axiosMock.request).toHaveBeenCalledWith(expect.objectContaining({ url: '/api/v1/results/my' }));
    });

    it('lists own results', async () => {
        const results = [
            { placement: 1, horse: { name: 'Jolly Jumper' } }
        ] as Result[];
        axiosMock.request.mockResolvedValue({
            data: results
        });

        await resultsStore.fetchOwn();

        expect(resultsStore.listOwn).toEqual(results);
    });
});
