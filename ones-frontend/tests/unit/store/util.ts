import { VuexModule, VuexModuleConstructor } from "vuex-class-component/dist/interfaces";
import Vuex, { Store } from "vuex";
import { extractVuexModule } from "vuex-class-component";
import { EventsStore } from "@/store/events.vuex";
import { UserStore } from "@/store/user.vuex";
import { HorseStore } from "@/store/horse.vuex";
import { ResultsStore } from "@/store/results.vuex";
import { AppStore } from "@/store/app.vuex";

export const escaped = (text: string): string => {
    return text.replace(" ", "+");
};

export type Resolved<T> = T extends Promise<infer C> ? C : never;

/**
 * This function is used to clear the proxy cache of the handed vuex module
 * to prevent the reuse of a vuex store between the tests.
 * Unfortunately, the original clearProxyCache function has no implementation.
 * This implementation was taken from
 * https://github.com/Glandos/vuex-class-component/commit/a22dd89513b7f292cd3e62cd3883da1316938963
 * A corresponding issue has been opened at
 * https://github.com/michaelolof/vuex-class-component/issues/101
 * @param cls The vuex module to clear the cache for.
 */
export function clearProxyCache<T extends typeof VuexModule>(cls: T): void {
    // eslint-disable-next-line @typescript-eslint/ban-ts-comment
    // @ts-ignore
    const VuexClass = cls as VuexModuleConstructor;
    delete VuexClass.prototype.__vuex_module_cache__;
    delete VuexClass.prototype.__vuex_proxy_cache__;
    delete VuexClass.prototype.__store_cache__;
    delete VuexClass.prototype.__vuex_local_proxy_cache__;
    for (const submodule of Object.values(VuexClass.prototype.__submodules_cache__)) {
        clearProxyCache(submodule);
    }
}

export function createTestStore(): Store<unknown> {
    const store = new Vuex.Store({
        modules: {
            ...extractVuexModule(AppStore),
            ...extractVuexModule(EventsStore),
            ...extractVuexModule(UserStore),
            ...extractVuexModule(HorseStore),
            ...extractVuexModule(ResultsStore)
        }
    });
    // eslint-disable-next-line @typescript-eslint/no-explicit-any
    (window as any).store = store;
    return store;
}
