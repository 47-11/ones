<template>
    <app-layout>
        <div class="max-w-6xl m-auto py-12">
            <div class="flex items-start">
                <page-header>{{ $t("events.title") }}</page-header>

                <v-button type="button" class="ml-auto mr-6 lg:mr-0" v-on:click.native="showFilter = !showFilter">
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

                <div class="flex flex-col lg:flex-row mt-6">
                    <div>
                        <v-label class="mb-1">{{ $t("events.filter.period") }}</v-label>

                        <v-date-picker v-model="range" is-range :columns="$screens({ default: 1, lg: 4 })">
                            <template v-slot="{ inputValue, inputEvents }">
                                <div class="flex justify-center items-center">
                                    <input type="text" :value="inputValue.start" v-on="inputEvents.start"
                                    class="w-full lg:w-36 rounded-md shadow-sm border-gray-300 focus:border-indigo-300 focus:ring focus:ring-indigo-200 focus:ring-opacity-50"/>
                                    <svg class="w-4 h-4 flex-shrink-0 mx-2" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                                        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M14 5l7 7m0 0l-7 7m7-7H3"/>
                                    </svg>
                                    <input type="text" :value="inputValue.end" v-on="inputEvents.end"
                                    class="w-full lg:w-36 rounded-md shadow-sm border-gray-300 focus:border-indigo-300 focus:ring focus:ring-indigo-200 focus:ring-opacity-50"/>
                                </div>
                            </template>
                        </v-date-picker>

                        <v-label class="mt-5 mb-1">{{ $t("events.filter.region") }}</v-label>

                        <v-select class="w-full">
                            <option v-for="region in events.regions" :key="region">{{region}}</option>
                        </v-select>
                    </div>
                    <div class="mt-6 lg:mt-0 lg:ml-12">
                        <v-label class="mb-3 flex items-center">
                            {{ $t("events.filter.categories") }}
                            <div class="ml-auto">
                                <span class="text-indigo-500">{{ $t("events.filter.all") }}</span>
                            </div>
                        </v-label>

                        <div class="grid grid-cols-3 md:grid-cols-4 lg:gird-cols-3 gap-x-10">
                            <div class="flex items-center mt-1" v-for="category in events.categories" :key="category.code">
                                <v-checkbox/>
                                <div class="ml-2">{{category.description}}</div>
                            </div>
                        </div>
                    </div>
                    <div class="flex flex-col items-start md:flex-row md:w-full lg:w-auto">
                        <div class="mt-5 w-full lg:w-auto lg:mt-0 lg:ml-12">
                            <v-label class="mb-3">{{ $t("events.filter.cardRide") }}</v-label>

                            <v-select class="w-full lg:w-36">
                                <option>---</option>
                                <option>{{ $t("events.filter.yes") }}</option>
                                <option>{{ $t("events.filter.no") }}</option>
                            </v-select>
                        </div>

                        <div class="mt-5 w-full md:mx-6 lg:mx-0 lg:w-auto lg:mt-0 lg:ml-6">
                            <v-label class="mb-3">{{ $t("events.filter.nationalChampionchip") }}</v-label>

                            <v-select class="w-full lg:w-36">
                                <option>---</option>
                                <option>{{ $t("events.filter.yes") }}</option>
                                <option>{{ $t("events.filter.no") }}</option>
                            </v-select>
                        </div>

                        <div class="mt-5 w-full lg:w-auto lg:mt-0 lg:ml-6">
                            <v-label class="mb-3">{{ $t("events.filter.internationalChampionchip") }}</v-label>

                            <v-select class="w-full lg:w-36">
                                <option>---</option>
                                <option>{{ $t("events.filter.yes") }}</option>
                                <option>{{ $t("events.filter.no") }}</option>
                            </v-select>
                        </div>
                    </div>
                </div>
            </div>
            <v-table>
                <thead class="bg-gray-50">
                <tr>
                    <v-th :sortable="events" sortKey="start">
                        {{ $t('events.start') }}
                    </v-th>
                    <v-th :sortable="events" sortKey="end">
                        {{ $t('events.end') }}
                    </v-th>
                    <v-th :sortable="events" sortKey="title">
                        {{ $t('events.ride') }}
                    </v-th>
                    <v-th>{{ $t('events.documents') }}</v-th>
                    <v-th></v-th>
                </tr>
                </thead>
                <tbody class="bg-white divide-y divide-gray-200">
                <tr v-for="event in events.list" :key="event.uuid">
                    <v-td>{{
                            new Date(event.start).toLocaleDateString(locale)
                        }}
                    </v-td>
                    <v-td>{{ new Date(event.end).toLocaleDateString(locale) }}</v-td>
                    <v-td>{{ event.title }}</v-td>
                    <v-td>
                        <v-link to="#">{{ $t('events.callForTenders') }}</v-link>
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
import Pagination from "@/components/pagination/Pagination.vue";
import VButton from "@/components/VButton.vue";
import VLink from "@/components/VLink.vue";
import { vxm } from "@/store";
import VSelect from "@/components/forms/VSelect.vue";
import VCheckbox from "@/components/forms/VCheckbox.vue";
import VRadio from "@/components/forms/VRadio.vue";
import VLabel from "@/components/forms/VLabel.vue";
import PageHeader from "@/components/PageHeader.vue";

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
        VSelect,
        VLabel,
        VCheckbox,
        VRadio,
        PageHeader
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

    resetFilter(): void {
        // Do something ...
    }

    log(text: string): void {
        console.dir(text);
    }
}
</script>
