<template>
    <v-button @click.native="close" class="ml-auto">
        {{ $t('modal.close') }}
    </v-button>
</template>
<script lang="ts">
import { Component, Vue } from "vue-property-decorator";
import VButton from "@/components/VButton.vue";

@Component({
    components: {
        VButton
    }
})
export default class VHorseFooter extends Vue {
    close(): void {
        this.$emit("close");
    }
}
</script>
