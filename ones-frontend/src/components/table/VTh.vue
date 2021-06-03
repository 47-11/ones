<template>
    <th class="px-4 py-3 text-left text-xs font-medium text-gray-500 tracking-wider">
        <div v-if="sortable && sortKey" @click="sort(sortKey)" class="cursor-pointer">
            <slot></slot>

            <div class="inline-block" v-if="isSortedBy(sortKey)">
                <font-awesome-icon v-if="isSortedAscending" :icon="'chevron-down'" class="text-indigo-600"/>
                <font-awesome-icon v-else :icon="'chevron-up'" class="text-indigo-600"/>
            </div>
        </div>
        <div v-else>
            <slot></slot>
        </div>
    </th>
</template>

<script lang="ts">
import { Component, Prop, Vue } from "vue-property-decorator";
import { Sortable } from "@/components/table/sortable";
import { SimpleEventDto as SimpleEvent } from "@/openapi/generated";
import { SortDirection } from "@/store/events.vuex";

@Component
export default class Pagination extends Vue {
    @Prop() public sortable!: Sortable;
    @Prop() public sortKey!: string;

    sort(criterion: keyof SimpleEvent): void {
        if (this.sortable !== undefined && this.sortKey !== undefined) {
            return;
        }

        if (this.isSortedBy(criterion)) {
            this.sortable.toggleSortDirection();
        } else {
            this.sortable.sortBy(criterion);
        }
    }

    isSortedBy(criterion: keyof SimpleEvent): boolean {
        return this.sortable?.sortCriterion === criterion;
    }

    get isSortedAscending(): boolean {
        return this.sortable?.sortDirection === SortDirection.Ascending;
    }
}
</script>
