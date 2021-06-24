<template>
    <guest-layout>
        <auth-card v-if="mailSend">
            <div class="px-6 py-5">
                <feedback color="success" class="mb-5">
                    {{ $t("forgotPassword.success") }}
                </feedback>
            </div>
            <div class="flex items-center justify-end px-4 py-3 bg-gray-50 text-right sm:px-6">
                <router-link to="login">
                    <v-button>{{$t("forgotPassword.toLogin")}}</v-button>
                </router-link>
            </div>
        </auth-card>
        <auth-card v-else>
            <form @submit.prevent="sendForgotMail">
                <div class="px-6 py-5">
                    <error-message :error="error"/>

                    <div class="mb-4 text-sm text-gray-600">
                        <h1 class="text-xl mb-2">{{$t("forgotPassword.title")}}</h1>
                        <p>{{$t("forgotPassword.message")}}</p>
                    </div>

                    <div>
                        <v-label>{{$t("forgotPassword.email")}}</v-label>
                        <v-input type="text" class="w-full" v-model="email" :disabled="inputsDisabled"></v-input>
                    </div>
                </div>

                <div class="flex items-center justify-end px-4 py-3 bg-gray-50 text-right sm:px-6">
                    <v-button type="submit" :disabled="inputsDisabled">{{$t("forgotPassword.submit")}}</v-button>
                </div>
            </form>
        </auth-card>
    </guest-layout>
</template>

<script lang="ts">
import { Component, Vue } from "vue-property-decorator";
import GuestLayout from "@/layouts/GuestLayout.vue";
import AuthCard from "@/components/AuthCard.vue";
import VLabel from "@/components/forms/VLabel.vue";
import VInput from "@/components/forms/VInput.vue";
import VButton from "@/components/VButton.vue";
import VHint from "@/components/forms/VHint.vue";
import VCheckbox from "@/components/forms/VCheckbox.vue";
import Feedback from "@/components/Feedback.vue";
import { vxm } from "@/store";

@Component({
    components: {
        Feedback,
        VCheckbox,
        VHint,
        VButton,
        VInput,
        VLabel,
        AuthCard,
        GuestLayout
    }
})
export default class ForgotPassword extends Vue {
    error = null;
    mailSend = true;
    email = "";
    inputsDisabled = true;

    mounted(): void {
        this.mailSend = false;
        this.inputsDisabled = false;
    }

    async sendForgotMail(): Promise<void> {
        const loader = this.$loading.show();

        this.inputsDisabled = true;

        try {
            this.error = null;

            await vxm.user.forgotPassword({ email: this.email });
            this.mailSend = true;
        } catch (error) {
            this.error = error;
        } finally {
            loader.hide();
        }

        this.inputsDisabled = false;
    }
}
</script>
