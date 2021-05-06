<template>
    <router-link :to="to" class="block px-5 border-b-0 py-2.5 text-left font-medium leading-5 text-gray-700 hover:bg-gray-100 cursor-pointer focus:outline-none focus:bg-gray-100 transition duration-150 ease-in-out">
        <slot></slot>
    </router-link>
</template>

<script lang="ts">
import { Component, Prop, Vue } from 'vue-property-decorator';

@Component
export default class NavLink extends Vue {
    @Prop() private to!: string;
}
</script>
