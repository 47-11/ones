<template>
    <app-layout>
        <div class="max-w-6xl m-auto py-12">
            <div class="flex items-start mx-4 lg:mx-0">
                <page-header>{{ $t("profile.title") }}</page-header>
                <v-button class="ml-auto" v-if="user">{{$t('profile.edit')}}</v-button>
            </div>

            <div class="grid grid-cols-1 md:grid-cols-2 gap-6 lg:grid-cols-6 mx-4 lg:mx-0" v-if="user">
                <div class="sm:col-span-1 md:col-span-2 lg:col-span-2">
                    <h2 class="text-xl font-bold text-gray-700">{{$t('profile.personalData')}}</h2>
                    <card class="mt-3 overflow-x-hidden">
                        <div class="px-5 py-3">
                            <div class="mb-3">
                                <span class="text-xs text-gray-400">{{$t('data.user.vddNumber')}}</span> <br>
                                <span v-if="user.vddNumber">{{user.vddNumber}}</span>
                                <span class="italic" v-else>{{ $t('data.user.unset') }}</span>
                            </div>

                            <div class="mb-3">
                                <span class="text-xs text-gray-400">{{$t('data.user.fullName')}}</span> <br>
                                <span v-if="user.firstName">{{user.firstName}} {{user.fullName}}</span>
                                <span class="italic" v-else>{{ $t('data.user.unset') }}</span>
                            </div>

                            <div class="mb-3">
                                <span class="text-xs text-gray-400">{{$t('data.user.birthName')}}</span> <br>
                                <span v-if="user.birthName">{{user.birthName}}</span>
                                <span class="italic" v-else>{{ $t('data.user.unset') }}</span>
                            </div>

                            <div>
                                <span class="text-xs text-gray-400">{{$t('data.user.birthday')}}</span> <br>
                                <span v-if="user.birthday">{{user.birthday}}</span>
                                <span class="italic" v-else>{{ $t('data.user.unset') }}</span>
                            </div>
                        </div>
                    </card>
                </div>
                <div class="sm:col-span-1 md:col-span-2 lg:col-span-2">
                    <h2 class="text-xl font-bold text-gray-700">{{$t('profile.contactInfo')}}</h2>
                    <card class="mt-3 overflow-x-hidden">

                        <div class="px-5 py-3">
                            <div class="mb-3">
                                <span class="text-xs text-gray-400">{{$t('data.user.address')}}</span> <br>
                                <v-address v-if="user.address" :address="user.address"></v-address>
                                <span class="italic" v-else>{{ $t('data.user.unset') }}</span>
                            </div>
                            <div class="mb-3">
                                <span class="text-xs text-gray-400">{{$t('data.user.phoneNumber')}}</span> <br>
                                <span v-if="user.phoneNumber">{{user.phoneNumber}}</span>
                                <span class="italic" v-else>{{ $t('data.user.unset') }}</span>
                            </div>
                            <div class="mb-3">
                                <span class="text-xs text-gray-400">{{$t('data.user.phoneNumberMobile')}}</span> <br>
                                <span v-if="user.phoneNumberMobile">{{user.phoneNumberMobile}}</span>
                                <span class="italic" v-else>{{ $t('data.user.unset') }}</span>
                            </div>
                            <div>
                                <span class="text-xs text-gray-400">{{$t('data.user.phoneNumberEmergency')}}</span> <br>
                                <span v-if="user.phoneNumberEmergency">{{user.phoneNumberEmergency}}</span>
                                <span class="italic" v-else>{{ $t('data.user.unset') }}</span>
                            </div>
                        </div>
                    </card>
                </div>
                <div class="sm:col-span-1 md:col-span-2 lg:col-span-2">
                    <h2 class="text-xl font-bold text-gray-700">{{$t('profile.otherData')}}</h2>
                    <card class="mt-3 overflow-x-hidden">
                        <div class="px-5 py-3">
                            <div class="mb-3">
                                <span class="text-xs text-gray-400">{{$t('data.user.qualificationLevel')}}</span> <br>
                                <span v-if="user.qualificationLevel || user.qualificationLevel == 0">{{user.qualificationLevel}}</span>
                                <span class="italic" v-else>{{ $t('data.user.unset') }}</span>
                            </div>

                            <div class="mb-3">
                                <span class="text-xs text-gray-400">{{$t('data.user.feiNo')}}</span> <br>
                                <span v-if="user.feiNo">{{user.feiNo}}</span>
                                <span class="italic" v-else>{{ $t('data.user.unset') }}</span>
                            </div>

                            <div class="mb-3">
                                <span class="text-xs text-gray-400">{{$t('data.user.fnNo')}}</span> <br>
                                <span v-if="user.fnNo">{{user.fnNo}}</span>
                                <span class="italic" v-else>{{ $t('data.user.unset') }}</span>
                            </div>
                        </div>
                    </card>
                </div>
            </div>
        </div>
    </app-layout>
</template>

<script lang="ts">
import { Component, Vue } from "vue-property-decorator";
import PageHeader from "@/components/PageHeader.vue";
import Card from "@/components/Card.vue";
import VAddress from "@/components/VAddress.vue";
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
        VAddress,
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
}
</script>
