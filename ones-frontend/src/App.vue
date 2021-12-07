<template>
    <div id="app" class="font-sans">
        <div class="absolute w-full h-full z-50 bg-gray-700 bg-opacity-50 flex felx-col items-center justify-center" v-if="app.isOffline">
            <div class="bg-red-600 text-white text-center p-2 w-1/2 shadow-2xl rounded-lg">
                <h2 class="text-lg">
                    <font-awesome-icon :icon="'exclamation-triangle'" class="ml-2"/>
                    {{ $t("offlineWarning.noConnection") }}
                </h2>
                {{ $t("offlineWarning.message")}}
            </div>
        </div>
        <router-view/>
        <modals-container/>
    </div>
</template>

<style>
@font-face {
    font-family: "Nunito";
    font-weight: normal;
    src: local("Nunito"), url("./assets/fonts/nunito-regular.ttf");
}

@font-face {
    font-family: "Nunito";
    font-weight: 500;
    src: local("Nunito Medium"), url('./assets/fonts/nunito-medium.ttf');
}

@font-face {
    font-family: "Nunito";
    font-weight: 800;
    src: local("Nunito Bold"), url('./assets/fonts/nunito-bold.ttf');
}

.router-link-active, a {
    @apply
    text-indigo-500
    border-b-2
    border-transparent
    hover:border-gray-200
    font-bold;
}

.tooltip .tooltip-inner {
    @apply
    text-white
    bg-indigo-500
    py-1
    px-2
    rounded;
}

.tooltip .tooltip-arrow {
    @apply
    w-1
    h-1
    border-indigo-500
    border-solid
    absolute
    m-0.5;
}

.tooltip[x-placement^="top"] {
    @apply
    mb-2;
}

.tooltip .tooltip-arrow {
    @apply
    border-4
    border-b-0
    mt-0
    mb-0;
    border-left-color: transparent !important;
    border-right-color: transparent !important;
    border-bottom-color: transparent !important;
    bottom: -5px;
    left: calc(50% - 5px);
}

</style>

<script lang="ts">
import Vue from "vue";
import Component from "vue-class-component";
import { getVxm } from "./store";

@Component
export default class App extends Vue {
    app = getVxm().app;
}
</script>
