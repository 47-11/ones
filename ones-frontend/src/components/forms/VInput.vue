<template>
    <input class="rounded-md shadow-sm border-gray-300 focus:border-red-300 focus:ring focus:ring-red-200 focus:ring-opacity-50" v-bind:value="value" @input="handleInput"
           v-bind:class="{ 'bg-gray-100': disabled }">
</template>

<script lang="ts">
import { Component, Prop, Vue } from 'vue-property-decorator';

@Component
export default class VInput extends Vue {
    @Prop() public disabled!: boolean;
    @Prop() public value = '';

    // eslint-disable-next-line @typescript-eslint/no-explicit-any, @typescript-eslint/explicit-module-boundary-types
    handleInput (e: any): void {
        this.$emit('input', e.target.value);
    }
}
</script>
