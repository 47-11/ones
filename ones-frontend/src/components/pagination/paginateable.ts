export interface Paginateable {
    page: number;
    pageSize: number;
    pageCount: number;
    hasNextPage: boolean;
    hasPrevPage: boolean;
    totalElementCount: number;
    firstElementIndex: number;
    lastElementIndex: number;

    selectPage(page: number): Promise<void>;
    nextPage(): Promise<void>;
    prevPage(): Promise<void>;
}
