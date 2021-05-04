<template>
    <input type="checkbox" class="rounded border-gray-300 text-indigo-600 shadow-sm focus:border-indigo-300 focus:ring focus:ring-indigo-200 focus:ring-opacity-50"
           :disabled="disabled" v-bind:class="{ 'opacity-50 cursor-not-allowed': disabled }" v-bind:value="value" @input="handleInput"/>
</template>

<script lang="ts">
import { Component, Prop, Vue } from 'vue-property-decorator';
import { CheckboxInputEvent } from '@/customTypes/inputEvent';

@Component
export default class VCheckbox extends Vue {
    @Prop() private disabled!: boolean;
    @Prop() public value = false;

    handleInput (e: CheckboxInputEvent): void {
        this.$emit('input', e.target.value);
    }
}
</script>
