<template>
    <guest-layout>

        <div class="min-h-screen flex flex-col sm:justify-center items-center pt-6 md:pt-0 bg-gray-100">
            <div class="max-w-4xl">
                <page-header>{{ $t("setPersonalData.title") }}</page-header>

                <div class="flex flex-col md:flex-row">
                    <div class="md:w-2/3 order-2 md:order-1 md:mt-6 md:mr-12 bg-white shadow-md overflow-hidden sm:rounded-lg">
                        <form @submit.prevent="setPersonalData">
                        <div class="px-6 py-5">
                            <error-message :error="error"/>

                            <div class="grid grid-cols-12 gap-4 mb-5">
                                <div class="col-span-12 sm:col-span-6">
                                    <v-label>{{ $t("data.user.firstName") }}</v-label>
                                    <v-input type="text" class="w-full" @input="update('firstName', $event)" :disabled="inputsDisabled"/>
                                </div>

                                <div class="col-span-12 sm:col-span-6">
                                    <v-label>{{ $t("data.user.lastName") }}</v-label>
                                    <v-input type="text" class="w-full" @input="update('lastName', $event)" :disabled="inputsDisabled"/>
                                </div>
                            </div>
                            <div class="grid grid-cols-12 gap-4 mb-5">
                                <div class="col-span-12 sm:col-span-6">
                                    <v-label>
                                        {{ $t("data.user.birthName") }}
                                        <span class="text-xs font-thin text-gray-400 float-right">{{ $t('data.user.optional') }}</span>
                                    </v-label>
                                    <v-input type="text" class="w-full" @input="update('birthName', $event)" :disabled="inputsDisabled"/>
                                </div>
                                <div class="col-span-12 sm:col-span-6">
                                    <v-label>{{ $t("data.user.birthday") }}</v-label>
                                    <v-input type="date" class="w-full" @input="update('birthday', $event)" :disabled="inputsDisabled"/>
                                </div>
                            </div>

                            <div class="grid grid-cols-12 gap-4 mb-5">
                                <div class="col-span-12 sm:col-span-9">
                                    <v-label>{{ $t("data.user.street") }}</v-label>
                                    <v-input type="text" class="w-full" @input="update('street', $event)" :disabled="inputsDisabled"/>
                                </div>

                                <div class="col-span-12 sm:col-span-3">
                                    <v-label>{{ $t("data.user.houseNumber") }}</v-label>
                                    <v-input type="text" class="w-full" @input="update('houseNumber', $event)" :disabled="inputsDisabled"/>
                                </div>
                            </div>

                            <div class="grid grid-cols-12 gap-4 mb-5">
                                <div class="col-span-12 sm:col-span-3">
                                    <v-label>{{ $t("data.user.zipCode") }}</v-label>
                                    <v-input type="text" class="w-full" @input="update('zipCode', $event)" :disabled="inputsDisabled"/>
                                </div>

                                <div class="col-span-12 sm:col-span-5">
                                    <v-label>{{ $t("data.user.city") }}</v-label>
                                    <v-input type="text" class="w-full" @input="update('city', $event)" :disabled="inputsDisabled"/>
                                </div>

                                <div class="col-span-12 sm:col-span-4">
                                    <v-label>{{ $t("data.user.country") }}</v-label>
                                    <v-select @input="update('country', $event)" :disabled="inputsDisabled" class="w-full">
                                        <option value="DE">{{ $t("shared.countries.germany") }}</option>
                                        <option value="NL">{{ $t("shared.countries.netherlands") }}</option>
                                        <option value="AT">{{ $t("shared.countries.austria") }}</option>
                                        <option value="CH">{{ $t("shared.countries.switzerland") }}</option>
                                    </v-select>
                                </div>
                            </div>

                            <div class="grid grid-cols-12 gap-4 mb-5">
                                <div class="col-span-12 sm:col-span-6">
                                    <v-label>{{ $t("data.user.phoneNumber") }}</v-label>
                                    <v-input type="text" class="w-full" @input="update('phoneNumber', $event)" :disabled="inputsDisabled"/>
                                </div>

                                <div class="col-span-12 sm:col-span-6">
                                    <v-label>
                                        {{ $t("data.user.phoneNumberMobile") }}
                                        <span class="text-xs font-thin text-gray-400 float-right">{{ $t('data.user.optional') }}</span>
                                    </v-label>
                                    <v-input type="text" class="w-full" @input="update('phoneNumberMobile', $event)" :disabled="inputsDisabled"/>
                                </div>
                            </div>

                            <div class="col-span-12 gap-4 mb-5">
                                <v-label>{{ $t("data.user.phoneNumberEmergency") }}</v-label>
                                <v-input type="text" class="w-full" @input="update('phoneNumberEmergency', $event)" :disabled="inputsDisabled"/>
                            </div>

                            <div class="grid grid-cols-12 gap-4 mb-5">
                                <div class="col-span-12 sm:col-span-4">
                                    <v-label>{{ $t("data.user.qualificationStage") }}</v-label>
                                    <v-select @input="update('qualificationStage', $event)" :disabled="inputsDisabled" class="w-full">
                                        <option value="0">{{ 0 }}</option>
                                        <option value="1">{{ 1 }}</option>
                                        <option value="2">{{ 2 }}</option>
                                        <option value="3">{{ 3 }}</option>
                                    </v-select>
                                </div>

                                <div class="col-span-12 sm:col-span-4">
                                    <v-label>
                                        {{ $t("data.user.feiNo") }}
                                        <span class="text-xs font-thin text-gray-400 float-right">{{ $t('data.user.optional') }}</span>
                                    </v-label>
                                    <v-input type="text" class="w-full" @input="update('feiNo', $event)" :disabled="inputsDisabled"/>
                                </div>

                                <div class="col-span-12 sm:col-span-4">
                                    <v-label>
                                        {{ $t("data.user.fnNo") }}
                                        <span class="text-xs font-thin text-gray-400 float-right">{{ $t('data.user.optional') }}</span>
                                    </v-label>
                                    <v-input type="text" class="w-full" @input="update('fnNo', $event)" :disabled="inputsDisabled"/>
                                </div>
                            </div>
                        </div>
                        <div class="flex items-center justify-end px-4 py-3 bg-gray-50 text-right sm:px-6">
                            <v-link to="logout">{{$t("setPersonalData.logout")}}</v-link>
                            <div class="flex-grow"></div>
                            <v-button role="submit" :disabled="inputsDisabled">{{$t("setPersonalData.submit")}}</v-button>
                        </div>
                    </form>
                    </div>

                    <div class="mb-8 md:mt-8 order-1 md:order-2 px-6 md:px-0 md:w-64 flex-grow-0">
                        <h2 class="text-xl font-bold">{{ $t("register.steps.title") }}</h2>

                        <div class="mt-8 flex items-center">
                            <badge-circle class="mr-5 bg-gray-700 text-white">1.</badge-circle>
                            <h3 class="text-lg font-bold">{{ $t("register.steps.first.title") }}</h3>
                        </div>

                        <p class="text-gray-500 text-sm mt-4">{{ $t("register.steps.first.description") }}</p>

                        <div class="mt-8 flex items-center">
                            <badge-circle class="mr-5  bg-indigo-500 text-white">2.</badge-circle>
                            <h3 class="text-lg font-bold">{{ $t("register.steps.second.title") }}</h3>
                        </div>

                        <p class="text-gray-500 text-sm mt-4">{{ $t("register.steps.second.description") }} </p>
                    </div>
                </div>
            </div>
        </div>
    </guest-layout>
