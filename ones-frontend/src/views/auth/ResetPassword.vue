<template>
    <guest-layout>
        <auth-card>
            <form @submit.prevent="submit">
                <div class="px-6 py-5">
                    <div class="mb-4 text-sm text-gray-600">
                        <h1 class="text-xl font-bold">Passwort zurücksetzen</h1>
                        <p>Wähle ein starkes und sicheres Passwort aus.</p>
                    </div>

                    <div>
                        <v-label>Neues Passwort</v-label>
                        <v-input type="password" class="w-full"></v-input>
                    </div>

                    <div class="bg-gray-200 w-full h-1.5 flex items-stretch mt-3 rounded overflow-hidden">
                        <div class="bg-lime-600" style="width: 70%;"></div>
                    </div>

                    <div class="text-xs text-gray-500 mt-1 font-bold">Super starkes Passwort!</div>

                    <div class="mt-5">
                        <v-label>Passwort wiederholen</v-label>
                        <v-input type="password" class="w-full"></v-input>
                    </div>
                </div>

                <div class="flex items-center justify-end px-4 py-3 bg-gray-50 text-right sm:px-6">
                    <v-button>Passwort speichern</v-button>
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
export default class ResetPassword extends Vue {
    submit(): void {
        // Do something ...
    }
}
</script>
