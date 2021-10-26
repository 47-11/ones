<template>
    <app-layout v-if="contest && details">
        <template v-slot:header>
            <div class="ml-0 w-full">
                <div class="flex items-center">
                    <div class="pr-4 md:pr-8">
                        <router-link :to="'/events/' + eventId">
                            <font-awesome-icon :icon="'chevron-left'" class="text-2xl"/>
                        </router-link>
                    </div>
                    <div class="flex items-center">
                        <div>
                            <div class="text-sm text-gray-700">
                                {{ details.title }} - {{ contest.category }} - {{ start.format("DD.MM.YYYY") }}
                            </div>
                            <h1 class="text-xl">
                                {{$t('signUp.title')}}
                            </h1>
                        </div>
                    </div>
                    <div class="bg-indigo-600 text-white px-3 pt-1 pb-2 rounded-md flex flex-col ml-auto justify-center leading-none text-center">
                        <div class="text-lg">
                            {{ contest.currentParticipants }} / {{ contest.maximumParticipants }}
                        </div>
                        <div class="text-2xs">{{$t('details.participants')}}</div>
                    </div>
                </div>
            </div>
        </template>
        <div class="max-w-7xl md:px-4 sm:px-6 lg:px-8 m-auto py-8 md:py-10">
            <div class="grid grid-cols-1 md:grid-cols-2 gap-12 lg:grid-cols-3">
                <card>
                    <div class="px-5 py-4 mb-3 text-lg bg-gray-50">
                        <span class="font-bold">
                            {{ contest.contestType }}
                        </span>
                    </div>

                    <table>
                        <tr>
                            <th class="text-left px-5 py-1 align-top">
                                {{$t('details.distance')}}
                                </th>
                            <td class="text-left px-5 py-1">
                                <span class="mr-2">
                                    {{ contest ? contest.distance : "" }}
                                </span>
                            </td>
                        </tr>
                        <tr>
                            <th class="text-left px-5 py-1 align-top">
                                {{$t('details.qualification')}}
                            </th>
                            <td class="text-left px-5 py-1">
                                {{ contest.qualificationLevel }}
                            </td>
                        </tr>
                        <tr>
                            <th class="text-left px-5 py-1 align-top">
                                {{$t('details.elevation')}}<sup class="text-gray-400 font-normal">1</sup>
                            </th>
                            <td class="text-left px-5 py-1">
                                {{ contest.altitudeDifference }} m
                            </td>
                        </tr>
                        <tr>
                            <th class="text-left px-5 py-1 align-top">
                                {{$t('details.maximumTime')}}<sup class="text-gray-400 font-normal">4</sup>
                            </th>
                            <td class="text-left px-5 py-1">
                                {{ contest.maximumDuration }}
                            </td>
                        </tr>
                        <tr>
                            <th class="pt-4 text-left px-5 py-1 align-top">
                                {{$t('details.startFee')}}<sup class="text-gray-400 font-normal">3</sup>
                            </th>
                            <td class="pt-4 text-left px-5 py-1">
                                {{ contest.startFee }} EUR
                            </td>
                        </tr>
                        <tr>
                            <th class="text-left px-5 py-1 align-top">
                                {{$t('details.signUpDeadline')}}
                            </th>
                            <td class="text-left px-5 py-1">
                                {{ deadline.format("DD.MM.YYYY") }}
                            </td>
                        </tr>
                        <tr>
                            <th class="text-left px-5 py-1 align-top leading-5">
                                {{$t('details.signUpFee')}} <br>
                                <span class="text-xs text-gray-400 font-normal">
                                    {{$t('details.caseSignUpDeadlineMissed')}}
                                </span>
                            </th>
                            <td class="text-left px-5 py-1">
                                {{ details.signUpDeadlineMissedFee }} EUR
                            </td>
                        </tr>
                    </table>

                    <div class="px-5 mt-4 mb-1">
                        <span class="font-bold">{{$t('details.accomodation')}}</span>
                    </div>

                    <table>
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

                    <div class="px-5 py-3 mt-2">
                        <span class="font-bold">{{ $t("signUp.requirements.title") }}</span>

                        <ul class="list-inside list-disc mt-2 mb-4">
                            <li>{{ $t("signUp.requirements.minimumHorseAge", { age: contest.minimumHorseAge }) }}</li>
                            <li>{{ $t("signUp.requirements.minimumParticipantAge", { age: contest.minimumParticipantAge }) }}</li>
                        </ul>

                        <badge class="bg-amber-500 text-white text-xs font-medium mr-2 mb-2" v-if="details.isVaccinationMandatory">
                                {{$t('details.vaccinationMandatory')}}
                        </badge>

                        <badge class="bg-gray-200 text-gray-600 text-xs font-medium mr-2 mb-2" v-if="!details.isVaccinationMandatory">
                            {{$t('details.vaccinationNotMandatory')}}
                        </badge>

                        <badge class="bg-amber-500 text-white text-xs font-medium mr-2 mb-2" v-if="details.isHelmetMandatory">
                            {{$t('details.helmetMandatory')}}
                        </badge>

                        <badge class="bg-gray-200 text-gray-600 text-xs font-medium mr-2 mb-2" v-if="!details.isHelmetMandatory">
                            {{$t('details.helmetNotMandatory')}}
                        </badge>
                    </div>
                </card>
                <div class="col-span-2">
                    <form @submit.prevent="signUp" v-if="!hasSubmitted">
                        <h2 class="text-xl font-bold">
                            {{ $t('signUp.selectHorse.title') }}
                        </h2>

                        <div class="text-gray-500 mb-5">
                            {{ $t('signUp.selectHorse.subtitle') }}
                        </div>

                        <error-message :error="error"/>

                        <card>
                            <div class="bg-white border-b px-5 py-4 flex items-center" v-for="horse in horses.list" :key="horse.uuid">
                                <input type="checkbox" :value="horse.uuid" :id="'horse_' + horse.uuid" v-model="checkedHorses" :disabled="inputsDisabled"
                                    class="rounded border-gray-300 text-indigo-600 shadow-sm focus:border-indigo-300 focus:ring focus:ring-indigo-200 focus:ring-opacity-50 mr-5">
                                <div class="leading-5">
                                    <span>{{ horse.name }}</span> <br>
                                    <span class="text-gray-400 text-xs">
                                        {{ $t('signUp.selectHorse.lifeNumber') }} {{ horse.lifeNumber }}
                                    </span>
                                </div>
                            </div>
                        </card>

                        <div class="flex w-full justify-center mt-8">
                            <v-button class="text-lg px-8 pt-2 pb-2" :disabled="inputsDisabled">
                                {{ $t('signUp.submit') }}
                            </v-button>
                        </div>
                    </form>
                    <div class="text-gray-700" v-else>
                        <div class="text-center my-20">
                            <h2 class="text-4xl mb-3 font-medium">Sie sind angemeldet!</h2>
                            <p>Vielen Dank für Ihre Anmeldung.</p>
                        </div>

                        <h3 class="text-xl mb-5">Angemeldete Pferde</h3>

                        <card>
                            <div class="bg-white border-b px-5 py-4" v-for="horse in horses.list" :key="horse.uuid">
                                <div class="leading-5">
                                    <span>{{ horse.name }}</span> <br>
                                    <span class="text-gray-400 text-xs">
                                        {{ $t('signUp.selectHorse.lifeNumber') }} {{ horse.lifeNumber }}
                                    </span>
                                </div>
                            </div>
                        </card>
                    </div>
                </div>
            </div>
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
import VCheckbox from "@/components/forms/VCheckbox.vue";
import DateRange from "@/components/DateRange.vue";
import { vxm } from "@/store";
import moment from "moment";
import { FullContestDto as FullContest, FullEventDto as FullEvent } from "@/openapi/generated";

