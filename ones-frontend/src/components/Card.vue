<template>
    <div class="bg-white shadow sm:rounded-lg overflow-hidden">
        <div class="px-4 py-5 sm:px-6 flex items-center text-sm text-gray-700 border-b px-6 py-4" v-if="hasHeader()">
            <slot name="header"></slot>
        </div>

        <slot></slot>

        <div class="flex items-center px-4 py-3 bg-gray-50 text-right sm:px-6" v-if="hasFooter()">
            <slot name="footer"></slot>
        </div>
    </div>
</template>

<script lang="ts">
import { Component, Vue } from "vue-property-decorator";

@Component
export default class Card extends Vue {
    hasHeader(): boolean {
        return this.$slots.header !== undefined;
    }

    hasFooter(): boolean {
        return this.$slots.footer !== undefined;
    }
}
</script>
