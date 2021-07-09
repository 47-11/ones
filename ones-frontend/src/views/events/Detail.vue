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
                    <card class="mt-3 max-h-80 overflow-y-auto overflow-x-hidden">
                        <table class="my-3">
                            <tr>
                                <th class="text-left px-5 py-1 align-top">{{$t('details.timeRange')}}</th>
                                <td class="text-left px-5 py-1">
                                    <span class="mr-2">
                                        <date-range :start="details.start" :end="details.end"/>
                                    </span>
                                </td>
                            </tr>
                            <template v-for="(address, key, index) of details.addresses">
                                <tr :key="index + 'country'">
                                    <th class="text-left px-5 py-1 align-top">{{$t('details.country')}}</th>
                                    <td class="text-left px-5 py-1">
                                        {{ address.country }}
                                    </td>
                                </tr>
                                <tr :key="index + 'addresses'">
                                    <th class="text-left px-5 py-1 align-top">{{$t('details.startingPlace')}}</th>
                                    <td class="text-left px-5 py-1">
                                        <address>
                                            {{ address.locationName }} <br v-if="address.locationName && address.locationName.trim().length > 0"/>
                                            {{ address.street }}<br v-if="address.street && address.street.trim().length > 0"/>
                                            {{ address.zipCode }} {{ address.city }}<br v-if="(address.zipCode && address.zipCode.trim().length > 0) || (address.city && address.city.trim().length > 0)" />
                                            {{ address.country }}
                                        </address>
                                    </td>
                                </tr>
                                <tr v-if="address.gpsCoordinates" :key="index + 'coordinates'">
                                    <th class="text-left px-5 py-1 align-top">{{$t('details.coordinates')}}</th>
                                    <td class="text-left px-5 py-1">
                                        <a :href="'https://maps.google.com/maps?q=' + address.gpsCoordinates.replaceAll(' ', '').replace('/', ',')" target="_blank">
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
                    <card class="mt-3 max-h-80 overflow-y-auto overflow-x-hidden">
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

                        <div class="text-left px-5 pb-5 align-top leading-5 flex justify-between flex-wrap">
                            <a target="_blank" :href="details.organizerWebsiteUrl" v-if="details.organizerWebsiteUrl">
                                {{$t("details.hostWebsite")}}
                            </a>
                            <span class="text-gray-500 font-bold" v-if="!details.organizerWebsiteUrl">
                                {{$t("details.hostWebsite")}}
                            </span>
                            <a target="_blank" :href="details.signupDocumentUrl" v-if="details.signupDocumentUrl">
                                {{$t("details.paperForm")}}
                            </a>
                            <span class="text-gray-500 font-bold" v-if="!details.signupDocumentUrl">
                                {{$t("details.paperForm")}}
                            </span>
                        </div>
                    </card>
                </div>

                <div class="sm:col-span-1 md:col-span-2 lg:col-span-2">
                    <h2 class="text-xl px-4 md:px-0 font-bold text-gray-700">{{$t('details.notes')}}</h2>
                    <card class="mt-3 max-h-80 overflow-y-auto overflow-x-hidden">
                        <div class="px-5 py-2 border-b" v-for="(comment, index) in details.additionalComments" :key="index">
                            {{ comment }}
                        </div>
                    </card>
                </div>
            </div>

            <div class="mt-10">
                <h2 class="text-xl px-4 md:px-0 font-bold text-gray-700 sm:mt-4 md:mt-0 lg:mt-0">{{$t('details.contacts')}}</h2>
                <card class="mt-3 text-sm flex items-stretch flex-col md:flex-row">
                    <div class="px-6 py-4 border-b md:border-b-0 md:border-r w-full" v-if="details.eventHost">
                        <div class="font-bold mb-0.5 text-gray-700">{{$t('details.host')}}</div>
                        <person :person="details.eventHost"/>
                    </div>

                    <div class="px-6 py-4 border-b md:border-b-0 md:border-r w-full" v-if="details.eventOrganizer">
                        <div class="font-bold mb-0.5 text-gray-700">{{$t('details.organizer')}}</div>
                        <person :person="details.eventOrganizer"/>
                    </div>

                    <div class="px-6 py-4 w-full" v-if="details.contactPerson">
                        <div class="font-bold mb-0.5 text-gray-700">{{$t('details.infoAndSignUp')}}</div>
                        <person :person="details.contactPerson"/>
                    </div>
                </card>
            </div>

            <h2 class="text-xl font-bold text-gray-700 px-4 md:px-0 mt-12">{{$t('details.contests')}}</h2>

            <v-table class="mt-2">
                <thead class="bg-gray-50">
                <tr>
                    <v-th>{{$t('details.contestShort')}}</v-th>
                    <v-th>{{$t('details.distance')}}</v-th>
                    <v-th>{{$t('details.date')}}</v-th>
                    <v-th>{{$t('details.qualification')}}</v-th>
                    <v-th>{{$t('details.horseAge')}}</v-th>
                    <v-th>{{$t('details.riderAge')}}</v-th>
                    <v-th>{{$t("details.stages")}}</v-th>
                    <v-th>{{$t("details.markings")}}</v-th>
                    <v-th>{{$t('details.maximumParticipants')}}</v-th>
                    <v-th></v-th>
                </tr>
                </thead>
                <tbody class="bg-white divide-y divide-gray-200">
                <tr v-for="contest in contests" :key="contest.uuid">
                    <v-td class="font-bold">
                        {{ contest.category }}
                    </v-td>
                    <v-td>{{ contest.distance }} km</v-td>
                    <v-td>{{ toMoment(contest.start).format("DD.MM.") }}</v-td>
                    <v-td>{{ contest.qualificationLevel }}</v-td>
                    <v-td>
                        <span v-if="contest.minimumHorseAge && contest.maximumHorseAge">{{ $t("details.ageFromTo", { from: contest.minimumHorseAge, to: contest.maximumHorseAge}) }}</span>
                        <span v-if="contest.minimumHorseAge && !contest.maximumHorseAge">{{ $t("details.ageFrom", { from: contest.minimumHorseAge }) }}</span>
                        <span v-if="!contest.minimumHorseAge && contest.maximumHorseAge">{{ $t("details.ageTo", { to: contest.maximumHorseAge}) }}</span>
                    </v-td>
                    <v-td>
                        <span v-if="contest.minimumParticipantAge && contest.maximumParticipantAge">{{ $t("details.ageFromTo", { from: contest.minimumParticipantAge, to: contest.maximumParticipantAge}) }}</span>
                        <span v-if="contest.minimumParticipantAge && !contest.maximumParticipantAge">{{ $t("details.ageFrom", { from: contest.minimumParticipantAge }) }}</span>
                        <span v-if="!contest.minimumParticipantAge && contest.maximumParticipantAge">{{ $t("details.ageTo", { to: contest.maximumParticipantAge}) }}</span>
                    </v-td>
                    <v-td>{{contest.numberOfStages}}</v-td>
                    <v-td>{{contest.markings}}</v-td>
                    <v-td>
                        {{ contest.currentParticipants || 0 }}
                        /
                        <span v-if="contest.maximumParticipants">{{ contest.maximumParticipants }} </span>
                        <span class="text-2xl" v-else>&infin;</span>
                    </v-td>
                    <v-td>
                        <router-link :to="'/events/' + eventId + '/contests/' + contest.uuid + '/sign-up'" v-tooltip="contest.signedUpHorses ? $t('details.alreadySignedUp', {horses: contest.signedUpHorses}) : ''">
                            <v-button :disabled="contest.signedUpHorses && contest.signedUpHorses.length > 0">{{ $t('details.signUp') }}</v-button>
                        </router-link>
                    </v-td>
                </tr>
                </tbody>
            </v-table>
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
import { FullContestDto, FullEventDto } from "@/openapi/generated/api";

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
}
</script>
