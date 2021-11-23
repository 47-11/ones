import "@/assets/css/tailwind.css";
import ErrorMessage from "@/components/ErrorMessage.vue";
import Modal from "@/layouts/Modal.vue";
import { library } from "@fortawesome/fontawesome-svg-core";
import {
    faAt,
    faCheck,
    faChevronDown,
    faChevronLeft,
    faChevronRight,
    faChevronUp,
    faExclamationTriangle,
    faExternalLinkAlt,
    faFilePdf,
    faFlag,
    faGlobe,
    faHorseHead,
    faMap,
    faMars,
    faPencilAlt,
    faPhone,
    faTimes,
    faTrailer,
    faVenus
} from "@fortawesome/free-solid-svg-icons/";
import { FontAwesomeIcon } from "@fortawesome/vue-fontawesome";
import axios from "axios";
import VCalendar from "v-calendar";
import vToolTip from "v-tooltip";
import Vue from "vue";
import vfmPlugin from "vue-final-modal";
import VueI18n from "vue-i18n";
import VueLoading from "vue-loading-overlay";
import "vue-loading-overlay/dist/vue-loading.css";
import App from "./App.vue";
import { UserDto } from "./openapi/generated";
import "./registerServiceWorker";
import router from "./router";
import store, { vxm } from "./store";
import VTable from "@/components/table/VTable.vue";
import VTh from "@/components/table/VTh.vue";
import VTd from "@/components/table/VTd.vue";
import VTr from "@/components/table/VTr.vue";
import VTbody from "@/components/table/VTbody.vue";
import VThead from "@/components/table/VThead.vue";
import VLabel from "@/components/forms/VLabel.vue";

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
    faExclamationTriangle,
    faExternalLinkAlt,
    faMap,
    faGlobe,
    faFlag,
    faMars,
    faVenus,
    faTimes,
    faPencilAlt,
    faCheck
);

Vue.component("font-awesome-icon", FontAwesomeIcon);
Vue.component("error-message", ErrorMessage);

Vue.component("v-table", VTable);
Vue.component("v-tbody", VTbody);
Vue.component("v-td", VTd);
Vue.component("v-th", VTh);
Vue.component("v-thead", VThead);
Vue.component("v-tr", VTr);
Vue.component("v-label", VLabel);

Vue.component("Modal", Modal);

Vue.use(vToolTip);
Vue.use(VueI18n);
Vue.use(VueLoading, {
    color: "rgb(79, 70, 229)",
    loader: "dots",
    backgroundColor: "#ffffff"
});

Vue.use(VCalendar);
Vue.use(vfmPlugin());

const i18n = new VueI18n({
    locale: navigator.language,
    fallbackLocale: "en",
    messages: {
        en: require("@/assets/i18n/en"),
        de: require("@/assets/i18n/de")
    },
    silentFallbackWarn: true
});

setInterval(() => vxm.app.checkOnlineState(), 10 * 1000);

axios.interceptors.response.use(res => {
    vxm.app.isOffline = false;
    return res;
}, (res) => {
    if (res.message === "Network Error") {
        vxm.app.isOffline = true;
        throw new Error(i18n.t("offlineWarning.noConnection").toString());
    } else {
        vxm.app.isOffline = false;
    }

    if (res.response?.status === 403) {
        if (vxm.user.authenticated) {
            router.push("/logout").catch(() => { /* ignore error that occurs because logout will redirect us to login in the end" */ });
            throw new Error("Token is invalid or has expired.");
        }
    }
    throw res;
});

vxm.user.$watch("current", (current: UserDto | null) => {
    if (current && current.uuid === null && router.currentRoute.path !== "/set-personal-data") {
        router.push("/set-personal-data");
    }
});

new Vue({
    router,
    store,
    i18n,
    render: h => h(App)
}).$mount("#app");
