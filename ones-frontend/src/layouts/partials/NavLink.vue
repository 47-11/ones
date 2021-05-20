<template>
    <router-link :to="to" class="inline-flex items-center px-1 pt-1 border-b-2 leading-5 focus:outline-none font-medium"
                 v-bind:class="{ active: isActive(), inactive: !isActive() }">
        <slot></slot>
    </router-link>
</template>

<script lang="ts">
import { Component, Prop, Vue } from 'vue-property-decorator';

@Component
export default class NavLink extends Vue {
    @Prop() private to!: string;

    isActive (): boolean {
        if (this.$route.path === '/') {
            return this.to === '/';
        }

        return this.to.startsWith(this.$route.path);
    }
}
</script>

<style scoped>
.active {
    @apply
    border-indigo-400
    font-medium
    text-gray-900
    focus:border-indigo-600
    transition
    duration-150
    ease-in-out;
}

.inactive {
    @apply
    border-transparent
    text-gray-500
    hover:text-gray-700
    hover:border-gray-300
    focus:text-gray-700
    focus:border-gray-300
    transition duration-150
    ease-in-out;
}
</style>
