<template>
    <app-layout>
        <div class="max-w-6xl m-auto py-12">
            <div class="flex items-start">
                <page-header>{{ $t("events.title") }}</page-header>

                <v-button type="button" class="ml-auto mr-6 lg:mr-0" @click.native="showFilter = !showFilter">
                    <span v-if="!showFilter">{{ $t("events.filter.open") }}</span>
                    <span v-else>{{ $t("events.filter.close") }}</span>
                </v-button>
            </div>

            <div class="border-t border-b mb-12 px-6 lg:px-0 pt-6 pb-8" v-if="showFilter">
                <div class="flex items-center">
                    <h2 class="text-xl mb-4">{{ $t("events.filter.title") }}</h2>

                    <span class="text-sm text-indigo-500 hover:text-indigo-600 font-bold ml-auto cursor-pointer"
                          @click="resetFilter()">
                        {{ $t("events.filter.reset") }}
                    </span>
                </div>

                <div class="grid grid-cols-12">
                    <div class="col-span-12 lg:col-span-3">
                        <v-label class="mb-1">{{ $t("events.filter.period") }}</v-label>

                        <div class="flex justify-center items-center">
                            <v-date-picker :columns="$screens({ default: 1, lg: 2 })" v-model="from" is-required>
                                <template v-slot="{ inputValue, inputEvents }">
                                    <div class="flex justify-center items-center">
                                        <input type="text" :value="inputValue" v-on="inputEvents"
                                               class="w-full lg:w-32 rounded-md shadow-sm border-gray-300 focus:border-indigo-300 focus:ring focus:ring-indigo-200 focus:ring-opacity-50"/>
                                    </div>
                                </template>
                            </v-date-picker>

                            <svg class="w-4 h-4 flex-shrink-0 mx-2" fill="none" viewBox="0 0 24 24"
                                 stroke="currentColor">
                                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                                      d="M14 5l7 7m0 0l-7 7m7-7H3"/>
                            </svg>

                            <v-date-picker :columns="$screens({ default: 1, lg: 2 })" v-model="until">
                                <template v-slot="{ inputValue, inputEvents }">
                                    <div class="flex justify-center items-center">
                                        <input type="text" :value="inputValue" v-on="inputEvents"
                                               class="w-full lg:w-32 rounded-md shadow-sm border-gray-300 focus:border-indigo-300 focus:ring focus:ring-indigo-200 focus:ring-opacity-50"/>
                                    </div>
                                </template>
                            </v-date-picker>
                        </div>

                        <v-label class="mt-5 mb-1 flex items-center">
                            {{ $t("events.filter.region") }}
                            <div class="ml-auto">
                                <span class="text-sm text-indigo-500 hover:text-indigo-600 font-bold ml-auto cursor-pointer"
                                    @click="resetRegions()">
                                    {{ $t("events.filter.all") }}
                                </span>
                                <span class="text-sm text-indigo-500 hover:text-indigo-600 font-bold ml-2 cursor-pointer"
                                      @click="noneRegions()">
                                    {{ $t("events.filter.none") }}
                                </span>
                            </div>
                        </v-label>

                        <multiselect class="w-full" :multiple="true" :value="selectedRegions" :options="events.regions"
                                     :close-on-select="false"
                                     @input="updateRegions" :allow-empty="false" style="width: 100%!important">
                            <template slot="selection" slot-scope="{ values, isOpen }"><span class="multiselect__single"
                                                                                             v-if="values.length &amp;&amp; !isOpen">{{
                                    $t("events.selectedRegions", {count: values.length})
                                }}</span></template>
                        </multiselect>

                        <v-label class="mt-5 mb-1">{{ $t("events.filter.registrationStatus") }}</v-label>

                        <v-select class="w-full lg:w-44" v-model="alreadySignedUp">
                            <option value="undefined">---</option>
                            <option value="true">{{ $t("events.filter.registered") }}</option>
                            <option value="false">{{ $t("events.filter.notRegistered") }}</option>
                        </v-select>
                    </div>
                    <div class="col-span-12 lg:col-span-6 mt-6 lg:mt-0 lg:ml-12">
                        <v-label class="mb-3 flex items-center">
                            {{ $t("events.filter.categories") }}
                            <div class="ml-auto">
                                <span class="text-sm text-indigo-500 hover:text-indigo-600 font-bold ml-auto cursor-pointer"
                                    @click="resetCategories()">
                                    {{ $t("events.filter.all") }}
                                </span>
                                <span class="text-sm text-indigo-500 hover:text-indigo-600 font-bold ml-2 cursor-pointer"
                                      @click="noneCategories()">
                                    {{ $t("events.filter.none") }}
                                </span>
                            </div>
                        </v-label>

                        <div class="grid grid-cols-2 sm:grid-cols-3 md:grid-cols-4 lg:grid-cols-3 gap-x-10">
                            <div class="flex items-center mt-1" v-for="category in events.categories"
                                 :key="category.code">
                                <input type="checkbox" v-model="selectedCategories" :value="category.code"
                                       class="rounded border-gray-300 text-indigo-600 shadow-sm focus:border-indigo-300 focus:ring focus:ring-indigo-200 focus:ring-opacity-50"/>
                                <div class="ml-2">{{ category.description }}</div>
                            </div>
                        </div>
                    </div>
                    <div class="col-span-12 lg:col-span-3 flex flex-col items-start md:w-full lg:w-auto lg:ml-12">
                        <div class="mt-5 w-full lg:w-auto lg:mt-0 lg:ml-6">
                            <v-label class="mb-3">{{ $t("events.filter.cardRide") }}</v-label>

                            <v-select class="w-full lg:w-44" v-model="cardRide">
                                <option value="undefined">---</option>
                                <option value="true">{{ $t("events.shared.yes") }}</option>
                                <option value="false">{{ $t("events.shared.no") }}</option>
                            </v-select>
                        </div>

                        <div class="mt-5 w-full lg:w-auto lg:ml-6">
                            <v-label class="mb-3">{{ $t("events.filter.internationalChampionchip") }}</v-label>

                            <v-select class="w-full lg:w-44" v-model="internationalChampionchip">
                                <option value="undefined">---</option>
                                <option value="true">{{ $t("events.shared.yes") }}</option>
                                <option value="false">{{ $t("events.shared.no") }}</option>
                            </v-select>
                        </div>
                    </div>
                </div>
            </div>

            <no-results v-if="events.list.length === 0">
                {{ $t("events.noEvents")}}
            </no-results>

            <v-table class="relative" ref="eventTableBody" v-else>
                <v-thead class="bg-gray-50">
                    <v-tr>
                        <v-th class="sm:w-1/12">
                            {{ $t("events.state") }}
                        </v-th>
                        <v-th :sortable="events" sortKey="start" class="sm:w-3/12">
                            {{ $t('events.date') }}
                        </v-th>
                        <v-th :sortable="events" sortKey="title" class="sm:w-3/12">
                            {{ $t('events.ride') }}
                        </v-th>
                        <v-th :sortable="events" sortKey="region" class="sm:w-2/12">
                            {{ $t('events.region') }}
                        </v-th>
                        <v-th class="sm:w-2/12">
                            {{ $t('events.categories') }}
                        </v-th>
                        <v-th class="sm:w-1/12"></v-th>
                    </v-tr>
                </v-thead>
                <v-tbody class="bg-white divide-y divide-gray-200" isLoading="isLoading">
                <v-tr v-for="event in events.list" :key="event.uuid" v-on:click="details(event)" class="cursor-pointer">
                    <v-td class="sm:w-1/12">
                        {{$t("events.states." + event.status)}}
                    </v-td>
                    <v-td class="sm:w-3/12">
                        <date-range :start="event.start" :end="event.end"/>
                    </v-td>
                    <v-td class="sm:w-3/12">
                        <router-link :to="'/events/' + event.uuid">
                            <div class="whitespace-normal" style="max-width: 8rem">
                                {{ event.title }}
                            </div>
                        </router-link>
                    </v-td>
                    <v-td class="sm:w-3/12">{{ event.region || "Buxtehude" }}</v-td>
                    <v-td class="sm:w-2/12">
                        <div class="whitespace-normal" style="max-width: 10rem;">
                            <template v-for="(category, index) in categories(event)">
                                {{category}}<template v-if="index < categories(event).length - 1">,</template>
                            </template>
                        </div>
                    </v-td>
                    <v-td class="sm:w-1/12">
                        <div class="flex">
                        <font-awesome-icon :icon="'map'" class="mx-2 text-gray-200"
                            v-tooltip="event.isMap ? $t('events.mapRide') : $t('events.noMapRide')"
                            v-bind:class="{
                                'text-gray-600': event.isMap
                            }"></font-awesome-icon>
                        <font-awesome-icon :icon="'flag'" class="mx-2 text-gray-200"
                            v-tooltip="event.isNationalChampionship ? $t('events.nationalChampionship') : $t('events.noNationalChampionship')"
                            v-bind:class="{
                                'text-gray-600': event.isNationalChampionship
                            }"></font-awesome-icon>
                        <font-awesome-icon :icon="'globe'" class="mx-2 text-gray-200"
                            v-tooltip="event.isInternational ? $t('events.internationalRide') : $t('events.noInternationalRide')"
                            v-bind:class="{
                                'text-gray-600': event.isInternational
                            }"></font-awesome-icon>

                        <font-awesome-icon :icon="'check'" class="mx-2 text-gray-200"
                                           v-tooltip="isRegisteredFor(event) ? $t('events.registered') : $t('events.notRegistered')"
                                           v-bind:class="{
                                'text-lime-600': isRegisteredFor(event)
                            }"></font-awesome-icon>
                        </div>
                    </v-td>
                </v-tr>
                </v-tbody>

                <template v-slot:pagination v-if="true">
                    <div class="hidden sm:flex-1 sm:flex sm:items-center sm:justify-between">
                        <div class="text-sm text-gray-700">
                            <i18n path="events.pagination">
                                <template v-slot:from>
                                    <span class="font-medium">
                                        {{ events.firstElementIndex + 1 }}
                                    </span>
                                </template>

                                <template v-slot:to>
                                    <span class="font-medium">
                                        {{ events.lastElementIndex + 1 }}
                                    </span>
                                </template>

                                <template v-slot:of>
                                    <span class="font-medium">
                                        {{ events.totalElementCount }}
                                    </span>
                                </template>
                            </i18n>
                        </div>

                        <pagination :paginateable="events"></pagination>
                    </div>
                </template>
            </v-table>
        </div>
    </app-layout>
