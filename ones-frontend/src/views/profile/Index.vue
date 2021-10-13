<template>
    <app-layout>
        <div class="max-w-6xl m-auto py-12">
            <div class="flex items-start">
                <page-header>{{ $t("profile.title") }}</page-header>
            </div>

            <div class="flex flex-col md:flex-row" v-if="user">
                <div class="md:w-2/3 order-2 md:order-1 md:mt-6 md:mr-12 bg-white shadow-md overflow-hidden sm:rounded-lg">
                    <div class="px-6 py-5">
                        <div class="grid grid-cols-12 gap-4 mb-5">
                            <div class="col-span-12 sm:col-span-6">
                                <span class="text-3xl">{{user.firstName}}</span>
                                <v-label class="italic">{{ $t("data.user.firstName") }}</v-label>
                            </div>

                            <div class="col-span-12 sm:col-span-6 text-right">
                                <span class="text-3xl">{{user.lastName}}</span>
                                <v-label class="italic">{{ $t("data.user.lastName") }}</v-label>
                            </div>
                        </div>

                        <div class="grid grid-cols-12 gap-4 mb-5">
                            <div class="col-span-12 sm:col-span-6">
                                <span class="text-3xl" v-if="user.birthName">{{user.birthName}}</span>
                                <span class="text-3xl italic text-gray-300" v-else>{{ $t('data.user.unset') }}</span>
                                <v-label class="italic">{{ $t("data.user.birthName") }}</v-label>
                            </div>
                            <div class="col-span-12 sm:col-span-6 text-right">
                                <span class="text-3xl">{{user.birthday}}</span>
                                <v-label class="italic">{{ $t("data.user.birthday") }}</v-label>
                            </div>
                        </div>
                        <div class="grid grid-cols-12 gap-4 mb-5">
                            <div class="col-span-12 sm:col-span-9">
                                <span class="text-3xl">{{user.address.street}}</span>
                                <v-label class="italic">{{ $t("data.user.street") }}</v-label>
                            </div>

                            <div class="col-span-12 sm:col-span-3 text-right">
                                <span class="text-3xl">{{user.address.houseNumber}}</span>
                                <v-label class="italic">{{ $t("data.user.houseNumber") }}</v-label>
                            </div>
                        </div>

                        <div class="grid grid-cols-12 gap-4 mb-5">
                            <div class="col-span-12 sm:col-span-3">
                                <span class="text-3xl">{{user.address.zipCode}}</span>
                                <v-label class="italic">{{ $t("data.user.zipCode") }}</v-label>
                            </div>

                            <div class="col-span-12 sm:col-span-5 text-center">
                                <span class="text-3xl">{{user.address.city}}</span>
                                <v-label class="italic">{{ $t("data.user.city") }}</v-label>
                            </div>

                            <div class="col-span-12 sm:col-span-4 text-right">
                                <span class="text-3xl">{{user.address.country}}</span>
                                <v-label class="italic">{{ $t("data.user.country") }}</v-label>
                            </div>
                        </div>

                        <div class="grid grid-cols-12 gap-4 mb-5">
                            <div class="col-span-12 sm:col-span-6">
                                <span class="text-3xl">{{user.phoneNumber}}</span>
                                <v-label class="italic">{{ $t("data.user.phoneNumber") }}</v-label>
                            </div>

                            <div class="col-span-12 sm:col-span-6 text-right">
                                <span class="text-3xl" v-if="user.phoneNumberMobile">{{user.phoneNumberMobile}}</span>
                                <span class="text-3xl italic text-gray-300" v-else>{{ $t('data.user.unset') }}</span>
                                <v-label class="italic">{{ $t("data.user.phoneNumberMobile") }}</v-label>
                            </div>
                        </div>

                        <div class="col-span-12 gap-4 mb-5">
                            <span class="text-3xl">{{user.phoneNumberEmergency}}</span>
                            <v-label class="italic">{{ $t("data.user.phoneNumberEmergency") }}</v-label>
                        </div>

                        <div class="grid grid-cols-12 gap-4 mb-5">
                            <div class="col-span-12 sm:col-span-4">
                                <span class="text-3xl">{{user.qualificationStage}}</span>
                                <v-label class="italic">{{ $t("data.user.qualificationStage") }}</v-label>
                            </div>

                            <div class="col-span-12 sm:col-span-4 text-center">
                                <span class="text-3xl" v-if="user.feiNo">{{user.feiNo}}</span>
                                <span class="text-3xl italic text-gray-300" v-else>{{ $t('data.user.unset') }}</span>
                                <v-label class="italic">{{ $t("data.user.feiNo") }}</v-label>
                            </div>

                            <div class="col-span-12 sm:col-span-4 text-right">
                                <span class="text-3xl" v-if="user.fnNo">{{user.fnNo}}</span>
                                <span class="text-3xl italic text-gray-300" v-else>{{ $t('data.user.unset') }}</span>
                                <v-label class="italic">{{ $t("data.user.fnNo") }}</v-label>
                            </div>
                        </div>
                    </div>
                    <div class="flex items-center justify-end px-4 py-3 bg-gray-50 text-right sm:px-6">
                        <div class="flex-grow"></div>
                        <v-button>{{$t("profile.edit")}}</v-button>
                    </div>
                </div>
            </div>
        </div>
    </app-layout>
</template>

<script lang="ts">
import { Component, Vue } from "vue-property-decorator";
import PageHeader from "@/components/PageHeader.vue";
import Card from "@/components/Card.vue";
import VButton from "@/components/VButton.vue";
import VLink from "@/components/VLink.vue";
import VInput from "@/components/forms/VInput.vue";
import VLabel from "@/components/forms/VLabel.vue";
import VSelect from "@/components/forms/VSelect.vue";
import BadgeCircle from "@/components/BadgeCircle.vue";
import AppLayout from "@/layouts/AppLayout.vue";
import { vxm } from "@/store";
import { UserDto } from "@/openapi/generated";

@Component({
    components: {
        PageHeader,
        AppLayout,
        Card,
        BadgeCircle,
        VButton,
        VLink,
        VInput,
        VLabel,
        VSelect
    }
})
export default class Profile extends Vue {
    get user(): UserDto | null {
        return vxm.user.current;
    }

    mounted(): void {
        vxm.user.fetchCurrent();
    }
}
</script>
