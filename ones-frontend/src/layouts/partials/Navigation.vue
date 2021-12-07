<template>
    <nav class="bg-white border-b border-gray-100">
        <div class="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
            <div class="flex justify-between h-16">
                <div class="flex">
                    <div class="flex-shrink-0 flex items-center">
                        <router-link to="/">
                            <img src="@/assets/logo.png" class="h-9">
                        </router-link>
                    </div>

                    <div class="hidden space-x-8 sm:-my-px sm:ml-10 sm:flex">
                        <nav-link to="/events">{{$t("navigation.events")}}</nav-link>
                        <nav-link to="/profile">{{$t("navigation.profile")}}</nav-link>
                        <nav-link to="/horses">{{$t("navigation.horses")}}</nav-link>
                    </div>

                    <div class="hidden space-x-8 sm:-my-px sm:ml-10 sm:flex">
                        <nav-link to="/results">{{$t("navigation.results")}}</nav-link>
                    </div>
                </div>

                <!-- Settings Dropdown -->
                <div class="hidden sm:flex sm:items-center sm:ml-6">
                    <dropdown align="right" width="48">
                        <template v-slot:trigger>
                            <button
                                class="flex items-center text-sm font-medium text-gray-500 hover:text-gray-700 hover:border-gray-300 focus:outline-none focus:text-gray-700 focus:border-gray-300 transition duration-150 ease-in-out">
                                <div>{{ userName }}</div>

                                <div class="ml-1">
                                    <svg class="fill-current h-4 w-4" xmlns="http://www.w3.org/2000/svg"
                                         viewBox="0 0 20 20">
                                        <path fill-rule="evenodd"
                                              d="M5.293 7.293a1 1 0 011.414 0L10 10.586l3.293-3.293a1 1 0 111.414 1.414l-4 4a1 1 0 01-1.414 0l-4-4a1 1 0 010-1.414z"
                                              clip-rule="evenodd"/>
                                    </svg>
                                </div>
                            </button>
                        </template>

                        <dropdown-link to="/logout">
                            {{ $t("navigation.logout")}}
                        </dropdown-link>
                    </dropdown>
                </div>

                <!-- Hamburger -->
                <div class="-mr-2 flex items-center sm:hidden" v-on:click="showMenu = !showMenu">
                    <button
                        class="inline-flex items-center justify-center p-2 rounded-md text-gray-400 hover:text-gray-500 hover:bg-gray-100 focus:outline-none focus:bg-gray-100 focus:text-gray-500 transition duration-150 ease-in-out">
                        <svg class="h-6 w-6" stroke="currentColor" fill="none" viewBox="0 0 24 24">
                            <path class="inline-flex"
                                  stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                                  d="M4 6h16M4 12h16M4 18h16"/>
                        </svg>
                    </button>
                </div>
            </div>
        </div>

        <!-- Responsive Navigation Menu -->
        <div v-show="showMenu" class="sm:hidden">
            <div class="pt-2 pb-3 space-y-1">
                <responsive-nav-link to="/events">{{$t("navigation.events")}}</responsive-nav-link>
                <responsive-nav-link to="/results">{{$t("navigation.results")}}</responsive-nav-link>
                <responsive-nav-link to="/profile">{{$t("navigation.profile")}}</responsive-nav-link>
                <responsive-nav-link to="/horses">{{$t("navigation.horses")}}</responsive-nav-link>
            </div>

            <!-- Responsive Settings Options -->
            <div class="pt-4 pb-1 border-t border-gray-200">
                <div class="flex items-center px-4">
                    <div class="flex-shrink-0">
                        <svg class="h-10 w-10 fill-current text-gray-400" xmlns="http://www.w3.org/2000/svg"
                             fill="none"
                             viewBox="0 0 24 24" stroke="currentColor">
                            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                                  d="M16 7a4 4 0 11-8 0 4 4 0 018 0zM12 14a7 7 0 00-7 7h14a7 7 0 00-7-7z"/>
                        </svg>
                    </div>

                    <div class="ml-3">
                        <div class="font-medium text-base text-gray-800">{{$t("navigation.user")}}</div>
                        <div class="font-medium text-sm text-gray-500">{{$t("navigation.mail")}}</div>
                    </div>
                </div>

                <div class="mt-3 space-y-1">
                    <responsive-nav-link to="/logout">{{$t("navigation.logout")}}</responsive-nav-link>
                </div>
            </div>
        </div>
    </nav>
</template>

<script lang="ts">
import { Component, Vue } from "vue-property-decorator";
import NavLink from "@/layouts/partials/NavLink.vue";
import ResponsiveNavLink from "@/layouts/partials/ResponsiveNavLink.vue";
import Dropdown from "@/components/dropdown/Dropdown.vue";
import DropdownLink from "@/components/dropdown/DropdownLink.vue";

import { getVxm } from "@/store";

@Component({
    components: {
        DropdownLink,
        Dropdown,
        ResponsiveNavLink,
        NavLink
    }
})
export default class Navigation extends Vue {
    public data(): {showMenu: boolean} {
        return {
            showMenu: false
        };
    }

    get userName(): string {
        const firstName = getVxm().user.current?.firstName || "";
        const lastName = getVxm().user.current?.lastName || "";
        return `${firstName} ${lastName}`.trim();
    }
}
</script>