</template>

<script lang="ts">
import { Component, Vue } from "vue-property-decorator";
import Card from "@/components/Card.vue";
import AppLayout from "@/layouts/AppLayout.vue";
import Badge from "@/components/Badge.vue";
import Pagination from "@/components/pagination/Pagination.vue";
import VButton from "@/components/VButton.vue";
import VLink from "@/components/VLink.vue";
import { SimpleEventDto } from "@/openapi/generated";
import VSelect from "@/components/forms/VSelect.vue";
import VCheckbox from "@/components/forms/VCheckbox.vue";
import VRadio from "@/components/forms/VRadio.vue";
import VLabel from "@/components/forms/VLabel.vue";
import PageHeader from "@/components/PageHeader.vue";
import moment from "moment";
import Multiselect from "vue-multiselect/src/Multiselect.vue";
import DateRange from "@/components/DateRange.vue";
import { getVxm } from "@/store";
import { LoaderComponent } from "vue-loading-overlay";

@Component({
    components: {
        VLink,
        Pagination,
        AppLayout,
        Card,
        VButton,
        Badge,
        VCheckbox,
        DateRange,
        VSelect,
        VLabel,
        VRadio,
        PageHeader,
        Multiselect
    }
})
export default class Home extends Vue {
    events = getVxm().events;
    locale = window.navigator.language;

