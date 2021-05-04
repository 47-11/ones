<template>
    <router-link :to="to" class="font-bold text-indigo-600 hover:text-indigo-700 hover:border-b-2 pb-0.5">
        <slot></slot>
    </router-link>
</template>

<script lang="ts">
import { Component, Prop, Vue } from 'vue-property-decorator';

@Component
export default class VButton extends Vue {
    @Prop() private to!: string;
}
</script>
