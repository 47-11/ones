<template>
    <app-layout>
        <template v-slot:header>
            <div class="ml-0 w-full">
                <div class="flex items-center">
                    <div class="pr-8">
                        <svg aria-hidden="true" focusable="false" data-prefix="fas" data-icon="chevron-left"
                             class="w-7 h-7 text-gray-400 svg-inline--fa fa-chevron-left fa-w-10" role="img"
                             xmlns="http://www.w3.org/2000/svg"
                             viewBox="0 0 320 512">
                            <path fill="currentColor"
                                  d="M34.52 239.03L228.87 44.69c9.37-9.37 24.57-9.37 33.94 0l22.67 22.67c9.36 9.36 9.37 24.52.04 33.9L131.49 256l154.02 154.75c9.34 9.38 9.32 24.54-.04 33.9l-22.67 22.67c-9.37 9.37-24.57 9.37-33.94 0L34.52 272.97c-9.37-9.37-9.37-24.57 0-33.94z"></path>
                        </svg>
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
        <div class="max-w-7xl px-4 sm:px-6 lg:px-8 m-auto py-12">
            <div class="grid grid-cols-3 gap-10">
                <div>
                    <h2 class="text-xl font-bold text-gray-700">Details</h2>
                    <card class="mt-3">
                        <table class="my-3">
                            <tr>
                                <th class="text-left px-5 py-1 align-top">Zeitraum</th>
                                <td class="text-left px-5 py-1">
                                    13. - 16.05.2021
                                    <badge class="bg-lime-600 text-white text-xs ml-2">
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
                            <v-button class="flex items-center">
                                <span class="mr-1.5">VDD-Nennung</span>
                                <svg aria-hidden="true" focusable="false" data-prefix="far" data-icon="file-pdf"
                                     class="w-4 h-4 svg-inline--fa fa-file-pdf fa-w-12" role="img"
                                     xmlns="http://www.w3.org/2000/svg" viewBox="0 0 384 512">
                                    <path fill="currentColor"
                                          d="M369.9 97.9L286 14C277 5 264.8-.1 252.1-.1H48C21.5 0 0 21.5 0 48v416c0 26.5 21.5 48 48 48h288c26.5 0 48-21.5 48-48V131.9c0-12.7-5.1-25-14.1-34zM332.1 128H256V51.9l76.1 76.1zM48 464V48h160v104c0 13.3 10.7 24 24 24h104v288H48zm250.2-143.7c-12.2-12-47-8.7-64.4-6.5-17.2-10.5-28.7-25-36.8-46.3 3.9-16.1 10.1-40.6 5.4-56-4.2-26.2-37.8-23.6-42.6-5.9-4.4 16.1-.4 38.5 7 67.1-10 23.9-24.9 56-35.4 74.4-20 10.3-47 26.2-51 46.2-3.3 15.8 26 55.2 76.1-31.2 22.4-7.4 46.8-16.5 68.4-20.1 18.9 10.2 41 17 55.8 17 25.5 0 28-28.2 17.5-38.7zm-198.1 77.8c5.1-13.7 24.5-29.5 30.4-35-19 30.3-30.4 35.7-30.4 35zm81.6-190.6c7.4 0 6.7 32.1 1.8 40.8-4.4-13.9-4.3-40.8-1.8-40.8zm-24.4 136.6c9.7-16.9 18-37 24.7-54.7 8.3 15.1 18.9 27.2 30.1 35.5-20.8 4.3-38.9 13.1-54.8 19.2zm131.6-5s-5 6-37.3-7.8c35.1-2.6 40.9 5.4 37.3 7.8z"></path>
                                </svg>
                            </v-button>

                            <v-button class="flex items-center ml-2" color="secondary">
                                <span class="mr-1.5">Ausschreibung</span>
                                <svg aria-hidden="true" focusable="false" data-prefix="far" data-icon="file-pdf"
                                     class="w-4 h-4 svg-inline--fa fa-file-pdf fa-w-12" role="img"
                                     xmlns="http://www.w3.org/2000/svg" viewBox="0 0 384 512">
                                    <path fill="currentColor"
                                          d="M369.9 97.9L286 14C277 5 264.8-.1 252.1-.1H48C21.5 0 0 21.5 0 48v416c0 26.5 21.5 48 48 48h288c26.5 0 48-21.5 48-48V131.9c0-12.7-5.1-25-14.1-34zM332.1 128H256V51.9l76.1 76.1zM48 464V48h160v104c0 13.3 10.7 24 24 24h104v288H48zm250.2-143.7c-12.2-12-47-8.7-64.4-6.5-17.2-10.5-28.7-25-36.8-46.3 3.9-16.1 10.1-40.6 5.4-56-4.2-26.2-37.8-23.6-42.6-5.9-4.4 16.1-.4 38.5 7 67.1-10 23.9-24.9 56-35.4 74.4-20 10.3-47 26.2-51 46.2-3.3 15.8 26 55.2 76.1-31.2 22.4-7.4 46.8-16.5 68.4-20.1 18.9 10.2 41 17 55.8 17 25.5 0 28-28.2 17.5-38.7zm-198.1 77.8c5.1-13.7 24.5-29.5 30.4-35-19 30.3-30.4 35.7-30.4 35zm81.6-190.6c7.4 0 6.7 32.1 1.8 40.8-4.4-13.9-4.3-40.8-1.8-40.8zm-24.4 136.6c9.7-16.9 18-37 24.7-54.7 8.3 15.1 18.9 27.2 30.1 35.5-20.8 4.3-38.9 13.1-54.8 19.2zm131.6-5s-5 6-37.3-7.8c35.1-2.6 40.9 5.4 37.3 7.8z"></path>
                                </svg>
                            </v-button>
                        </div>

                        <div class="bg-indigo-50 px-5 py-3 mt-4 text-gray-600 text-sm">
                            Ab dem 01. Januar 2018 gilt der VDD-<a href="#"
                                                                   class="text-indigo-500">Qualifikationsweg</a>.
                        </div>
                    </card>
                </div>

                <div>
                    <h2 class="text-xl font-bold text-gray-700">Rittdaten</h2>
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

                <div>
                    <h2 class="text-xl font-bold text-gray-700">Veranstaltung</h2>
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
                                            <svg aria-hidden="true" focusable="false" data-prefix="fas"
                                                 data-icon="phone"
                                                 class="w-3 h-3 text-gray-400 svg-inline--fa fa-phone fa-w-16"
                                                 role="img"
                                                 xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512">
                                                <path fill="currentColor"
                                                      d="M493.4 24.6l-104-24c-11.3-2.6-22.9 3.3-27.5 13.9l-48 112c-4.2 9.8-1.4 21.3 6.9 28l60.6 49.6c-36 76.7-98.9 140.5-177.2 177.2l-49.6-60.6c-6.8-8.3-18.2-11.1-28-6.9l-112 48C3.9 366.5-2 378.1.6 389.4l24 104C27.1 504.2 36.7 512 48 512c256.1 0 464-207.5 464-464 0-11.2-7.7-20.9-18.6-23.4z"></path>
                                            </svg>
                                        </td>
                                        <td class="pl-3">+49 151 14773681</td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <svg aria-hidden="true" focusable="false" data-prefix="fas"
                                                 data-icon="phone"
                                                 class="w-3 h-3 text-gray-400 svg-inline--fa fa-phone fa-w-16"
                                                 role="img"
                                                 xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512">
                                                <path fill="currentColor"
                                                      d="M493.4 24.6l-104-24c-11.3-2.6-22.9 3.3-27.5 13.9l-48 112c-4.2 9.8-1.4 21.3 6.9 28l60.6 49.6c-36 76.7-98.9 140.5-177.2 177.2l-49.6-60.6c-6.8-8.3-18.2-11.1-28-6.9l-112 48C3.9 366.5-2 378.1.6 389.4l24 104C27.1 504.2 36.7 512 48 512c256.1 0 464-207.5 464-464 0-11.2-7.7-20.9-18.6-23.4z"></path>
                                            </svg>
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

            <h2 class="text-xl font-bold text-gray-700 mt-12">Wettbewerbe</h2>

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

            <div class="mt-4 text-xs text-gray-400">
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

import { Component, Vue } from 'vue-property-decorator';
import AppLayout from '@/layouts/AppLayout.vue';
import Card from '@/components/Card.vue';
import Badge from '@/components/Badge.vue';
import VButton from '@/components/VButton.vue';
import VTable from '@/components/table/VTable.vue';
import VTh from '@/components/table/VTh.vue';
import VTd from '@/components/table/VTd.vue';

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
}
</script>
