<template>
    <input type="radio" class="focus:ring-indigo-500 h-4 w-4 text-indigo-600 border-gray-300" v-bind:value="value" @input="handleInput">
</template>

<script lang="ts">
import { Component, Prop, Vue } from "vue-property-decorator";
import { InputEvent } from "@/customTypes/inputEvent";

@Component
export default class VRadio extends Vue {
    @Prop() public value = "";

    handleInput(e: InputEvent): void {
        this.$emit("input", e.target.value);
    }
}
</script>
