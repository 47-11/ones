import "@/assets/css/tailwind.css";
import { library } from "@fortawesome/fontawesome-svg-core";
import {
    faAt,
    faChevronLeft,
    faFilePdf,
    faPhone,
    faTrailer,
    faHorseHead,
    faExclamationTriangle,
    faChevronRight, faChevronDown, faChevronUp
} from "@fortawesome/free-solid-svg-icons/";
import { FontAwesomeIcon } from "@fortawesome/vue-fontawesome";
import ErrorMessage from "@/components/ErrorMessage.vue";
import Vue from "vue";
import VueI18n from "vue-i18n";
import App from "./App.vue";

import "./registerServiceWorker";
import router from "./router";
import store, { vxm } from "./store";
import VueLoading from "vue-loading-overlay";
import "vue-loading-overlay/dist/vue-loading.css";
import axios from "axios";

Vue.config.productionTip = false;

library.add(
    faChevronLeft,
    faChevronRight,
    faChevronDown,
    faChevronUp,
    faPhone,
    faAt,
    faFilePdf,
    faTrailer,
    faHorseHead,
    faExclamationTriangle
);

Vue.component("font-awesome-icon", FontAwesomeIcon);
Vue.component("error-message", ErrorMessage);

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

axios.interceptors.response.use(undefined, (res) => {
    if (res.response.status === 403) {
        if (vxm.user.authenticated) {
            router.push("/logout").catch(() => { /* ignore error that occurs because logout will redirect us to login in the end" */ });
            throw new Error("Token is invalid or has expired");
        }
    }
    return res;
});

new Vue({
    router,
    store,
    i18n,
    render: h => h(App)
}).$mount("#app");
