<template>
    <app-layout>
        <div class="max-w-6xl m-auto py-12">
            <div class="flex items-start">
                <page-header>{{ $t("profile.title") }}</page-header>
                <v-button class="ml-auto" v-if="user">{{$t('profile.edit')}}</v-button>
            </div>

            <div class="grid grid-cols-1 md:grid-cols-2 gap-6 lg:grid-cols-6 mx-4" v-if="user">
                <div class="sm:col-span-1 md:col-span-2 lg:col-span-2">
                    <h2 class="text-xl font-bold text-gray-700">{{$t('profile.personalData')}}</h2>
                    <card class="mt-3 overflow-x-hidden">
                        <table class="my-3">
                            <tr>
                                <th class="text-left px-5 py-1 align-top">{{$t('data.user.firstName')}}</th>
                                <td class="text-left px-5 py-1">
                                    <span v-if="user.firstName">{{user.firstName}}</span>
                                    <span class="italic" v-else>{{ $t('data.user.unset') }}</span>
                                </td>
                            </tr>
                            <tr>
                                <th class="text-left px-5 py-1 align-top">{{$t('data.user.lastName')}}</th>
                                <td class="text-left px-5 py-1">
                                    <span v-if="user.lastName">{{user.lastName}}</span>
                                    <span class="italic" v-else>{{ $t('data.user.unset') }}</span>
                                </td>
                            </tr>
                            <tr>
                                <th class="text-left px-5 py-1 align-top">{{$t('data.user.birthName')}}</th>
                                <td class="text-left px-5 py-1">
                                    <span v-if="user.birthName">{{user.birthName}}</span>
                                    <span class="italic" v-else>{{ $t('data.user.unset') }}</span>
                                </td>
                            </tr>
                            <tr>
                                <th class="text-left px-5 py-1 align-top">{{$t('data.user.birthday')}}</th>
                                <td class="text-left px-5 py-1">
                                    <span v-if="user.birthday">{{user.birthday}}</span>
                                    <span class="italic" v-else>{{ $t('data.user.unset') }}</span>
                                </td>
                            </tr>
                        </table>
                    </card>
                </div>
                <div class="sm:col-span-1 md:col-span-2 lg:col-span-2">
                    <h2 class="text-xl font-bold text-gray-700">{{$t('profile.contactInfo')}}</h2>
                    <card class="mt-3 overflow-x-hidden">
                        <table class="my-3">
                            <tr>
                                <th class="text-left px-5 py-1 align-top">{{$t('data.user.address')}}</th>
                                <td class="text-left px-5 py-1">
                                    <v-address v-if="user.address" :address="user.address"></v-address>
                                    <span class="italic" v-else>{{ $t('data.user.unset') }}</span>
                                </td>
                            </tr>
                            <tr>
                                <th class="text-left px-5 py-1 align-top">{{$t('data.user.phoneNumber')}}</th>
                                <td class="text-left px-5 py-1">
                                    <span v-if="user.phoneNumber">{{user.phoneNumber}}</span>
                                    <span class="italic" v-else>{{ $t('data.user.unset') }}</span>
                                </td>
                            </tr>
                            <tr>
                                <th class="text-left px-5 py-1 align-top">{{$t('data.user.phoneNumberMobile')}}</th>
                                <td class="text-left px-5 py-1">
                                    <span v-if="user.phoneNumberMobile">{{user.phoneNumberMobile}}</span>
                                    <span class="italic" v-else>{{ $t('data.user.unset') }}</span>
                                </td>
                            </tr>
                            <tr>
                                <th class="text-left px-5 py-1 align-top">{{$t('data.user.phoneNumberEmergency')}}</th>
                                <td class="text-left px-5 py-1">
                                    <span v-if="user.phoneNumberEmergency">{{user.phoneNumberEmergency}}</span>
                                    <span class="italic" v-else>{{ $t('data.user.unset') }}</span>
                                </td>
                            </tr>
                        </table>
                    </card>
                </div>
                <div class="sm:col-span-1 md:col-span-2 lg:col-span-2">
                    <h2 class="text-xl font-bold text-gray-700">{{$t('profile.otherData')}}</h2>
                    <card class="mt-3 overflow-x-hidden">
                        <table class="my-3">
                            <tr>
                                <th class="text-left px-5 py-1 align-top">{{$t('data.user.qualificationStage')}}</th>
                                <td class="text-left px-5 py-1">
                                    <span v-if="user.qualificationStage">{{user.qualificationStage}}</span>
                                    <span class="italic" v-else>{{ $t('data.user.unset') }}</span>
                                </td>
                            </tr>
                            <tr>
                                <th class="text-left px-5 py-1 align-top">{{$t('data.user.feiNo')}}</th>
                                <td class="text-left px-5 py-1">
                                    <span v-if="user.feiNo">{{user.feiNo}}</span>
                                    <span class="italic" v-else>{{ $t('data.user.unset') }}</span>
                                </td>
                            </tr>
                            <tr>
                                <th class="text-left px-5 py-1 align-top">{{$t('data.user.fnNo')}}</th>
                                <td class="text-left px-5 py-1">
                                    <span v-if="user.fnNo">{{user.fnNo}}</span>
                                    <span class="italic" v-else>{{ $t('data.user.unset') }}</span>
                                </td>
                            </tr>
                        </table>
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
