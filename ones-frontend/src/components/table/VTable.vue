<template>
    <div class="-my-2 overflow-x-auto sm:-mx-6 lg:-mx-8">
        <div class="py-2 align-middle inline-block min-w-full sm:px-6 lg:px-8">
            <div class="shadow overflow-hidden sm:rounded-lg">
                <div class="min-w-full table divide-y divide-gray-200 dark:divide-gray-800">
                    <slot></slot>
                </div>

                <div class="bg-white dark:bg-gray-800 px-4 py-3 justify-between border-t border-gray-200 dark:border-gray-900 dark:text-gray-300 dark:divide-gray-800 sm:px-6">
                    <slot name="pagination"></slot>
                </div>
            </div>
        </div>
    </div>
</template>

<script lang="ts">
import { Component, Vue } from "vue-property-decorator";

@Component
export default class VTable extends Vue {
    hasPagination(): boolean {
        return Boolean(this.$slots.pagination);
    }
}
</script>
