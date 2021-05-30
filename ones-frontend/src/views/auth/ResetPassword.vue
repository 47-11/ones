<template>
    <guest-layout>
        <auth-card v-if="changeDone">
            <div class="px-6 py-5">
                <feedback color="success" class="mb-5">
                    {{$t("resetPassword.success")}}
                </feedback>
            </div>
            <div class="flex items-center justify-end px-4 py-3 bg-gray-50 text-right sm:px-6">
                <router-link to="login">
                    <v-button>{{$t('resetPassword.toLogin')}}</v-button>
                </router-link>
            </div>
        </auth-card>
        <auth-card v-else>
            <form @submit.prevent="submit">
                <div class="px-6 py-5">
                    <feedback color="danger" class="mb-5" v-if="error.length > 0">
                        <h2 class="text-lg">{{$t('resetPassword.error')}}</h2>
                        {{ error }}
                    </feedback>

                    <div class="mb-4 text-sm text-gray-600">
                        <h1 class="text-xl font-bold">{{$t('resetPassword.resetPassword')}}</h1>
                        <p>{{$t('resetPassword.chooseStrongPassword')}}</p>
                    </div>

                    <v-password v-bind:label="'Neues Passwort'" v-model="password" v-on:score="scoreChanged" :disabled="inputsDisabled"></v-password>

                    <div class="mt-5">
                        <v-label>{{$t('resetPassword.passwordRepeat')}}</v-label>
                        <v-input type="password" class="w-full" v-model="passwordRepeat" :disabled="inputsDisabled"></v-input>
                    </div>
                </div>

                <div class="flex items-center justify-end px-4 py-3 bg-gray-50 text-right sm:px-6">
                    <v-button @click.native="resetPassword">{{$t('resetPassword.savePassword')}}</v-button>
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
import VPassword from "@/components/forms/VPassword.vue";
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
        GuestLayout,
        VPassword
    }
})
export default class ResetPassword extends Vue {
    error = "";
    password = "";
    passwordRepeat = "";
    inputsDisabled = true;
    changeDone = true;
    score = 0;

    mounted(): void {
        this.inputsDisabled = false;
        this.changeDone = false;
    }

    async resetPassword(): Promise<void> {
        this.inputsDisabled = true;
        this.error = "";
        const code = this.$route.query.code as string;

        try {
            this.assertValid();
            await vxm.user.setNewPasswordByCode({
                password: this.password,
                code
            });
            this.changeDone = true;
        } catch (error) {
            if (error.response?.data?.userMessage) {
                this.error = error.response?.data?.userMessage;
            }
            this.error = error.message;
        }
        this.inputsDisabled = false;
    }

    private assertValid(): void {
        if (this.score < 4) {
            throw new Error("Passwort ist zu schwach.");
        } else if (this.password !== this.passwordRepeat) {
            throw new Error("Password Wiederholung nicht identisch mit Passwort.");
        }
    }

    public scoreChanged(newScore: number): void {
        this.score = newScore;
    }
}
</script>
