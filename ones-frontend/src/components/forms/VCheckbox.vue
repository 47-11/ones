<template>
    <input type="checkbox" class="rounded border-gray-300 text-indigo-600 shadow-sm focus:border-indigo-300 focus:ring focus:ring-indigo-200 focus:ring-opacity-50"
       :disabled="disabled" v-bind:class="{ 'opacity-50 cursor-not-allowed': disabled }" v-model="localValue"/>
</template>

<script lang="ts">
import { Component, Prop, Vue } from "vue-property-decorator";

@Component
export default class VCheckbox extends Vue {
    @Prop() private disabled!: boolean;
    @Prop() public value!: boolean;

    localValue = false;

    created(): void {
        this.localValue = this.value;

        this.$watch("localValue", value => {
            this.$emit("input", value);
        });
    }
}
</script>
