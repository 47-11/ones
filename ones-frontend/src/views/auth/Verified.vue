<template>
    <guest-layout>
        <auth-card>
            <div class="px-6 py-5">
                <div class="text-sm text-gray-600">
                    <h1 class="text-xl">E-Mail erfolgreich bestätigt.</h1>
                </div>
            </div>

            <div class="flex items-center justify-end px-4 py-3 bg-gray-50 text-right sm:px-6">
                <v-button>zum Login</v-button>
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
import { vxm } from '@/store';

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
export default class Verified extends Vue {
    mounted (): void {
        const code = this.$route.query.code as string;
        vxm.user.verify({ code }).catch(console.error);
    }
}
</script>
