<template>
    <guest-layout>
        <auth-card v-if="registrationDone">
            <div class="px-6 py-5">
                <i18n path="register.success">
                    <template v-slot:email>
                        <i>{{email}}</i>
                    </template>
                </i18n>
                <div class="flex items-center justify-end px-4 py-3 text-right sm:px-6">
                    <v-button @click.native="nextRegistration">{{$t("register.nextRegistration")}}</v-button>
                </div>
            </div>
        </auth-card>
        <auth-card v-else>
            <form @submit.prevent="register">
                <div class="px-6 py-5">
                    <error-message :error="error"/>

                    <div>
                        <v-label>{{ $t("register.email") }}</v-label>
                        <v-input type="text" class="w-full" v-model="email" :disabled="inputsDisabled"></v-input>
                        <v-hint>
                            {{ $t("register.sameMail") }}
                        </v-hint>
                    </div>

                    <div>
                        <v-label>{{ $t("register.vddNumber") }} ({{ $t("register.optional")}})</v-label>
                        <v-input type="number" class="w-full" v-model="vddNumber" :disabled="inputsDisabled"></v-input>
                    </div>

                    <v-password v-model="password" v-on:score="scoreChanged" :disabled="inputsDisabled"></v-password>

                    <div class="mt-5">
                        <v-label>{{$t("register.passwordRepeat")}}</v-label>
                        <v-input type="password" class="w-full" v-model="passwordRepeat" :disabled="inputsDisabled"></v-input>
                    </div>

                    <div class="block mt-4">
                        <label for="accept_policy_conditions" class="inline-flex items-center">
                            <v-checkbox id="accept_policy_conditions" name="remember" v-model="dataProtectionAccepted" :disabled="inputsDisabled"/>
                            <span class="ml-2 text-sm text-gray-600">
                                <i18n path="register.agreeToPolicy">
                                    <template v-slot:policy>
                                        <v-link to="/">{{$t("register.privacyPolicy")}}</v-link>
                                    </template>
                                </i18n>
                            </span>
                        </label>
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
export default class Register extends Vue {
    email = "";
    password = "";
    score = 0;
    vddNumber: string | undefined;

    data(): Record<string, undefined> {
        return {
            vddNumber: undefined
        };
    }

    passwordRepeat = "";
    dataProtectionAccepted = true;
    error = null;
    inputsDisabled = true;
    registrationDone = true;

    mounted(): void {
        this.inputsDisabled = false;
        this.dataProtectionAccepted = false;
        this.registrationDone = false;
    }

    public async register(): Promise<void> {
        const loader = this.$loading.show();

        this.inputsDisabled = true;
        this.error = null;
        try {
            this.assertValid();

            const vddNumber = this.vddNumber ? parseInt(this.vddNumber) : undefined;
            await vxm.user.register({
                email: this.email,
                password: this.password,
                vddNumber
            });
            this.registrationDone = true;
        } catch (error) {
            this.error = error;
        } finally {
            loader.hide();
        }

        this.inputsDisabled = false;
    }

    public nextRegistration(): void {
        this.registrationDone = false;
    }

    public scoreChanged(newScore: number): void {
        this.score = newScore;
    }

    private assertValid(): void {
        if (this.email === "") {
            throw new Error("register.mailRequired");
        } else if (this.score < 4) {
            throw new Error("register.tooWeak");
        } else if (this.password !== this.passwordRepeat) {
            throw new Error("register.notIdentical");
        } else if (!this.dataProtectionAccepted) {
            throw new Error("register.acceptanceRequired");
        }
    }
}
</script>
