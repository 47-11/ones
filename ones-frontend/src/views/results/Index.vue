<template>
    <app-layout>
        <div class="max-w-6xl m-auto py-12">
            <page-header>{{ $t("results.title") }}</page-header>

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
                </tr>
                </thead>
                <tbody class="bg-white divide-y divide-gray-200">
                <tr v-for="result in results.list" :key="result.uuid">
                    <v-td></v-td>
                    <v-td></v-td>
                    <v-td>{{ $t(`contests.longTypes.${result.contest.contestType}`) }}</v-td>
                    <v-td class="whitespace-nowrap">
                        <div v-for="horse in result.horses" :key="horse.uuid">
                            {{ horse.name }}
                            <span class="text-xs text-gray-400">
                                {{ horse.lifeNumber }}
                            </span>
                        </div>
                    </v-td>
                    <v-td>{{ result.contest.distance }}</v-td>
                    <v-td>{{ result.placement }}</v-td>
                    <v-td>{{ result.averageSpeed }} km/h</v-td>
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
import { vxm } from "@/store";

@Component({
    components: {
        VLink,
        Pagination,
        VTable,
        VTh,
        VTd,
        AppLayout,
        Card,
        VButton
    }
})
export default class Home extends Vue {
    results = vxm.results;
    locale = window.navigator.language;

    mounted(): void {
        vxm.results.fetchOwn();
    }
}
</script>
