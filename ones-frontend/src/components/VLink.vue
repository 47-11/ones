<template>
    <router-link :to="to" class="text-indigo-500 border-b-2 border-transparent hover:border-gray-200 font-bold">
        <slot></slot>
    </router-link>
</template>

<script lang="ts">
import { Component, Prop, Vue } from "vue-property-decorator";

@Component
export default class VButton extends Vue {
    @Prop() private to!: string;
}
</script>
