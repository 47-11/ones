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

                    <v-password v-model="password" v-on:score="scoreChanged" :disabled="inputsDisabled"></v-password>

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

    passwordRepeat = "";
    dataProtectionAccepted = true;
    error = "";
    inputsDisabled = true;
    registrationDone = true;

    mounted(): void {
        this.inputsDisabled = false;
        this.dataProtectionAccepted = false;
        this.registrationDone = false;
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

    public scoreChanged(newScore: number): void {
        this.score = newScore;
    }

    private assertValid(): void {
        if (this.email === "") {
            throw new Error("E-Mail ist erforderlich.");
        } else if (this.score < 4) {
            throw new Error("Passwort ist zu schwach.");
        } else if (this.password !== this.passwordRepeat) {
            throw new Error("Password Wiederholung nicht identisch mit Passwort.");
        } else if (!this.dataProtectionAccepted) {
            throw new Error("Datenschutzbedingungen müssen akzeptiert werden.");
        }
    }
}
</script>
