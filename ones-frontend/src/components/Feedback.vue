<template>
    <div class="rounded-md py-3 px-5 mb-4 mt-2 font-bold"
         v-bind:class="{ danger: color == 'danger', warning: color == 'warning', success: color == 'success' }">
        <slot></slot>
    </div>
</template>

<style>
.danger { @apply bg-red-600 text-white }
.warning { @apply bg-amber-500 text-white }
.success { @apply bg-lime-600 text-white }
</style>

<script lang="ts">
import { Component, Prop, Vue } from 'vue-property-decorator';

@Component
export default class Feedback extends Vue {
    @Prop() private color!: string;
}
</script>