@Component({
    components: {
        VTable,
        VButton,
        VCheckbox,
        Badge,
        Card,
        AppLayout,
        VTh,
        VTd,
        DateRange
    }
})
export default class SignUp extends Vue {
    selectedHorseId = "a";
    checkedHorses: [] = [];

    error = null;
    hasSubmitted = false;
    inputsDisabled = false;

    horses = vxm.horses;

    eventId: string = this.$route.params.eventId;
    contestId: string | null = this.$route.params.contestId;

    mounted(): void {
        this.contestId = this.contestId === "null" ? null : this.contestId;

        vxm.horses.fetch();
        vxm.events.fetchEvent(this.eventId);
        vxm.events.selectContest(this.contestId);
    }

    async signUp(): Promise<void> {
        const loader = this.$loading.show();
        this.disableInputs();

        try {
            this.request();
            this.hasSubmitted = true;
        } catch (error) {
            this.error = error;
        }

        loader.hide();
        this.releaseInputs();
    }

    private async request() {
        this.assertValid();

        await vxm.events.signUp({
            contestUuid: this.contestId as string,
            horseUuids: this.checkedHorses
        });
    }

    private assertValid(): void {
        if (this.checkedHorses.length === 0) {
            throw new Error("signUp.minHorses");
        }

        if (this.contestId === null) {
            throw new Error("No contest selected");
        }
    }

    private disableInputs() {
        this.inputsDisabled = true;
    }

    private releaseInputs() {
        this.inputsDisabled = false;
    }

    get contest(): FullContest | null {
        return vxm.events.selectedContest;
    }

    get details(): FullEvent | null {
        return vxm.events.eventDetails;
    }

    get deadline(): moment.Moment {
        return moment(this.details?.signupDeadline);
    }

    get start(): moment.Moment {
        return moment(this.contest?.start);
    }
}
</script>
