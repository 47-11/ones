<template>
    <input class="rounded-md shadow-sm border-gray-300 focus:border-red-300 focus:ring focus:ring-red-200 focus:ring-opacity-50" v-bind:value="value" @input="handleInput" :disabled="disabled"
           v-bind:class="{ 'bg-gray-100': disabled }">
</template>

<script lang="ts">
import { Component, Prop, Vue } from 'vue-property-decorator';
import { InputEvent } from '@/customTypes/inputEvent';

@Component
export default class VInput extends Vue {
    @Prop() public disabled!: boolean;
    @Prop() public value = '';

    handleInput (e: InputEvent): void {
        this.$emit('input', e.target.value);
    }
}
</script>
