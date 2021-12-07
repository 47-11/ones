<template>
    <app-layout>
        <div class="max-w-7xl m-auto py-12">
            <page-header>{{ $t("navigation.results") }}</page-header>

            <v-table>
                <thead class="bg-gray-50">
                <tr>
                    <v-th>{{ $t("results.date") }}</v-th>
                    <v-th>{{ $t("results.name") }}</v-th>
                    <v-th>{{ $t("results.contestType") }}</v-th>
                    <v-th>{{ $t("results.horses") }}</v-th>
                    <v-th>{{ $t("results.distance") }}</v-th>
                    <v-th>{{ $t("results.placement") }}</v-th>
                    <v-th>{{ $t("results.averageSpeed") }}</v-th>
                    <v-th>{{ $t("results.pace") }}</v-th>
                    <v-th>{{ $t("results.duration") }}</v-th>
                    <v-th>{{ $t("results.failureReason") }}</v-th>
                </tr>
                </thead>
                <tbody class="bg-white divide-y divide-gray-200">
                <tr v-for="result in results.list" :key="result.uuid">
                    <v-td><date-range :start="result.contest.start" :end="result.contest.end"/></v-td>
                    <v-td>{{ result.event.title }}</v-td>
                    <v-td>{{ result.contest.category }}</v-td>
                    <v-td class="whitespace-nowrap">
                        <div v-for="horse in result.horses" :key="horse.uuid">
                            {{ horse.name }}
                            <span class="text-xs text-gray-400">
                                {{ horse.lifeNumber }}
                            </span>
                        </div>
                    </v-td>
                    <v-td>{{ result.contest.distance }} km</v-td>
                    <v-td>{{ result.placement }}</v-td>
                    <v-td>{{ result.averageSpeed }} km/h</v-td>
                    <v-td>{{ result.pace }} min/km</v-td>
                    <v-td>{{ formattedDuration(result.duration) }}</v-td>
                    <v-td>{{ result.reason }}</v-td>
                </tr>
                </tbody>
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
import DateRange from "@/components/DateRange.vue";
import { getVxm } from "@/store";

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
        DateRange
    }
})
export default class Home extends Vue {
    results = getVxm().results;
    locale = window.navigator.language;

    mounted(): void {
        getVxm().results.fetchOwn();
    }

    formattedDuration(duration: number): string {
        return new Date(duration).toISOString().slice(11, 19);
    }
}
</script>
