import { vxm } from "@/store";
import ForgotPassword from "@/views/auth/ForgotPassword.vue";
import ResetPassword from "@/views/auth/ResetPassword.vue";
import SetPersonalData from "@/views/auth/SetPersonalData.vue";
import Verified from "@/views/auth/Verified.vue";
import SignUp from "@/views/contests/SignUp.vue";
import EventDetail from "@/views/events/Detail.vue";
import EventsIndex from "@/views/events/Index.vue";
import HorsesIndex from "@/views/horses/Index.vue";
import ProfileEdit from "@/views/profile/Edit.vue";
import ProfileIndex from "@/views/profile/Index.vue";
import ResultsIndex from "@/views/results/Index.vue";
import Vue from "vue";
import VueRouter, { Route, RouteConfig } from "vue-router";
import Login from "../views/auth/Login.vue";
import Register from "../views/auth/Register.vue";

Vue.use(VueRouter);

const routes: Array<RouteConfig> = [
    {
        path: "/",
        redirect: "/events"
    },
    {
        path: "/register",
        component: Register
    },
    {
        path: "/login",
        component: Login
    },
    {
        path: "/forgot-password",
        component: ForgotPassword
    },
    {
        path: "/reset-password",
        component: ResetPassword
    },
    {
        path: "/verified",
        component: Verified
    },
    {
        path: "/results",
        component: ResultsIndex
    },
    {
        path: "/events",
        component: EventsIndex
    },
    {
        path: "/events/:eventId/contests/:contestId/sign-up",
        name: "Anmeldung zum Wettbewerb",
        component: SignUp
    },
    {
        path: "/events/:eventId",
        component: EventDetail
    },
    {
        path: "/set-personal-data/",
        component: SetPersonalData
    },
    {
        path: "/profile",
        component: ProfileIndex
    },
    {
        path: "/profile/edit",
        component: ProfileEdit
    },
    {
        path: "/horses",
        component: HorsesIndex
    }
];

const router = new VueRouter({
    mode: "history",
    base: process.env.BASE_URL,
    routes
});

router.beforeEach((to, f, next) => {
    if (needsAuth(to) && !vxm.user.authenticated) {
        next("/login");
        return;
    } else if (!needsAuth(to) && vxm.user.authenticated) {
        next("/");
        return;
    }

    if (to.path === "/logout") {
        vxm.user.logout();
        router.go(0);
        next("/login");
        return;
    }

    const currentUser = vxm.user.current;

    if (currentUser && needsToSetPersonalData() && to.path !== "/set-personal-data") {
        next("/set-personal-data");
        return;
    } else if ((!currentUser || (currentUser && isPersonalDataKnown())) && to.path === "/set-personal-data") {
        next("/");
        return;
    }

    next();
});

function needsAuth(to: Route) {
    const needsNoAuth = ["/login", "/register", "/forgot-password", "/reset-password", "/verified"].includes(to.path);
    return !needsNoAuth;
}

function needsToSetPersonalData(): boolean {
    return vxm.user.current?.uuid === null;
}

function isPersonalDataKnown(): boolean {
    return !needsToSetPersonalData();
}

export default router;
