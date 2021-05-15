<template>
    <div class="relative">
        <div @click="toggle()">
            <slot name="trigger"></slot>
        </div>

        <div v-if="opened" class="absolute z-50 mt-2 w-72 rounded-md shadow-lg origin-top-right right-0">
            <div class="rounded-md ring-1 ring-black ring-opacity-5 py-1 bg-white">
                <slot></slot>
            </div>
        </div>
    </div>
</template>

<script lang="ts">
import { Component, Vue } from "vue-property-decorator";

@Component
export default class Dropdown extends Vue {
    opened = false;

    toggle (): void {
        this.opened = !this.opened;
    }
}
</script>
