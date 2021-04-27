<template>
    <router-link :to="to" class="block pl-3 pr-4 py-2 border-l-4 text-base focus:outline-none ease-in-out"
                 v-bind:class="{ active: active, inactive: !active }">
        <slot></slot>
    </router-link>
</template>

<script lang="ts">
import { Component, Prop, Vue } from 'vue-property-decorator';

@Component
export default class ResponsiveNavLink extends Vue {
    @Prop() public to!: string;
    @Prop() public active!: boolean;
}
</script>

<style scoped>
.active {
    @apply border-indigo-400 font-medium text-indigo-700 bg-indigo-50 focus:text-indigo-800 focus:bg-indigo-100 focus:border-indigo-700 transition duration-150;
}

.inactive {
    @apply border-transparent text-gray-600 hover:text-gray-800 hover:bg-gray-50 hover:border-gray-300 focus:text-gray-800 focus:bg-gray-50 focus:border-gray-300 transition duration-150;
}
</style>
