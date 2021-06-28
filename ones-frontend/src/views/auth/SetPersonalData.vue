<template>
    <guest-layout>
        <auth-card>
            <form @submit.prevent="setPersonalData">
                <div class="px-6 py-5">
                    <error-message :error="error"/>

                    <div v-for="property in propertyNames" :key="property">

                        <v-label>{{ $t("setPersonalData." + property) }}</v-label>
                        <v-input type="text" class="w-full" @input="update(property, $event)" :disabled="inputsDisabled"></v-input>
                    </div>
                </div>
                <div class="flex items-center justify-end px-4 py-3 bg-gray-50 text-right sm:px-6">
                    <v-link to="login">{{$t("register.login")}}</v-link>
                    <div class="flex-grow"></div>
                    <v-button role="submit" :disabled="inputsDisabled">{{$t("register.submit")}}</v-button>
                </div>
            </form>
        </auth-card>
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
import VPassword from "@/components/forms/VPassword.vue";
import VButton from "@/components/VButton.vue";
import VHint from "@/components/forms/VHint.vue";
import VCheckbox from "@/components/forms/VCheckbox.vue";
import { vxm } from "@/store";
import VLink from "@/components/VLink.vue";

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
        VPassword
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

            await vxm.user.setPersonalData(this);
        } catch (error) {
            this.error = error;
        } finally {
            loader.hide();
        }

        this.inputsDisabled = false;
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
