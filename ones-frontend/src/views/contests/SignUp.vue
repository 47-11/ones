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
                                {{ $t('signUp.title') }}
                            </h1>
                        </div>
                    </div>
                    <div
                        class="bg-indigo-600 text-white px-3 pt-1 pb-2 rounded-md flex flex-col ml-auto justify-center leading-none text-center">
                        <div class="text-lg">
                            {{ contest.currentParticipants || 0 }} /
                            <span v-if="contest.maximumParticipants">{{ contest.maximumParticipants }}</span>
                            <span v-else>&infin;</span>
                        </div>
                        <div class="text-2xs">{{ $t('details.participants') }}</div>
                    </div>
                </div>
            </div>
        </template>
        <div class="max-w-7xl md:px-4 sm:px-6 lg:px-8 m-auto py-8 md:py-10">
            <page-header>{{ $t('signUp.title') }}</page-header>

            <div class="grid grid-cols-1 md:grid-cols-2 gap-12 lg:grid-cols-3">
                <card>
                    <div class="px-5 py-4 mb-3 text-lg bg-gray-50">
                        <span class="font-bold">
                            {{ contest.category }}
                        </span>
                    </div>

                    <table>
                        <tr v-if="details.addresses[0].locationName">
                            <th class="text-left px-5 py-1 align-top">
                                {{$t('details.place')}}
                                </th>
                            <td class="text-left px-5 py-1">
                                {{ details.addresses[0].locationName }} <br v-if="details.addresses[0].locationName">
                            </td>
                        </tr>

                        <tr>
                            <th class="text-left px-5 py-1 align-top">
                                {{$t('details.date')}}
                                </th>
                            <td class="text-left px-5 py-1">
                                {{ start.format("DD.MM.YYYY") }}
                            </td>
                        </tr>

                        <tr>
                            <th class="text-left px-5 py-1 align-top">
                                {{ $t('details.distance') }}
                            </th>
                            <td class="text-left px-5 py-1">
                                <span class="mr-2">
                                    {{ contest ? (contest.distance + " km") : "" }}
                                </span>
                            </td>
                        </tr>
                        <tr>
                            <th class="text-left px-5 py-1 align-top">
                                {{ $t('details.qualification') }}
                            </th>
                            <td class="text-left px-5 py-1">
                                {{ contest.qualificationLevel }}
                            </td>
                        </tr>
                        <tr>
                            <th class="pt-4 text-left px-5 py-1 align-top">
                                {{ $t('details.startFee') }}<sup class="text-gray-400 font-normal">3</sup>
                            </th>
                            <td class="pt-4 text-left px-5 py-1">
                                {{ contest.startFee }} €
                            </td>
                        </tr>
                        <tr>
                            <th class="text-left px-5 py-1 align-top leading-5">
                                {{ $t('details.signUpFee') }} <br>
                                <span class="text-xs text-gray-400 font-normal">
                                    {{ $t('details.caseSignUpDeadlineMissed') }}
                                </span>
                            </th>
                            <td class="text-left px-5 py-1">
                                {{ details.lateSignupFee.amount }} {{ details.lateSignupFee.currency }}
                            </td>
                        </tr>
                        <tr v-if="details.signupChangeFee">
                            <th class="text-left px-5 py-1 align-top leading-5">
                                {{ $t('details.signupChangeFee') }}
                            </th>
                            <td class="text-left px-5 py-1">
                                {{ details.signupChangeFee.amount }} {{ details.signupChangeFee.currency }}
                            </td>
                        </tr>

                        <tr>
                            <th class="text-left px-5 py-1 align-top">
                                {{ $t('details.signUpDeadline') }}
                            </th>
                            <td class="text-left px-5 py-1">
                                {{ deadline.format("DD.MM.YYYY") }}
                            </td>
                        </tr>
                    </table>

                    <div class="px-5 py-3 mt-2">
                        <div class="font-bold mb-1.5">{{ $t("signUp.paymentInformation.title") }}</div>

                        {{ details.paymentInformation.bankTransferAccountHolder }} <br>
                        {{ details.paymentInformation.bankTransferIban }} <br>
                        {{ details.paymentInformation.bankTransferBic }}

                        <div class="mt-1.5">
                            <div class="text-sm text-gray-400">
                                {{ $t("signUp.paymentInformation.remarks") }}
                            </div>
                            {{ details.paymentInformation.remarks }}
                        </div>
                    </div>

                    <div class="px-5 py-3">
                        <span class="font-bold">{{ $t("signUp.requirements.title") }}</span>

                        <ul class="list-inside list-disc mt-2 mb-4">
                            <li>{{ $t("signUp.requirements.minimumHorseAge", {age: contest.minimumHorseAge}) }}</li>
                            <li>{{
                                    $t("signUp.requirements.minimumParticipantAge", {age: contest.minimumParticipantAge})
                                }}
                            </li>
                        </ul>

                        <badge class="bg-amber-500 text-white text-xs font-medium mr-2 mb-2"
                               v-if="details.isVaccinationMandatory">
                            {{ $t('details.vaccinationMandatory') }}
                        </badge>

                        <badge class="bg-gray-200 text-gray-600 text-xs font-medium mr-2 mb-2"
                               v-if="!details.isVaccinationMandatory">
                            {{ $t('details.vaccinationNotMandatory') }}
                        </badge>

                        <badge class="bg-amber-500 text-white text-xs font-medium mr-2 mb-2"
                               v-if="details.isHelmetMandatory">
                            {{ $t('details.helmetMandatory') }}
                        </badge>

                        <badge class="bg-gray-200 text-gray-600 text-xs font-medium mr-2 mb-2"
                               v-if="!details.isHelmetMandatory">
                            {{ $t('details.helmetNotMandatory') }}
                        </badge>
                    </div>
                </card>
                <div class="col-span-2">
                    <div class="mb-5">
                        <h1 class="text-2xl font-bold mb-5">
                            {{ $t('signUp.signedUpHorses') }}
                        </h1>

                        <card>
                            <div class="bg-white border-b px-5 py-4" >
                                <div class="leading-5" v-for="horse in horses.list.filter(horse => contest.signedUpHorses.includes(horse.uuid))" :key="horse.uuid">
                                    <span>{{ horse.name }}</span><br>
                                    <span class="text-gray-400 text-xs">
                                        {{ $t('signUp.selectHorse.lifeNumber') }} {{ horse.chipNumber }}
                                    </span>
                                    <span>{{ horse.name }}</span>
                                </div>
                            </div>
                        </card>
                    </div>

                    <form @submit.prevent="signUp" v-if="!hasSubmitted">

                        <h1 class="text-2xl font-bold mb-5">
                            {{ $t('signUp.signUpTitle') }}
                        </h1>

                        <error-message :error="error"/>

                        <h2 class="text-lg font-bold">
                            {{ $t('signUp.selectHorse.title') }}
                        </h2>

                        <div class="text-gray-500 mb-5">
                            {{ $t('signUp.selectHorse.subtitle') }}
                        </div>

                        <card>
                            <div class="bg-white border-b px-5 py-4 flex items-center" v-for="horse in horsesNotSignedUp"
                                 :key="horse.uuid">
                                <input type="checkbox" :value="horse.uuid" :id="'horse_' + horse.uuid"
                                       v-model="checkedHorses" :disabled="inputsDisabled"
                                       class="rounded border-gray-300 text-indigo-600 shadow-sm focus:border-indigo-300 focus:ring focus:ring-indigo-200 focus:ring-opacity-50 mr-5">
                                <div class="leading-5">
                                    <span>{{ horse.name }}</span> <br>
                                    <span class="text-gray-400 text-xs">
                                        {{ $t('signUp.selectHorse.lifeNumber') }} {{ horse.chipNumber }}
                                    </span>
                                </div>
                            </div>
                        </card>

                        <div class="block mt-6">
                            <label class="inline-flex items-start">
                                <input type="checkbox" v-model="confirmed"
                                       class="rounded border-gray-300 text-indigo-600 shadow-sm focus:border-indigo-300 focus:ring focus:ring-indigo-200 focus:ring-opacity-50 mt-1">
                                <div class="ml-4 text-sm text-gray-600">
                                    <h4 class="text-base font-bold mb-1">{{ $t('signUp.confirmation.title') }}</h4>
                                    {{ $t('signUp.confirmation.description') }}
                                </div>
                            </label>
                        </div>

                        <div class="flex w-full justify-center mt-8">
                            <v-button class="text-lg px-8 pt-2 pb-2" :disabled="inputsDisabled">
                                {{ $t('signUp.submit') }}
                            </v-button>
                        </div>
                    </form>
                    <div class="text-gray-700" v-if="hasSubmitted">
                        <div class="text-center my-20">
                            <h2 class="text-4xl mb-3 font-medium">{{ $t('signUp.signedUp') }}</h2>
                            <p>{{ $t('signUp.thanks') }}</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="mt-4 text-xs text-gray-400 px-4 md:px-0">
                <table>
                    <tr>
                        <td class="pr-3">1)</td>
                        <td>{{ $t('details.elevationInfo') }}</td>
                    </tr>
                    <tr>
                        <td class="pr-3">2)</td>
                        <td>
                            {{ $t('details.signUpFeeInfo') }}
                        </td>
                    </tr>
                    <tr>
                        <td class="pr-3">3)</td>
                        <td>
                            {{ $t('details.maximumTimeInfo') }}
                        </td>
                    </tr>
                    <tr>
                        <td class="pr-3">4)</td>
                        <td>{{ $t('details.inCommunicationWithHost') }}</td>
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
import moment from "moment";
import { FullContestDto as FullContest, FullEventDto as FullEvent, FullHorseDto } from "@/openapi/generated";
import { getVxm } from "@/store";

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
    confirmed = false;

    error: Error | null = null;
    hasSubmitted = false;
    inputsDisabled = false;

    horses = getVxm().horses;

    eventId: string = this.$route.params.eventId;
    contestId: string | null = this.$route.params.contestId;

    mounted(): void {
        this.contestId = this.contestId === "null" ? null : this.contestId;

        getVxm().horses.fetch();
        getVxm().events.fetchEvent(this.eventId);
        getVxm().events.selectContest(this.contestId);
    }

    async signUp(): Promise<void> {
        const loader = this.$loading.show();
        this.disableInputs();

        try {
            this.assertValid();
            this.request();
            getVxm().events.fetchEvent(this.eventId);

            this.hasSubmitted = true;
        } catch (error) {
            this.error = error as Error;
        }

        loader.hide();
        this.releaseInputs();
    }

    private async request() {
        this.assertValid();

        await getVxm().events.signUp({
            contestUuid: this.contestId as string,
            horseUuids: this.checkedHorses
        });
    }

    private assertValid(): void {
        if (this.checkedHorses.length === 0) {
            throw new Error("signUp.minHorses");
        }

        if (!this.confirmed) {
            throw new Error("signUp.confirm");
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
        return getVxm().events.selectedContest;
    }

    get details(): FullEvent | null {
        return getVxm().events.eventDetails;
    }

    get deadline(): moment.Moment {
        return moment(this.details?.signupDeadline);
    }

    get start(): moment.Moment {
        return moment(this.contest?.start);
    }

    get horsesNotSignedUp(): FullHorseDto[] {
        // eslint-disable-next-line @typescript-eslint/no-non-null-assertion
        const signedUpHorseIds = Array.from(this.contest!.signedUpHorses!)
            .map(horses => horses.uuid);
        return this.horses.list.filter(
            horse => !signedUpHorseIds.includes(horse.uuid)
        );
    }
}
</script>
