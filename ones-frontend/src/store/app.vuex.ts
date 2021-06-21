import { createModule } from "vuex-class-component";

const VuexModule = createModule({
    namespaced: "app",
    strict: false
});

export class AppStore extends VuexModule {
    public isOffline = false;
}
