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
                    <div class="flex items-center flex-grow" v-if="details">
                        <div class="flex flex-auto items-center">
                            <div>
                                <div class="text-sm text-gray-700">
                                    <date-range :start="details.start" :end="details.end"/>
                                </div>
                                <h1 class="text-xl">
                                    {{ details.title }}
                                </h1>
                            </div>
                            <badge v-if="details.isNationalChampionship" class="bg-indigo-600 text-white text-sm ml-10 font-medium">
                                {{$t('details.nationalChampionship')}}
                            </badge>

                            <badge v-if="details.isInternational" class="bg-indigo-600 text-white text-sm ml-10 font-medium">
                                {{$t('details.internationalChampionship')}}
                            </badge>
                        </div>
                        <div class="flex-grow"></div>
                        <div class="text-center">
                            <div class="text-2xl w-full">{{details.currentParticipants}}/{{details.maximumParticipants}}</div>
                            <div class="text-base font-bold w-full">{{$t("details.participants")}}</div>
                            <div class="text-xs w-full italic">{{ $t('details.min', {count: details.minimumParticipants}) }}</div>
                        </div>
                    </div>
                </div>
            </div>
        </template>
        <div class="max-w-7xl md:px-4 sm:px-6 lg:px-8 m-auto py-8 md:py-10" v-if="details">
            <div class="grid grid-cols-1 md:grid-cols-2 gap-6 lg:grid-cols-6">
                <div class="sm:col-span-1 md:col-span-2 lg:col-span-2">
                    <h2 class="text-xl px-4 md:px-0 font-bold text-gray-700">{{$t('details.placeAndTime')}}</h2>
                    <card class="mt-3">
                        <table class="my-3">
                            <tr>
                                <th class="text-left px-5 py-1 align-top">{{$t('details.timeRange')}}</th>
                                <td class="text-left px-5 py-1">
                                    <span class="mr-2">
                                        <date-range :start="details.start" :end="details.end"/>
                                    </span>
                                </td>
                            </tr>
                            <template v-for="address of details.addresses">
                                <tr :key="address">
                                    <th class="text-left px-5 py-1 align-top">{{$t('details.region')}}</th>
                                    <td class="text-left px-5 py-1">
                                        {{ address.region }}
                                    </td>
                                </tr>
                                <tr :key="address">
                                    <th class="text-left px-5 py-1 align-top">{{$t('details.country')}}</th>
                                    <td class="text-left px-5 py-1">
                                        {{ address.country }}
                                    </td>
                                </tr>
                                <tr :key="address">
                                    <th class="text-left px-5 py-1 align-top">{{$t('details.startingPlace')}}</th>
                                    <td class="text-left px-5 py-1">
                                        <address>
                                            {{ address.locationName }} <br/>
                                            {{ address.street }}<br/>
                                            {{ address.zipCode }} {{ address.city }}<br/>
                                            {{ address.country }}
                                        </address>
                                    </td>
                                </tr>
                                <tr v-if="address.gpsCoordinates != undefined" :key="address">
                                    <th class="text-left px-5 py-1 align-top">{{$t('details.coordinates')}}</th>
                                    <td class="text-left px-5 py-1">
                                        <a :href="'https://maps.google.com/maps?q=' + gpsCoordinates" target="_blank">
                                            {{ address.gpsCoordinates }}
                                            <font-awesome-icon :icon="'external-link-alt'"></font-awesome-icon>
                                        </a>
                                    </td>
                                </tr>
                            </template>
                        </table>
                    </card>
                </div>

                <div class="sm:col-span-1 md:col-span-2 lg:col-span-2">
                    <h2 class="text-xl px-4 md:px-0 font-bold text-gray-700">{{$t('details.details')}}</h2>
                    <card class="mt-3">
                        <table class="my-3">
                            <tr>
                                <th class="text-left px-5 py-1 align-top">{{$t('details.signUpDeadline')}}</th>
                                <td class="text-left px-5 py-1">
                                    {{ deadline.format("DD.MM.YYYY") }}
                                </td>
                            </tr>
                            <tr>
                                <th class="text-left px-5 py-1 align-top">{{$t('details.signUpAfterDeadlinePossible')}}</th>
                                <td class="text-left px-5 py-1">
                                    {{ details.signUpAfterDeadlinePossible ? $t("shared.yes") : $t("shared.no") }}
                                </td>
                            </tr>
                            <tr v-if="details.signUpAfterDeadlinePossible">
                                <th class="text-left px-5 py-1 align-top leading-5">
                                    {{$t('details.signUpFeeAfterDeadlineMissed')}}
                                </th>
                                <td class="text-left px-5 py-1">
                                    {{ details.signUpDeadlineMissedFee || 0 }} EUR
                                </td>
                            </tr>
                            <tr>
                                <th class="text-left px-5 py-1 align-top leading-5">
                                    {{$t('details.signUpChangeFee')}}
                                </th>
                                <td class="text-left px-5 py-1">
                                    {{ details.signUpChangeFee || 0 }} EUR
                                </td>
                            </tr>
                            <tr>
                                <th class="text-left px-5 py-1 align-top leading-5">
                                    {{$t('details.vaccinationRequirements')}}
                                </th>
                                <td class="text-left px-5 py-1">
                                    {{ details.isVaccinationRequired || $t("shared.unknown") }}
                                </td>
                            </tr>
                            <tr>
                                <th class="text-left px-5 py-1 align-top leading-5">
                                    {{$t('details.helmetRequirements')}}
                                </th>
                                <td class="text-left px-5 py-1">
                                    {{ details.isHelmetMandatory || $t("shared.unknown") }}
                                </td>
                            </tr>
                        </table>

                        <div class="text-left px-5 py-1 align-top leading-5 flex justify-between flex-wrap">
                            <a target="_blank" :href="details.organizerWebsiteUrl" v-if="details">
                                {{$t("details.hostWebsite")}}
                            </a>
                            <a target="_blank" :href="details.signupDocumentUrl" v-if="details">
                                {{$t("details.paperForm")}}
                            </a>
                        </div>
                    </card>
                </div>

                <div class="sm:col-span-1 md:col-span-2 lg:col-span-2">
                    <h2 class="text-xl px-4 md:px-0 font-bold text-gray-700">{{$t('details.paymentInfo')}}</h2>
                    <card class="mt-3">
                        <table class="my-3">
                            <tr>
                                <th class="text-left px-5 py-1 align-top">
                                    {{$t('details.iban')}}
                                </th>
                                <td class="text-left px-5 py-1">
                                    {{ "DE12 3456 7890 1234 00" }}
                                </td>
                            </tr>
                            <tr>
                                <th class="text-left px-5 py-1 align-top">
                                    {{$t('details.bic')}}
                                </th>
                                <td class="text-left px-5 py-1">
                                    {{ "GENOBLA" }}
                                </td>
                            </tr>
                            <tr>
                                <th class="text-left px-5 py-1 align-top">
                                    {{$t('details.purpose')}}
                                </th>
                                <td class="text-left px-5 py-1">
                                    {{ "Sign Up Fee" }}
                                </td>
                            </tr>
                            <tr>
                                <th class="text-left px-5 py-1 align-top">
                                    {{$t('details.payPal')}}
                                </th>
                                <td class="text-left px-5 py-1">
                                    {{ "Sign Up Fee" }}
                                </td>
                            </tr>
                        </table>
                    </card>
                </div>

                <div class="sm:col-span-1 md:col-span-2 lg:col-span-3">
                    <h2 class="text-xl px-4 md:px-0 font-bold text-gray-700">
                        {{$t('details.accomodation')}}
                    </h2>
                    <card class="mt-3">
                        <table class="mb-4" v-if="details.availableAccommodations.length > 0">
                            <tr v-for="(accommodation, index) in details.availableAccommodations" :key="index">
                                <th class="text-left px-5 py-1 align-top">{{ accommodation.type }}</th>
                                <td class="text-left px-5 py-1">
                                    {{ accommodation.fee }} {{ accommodation.feeUnit }}
                                </td>
                                <td class="text-left px-5 py-1">
                                    {{ accommodation.pledgeFee }} EUR <span class="text-xs text-gray-500">{{$t('details.deposit')}}</span>
                                </td>
                            </tr>
                        </table>
                        <div v-else class="px-5 py-2">{{$t("shared.unknown")}}</div>
                    </card>
                </div>

                <div class="sm:col-span-1 md:col-span-2 lg:col-span-3">
                    <h2 class="text-xl px-4 md:px-0 font-bold text-gray-700">{{$t('details.notes')}}</h2>
                    <card class="mt-3">
                        <div class="px-5 py-2 border-b" v-for="(comment, index) in details.additionalComments" :key="index">
                            {{ comment }}
                        </div>
                    </card>
                </div>
            </div>

            <div class="mt-10">
                <h2 class="text-xl px-4 md:px-0 font-bold text-gray-700 sm:mt-4 md:mt-0 lg:mt-0">{{$t('details.contacts')}}</h2>
                <card class="mt-3 text-sm flex items-stretch flex-col md:flex-row">
                    <div class="px-6 py-4 border-b md:border-b-0 md:border-r w-full">
                        <div class="font-bold mb-0.5 text-gray-700">{{$t('details.host')}}</div>
                        <person :person="details.eventHost"/>
                    </div>

                    <div class="px-6 py-4 border-b md:border-b-0 md:border-r w-full">
                        <div class="font-bold mb-0.5 text-gray-700">{{$t('details.organizer')}}</div>
                        <person :person="details.eventOrganizer"/>
                    </div>

                    <div class="px-6 py-4 w-full">
                        <div class="font-bold mb-0.5 text-gray-700">{{$t('details.infoAndSignUp')}}</div>
                        <person :person="details.contactPerson"/>
                    </div>
                </card>
            </div>

            <h2 class="text-xl font-bold text-gray-700 px-4 md:px-0 mt-12">{{$t('details.contests')}}</h2>

            <v-table class="mt-2">
                <thead class="bg-gray-50">
                <tr>
                    <v-th></v-th>
                    <v-th>{{$t('details.contestShort')}}</v-th>
                    <v-th>{{$t('details.distance')}}</v-th>
                    <v-th>{{$t('details.date')}}</v-th>
                    <v-th>{{$t('details.qualification')}}</v-th>
                    <v-th>{{$t('details.elevation')}}<sup class="text-gray-400">1</sup></v-th>
                    <v-th>{{$t('details.startFee')}}<sup class="text-gray-400">3</sup></v-th>
                    <v-th>{{$t('details.maximumTime')}}<sup class="texts text-gray-400">4</sup></v-th>
                    <v-th>{{$t('details.minHorseAge')}}</v-th>
                    <v-th>{{$t('details.minRiderAge')}}</v-th>
                    <v-th>{{$t('details.maximumParticipants')}}</v-th>
                    <v-th></v-th>
                </tr>
                </thead>
                <tbody class="bg-white divide-y divide-gray-200">
                <tr v-for="contest in contests" :key="contest.uuid">
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
                    <v-td>
                        <router-link :to="'/events/' + eventId + '/contests/' + contest.uuid + '/sign-up'">
                            <v-button>Anmelden</v-button>
                        </router-link>
                    </v-td>
                </tr>
                </tbody>
            </v-table>

            <div class="mt-4 text-xs text-gray-400 px-4 md:px-0">
                <table>
                    <tr>
                        <td class="pr-3">1)</td>
                        <td>{{$t('details.elevationInfo')}}</td>
                    </tr>
                    <tr>
                        <td class="pr-3">2)</td>
                        <td>
                            {{$t('details.signUpFeeInfo')}}
                        </td>
                    </tr>
                    <tr>
                        <td class="pr-3">3)</td>
                        <td>
                            {{$t('details.maximumTimeInfo')}}
                        </td>
                    </tr>
                    <tr>
                        <td class="pr-3">4)</td>
                        <td>{{$t('details.inCommunicationWithHost')}}</td>
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
import { FullContestDto, FullEventDto, SimpleContestDto as Contest } from "@/openapi/generated/api";

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

    get details(): FullEventDto | null {
        return vxm.events.eventDetails;
    }

    get contests(): FullContestDto[] {
        return vxm.events.eventContests;
    }

    mounted(): void {
        vxm.events.fetchEvent(this.eventId);
    }

    get deadline(): moment.Moment {
        return moment(this.details?.signupDeadline);
    }

    toMoment(date: string): moment.Moment {
        return moment(date);
    }

    isRide(contest: Contest): boolean {
        return contest.contestType?.endsWith("_RIDE") ?? false;
    }
}
</script>
