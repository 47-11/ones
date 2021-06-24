import Vue from "vue";
import Vuex from "vuex";
import { createProxy, extractVuexModule } from "vuex-class-component";
import { AppStore } from "./app.vuex";
import { EventsStore } from "./events.vuex";
import { HorseStore } from "./horse.vuex";
import { ResultsStore } from "./results.vuex";
import { UserStore } from "./user.vuex";

Vue.use(Vuex);

const store = new Vuex.Store({
    state: {
    },
    mutations: {
    },
    actions: {
    },
    modules: {
        ...extractVuexModule(EventsStore),
        ...extractVuexModule(UserStore),
        ...extractVuexModule(HorseStore),
        ...extractVuexModule(ResultsStore),
        ...extractVuexModule(AppStore)
    }
});

export default store;

export const vxm = {
    user: createProxy(store, UserStore),
    events: createProxy(store, EventsStore),
    horses: createProxy(store, HorseStore),
    results: createProxy(store, ResultsStore),
    app: createProxy(store, AppStore)
};