</template>

<style scoped>
#passwordBar {
    transition: background-color, width 0.5s ease-in-out;
}
</style>

<script lang="ts">
import Feedback from "@/components/Feedback.vue";
import { Component, Vue } from "vue-property-decorator";
import GuestLayout from "@/layouts/GuestLayout.vue";
import AuthCard from "@/components/AuthCard.vue";
import VLabel from "@/components/forms/VLabel.vue";
import VInput from "@/components/forms/VInput.vue";
import VSelect from "@/components/forms/VSelect.vue";
import VPassword from "@/components/forms/VPassword.vue";
import VButton from "@/components/VButton.vue";
import VHint from "@/components/forms/VHint.vue";
import VCheckbox from "@/components/forms/VCheckbox.vue";
import { vxm } from "@/store";
import VLink from "@/components/VLink.vue";
import PageHeader from "@/components/PageHeader.vue";
import BadgeCircle from "@/components/BadgeCircle.vue";

@Component({
    components: {
        VLink,
        VCheckbox,
        VHint,
        VButton,
        VInput,
        VLabel,
        AuthCard,
        GuestLayout,
        Feedback,
        VSelect,
        VPassword,
        PageHeader,
        BadgeCircle
    }
})
export default class SetPersonalData extends Vue {
    firstName = "";
    lastName = "";
    birthName = "";
    birthday = "";
    phoneNumber = "";
    phoneNumberMobile = "";
    phoneNumberEmergency = "";
    street = "";
    houseNumber = "";
    zipCode = "";
    city = "";
    country = "";
    qualificationStage = "";
    feiNo = "";
    fnNo = "";

    error = null;
    inputsDisabled = true;

    mounted(): void {
        this.inputsDisabled = false;
    }

    get requiredProperties(): string[] {
        return [
            "firstName",
            "lastName",
            "birthday",
            "street",
            "houseNumber",
            "phoneNumber",
            "phoneNumberMobile",
            "phoneNumberEmergency",
            "zipCode",
            "city",
            "country",
            "qualificationStage"
        ];
    }

    public async setPersonalData(): Promise<void> {
        const loader = this.$loading.show();

        this.inputsDisabled = true;
        this.error = null;
        try {
            this.assertValid();

            await vxm.user.setPersonalData({
                firstName: this.firstName,
                lastName: this.lastName,
                birthName: this.birthName,
                birthday: this.birthday,
                phoneNumber: this.phoneNumber,
                phoneNumberMobile: this.phoneNumberMobile,
                phoneNumberEmergency: this.phoneNumberEmergency,
                address: {
                    street: this.street,
                    houseNumber: this.houseNumber,
                    zipCode: this.zipCode,
                    city: this.city,
                    country: this.country
                },
                qualificationLevel: this.qualificationStage,
                feiNumber: this.feiNo,
                fnNumber: this.fnNo
            });
        } catch (error) {
            this.error = error;
        } finally {
            loader.hide();
        }

        this.inputsDisabled = false;

        this.$router.push("/");
    }

    private assertValid(): void {
        for (const property of this.requiredProperties) {
            if ((this[property as keyof this] as unknown as string).length === 0) {
                throw new Error(this.$i18n.t("data.user." + property).toString() + this.$i18n.t("setPersonalData.lengthNull").toString());
            }
        }
    }

    public update(property: keyof this, value: string): void {
        // eslint-disable-next-line @typescript-eslint/no-explicit-any
        this[property] = value as any;
    }
}
</script>
