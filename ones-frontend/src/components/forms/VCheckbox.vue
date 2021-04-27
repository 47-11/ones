<template>
    <input type="checkbox" class="rounded border-gray-300 text-indigo-600 shadow-sm focus:border-indigo-300 focus:ring focus:ring-indigo-200 focus:ring-opacity-50"
           :disabled="disabled" v-bind:class="{ 'opacity-50 cursor-not-allowed': disabled }"/>
</template>

<script lang="ts">
import { Component, Prop, Vue } from 'vue-property-decorator';

@Component
export default class VCheckbox extends Vue {
    @Prop() private disabled!: boolean;
}
</script>
