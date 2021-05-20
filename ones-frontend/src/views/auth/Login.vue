<template>
    <guest-layout>
        <auth-card>
            <form @submit.prevent="login">
                <div class="px-6 py-5">

                    <feedback color="danger" class="mb-5" v-if="error.length > 0">
                        <h2 class="text-lg">Oops! Etwas ist schief gelaufen.</h2>
                        {{ error }}
                    </feedback>

                    <div>
                        <v-label>E-Mail</v-label>
                        <v-input type="text" class="w-full" v-model="email" :disabled="inputsDisabled"></v-input>
                    </div>

                    <div class="mt-5">
                        <v-label>Passwort</v-label>
                        <v-input type="password" class="w-full" v-model="password" :disabled="inputsDisabled"></v-input>
                    </div>

                    <div class="block mt-4">
                        <label for="accept_policy_conditions" class="inline-flex items-center">
                            <v-checkbox id="accept_policy_conditions" name="remember" v-model="remember" :disabled="inputsDisabled"/>
                            <span class="ml-2 text-sm text-gray-600">
                                Sitzung merken und eingeloggt bleiben.
                        </span>
                        </label>
                    </div>
                </div>

                <div class="flex items-center justify-end px-4 py-3 bg-gray-50 text-right sm:px-6">
                    <router-link to="register">
                        <span class="text-blue-600 hover:underline">Registrieren</span>
                    </router-link>
                    <div class="flex-grow"></div>
                    <v-button @click.native="login" :disabled="inputsDisabled" class="flex items-center">
                        Einloggen
                        <font-awesome-icon :icon="myIcon" class="ml-2"/>
                    </v-button>
                </div>
            </form>
        </auth-card>
    </guest-layout>
</template>

<script lang="ts">
import AuthCard from "@/components/AuthCard.vue";
import Feedback from "@/components/Feedback.vue";
import VCheckbox from "@/components/forms/VCheckbox.vue";
import VHint from "@/components/forms/VHint.vue";
import VInput from "@/components/forms/VInput.vue";
import VLabel from "@/components/forms/VLabel.vue";
import VButton from "@/components/VButton.vue";
import GuestLayout from "@/layouts/GuestLayout.vue";
import store, { vxm } from "@/store";
import router from "@/router";
import { Component, Vue } from "vue-property-decorator";
import { FontAwesomeIcon } from "@fortawesome/vue-fontawesome";
import { faSignInAlt } from "@fortawesome/free-solid-svg-icons";

@Component({
    components: {
        Feedback,
        VCheckbox,
        VHint,
        VButton,
        VInput,
        VLabel,
        AuthCard,
        GuestLayout,
        FontAwesomeIcon
    },
    store
})
export default class Login extends Vue {
    email = "";
    password = "";
    remember = Boolean();
    error = "";
    user = vxm.user;
    inputsDisabled = true;
    myIcon= faSignInAlt;

    mounted(): void {
        this.inputsDisabled = false;
    }

    public async login(): Promise<void> {
        try {
            this.inputsDisabled = true;
            this.error = "";
            await this.user.login({
                email: this.email,
                password: this.password,
                staySignedIn: this.remember
            });
            router.push("/");
        } catch (error) {
            if (error.response?.data?.userMessage) {
                this.error = error.response?.data?.userMessage;
            } else {
                this.error = error.message;
            }
        }
        this.inputsDisabled = false;
    }

    public logout(): void {
        this.user.logout();
    }
}
</script>
