<template>
    <button class="inline-flex justify-center border border-transparent font-bold rounded-md text-white focus:outline-none focus:ring-2 focus:ring-offset-2 bg-indigo-600 hover:bg-indigo-700 focus:ring-indigo-500 py-1.5 px-4"
            :disabled="disabled" v-bind:class="{ 'opacity-50 cursor-not-allowed': disabled }">
        <slot></slot>
    </button>
</template>

<script lang="ts">
import { Component, Prop, Vue } from 'vue-property-decorator';

@Component
export default class VButton extends Vue {
    @Prop() private disabled!: boolean;
}
</script>
