<template>
    <guest-layout>
        <auth-card v-if="registrationDone">
            <div class="px-6 py-5">
                <span>
                    Registierungs-Mail wurde an <i>{{email}}</i> versendet. Bitte folge den Anweisungen um die Registierung abzuschließen.
                </span>
                <div class="flex items-center justify-end px-4 py-3 bg-gray-50 text-right sm:px-6">
                    <v-button @click.native="nextRegistration">Nächste Registierung</v-button>
                </div>
            </div>
        </auth-card>
        <auth-card v-else>
            <form @submit.prevent="register">
                <div class="px-6 py-5">
                    <feedback color="danger" class="mb-5" v-if="error.length > 0">
                        <h2 class="text-lg">Oops! Etwas ist schief gelaufen.</h2>
                        {{ error }}
                    </feedback>

                    <div>
                        <v-label>E-Mail</v-label>
                        <v-input type="text" class="w-full" v-model="email" :disabled="inputsDisabled"></v-input>
                        <v-hint>
                            Bereits an Veranstaltungen teilgenommen? Nutzen Sie die gleiche E-Mail, sodass Daten übernommen werden.
                        </v-hint>
                    </div>

                    <div class="mt-5">
                        <v-label>Passwort</v-label>
                        <v-input type="password" class="w-full" v-model="password" @input="calculatePasswordStrength" :disabled="inputsDisabled"></v-input>
                    </div>

                    <div class="bg-gray-200 w-full h-1.5 flex items-stretch mt-3 rounded overflow-hidden">
                        <div v-bind:class="{ 'bg-red-600': score === 0, 'bg-yellow-600': score === 1, 'bg-yellow-300': score === 3, 'bg-lime-600': score === 4 }" :style="passwordBarStyle"></div>
                    </div>
                     <div class="text-xs text-gray-500 mt-1 font-bold">Super starkes Passwort!</div>

                    <div class="mt-5">
                        <v-label>Passwort wiederholen</v-label>
                        <v-input type="password" class="w-full" v-model="passwordRepeat" :disabled="inputsDisabled"></v-input>
                    </div>

                    <div class="block mt-4">
                        <label for="accept_policy_conditions" class="inline-flex items-center">
                            <v-checkbox id="accept_policy_conditions" name="remember" v-model="dataProtectionAccepted" :disabled="inputsDisabled"/>
                            <span class="ml-2 text-sm text-gray-600">
                                Ich stimme den <v-link to="/">Datenschutzbestimmungen</v-link> zu.
                            </span>
                        </label>
                    </div>
                </div>
                <div class="flex items-center justify-end px-4 py-3 bg-gray-50 text-right sm:px-6">
                    <v-link to="login">Login</v-link>
                    <div class="flex-grow"></div>
                    <v-button role="submit" :disabled="inputsDisabled">Registrieren</v-button>
                </div>
            </form>
        </auth-card>
    </guest-layout>
</template>

<script lang="ts">
import Feedback from "@/components/Feedback.vue";
import { Component, Vue } from "vue-property-decorator";
import GuestLayout from "@/layouts/GuestLayout.vue";
import AuthCard from "@/components/AuthCard.vue";
import VLabel from "@/components/forms/VLabel.vue";
import VInput from "@/components/forms/VInput.vue";
import VButton from "@/components/VButton.vue";
import VHint from "@/components/forms/VHint.vue";
import VCheckbox from "@/components/forms/VCheckbox.vue";
import { vxm } from "@/store";
import VLink from "@/components/VLink.vue";
import { zxcvbn, ZxcvbnOptions } from "@zxcvbn-ts/core";
import zxcvbnCommonPackage from "@zxcvbn-ts/language-common";
import zxcvbnEnPackage from "@zxcvbn-ts/language-en";
import zxcvbnDePackage from "@zxcvbn-ts/language-de";

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
        Feedback
    }
})
export default class Register extends Vue {
    email = "";
    password = "";
    passwordBarStyle = {
        width: "10%"
    };

    passwordRepeat = "";
    dataProtectionAccepted = true;
    error = "";
    inputsDisabled = true;
    registrationDone = true;
    score = 0;

    mounted(): void {
        this.inputsDisabled = false;
        this.dataProtectionAccepted = false;
        this.registrationDone = false;

        ZxcvbnOptions.setOptions({
            translations: zxcvbnEnPackage.translations,
            dictionary: {
                ...zxcvbnCommonPackage.dictionary,
                ...zxcvbnEnPackage.dictionary,
                ...zxcvbnDePackage.dictionary
            }
        });
    }

    public async register(): Promise<void> {
        this.inputsDisabled = true;
        this.error = "";
        try {
            this.assertValid();
            await vxm.user.register({
                email: this.email,
                password: this.password
            });
            this.registrationDone = true;
        } catch (error) {
            if (error.response?.data?.userMessage) {
                this.error = error.response?.data?.userMessage;
            } else {
                this.error = error.message;
            }
        }
        this.inputsDisabled = false;
    }

    public nextRegistration(): void {
        this.registrationDone = false;
    }

    private assertValid(): void {
        if (this.email === "") {
            throw new Error("E-Mail ist erforderlich.");
        } else if (this.password.length < 8) {
            throw new Error("Passwort muss aus mindestens 8 Zeichen bestehen.");
        } else if (this.password !== this.passwordRepeat) {
            throw new Error("Password Wiederholung nicht identisch mit Passwort.");
        } else if (!this.dataProtectionAccepted) {
            throw new Error("Datenschutzbedingungen müssen akzeptiert werden.");
        }
    }

    private calculatePasswordStrength(): void {
        if (this.password.length === 0) {
            this.passwordBarStyle.width = "10%";
            this.score = 0;
            return;
        }

        const result = zxcvbn(this.password);
        this.passwordBarStyle.width = Math.max(result.score * 25, 10) + "%";
        this.score = result.score;
    }
}
</script>
