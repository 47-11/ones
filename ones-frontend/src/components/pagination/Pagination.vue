<template>
    <div>
        <nav class="relative z-0 inline-flex rounded-md shadow-sm -space-x-px" aria-label="Pagination">
            <a @click="paginateable.prevPage()" v-if="paginateable.hasPrevPage"
               class="relative inline-flex items-center px-2 py-2 rounded-l-md border border-gray-300 bg-white text-sm font-medium text-gray-500 hover:bg-gray-50">
                <span class="sr-only">{{ $t("pagination.back") }}</span>

                <font-awesome-icon :icon="'chevron-left'" class="text-xs mx-2"/>
            </a>

            <a @click="paginateable.selectPage(page - 1)" v-for="page in paginateable.pageCount" :key="page"
               v-bind:class="{ 'rounded-l-md': !paginateable.hasPrevPage && page === 1, 'rounded-r-md': !paginateable.hasNextPage && page === paginateable.pageCount }"
               class="relative inline-flex items-center px-4 py-2 border border-gray-300 bg-white text-sm font-medium text-gray-700 hover:bg-gray-50">
                {{ page }}
            </a>

            <a @click="paginateable.nextPage()" v-if="paginateable.hasNextPage"
               class="relative inline-flex items-center px-2 py-2 rounded-r-md border border-gray-300 bg-white text-sm font-medium text-gray-500 hover:bg-gray-50">
                <span class="sr-only">{{ $t("pagination.forward") }}</span>

                <font-awesome-icon :icon="'chevron-right'" class="text-xs mx-2"/>
            </a>
        </nav>
    </div>
</template>

<script lang="ts">
import { Component, Prop, Vue } from "vue-property-decorator";
import { Paginateable } from "@/components/pagination/paginateable";

@Component
export default class Pagination extends Vue {
    @Prop() public paginateable!: Paginateable;
}
</script>