    public data(): { range: undefined } {
        return {
            range: undefined
        };
    }

    showFilter = false;

    private loading?: LoaderComponent;

    mounted(): void {
        getVxm().events.fetch();

        this.handleLoading(true);
        getVxm().events.$watch("isLoading", this.handleLoading.bind(this));
    }

    private handleLoading(isLoading: boolean): void {
        if (isLoading) {
            this.loading = this.$loading.show();
        } else {
            // eslint-disable-next-line no-unused-expressions
            this.loading?.hide();
        }
    }

    public categories(event: SimpleEventDto): string[] {
        return event.contests?.map(
            contest => contest.category || ""
        ) || [];
    }

    public details(event: SimpleEventDto): void {
        this.$router.push("/events/" + event.uuid);
    }

    async resetFilter(): Promise<void> {
        await this.events.resetFilter();
    }

    async resetCategories(): Promise<void> {
        await this.events.resetCategories();
    }

    async noneCategories(): Promise<void> {
        await this.events.addFilter({ categories: [] });
    }

    async resetRegions(): Promise<void> {
        await this.events.resetRegions();
    }

    async noneRegions(): Promise<void> {
        await this.events.addFilter({ regions: [] });
    }

    get selectedCategories(): string[] {
        return this.events.filter.categories;
    }

