<template>
    <guest-layout>
        <auth-card>
            <form @submit.prevent="submit">
                <div class="px-6 py-5">
                    <div class="mb-4 text-sm text-gray-600">
                        <h1 class="text-xl mb-2">Passwort vergessen?</h1>
                        <p>Kein Problem. Nenn uns deine E-Mail Adresse und wir schicken dir einen Link zum Zurücksetzen des Passworts.</p>
                    </div>

                    <feedback color="success" class="mb-5">
                        Eine E-Mail ist auf dem Weg ...
                    </feedback>

                    <div>
                        <v-label>E-Mail</v-label>
                        <v-input type="text" class="w-full"></v-input>
                    </div>
                </div>

                <div class="flex items-center justify-end px-4 py-3 bg-gray-50 text-right sm:px-6">
                    <v-button>Passwort zurücksetzen</v-button>
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
    submit(): void {
        // Do something ...
    }
}
</script>
