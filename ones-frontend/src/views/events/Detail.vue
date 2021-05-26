<template>
    <app-layout>
        <template v-slot:header>
            <div class="ml-0 w-full">
                <div class="flex items-center">
                    <div class="pr-4 md:pr-8">
                        <router-link to="/events">
                            <font-awesome-icon :icon="'chevron-left'" class="text-2xl"/>
                        </router-link>
                    </div>
                    <div>
                        <div class="text-sm text-gray-700">
                            13. - 16.05.2021
                        </div>
                        <h1 class="text-xl">
                            Ortsausgang Stuck
                        </h1>
                    </div>

                    <v-button class="ml-auto">Merken</v-button>
                </div>
            </div>
        </template>
        <div class="max-w-7xl md:px-4 sm:px-6 lg:px-8 m-auto py-8 md:py-10">
            <div class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
                <div>
                    <h2 class="text-xl px-4 md:px-0 font-bold text-gray-700">Details</h2>
                    <card class="mt-3">
                        <table class="my-3">
                            <tr>
                                <th class="text-left px-5 py-1 align-top">Zeitraum</th>
                                <td class="text-left px-5 py-1">
                                    <span class="mr-2">13. - 16.05.2021</span>
                                    <badge class="bg-lime-600 text-white text-xs">
                                        <span class="font-normal">steht fest</span>
                                    </badge>
                                </td>
                            </tr>
                            <tr>
                                <th class="text-left px-5 py-1 align-top">Region</th>
                                <td class="text-left px-5 py-1">
                                    Mecklenburg-Vorpommern
                                </td>
                            </tr>
                            <tr>
                                <th class="text-left px-5 py-1 align-top">Land</th>
                                <td class="text-left px-5 py-1">
                                    Deutschland
                                </td>
                            </tr>
                            <tr>
                                <th class="text-left px-5 py-1 align-top">Ort</th>
                                <td class="text-left px-5 py-1">
                                    Ortsausgang Stuck <br>
                                    Lenzenerstraße <br>
                                    19294 Stuck
                                </td>
                            </tr>
                        </table>

                        <div class="text-xs px-5 my-4">
                            <v-button class="flex items-center my-1 mr-2">
                                <span class="mr-1.5">VDD-Nennung</span>
                                <font-awesome-icon :icon="'file-pdf'"/>
                            </v-button>

                            <v-button class="flex items-center my-1" color="secondary">
                                <span class="mr-1.5">Ausschreibung</span>
                                <font-awesome-icon :icon="'file-pdf'"/>
                            </v-button>
                        </div>

                        <div class="bg-indigo-50 px-5 py-3 mt-4 text-gray-600 text-sm">
                            Ab dem 01. Januar 2018 gilt der VDD-<a href="#"
                                                                   class="text-indigo-500">Qualifikationsweg</a>.
                        </div>
                    </card>
                </div>

                <div>
                    <h2 class="text-xl px-4 md:px-0 font-bold text-gray-700 sm:mt-4 md:mt-0 lg:mt-0">Rittdaten</h2>
                    <card class="mt-3">
                        <table class="my-3">
                            <tr>
                                <th class="text-left px-5 py-1 align-top">MDR</th>
                                <td class="text-left px-5 py-1">
                                    62 <span class="text-gray-400 text-xs font-normal">km</span>
                                </td>
                            </tr>
                            <tr>
                                <th class="text-left px-5 py-1 align-top">
                                    LDR
                                </th>
                                <td class="text-left px-5 py-1 align-top">
                                    82, 100, 120 <span class="text-gray-400 text-xs font-normal">km</span>
                                </td>
                            </tr>
                            <tr>
                                <th class="text-left px-5 py-1 align-top">MTR</th>
                                <td class="text-left px-5 py-1">
                                    124 (62/62), 164 (82/82) <span class="text-gray-400 text-xs font-normal">km</span>
                                </td>
                            </tr>
                        </table>

                        <div class="-mx-1 px-5 mt-3">
                            <badge class="bg-gray-200 mx-1 text-gray-700 text-sm">Distanzritt</badge>
                            <badge class="bg-gray-200 mx-1 text-gray-700 text-sm">Distanzfahrt</badge>
                        </div>

                        <div class="bg-gray-100 px-5 py-3 mt-4 text-gray-600 text-sm">
                            <span class="text-xs text-gray-400">Bemerkung</span> <br>
                            Lorem ipsum dolor sit amet, consetetur sadipscing elitr, dolore sed diam nonumy eirmod.
                        </div>
                    </card>
                </div>

                <div class="md:col-span-2 lg:col-span-1">
                    <h2 class="text-xl px-4 md:px-0 font-bold text-gray-700 mt-4 lg:mt-0">Veranstaltung</h2>
                    <card class="mt-3 py-1 text-sm">
                        <div class="px-5 py-2 border-b">
                            <div class="font-bold mb-0.5 text-gray-700">Veranstalter</div>
                            <div class="leading-5 mt-1">
                                Vivien und Wiebke Angelbeck <br>
                                <span class="text-xs text-gray-400">Eldena Straße 6 - 19294 Stuck (DE)</span>
                            </div>
                        </div>

                        <div class="px-5 py-2 border-b">
                            <div class="font-bold mb-0.5 text-gray-700">Organisator</div>
                            <div class="leading-5 mt-1">
                                Vivien und Wiebke Angelbeck <br>
                                <span class="text-xs text-gray-400">Eldena Straße 6 - 19294 Stuck (DE)</span>
                            </div>
                        </div>

                        <div class="px-5 py-2">
                            <div class="font-bold mb-0.5 text-gray-700">Infos und Nennungen</div>
                            <div class="leading-5 mt-1">
                                Vivien und Wiebke Angelbeck <br>
                                <span class="text-xs text-gray-400">Eldena Straße 6 - 19294 Stuck (DE)</span> <br>

                                <table class="mt-3">
                                    <tr>
                                        <td>
                                            <font-awesome-icon :icon="'phone'" class="text-gray-400"/>
                                        </td>
                                        <td class="pl-3">+49 151 14773681</td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <font-awesome-icon :icon="'at'" class="text-gray-400"/>
                                        </td>
                                        <td class="pl-3 text-indigo-500">
                                            <a href="mailto:example@example.de">
                                                wiebke.angelbeck@gmx.de
                                            </a>
                                        </td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                    </card>
                </div>
            </div>

            <h2 class="text-xl font-bold text-gray-700 px-4 md:px-0 mt-12">Wettbewerbe</h2>

            <v-table class="mt-2">
                <thead class="bg-gray-50">
                <tr>
                    <v-th>WB</v-th>
                    <v-th>Distanz</v-th>
                    <v-th>Datum</v-th>
                    <v-th>Quali-Stufe</v-th>
                    <v-th>Höhenmeter<sup class="text-gray-400">1</sup></v-th>
                    <v-th>Kosten<sup class="text-gray-400">2</sup></v-th>
                    <v-th>Startgeld<sup class="text-gray-400">3</sup></v-th>
                    <v-th>Höchstzeit<sup class="texts text-gray-400">4</sup></v-th>
                    <v-th>min. Alter Pferd</v-th>
                    <v-th>min. Alter TN</v-th>
                    <v-th>TN/max TN</v-th>
                </tr>
                </thead>
                <tbody class="bg-white divide-y divide-gray-200">
                <tr>
                    <v-td class="font-bold">EFR</v-td>
                    <v-td>40km</v-td>
                    <v-td>08.05.</v-td>
                    <v-td>1</v-td>
                    <v-td></v-td>
                    <v-td>20,00 €</v-td>
                    <v-td>20,00 €</v-td>
                    <v-td>T8</v-td>
                    <v-td>5</v-td>
                    <v-td></v-td>
                    <v-td></v-td>
                </tr>
                <tr>
                    <v-td class="font-bold">MDR</v-td>
                    <v-td>82km</v-td>
                    <v-td>08.05.</v-td>
                    <v-td>2</v-td>
                    <v-td></v-td>
                    <v-td>30,00 €</v-td>
                    <v-td>30,00 €</v-td>
                    <v-td>T8</v-td>
                    <v-td>7</v-td>
                    <v-td></v-td>
                    <v-td></v-td>
                </tr>
                </tbody>
            </v-table>

            <div class="mt-4 text-xs text-gray-400 px-4 md:px-0">
                <table>
                    <tr>
                        <td class="pr-3">1)</td>
                        <td>Höhenmeterangabe = Summe aus Aufstieg und Abstieg</td>
                    </tr>
                    <tr>
                        <td class="pr-3">2)</td>
                        <td>
                            Bei GEspannen und Handpferderitten wird Nenngeld pro Pferd erhoben,
                            Stardgeld pro Gespann. Nenn- und Startgeld max 1,00 € pro km;
                            VDD Nichtmitglieder zahlen zusätzlich zum Startgeld: EFR/F 7,50 €,
                            KDR/F 15,00 €, MDR/F 21,00 €, LDR/F 30,00 €, Jugend bis 21 Jahre: 6 €
                        </td>
                    </tr>
                    <tr>
                        <td class="pr-3">3)</td>
                        <td>
                            Höchstzeit in min/km = langsamste erlaubte Zeit um in der Wertung
                            zu bleiben (Empfehlung lt. VDD-Regelment: T8 - T9)
                        </td>
                    </tr>
                    <tr>
                        <td class="pr-3">4)</td>
                        <td>nach Absprache mit dem Veranstalter</td>
                    </tr>
                </table>
            </div>
        </div>
    </app-layout>
</template>
<script lang="ts">

import { Component, Vue } from "vue-property-decorator";
import AppLayout from "@/layouts/AppLayout.vue";
import Card from "@/components/Card.vue";
import Badge from "@/components/Badge.vue";
import VButton from "@/components/VButton.vue";
import VTable from "@/components/table/VTable.vue";
import VTh from "@/components/table/VTh.vue";
import VTd from "@/components/table/VTd.vue";
import { vxm } from "@/store";

@Component({
    components: {
        VTable,
        VButton,
        Badge,
        Card,
        AppLayout,
        VTh,
        VTd
    }
})
export default class Detail extends Vue {
    eventId = this.$route.params.eventId;
    details = vxm.events.eventDetails;
    contests = vxm.events.eventContests;

    mounted(): void {
        vxm.events.fetchEvent(this.eventId).then(() => {
            console.dir(vxm.events.eventDetails);
        });
    }
}
</script>
