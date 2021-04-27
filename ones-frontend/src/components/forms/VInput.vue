<template>
    <input class="rounded-md shadow-sm border-gray-300 focus:border-red-300 focus:ring focus:ring-red-200 focus:ring-opacity-50"
           v-bind:class="{ 'bg-gray-100': disabled }">
</template>

<script lang="ts">
import { Component, Prop, Vue } from 'vue-property-decorator';

@Component
export default class NavLink extends Vue {
    @Prop() public disabled!: boolean;
}
</script>
