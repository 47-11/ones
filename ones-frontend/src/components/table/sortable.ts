import { SortDirection } from "@/store/events.vuex";

export interface Sortable {
    sortCriterion: string;
    sortDirection: SortDirection;

    sortBy(criterion: string): Promise<void>;
    sortInDirection(direction: SortDirection): Promise<void>;
    toggleSortDirection(): Promise<void>;
}
