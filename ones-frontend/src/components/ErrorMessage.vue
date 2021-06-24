<template>
    <feedback color="danger" class="mb-5" v-if="error">
        <h2 class="text-lg">{{ $t("shared.error") }}</h2>
        {{ $t(message) }}
    </feedback>
</template>

<script lang="ts">
import { Component, Prop, Vue } from "vue-property-decorator";
import Feedback from "@/components/Feedback.vue";
import { AxiosError } from "axios";

function isAxiosError(error: Error): error is AxiosError {
    return (error as AxiosError).config !== undefined;
}

@Component({
    components: { Feedback }
})
export default class ErrorMessage extends Vue {
    @Prop() private error!: Error;

    isActive(): boolean {
        return this.error !== undefined;
    }

    get message(): string {
        let message = this.error.message;
        if (isAxiosError(this.error)) {
            message = this.error.response?.data?.userMessage || message;
        }
        return message;
    }
}
</script>
