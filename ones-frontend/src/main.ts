import "@/assets/css/tailwind.css";
import { library } from "@fortawesome/fontawesome-svg-core";
import { faAt, faChevronLeft, faFilePdf, faPhone, faTrailer, faHorseHead, faExclamationTriangle } from "@fortawesome/free-solid-svg-icons/";
import { FontAwesomeIcon } from "@fortawesome/vue-fontawesome";
import Vue from "vue";
import VueI18n from "vue-i18n";
import App from "./App.vue";
import "./registerServiceWorker";
import router from "./router";
import store from "./store";
import VueLoading from "vue-loading-overlay";
import "vue-loading-overlay/dist/vue-loading.css";

Vue.config.productionTip = false;

library.add(faChevronLeft, faPhone, faAt, faFilePdf, faTrailer, faHorseHead, faExclamationTriangle);

Vue.component("font-awesome-icon", FontAwesomeIcon);

Vue.use(VueI18n);
Vue.use(VueLoading, {
    color: "rgb(79, 70, 229)",
    loader: "dots",
    backgroundColor: "#ffffff"
});

const i18n = new VueI18n({
    locale: navigator.language,
    fallbackLocale: "en",
    messages: {
        en: require("@/assets/i18n/en"),
        de: require("@/assets/i18n/de")
    }
});

new Vue({
    router,
    store,
    i18n,
    render: h => h(App)
}).$mount("#app");
