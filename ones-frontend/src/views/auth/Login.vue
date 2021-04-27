<template>
    <guest-layout>
        <auth-card>
            <div class="px-6 py-5">

                <!--
                <feedback color="danger" class="mb-5">
                    <h2 class="text-lg">Oops! Etwas ist schief gelaufen.</h2>
                    Das ist eine Fehlermeldung ...
                </feedback>
                -->

                <div>
                    <v-label>E-Mail</v-label>
                    <v-input type="text" class="w-full"></v-input>
                </div>

                <div class="mt-5">
                    <v-label>Passwort</v-label>
                    <v-input type="password" class="w-full"></v-input>
                </div>

                <div class="block mt-4">
                    <label for="accept_policy_conditions" class="inline-flex items-center">
                        <v-checkbox id="accept_policy_conditions" name="remember"/>
                        <span class="ml-2 text-sm text-gray-600">
                            Sitzung merken und eingeloggt bleiben.
                    </span>
                    </label>
                </div>
            </div>

            <div class="flex items-center justify-end px-4 py-3 bg-gray-50 text-right sm:px-6">
                <v-button>Einloggen</v-button>
            </div>
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
import Feedback from '@/components/Feedback.vue';

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
export default class Login extends Vue {
}
</script>
