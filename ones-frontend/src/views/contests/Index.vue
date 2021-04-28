<template>
    <app-layout>
        <div class="max-w-6xl m-auto py-12">
            <v-table>
                <thead class="bg-gray-50">
                <tr>
                    <v-th>Datum</v-th>
                    <v-th>Ritt</v-th>
                    <v-th>Rittarten</v-th>
                    <v-th>Region</v-th>
                    <v-th>Dokumente</v-th>
                    <v-th></v-th>
                </tr>
                </thead>
                <tbody class="bg-white divide-y divide-gray-200">
                <tr v-for="contest in contests" :key="contest.id">
                    <v-td>{{contest.date }}</v-td>
                    <v-td>{{contest.name }}</v-td>
                    <v-td>{{contest.type }}</v-td>
                    <v-td>{{contest.location }}</v-td>
                    <v-td>
                        <v-link to="#">Ausschreibung</v-link>
                    </v-td>
                    <v-td>
                        <v-button>Details</v-button>
                    </v-td>
                </tr>
                </tbody>

                <template v-slot:pagination>
                    <div class="hidden sm:flex-1 sm:flex sm:items-center sm:justify-between">
                        <div>
                            <p class="text-sm text-gray-700">
                                Zeigt
                                <span class="font-medium">1</span>
                                bis
                                <span class="font-medium">10</span>
                                von
                                <span class="font-medium">97</span>
                                Ergebnissen
                            </p>
                        </div>
                        <pagination></pagination>
                    </div>
                </template>
            </v-table>
        </div>
    </app-layout>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';
import Card from '@/components/Card.vue';
import AppLayout from '@/layouts/AppLayout.vue';
import VTable from '@/components/table/VTable.vue';
import VTh from '@/components/table/VTh.vue';
import VTd from '@/components/table/VTd.vue';
import Pagination from '@/components/Pagination.vue';
import VButton from '@/components/VButton.vue';
import VLink from '@/components/VLink.vue';

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
    contests = [
        {
            id: 1,
            date: '27.02.2021',
            name: 'Trechwitzer Wald- und Wiesenritt',
            type: 'Distanzfahrt',
            location: 'Berlin - Brandenburg'
        },
        {
            id: 2,
            date: '02.04. bis 04.04.2021',
            name: 'Pferdeparadies am Arendsee Ostern',
            type: 'Distanzfahrt',
            location: 'Westfalen'
        },
        {
            id: 3,
            date: '10.04.2021',
            name: '4. Aprilscherz in der Geest',
            type: 'Kartenritt',
            location: 'Niedersachsen Nord'
        }
    ];
}
</script>
