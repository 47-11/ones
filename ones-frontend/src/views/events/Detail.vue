<template>
    <app-layout v-if="event.details">
        <template v-slot:header>
            <div class="ml-0 w-full">
                <div class="flex items-center">
                    <div class="pr-4 md:pr-8">
                        <router-link to="/events">
                            <font-awesome-icon :icon="'chevron-left'" class="text-2xl"/>
                        </router-link>
                    </div>
                    <div class="flex items-center">
                        <div>
                            <div class="text-sm text-gray-700">
                                <date-range :start="event.details.start" :end="event.details.end"/>
                            </div>
                            <h1 class="text-xl">
                                {{ event.details.address.locationName }}
                            </h1>
                        </div>
                        <badge v-if="event.details.isNationalChampionship" class="bg-indigo-600 text-white text-sm ml-10 font-medium">
                            Landesmeisterschaft
                        </badge>

                        <badge v-if="event.details.isInternational" class="bg-indigo-600 text-white text-sm ml-10 font-medium">
                            Weltmeisterschaft
                        </badge>
                    </div>
                </div>
            </div>
        </template>
        <div class="max-w-7xl md:px-4 sm:px-6 lg:px-8 m-auto py-8 md:py-10">
            <div class="grid grid-cols-1 md:grid-cols-2 gap-6 lg:grid-cols-3">
                <div>
                    <h2 class="text-xl px-4 md:px-0 font-bold text-gray-700">Ort und Zeit</h2>
                    <card class="mt-3">
                        <table class="my-3">
                            <tr>
                                <th class="text-left px-5 py-1 align-top">Zeitraum</th>
                                <td class="text-left px-5 py-1">
                                    <span class="mr-2">
                                        <date-range :start="event.details.start" :end="event.details.end"/>
                                    </span>
                                </td>
                            </tr>
                            <tr>
                                <th class="text-left px-5 py-1 align-top">Region</th>
                                <td class="text-left px-5 py-1">
                                    {{ event.details.address.region }}
                                </td>
                            </tr>
                            <tr>
                                <th class="text-left px-5 py-1 align-top">Land</th>
                                <td class="text-left px-5 py-1">
                                    {{ event.details.address.country }}
                                </td>
                            </tr>
                            <tr>
                                <th class="text-left px-5 py-1 align-top">Ort</th>
                                <td class="text-left px-5 py-1">
                                    {{ event.details.address.locationName }} <br>
                                    {{ event.details.address.street }} <br>
                                    {{ event.details.address.zipCode }} {{ event.details.address.city }}
                                </td>
                            </tr>
                        </table>

                        <div class="bg-indigo-50 px-5 py-3 mt-4 text-gray-600 text-sm">
                            Ab dem 01. Januar 2018 gilt der VDD-<a href="#" class="text-indigo-500">Qualifikationsweg</a>.
                        </div>
                    </card>
                </div>

                <div>
                    <h2 class="text-xl px-4 md:px-0 font-bold text-gray-700">Details</h2>
                    <card class="mt-3">
                        <table class="my-3">
                            <tr>
                                <th class="text-left px-5 py-1 align-top">Nennschluss</th>
                                <td class="text-left px-5 py-1">
                                    {{ deadline.format("DD.MM.YYYY") }}
                                </td>
                            </tr>
                            <tr>
                                <th class="text-left px-5 py-1 align-top leading-5">
                                    Nenngeld <br>
                                    <span class="text-xs text-gray-400 font-normal">
                                        falls Nennschluss verpasst
                                    </span>
                                </th>
                                <td class="text-left px-5 py-1">
                                    {{ event.details.participationApplicationDeadlineMissedFee }} EUR
                                </td>
                            </tr>
                        </table>

                        <div class="px-5 text-sm text-gray-400">
                            Unterbringungen
                        </div>

                        <table class="mb-4">
                            <tr v-for="(accommodation, index) in event.details.availableAccommodations" :key="index">
                                <th class="text-left px-5 py-1 align-top">{{ accommodation.type }}</th>
                                <td class="text-left px-5 py-1">
                                    {{ accommodation.fee }} {{ accommodation.feeUnit }}
                                </td>
                                <td class="text-left px-5 py-1">
                                    {{ accommodation.pledgeFee }} EUR <span class="text-xs text-gray-500">Pfand</span>
                                </td>
                            </tr>
                        </table>

                        <div class="px-5 pb-5">
                            <badge class="bg-amber-500 text-white text-xs font-medium mr-2 mb-2" v-if="event.details.isVaccinationMandatory">
                                Impfpflicht
                            </badge>

                            <badge class="bg-gray-200 text-gray-600 text-xs font-medium mr-2 mb-2" v-if="!event.details.isVaccinationMandatory">
                                keine Impfpflicht
                            </badge>

                            <badge class="bg-amber-500 text-white text-xs font-medium mr-2 mb-2" v-if="event.details.isHelmetMandatory">
                                Helmpflicht
                            </badge>

                            <badge class="bg-gray-200 text-gray-600 text-xs font-medium mr-2 mb-2" v-if="!event.details.isHelmetMandatory">
                                keine Helmpflicht
                            </badge>
                        </div>
                    </card>
                </div>

                <div class="sm:col-span-1 md:col-span-2 lg:col-span-1">
                    <h2 class="text-xl px-4 md:px-0 font-bold text-gray-700">Notizen</h2>
                    <card class="mt-3">
                        <div class="px-5 py-2 border-b" v-for="(comment, index) in event.details.additionalComments" :key="index">
                            {{ comment }}
                        </div>
                    </card>
                </div>
            </div>

            <div class="mt-10">
                <h2 class="text-xl px-4 md:px-0 font-bold text-gray-700 sm:mt-4 md:mt-0 lg:mt-0">Kontaktdaten</h2>
                <card class="mt-3 text-sm flex items-stretch flex-col md:flex-row">
                    <div class="px-6 py-4 border-b md:border-b-0 md:border-r w-full">
                        <div class="font-bold mb-0.5 text-gray-700">Veranstalter</div>
                        <person :person="event.details.eventHost"/>
                    </div>

                    <div class="px-6 py-4 border-b md:border-b-0 md:border-r w-full">
                        <div class="font-bold mb-0.5 text-gray-700">Organisator</div>
                        <person :person="event.details.eventOrganizer"/>
                    </div>

                    <div class="px-6 py-4 w-full">
                        <div class="font-bold mb-0.5 text-gray-700">Infos und Nennungen</div>
                        <person :person="event.details.contactPerson"/>
                    </div>
                </card>
            </div>

            <h2 class="text-xl font-bold text-gray-700 px-4 md:px-0 mt-12">Wettbewerbe</h2>

            <v-table class="mt-2">
                <thead class="bg-gray-50">
                <tr>
                    <v-th></v-th>
                    <v-th>WB</v-th>
                    <v-th>Distanz</v-th>
                    <v-th>Datum</v-th>
                    <v-th>Quali-Stufe</v-th>
                    <v-th>Höhenmeter<sup class="text-gray-400">1</sup></v-th>
                    <v-th>Startgeld<sup class="text-gray-400">3</sup></v-th>
                    <v-th>Höchstzeit<sup class="texts text-gray-400">4</sup></v-th>
                    <v-th>min. Alter Pferd</v-th>
                    <v-th>min. Alter TN</v-th>
                    <v-th>TN/max TN</v-th>
                </tr>
                </thead>
                <tbody class="bg-white divide-y divide-gray-200">
                <tr v-for="contest in event.contests" :key="contest.uuid">
                    <v-td>
                        <font-awesome-icon :icon="'trailer'" v-if="!isRide(contest)" class="text-gray-400 text-lg"/>
                        <font-awesome-icon :icon="'horse-head'" v-if="isRide(contest)" class="text-gray-400 text-lg"/>
                    </v-td>
                    <v-td class="font-bold">
                        {{ contest.contestType }}
                    </v-td>
                    <v-td>{{ contest.distance }} km</v-td>
                    <v-td>{{ toMoment(contest.start).format("DD.MM.") }}</v-td>
                    <v-td>{{ contest.qualificationLevel }}</v-td>
                    <v-td>{{ contest.altitudeDifference }} m</v-td>
                    <v-td>{{ contest.startFee }} EUR</v-td>
                    <v-td>{{ contest.maximumDuration }}</v-td>
                    <v-td>{{ contest.minimumHorseAge }}</v-td>
                    <v-td>{{ contest.minimumParticipantAge }}</v-td>
                    <v-td>
                        {{ contest.currentParticipants }} / {{ contest.maximumParticipants }}
                    </v-td>
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
                            Bei Gespannen und Handpferderitten wird Nenngeld pro Pferd erhoben,
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
import DateRange from "@/components/DateRange.vue";
import Person from "./partials/Person.vue";
import { vxm } from "@/store";
import moment from "moment";
import { SimpleContestDto as Contest } from "@/openapi/generated/api";

@Component({
    components: {
        VTable,
        VButton,
        Badge,
        Card,
        AppLayout,
        VTh,
        VTd,
        DateRange,
        Person
    }
})
export default class Detail extends Vue {
    eventId = this.$route.params.eventId;

    event = {
        details: vxm.events.eventDetails,
        contests: vxm.events.eventContests
    };

    mounted(): void {
        vxm.events.fetchEvent(this.eventId).then(() => {
            this.event.details = vxm.events.eventDetails;
            this.event.contests = vxm.events.eventContests;
        });
    }

    get deadline(): moment.Moment {
        return moment(this.event.details?.participationApplicationDeadline);
    }

    toMoment(date: string): moment.Moment {
        return moment(date);
    }

    isRide(contest: Contest): boolean {
        return contest.contestType?.endsWith("_RIDE") ?? false;
    }
}
</script>
