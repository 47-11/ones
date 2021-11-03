<template v-slot="{ close }">
    <div class="flex items-end w-full">
        <div class="flex-grow"></div>
        <v-button @click.native="close" class="ml-auto" color="secondary">
            {{ $t('modal.abort') }}
        </v-button>
        <v-button @click.native="confirm" class="ml-2">
            {{ $t('horses.modals.add.confirm') }}
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
export default class VHorseFooter extends Vue {
    @Prop()
    confirm!: () => void;

    close(): void {
        this.$vfm.hide("add-horse");
    }
}
</script>
