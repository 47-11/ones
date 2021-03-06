<template>
    <guest-layout>
        <auth-card>
            <form @submit.prevent="login">
                <div class="px-6 py-5">

                    <error-message :error="error"/>

                    <div>
                        <v-label>{{$t("login.email")}}</v-label>
                        <v-input type="text" class="w-full" v-model="email" :disabled="inputsDisabled"></v-input>
                    </div>

                    <div class="mt-5">
                        <v-label>{{$t("login.password")}}</v-label>
                        <v-input type="password" class="w-full" v-model="password" :disabled="inputsDisabled"></v-input>

                        <router-link to="forgot-password" class="mt-2 inline-block">
                            <span class="text-blue-600">{{$t("login.forgotPassword")}}</span>
                        </router-link>
                    </div>

                    <div class="block mt-4">
                        <label for="accept_policy_conditions" class="inline-flex items-center">
                            <v-checkbox id="accept_policy_conditions" name="remember" v-model="remember" :disabled="inputsDisabled"/>
                            <span class="ml-2 text-sm text-gray-600">
                                {{$t("login.rememberSession")}}
                        </span>
                        </label>
                    </div>
                </div>

                <div class="flex items-center justify-end px-4 py-3 bg-gray-50 text-right sm:px-6">
                    <v-link to="register">{{$t("login.register")}}</v-link>
                    <div class="flex-grow"></div>
                    <v-button type="submit" :disabled="inputsDisabled" class="flex items-center">
                        {{$t("login.submit")}}
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
import { getVxm } from "@/store";
import router from "@/router";
import { Component, Vue } from "vue-property-decorator";
import { FontAwesomeIcon } from "@fortawesome/vue-fontawesome";
import { faSignInAlt } from "@fortawesome/free-solid-svg-icons";
import VLink from "@/components/VLink.vue";

@Component({
    components: {
        VLink,
        Feedback,
        VCheckbox,
        VHint,
        VButton,
        VInput,
        VLabel,
        AuthCard,
        GuestLayout,
        FontAwesomeIcon
    }
})
export default class Login extends Vue {
    email = "";
    password = "";
    remember = Boolean();
    error: Error | null = null;
    user = getVxm().user;
    inputsDisabled = true;
    myIcon= faSignInAlt;

    mounted(): void {
        this.inputsDisabled = false;
    }

    public async login(): Promise<void> {
        const loader = this.$loading.show();

        try {
            this.error = null;
            this.inputsDisabled = true;

            await this.user.login({
                email: this.email,
                password: this.password,
                staySignedIn: this.remember
            });

            router.push("/").catch(() => { /* has been redirected to track personal data */ });
        } catch (error) {
            this.error = error as Error;
        } finally {
            loader.hide();
        }
        this.inputsDisabled = false;
    }

    public logout(): void {
        this.user.logout();
    }
}
</script>
