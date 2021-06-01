import "@/assets/css/tailwind.css";
import { library } from "@fortawesome/fontawesome-svg-core";
import { faAt, faChevronLeft, faFilePdf, faPhone, faTrailer, faHorseHead, faExclamationTriangle } from "@fortawesome/free-solid-svg-icons/";
import { FontAwesomeIcon } from "@fortawesome/vue-fontawesome";
import Vue from "vue";
import App from "./App.vue";
import "./registerServiceWorker";
import router from "./router";
import store from "./store";

Vue.config.productionTip = false;

library.add(faChevronLeft, faPhone, faAt, faFilePdf, faTrailer, faHorseHead, faExclamationTriangle);

Vue.component("font-awesome-icon", FontAwesomeIcon);

new Vue({
    router,
    store,
    render: h => h(App)
}).$mount("#app");
