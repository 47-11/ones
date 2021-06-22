import Vue from "vue";
import VueRouter, { Route, RouteConfig } from "vue-router";
import Home from "../views/Home.vue";
import Register from "../views/auth/Register.vue";
import Login from "../views/auth/Login.vue";
import ForgotPassword from "@/views/auth/ForgotPassword.vue";
import ResetPassword from "@/views/auth/ResetPassword.vue";
import Verified from "@/views/auth/Verified.vue";
import EventsIndex from "@/views/events/Index.vue";
import EventDetail from "@/views/events/Detail.vue";
import { vxm } from "@/store";

Vue.use(VueRouter);

const routes: Array<RouteConfig> = [
    {
        path: "/",
        component: Home
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
        path: "/events/:eventId",
        component: EventDetail
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
    } else if (!needsAuth(to) && vxm.user.authenticated) {
        next("/");
    }

    if (to.path === "/logout") {
        vxm.user.logout();
        next("/login");
    }

    next();
});

function needsAuth(to: Route) {
    const needsNoAuth = ["/login", "/register", "/forgot-password", "/reset-password", "/verified"].includes(to.path);
    return !needsNoAuth;
}

export default router;
