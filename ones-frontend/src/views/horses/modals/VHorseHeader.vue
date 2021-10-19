<template>
    <div class="flex w-full justify-center">
        <h1 class="text-xl">
            {{ text }}
        </h1>

        <v-button class="ml-auto" color="secondary">
            <font-awesome-icon class="my-0.5" :icon="'pencil-alt'"></font-awesome-icon>
            &nbsp;
            {{ $t('modal.edit') }}
        </v-button>
    </div>
</template>
<script lang="ts">
import { Component, Prop, Vue } from "vue-property-decorator";
import VButton from "@/components/VButton.vue";

@Component({
    components: {
        VButton
    }
})
export default class VTitle extends Vue {
    @Prop({
        default: ""
    })
    public text!: string;
}
</script>
