<template>
<div>
    <div class="mt-5">
        <v-label>{{labelOrDefault}}</v-label>
        <v-input type="password" class="w-full" v-bind:value="value" @input="passwordChanged" :disabled="disabled"></v-input>
    </div>

    <div class="bg-gray-200 w-full h-1.5 flex items-stretch mt-3 rounded overflow-hidden">
        <div id="passwordBar" v-bind:class="{ 'bg-red-600': score === 0, 'bg-yellow-700': score === 1, 'bg-yellow-600': score === 2, 'bg-yellow-300': score === 3, 'bg-lime-600': score === 4 }" :style="passwordBarStyle"></div>
    </div>
    <div class="text-xs text-yellow-500 mt-1 font-bold" v-if="passwordWarning">
        <font-awesome-icon :icon="'exclamation-triangle'" class="ml-2"/>
        {{passwordWarning}}
    </div>
    <div v-for="(suggestion, index) in passwordSuggestions" :key="index">
        <div class="text-xs text-gray-500 mt-1 font-bold">{{suggestion}}</div>
    </div>
</div>
</template>

<script lang="ts">
import { zxcvbn, ZxcvbnOptions } from "@zxcvbn-ts/core";
import zxcvbnCommonPackage from "@zxcvbn-ts/language-common";
import zxcvbnEnPackage from "@zxcvbn-ts/language-en";
import zxcvbnDePackage from "@zxcvbn-ts/language-de";
import { Component, Prop, Vue } from "vue-property-decorator";
import VInput from "./VInput.vue";
import VLabel from "./VLabel.vue";

type EvaluationType = {
    feedback: {
        warning: string,
        suggestions: string[]
    },
    score: number
};

const EvaluationForEmptyPassword: EvaluationType = {
    feedback: {
        warning: "",
        suggestions: []
    },
    score: 0
};

// Translation error in german dictionary "Dies ist ein weniger häufig verwendetes Passwort." is fixed by not released yet.
zxcvbnDePackage.translations.warnings.common = "Dies ist ein häufig verwendetes Passwort.";

@Component({
    components: {
        VInput,
        VLabel
    }
})
export default class VPassword extends Vue {
    @Prop() public disabled!: boolean;
    @Prop() public value!: string;
    @Prop() public label!: string;

    get labelOrDefault(): string {
        return this.label || this.$t("password.password").toString();
    }

    passwordDebounceTimeout: number | undefined;
    debouncedPassword = "";

    get passwordEvaluation(): EvaluationType {
        if (this.debouncedPassword.length === 0) {
            return EvaluationForEmptyPassword;
        }
        return zxcvbn(this.debouncedPassword);
    }

    public get score(): number {
        this.$emit("score", this.passwordEvaluation.score);
        return this.passwordEvaluation.score;
    }

    get passwordBarStyle(): {width: string} {
        return {
            width: Math.max(this.passwordEvaluation.score * 25, 10) + "%"
        };
    }

    get passwordWarning(): string {
        return this.passwordEvaluation.feedback.warning;
    }

    get passwordSuggestions(): string[] {
        return this.passwordEvaluation.feedback.suggestions || "Good password.";
    }

    mounted(): void {
        const translations = navigator.language.startsWith("de") ? zxcvbnDePackage.translations : zxcvbnEnPackage.translations;
        ZxcvbnOptions.setOptions({
            translations,
            dictionary: {
                ...zxcvbnCommonPackage.dictionary,
                ...zxcvbnEnPackage.dictionary,
                ...zxcvbnDePackage.dictionary
            }
        });

        this.passwordChanged(this.value);
    }

    passwordChanged(newPassword: string): void {
        this.$emit("input", newPassword);
        this.clearPasswordDebounce();
        this.setPasswordDebounce(newPassword);
    }

    private clearPasswordDebounce(): void {
        if (this.passwordDebounceTimeout) {
            clearTimeout(this.passwordDebounceTimeout);
        }
    }

    private setPasswordDebounce(newPassword: string): void {
        this.passwordDebounceTimeout = setTimeout(() => {
            this.debouncedPassword = newPassword;
        }, 300);
    }
}
</script>
