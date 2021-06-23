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
                    <h2 class="text-xl">{{ $t("events.filter.title") }}</h2>

                    <span class="text-sm text-indigo-500 hover:text-indigo-600 font-bold ml-auto cursor-pointer" @click="resetFilter()">
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

                            <svg class="w-4 h-4 flex-shrink-0 mx-2" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M14 5l7 7m0 0l-7 7m7-7H3"/>
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

                        <v-label class="mt-5 mb-1">{{ $t("events.filter.region") }}</v-label>

                        <multiselect class="w-full" :multiple="true" :value="selectedRegions" :options="events.regions" :close-on-select="false"
                            @input="updateRegions" :allow-empty="false" style="width: 100%!important">
                            <template slot="selection" slot-scope="{ values, isOpen }"><span class="multiselect__single" v-if="values.length &amp;&amp; !isOpen">{{ $t("events.selectedRegions", { count: values.length}) }}</span></template>
                        </multiselect>
                    </div>
                    <div class="col-span-12 lg:col-span-6 mt-6 lg:mt-0 lg:ml-12">
                        <v-label class="mb-3 flex items-center">
                            {{ $t("events.filter.categories") }}
                            <div class="ml-auto">
                                <span class="text-sm text-indigo-500 hover:text-indigo-600 font-bold ml-auto cursor-pointer" @click="resetCategories()">
                                    {{ $t("events.filter.all") }}
                                </span>
                            </div>
                        </v-label>

                        <div class="grid grid-cols-2 sm:grid-cols-3 md:grid-cols-4 lg:grid-cols-3 gap-x-10">
                            <div class="flex items-center mt-1" v-for="category in events.categories" :key="category.code">
                                <input type="checkbox" v-model="selectedCategories" :value="category.code"
                                    class="rounded border-gray-300 text-indigo-600 shadow-sm focus:border-indigo-300 focus:ring focus:ring-indigo-200 focus:ring-opacity-50"
                                    @change="toggleCategory(category.code)"/>
                                <div class="ml-2">{{category.description}}</div>
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
            <v-table>
                <thead class="bg-gray-50">
                <tr>
                    <v-th :sortable="events" :sortKey="state">
                        {{ $t("events.state") }}
                    </v-th>
                    <v-th :sortable="events" sortKey="start">
                        {{ $t('events.start') }}
                    </v-th>
                    <v-th :sortable="events" sortKey="until">
                        {{ $t('events.end') }}
                    </v-th>
                    <v-th :sortable="events" sortKey="title">
                        {{ $t('events.ride') }}
                    </v-th>
                    <v-th :sortable="events" sortKey="region">
                        {{ $t('events.region') }}
                    </v-th>
                    <v-th>
                        {{ $t('events.rideType') }}
                    </v-th>
                    <v-th>
                        {{ $t('events.categories') }}
                    </v-th>
                    <v-th>
                        {{ $t('events.mapRide') }}
                    </v-th>
                    <v-th>
                        {{ $t('events.internationalRide') }}
                    </v-th>
                    <v-th></v-th>
                </tr>
                </thead>
                <tbody class="bg-white divide-y divide-gray-200">
                <tr v-for="event in events.list" :key="event.uuid">
                    <v-td>
                        {{$t("events.states." + event.state)}}
                    </v-td>
                    <v-td>{{
                            new Date(event.start).toLocaleDateString(locale)
                        }}
                    </v-td>
                    <v-td>{{ new Date(event.end).toLocaleDateString(locale) }}</v-td>
                    <v-td>{{ event.title }}</v-td>
                    <v-td>{{ event.region || "Buxtehude" }}</v-td>
                    <v-td>
                        <badge v-for="rideType in rideTypes(event)" :key="rideType" class="bg-amber-500 text-white text-xs font-medium mr-2 mb-2" >
                            {{rideType}}
                        </badge>
                    </v-td>
                    <v-td>
                        <badge v-for="category in categories(event)" :key="category" class="bg-red-700 text-white text-xs font-medium mr-2 mb-2" >
                            {{category}}
                        </badge>
                    </v-td>
                    <v-td>
                        {{ $t(event.mapRide ? "events.yes" : "events.no")}}
                    </v-td>
                    <v-td>
                        {{ $t(event.internationalRide ? "events.yes" : "events.no")}}
                    </v-td>
                    <v-td>
                        <router-link :to="'/events/' + event.uuid">
                            <v-button>{{ $t('events.details') }}</v-button>
                        </router-link>
                    </v-td>
                </tr>
                </tbody>

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
import VTable from "@/components/table/VTable.vue";
import VTh from "@/components/table/VTh.vue";
import VTd from "@/components/table/VTd.vue";
import Badge from "@/components/Badge.vue";
import Pagination from "@/components/pagination/Pagination.vue";
import VButton from "@/components/VButton.vue";
import VLink from "@/components/VLink.vue";
import { vxm } from "@/store";
import { SimpleEventDto } from "@/openapi/generated";
import VSelect from "@/components/forms/VSelect.vue";
import VCheckbox from "@/components/forms/VCheckbox.vue";
import VRadio from "@/components/forms/VRadio.vue";
import VLabel from "@/components/forms/VLabel.vue";
import PageHeader from "@/components/PageHeader.vue";
import moment from "moment";
import Multiselect from "vue-multiselect/src/Multiselect.vue";

@Component({
    components: {
        VLink,
        Pagination,
        VTable,
        VTh,
        VTd,
        AppLayout,
        Card,
        VButton,
        Badge
        VButton,
        VSelect,
        VLabel,
        VCheckbox,
        VRadio,
        PageHeader,
        Multiselect
    }
})
export default class Home extends Vue {
    events = vxm.events;
    locale = window.navigator.language;

    public data(): {range: undefined} {
        return {
            range: undefined
        };
    }

    showFilter = false;

    mounted(): void {
        vxm.events.fetch();
    }

    // eslint-disable-next-line @typescript-eslint/no-unused-vars
    public rideTypes(event: SimpleEventDto): string[] {
        return [
            "Fahrt",
            "Ritt"
        ];
    }

    // eslint-disable-next-line @typescript-eslint/no-unused-vars
    public categories(event: SimpleEventDto): string[] {
        return [
            "EFR",
            "MTR"
        ];
    }

    async resetFilter(): Promise<void> {
        await this.events.resetFilter();
    }

    async resetCategories(): Promise<void> {
        await this.events.resetCategories();
    }

    get selectedCategories(): string[] {
        return this.events.filter.categories;
    }

    set selectedCategories(value: string[]) {
        this.events.addFilter({
            categories: value
        });
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

    get selectedRegions(): string[] {
        return this.events.filter.regions;
    }

    updateRegions(values: string[]): void {
        this.events.addFilter({
            regions: values
        });
    }
}
</script>
