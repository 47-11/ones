import Vue from 'vue';
import Vuex from 'vuex';
import { createProxy, extractVuexModule } from 'vuex-class-component';
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
        ...extractVuexModule(UserStore)
    }
});

export default store;

export const vxm = {
    user: createProxy(store, UserStore)
};
