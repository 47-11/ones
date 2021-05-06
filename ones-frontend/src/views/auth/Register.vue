<template>
    <guest-layout>
        <auth-card>
            <form @submit.prevent="register">
                <div class="px-6 py-5">
                    <feedback color="danger" class="mb-5" v-if="error.length > 0">
                        <h2 class="text-lg">Oops! Etwas ist schief gelaufen.</h2>
                        {{ error }}
                    </feedback>

                    <div>
                        <v-label>E-Mail</v-label>
                        <v-input type="text" class="w-full" v-model="email"></v-input>
                        <v-hint>
                            Bereits an Veranstaltungen teilgenommen? Nutzen Sie die gleiche E-Mail, sodass Daten
                            übernommen werden.
                        </v-hint>
                    </div>

                    <div class="mt-5">
                        <v-label>Passwort</v-label>
                        <v-input type="password" class="w-full" v-model="password"></v-input>
                    </div>

                    <div class="bg-gray-200 w-full h-1.5 flex items-stretch mt-3 rounded overflow-hidden">
                        <div class="bg-lime-600" style="width: 70%;"></div>
                    </div>

                    <div class="text-xs text-gray-500 mt-1 font-bold">Super starkes Passwort!</div>

                    <div class="mt-5">
                        <v-label>Passwort wiederholen</v-label>
                        <v-input type="password" class="w-full" v-model="passwordRepeat"></v-input>
                    </div>

                    <div class="block mt-4">
                        <label for="accept_policy_conditions" class="inline-flex items-center">
                            <v-checkbox id="accept_policy_conditions" name="remember"/>
                            <span class="ml-2 text-sm text-gray-600">
                            Ich stimme den <router-link to="/">Datenschutzbestimmungen</router-link> zu.
                    </span>
                        </label>
                    </div>
                </div>

                <div class="flex items-center justify-end px-4 py-3 bg-gray-50 text-right sm:px-6">
                    <v-button @click.native="register">Registrieren</v-button>
                </div>
            </form>
        </auth-card>
    </guest-layout>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';
import GuestLayout from '@/layouts/GuestLayout.vue';
import AuthCard from '@/components/AuthCard.vue';
import VLabel from '@/components/forms/VLabel.vue';
import VInput from '@/components/forms/VInput.vue';
import VButton from '@/components/VButton.vue';
import VHint from '@/components/forms/VHint.vue';
import VCheckbox from '@/components/forms/VCheckbox.vue';
import { vxm } from '@/store';

@Component({
    components: {
        VCheckbox,
        VHint,
        VButton,
        VInput,
        VLabel,
        AuthCard,
        GuestLayout
    }
})
export default class Register extends Vue {
    email = '';
    password = '';
    passwordRepeat = '';
    remember = false;
    error = '';

    public async register (): Promise<void> {
        try {
            await vxm.user.register({
                email: this.email,
                password: this.password
            });
        } catch (error) {
            if (error.response?.data?.userMessage) {
                this.error = error.response?.data?.userMessage;
            } else {
                this.error = error.message;
            }
        }
    }
}
</script>
