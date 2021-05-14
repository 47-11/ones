import Vue from 'vue';
import Vuex from 'vuex';
import { createProxy, extractVuexModule } from 'vuex-class-component';
import { ContestsStore } from './contests.vuex';
import { ResultsStore } from './results.vuex';
import { UserStore } from './userStore.vuex';

Vue.use(Vuex);

const store = new Vuex.Store({
    state: {
    },
    mutations: {
    },
    actions: {
    },
    modules: {
        ...extractVuexModule(ContestsStore),
        ...extractVuexModule(UserStore),
        ...extractVuexModule(ResultsStore)
    }
});

export default store;

export const vxm = {
    user: createProxy(store, UserStore),
    contests: createProxy(store, ContestsStore)
};
