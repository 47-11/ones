<template>
    <div class="-my-2 overflow-x-auto sm:-mx-6 lg:-mx-8">
        <div class="py-2 align-middle inline-block min-w-full sm:px-6 lg:px-8">
            <div class="shadow overflow-hidden sm:rounded-lg">
                <table class="min-w-full divide-y divide-gray-200">
                    <slot></slot>
                </table>

                <div class="bg-white px-4 py-3 justify-between border-t border-gray-200 sm:px-6" v-if="hasPagination()">
                    <slot name="pagination"></slot>
                </div>
            </div>
        </div>
    </div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';

@Component
export default class VTable extends Vue {
    hasPagination (): boolean {
        return Boolean(this.$slots.pagination);
    }
}
</script>
