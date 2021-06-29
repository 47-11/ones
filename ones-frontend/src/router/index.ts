import Vue from "vue";
import VueRouter, { Route, RouteConfig } from "vue-router";
import Register from "../views/auth/Register.vue";
import Login from "../views/auth/Login.vue";
import ForgotPassword from "@/views/auth/ForgotPassword.vue";
import ResetPassword from "@/views/auth/ResetPassword.vue";
import Verified from "@/views/auth/Verified.vue";
import EventsIndex from "@/views/events/Index.vue";
import EventDetail from "@/views/events/Detail.vue";
import SignUp from "@/views/contests/SignUp.vue";
import SetPersonalData from "@/views/auth/SetPersonalData.vue";
import { vxm } from "@/store";

Vue.use(VueRouter);

const routes: Array<RouteConfig> = [
    {
        path: "/",
        redirect: "/events"
    },
    {
        path: "/about",
        // route level code-splitting
        // this generates a separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: () => import(/* webpackChunkName: "about" */ "../views/About.vue")
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
        path: "/setPersonalData/",
        component: SetPersonalData
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
    if (currentUser && !currentUser.isPersonalDataKnown && to.path !== "/setPersonalData") {
        next("/setPersonalData");
        return;
    } else if (currentUser && currentUser.isPersonalDataKnown && to.path === "/setPersonalData") {
        next("/");
        return;
    }

    next();
});

function needsAuth(to: Route) {
    const needsNoAuth = ["/login", "/register", "/forgot-password", "/reset-password", "/verified"].includes(to.path);
    return !needsNoAuth;
}

export default router;
