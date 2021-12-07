import Vue from "vue";
import Vuex from "vuex";
import { createProxy, extractVuexModule } from "vuex-class-component";
import { ProxyWatchers } from "vuex-class-component/dist/interfaces";
import { AppStore } from "./app.vuex";
import { EventsStore } from "./events.vuex";
import { HorseStore } from "./horse.vuex";
import { ResultsStore } from "./results.vuex";
import { UserStore } from "./user.vuex";

Vue.use(Vuex);

// eslint-disable-next-line @typescript-eslint/no-explicit-any
let store: any = null;

// eslint-disable-next-line @typescript-eslint/no-explicit-any
export function getStore(): any {
    if (store == null) {
        store = new Vuex.Store({
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
    }
    return store;
}

type VXMType = {
    user: UserStore & ProxyWatchers,
    events: EventsStore & ProxyWatchers,
    horses: HorseStore & ProxyWatchers,
    results: ResultsStore & ProxyWatchers,
    app: AppStore & ProxyWatchers,
};

let vxm: VXMType | null = null;
export function getVxm(): VXMType {
    if (vxm == null) {
        vxm = {
            user: createProxy(getStore(), UserStore),
            events: createProxy(getStore(), EventsStore),
            horses: createProxy(getStore(), HorseStore),
            results: createProxy(getStore(), ResultsStore),
            app: createProxy(getStore(), AppStore)
        };
    }
    return vxm;
}
