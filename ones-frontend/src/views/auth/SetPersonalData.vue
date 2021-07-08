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
                                <div class="col-span-12 sm:col-span-2">
                                    <v-label>{{ $t("setPersonalData.salutation") }}</v-label>
                                    <v-input type="text" class="w-full" @input="update('salutation', $event)" :disabled="inputsDisabled"/>
                                </div>

                                <div class="col-span-12 sm:col-span-5">
                                    <v-label>{{ $t("setPersonalData.firstName") }}</v-label>
                                    <v-input type="text" class="w-full" @input="update('firstName', $event)" :disabled="inputsDisabled"/>
                                </div>

                                <div class="col-span-12 sm:col-span-5">
                                    <v-label>{{ $t("setPersonalData.lastName") }}</v-label>
                                    <v-input type="text" class="w-full" @input="update('lastName', $event)" :disabled="inputsDisabled"/>
                                </div>
                            </div>

                            <div class="grid grid-cols-12 gap-4 mb-5">
                                <div class="col-span-12 sm:col-span-9">
                                    <v-label>{{ $t("setPersonalData.street") }}</v-label>
                                    <v-input type="text" class="w-full" @input="update('street', $event)" :disabled="inputsDisabled"/>
                                </div>

                                <div class="col-span-12 sm:col-span-3">
                                    <v-label>{{ $t("setPersonalData.houseNumber") }}</v-label>
                                    <v-input type="text" class="w-full" @input="update('houseNumber', $event)" :disabled="inputsDisabled"/>
                                </div>
                            </div>

                            <div class="grid grid-cols-12 gap-4 mb-5">
                                <div class="col-span-12 sm:col-span-3">
                                    <v-label>{{ $t("setPersonalData.zipCode") }}</v-label>
                                    <v-input type="text" class="w-full" @input="update('zipCode', $event)" :disabled="inputsDisabled"/>
                                </div>

                                <div class="col-span-12 sm:col-span-5">
                                    <v-label>{{ $t("setPersonalData.city") }}</v-label>
                                    <v-input type="text" class="w-full" @input="update('city', $event)" :disabled="inputsDisabled"/>
                                </div>

                                <div class="col-span-12 sm:col-span-4">
                                    <v-label>{{ $t("setPersonalData.country") }}</v-label>
                                    <v-select @input="update('country', $event)" :disabled="inputsDisabled" class="w-full">
                                        <option value="DE">Deutschland</option>
                                        <option value="NL">Niederlande</option>
                                        <option value="AT">Österreich</option>
                                        <option value="CH">Schweiz</option>
                                    </v-select>
                                </div>
                            </div>

                            <div class="grid grid-cols-12 gap-4 mb-5">
                                <div class="col-span-12 sm:col-span-6">
                                    <v-label>{{ $t("setPersonalData.phoneNumber") }}</v-label>
                                    <v-input type="text" class="w-full" @input="update('phoneNumber', $event)" :disabled="inputsDisabled"/>
                                </div>

                                <div class="col-span-12 sm:col-span-6">
                                    <v-label>{{ $t("setPersonalData.phoneNumberMobile") }}</v-label>
                                    <v-input type="text" class="w-full" @input="update('phoneNumberMobile', $event)" :disabled="inputsDisabled"/>
                                </div>
                            </div>

                            <v-label>{{ $t("setPersonalData.birthday") }}</v-label>
                            <v-input type="date" class="w-full" @input="update('birthday', $event)" :disabled="inputsDisabled"/>
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
    salutation = "";
    firstName = "";
    lastName = "";
    birthday = "";
    phoneNumber = "";
    phoneNumberMobile = "";
    street = "";
    houseNumber = "";
    zipCode = "";
    city = "";
    country = "";

    error = null;
    inputsDisabled = true;

    mounted(): void {
        this.inputsDisabled = false;
    }

    get propertyNames(): string[] {
        return [
            "salutation",
            "firstName",
            "lastName",
            "birthday",
            "phoneNumber",
            "phoneNumberMobile",
            "street",
            "houseNumber",
            "zipCode",
            "city",
            "country"
        ];
    }

    public async setPersonalData(): Promise<void> {
        const loader = this.$loading.show();

        this.inputsDisabled = true;
        this.error = null;
        try {
            this.assertValid();

            await vxm.user.setPersonalData({
                salutation: this.salutation,
                firstName: this.firstName,
                lastName: this.lastName,
                birthday: this.birthday,
                phoneNumber: this.phoneNumber,
                phoneNumberMobile: this.phoneNumberMobile,
                street: this.street,
                houseNumber: this.houseNumber,
                zipCode: this.zipCode,
                city: this.city,
                country: this.country
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
        for (const property of this.propertyNames) {
            if ((this[property as keyof this] as unknown as string).length === 0) {
                throw new Error(this.$i18n.t("setPersonalData." + property).toString() + this.$i18n.t("setPersonalData.lengthNull").toString());
            }
        }
    }

    public update(property: keyof this, value: string): void {
        // eslint-disable-next-line @typescript-eslint/no-explicit-any
        this[property] = value as any;
    }
}
</script>