    set selectedCategories(value: string[]) {
        this.events.addFilter({
            categories: value
        });
    }

    get alreadySignedUp(): "true" | "false" | "undefined" {
        return `${this.events.filter.alreadySignedUp}` as "true" | "false" | "undefined";
    }

    set alreadySignedUp(value: "true" | "false" | "undefined") {
        if (value === "undefined") {
            this.events.removeFilter("alreadySignedUp");
        } else {
            this.events.addFilter({ alreadySignedUp: value === "true" });
        }
    }

    toggleCategory(category: string): void {
        const categories = this.events.filter.categories;
        const position = categories.indexOf(category);
        if (position > -1) {
            categories.splice(position, 1);
        } else {
            categories.push(category);
        }
        this.events.addFilter({ categories });
    }

    get cardRide(): "true" | "false" | "undefined" {
        return `${this.events.filter.isCard}` as "true" | "false" | "undefined";
    }

    set cardRide(value: "true" | "false" | "undefined") {
        if (value === "undefined") {
            this.events.removeFilter("isCard");
        } else {
            this.events.addFilter({ isCard: value === "true" });
        }
    }

    get internationalChampionchip(): "true" | "false" | "undefined" {
        return `${this.events.filter.isInternational}` as "true" | "false" | "undefined";
    }

    set internationalChampionchip(value: "true" | "false" | "undefined") {
        if (value === "undefined") {
            this.events.removeFilter("isInternational");
        } else {
            this.events.addFilter({ isInternational: value === "true" });
        }
    }

    get from(): Date {
        return moment(this.events.filter.from).toDate();
    }

    set from(value: Date) {
        this.events.addFilter({ from: value.toISOString() });
    }

    get until(): Date | undefined {
        const until = this.events.filter.until;
        if (until) {
            moment(until).toDate();
        } else {
            return undefined;
        }
    }

    set until(value: Date | undefined) {
        if (value) {
            this.events.addFilter({ until: value.toISOString() });
        } else {
            this.events.removeFilter("until");
        }
    }

    isRegisteredFor(event: SimpleEventDto): boolean {
        return event.contests?.some(
            contest => (contest.signedUpHorses?.length || 0) > 0
        ) || false;
    }

    get selectedRegions(): string[] {
        return this.events.filter.regions;
    }

    updateRegions(values: string[]): void {
        this.events.addFilter({
            regions: values
        });
    }

    get isLoading(): boolean {
        return getVxm().events.isLoading;
    }
}
</script>
