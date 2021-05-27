<template>
    <button class="inline-flex justify-center border border-transparent font-bold rounded-md focus:outline-none focus:ring-2 focus:ring-offset-2 py-1.5 px-4"
            :disabled="disabled" v-bind:class="{ 'opacity-50 cursor-not-allowed': disabled, primary: color == undefined, secondary: color == 'secondary' }">
        <slot></slot>
    </button>
</template>

<style>
.primary { @apply bg-indigo-600 hover:bg-indigo-700 focus:ring-indigo-500 text-white }
.secondary { @apply bg-gray-200 hover:bg-gray-300 focus:ring-gray-400 text-gray-700 }
</style>

<script lang="ts">
import { Component, Prop, Vue } from "vue-property-decorator";

@Component
export default class VButton extends Vue {
    @Prop() private disabled!: boolean;
    @Prop() private color!: string;
}
</script>
