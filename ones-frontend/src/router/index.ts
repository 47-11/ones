import Vue from "vue";
import VueRouter, { Route, RouteConfig } from "vue-router";
import Home from "../views/Home.vue";
import Register from "../views/auth/Register.vue";
import Login from "../views/auth/Login.vue";
import ForgotPassword from "@/views/auth/ForgotPassword.vue";
import ResetPassword from "@/views/auth/ResetPassword.vue";
import Verified from "@/views/auth/Verified.vue";
import ContestIndex from "@/views/contests/Index.vue";
import ContestDetail from "@/views/contests/Detail.vue";
import { vxm } from "@/store";

Vue.use(VueRouter);

const routes: Array<RouteConfig> = [
    {
        path: "/",
        name: "Home",
        component: Home
    },
    {
        path: "/about",
        name: "About",
        // route level code-splitting
        // this generates a separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: () => import(/* webpackChunkName: "about" */ "../views/About.vue")
    },
    {
        path: "/register",
        name: "Register",
        component: Register
    },
    {
        path: "/login",
        name: "Login",
        component: Login
    },
    {
        path: "/forgot-password",
        name: "Passwort vergessen",
        component: ForgotPassword
    },
    {
        path: "/reset-password",
        name: "Passwort zurücksetzen",
        component: ResetPassword
    },
    {
        path: "/verified",
        name: "E-Mail bestätigt",
        component: Verified
    },
    {
        path: "/contests",
        name: "Wettbewerbe",
        component: ContestIndex
    },
    {
        path: '/contests/:id',
        name: 'Wettbewerb',
        component: ContestDetail
    }
];

const router = new VueRouter({
    mode: "history",
    base: process.env.BASE_URL,
    routes
});

router.beforeEach((to, f, next) => {
    if (needsAuth(to) && !vxm.user.authenticated) {
        next("login");
    } else if (!needsAuth(to) && vxm.user.authenticated) {
        next("/");
    }

    if (to.path === "/logout") {
        vxm.user.logout();
        next("login");
    }

    next();
});

function needsAuth(to: Route) {
    const needsNoAuth = ["/login", "/register", "/forgot-password", "/reset-password", "/verified"].includes(to.path);
    return !needsNoAuth;
}

export default router;
