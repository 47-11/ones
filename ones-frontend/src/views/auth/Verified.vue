<template>
    <guest-layout>
        <auth-card>
            <div class="px-6 py-5" v-if="!hasError && !verified">
                <feedback color="danger" class="mb-5">
                    <h2 class="text-lg">{{$t('verified.wait')}}</h2>
                    {{$t('verified.authenticationRunning')}}
                </feedback>
            </div>
            <div class="px-6 py-5" v-if="hasError">
                <error-message :error="error"></error-message>
            </div>
            <div class="px-6 py-5" v-if="verified && !hasError">
                <div class="text-sm text-gray-600">
                    <h1 class="text-xl">{{$t('verified.emailConfirmed')}}</h1>
                </div>
            </div>

            <div class="flex items-center justify-end px-4 py-3 bg-gray-50 text-right sm:px-6" v-if="hasError">
                <router-link to="login">
                    <v-button>{{$t('verified.nextRegistration')}}</v-button>
                </router-link>
            </div>

            <div class="flex items-center justify-end px-4 py-3 bg-gray-50 text-right sm:px-6"  v-if="verified && !hasError">
                <router-link to="login">
                    <v-button>{{$t('verified.toLogin')}}</v-button>
                </router-link>
            </div>
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
import { getVxm } from "@/store";

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
    verified = true;
    error = null;

    get hasError(): boolean {
        return !!this.error;
    }

    async mounted(): Promise<void> {
        const loader = this.$loading.show();

        this.error = null;
        this.verified = false;
        const code = this.$route.query.code as string;

        try {
            await getVxm().user.verify({ code });
            this.verified = true;
        } catch (error) {
            this.error = error;
        } finally {
            loader.hide();
        }
    }
}
</script>
