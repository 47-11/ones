<template v-slot="{ close }">
    <div class="flex items-end w-full">
        <div class="flex-grow"></div>
        <v-button @click.native="close" class="ml-auto" color="secondary">
            {{ $t('modal.abort') }}
        </v-button>
        <v-button @click.native="confirm" class="ml-2">
            <span v-if="isAdd">{{ $t('horses.modals.add.confirm') }}</span>
            <span v-if="isUpdate">{{ $t('horses.modals.edit.confirm') }}</span>
        </v-button>
    </div>
</template>
<script lang="ts">
import { Component, Prop, Vue } from "vue-property-decorator";
import VButton from "@/components/VButton.vue";
import { FullHorseDto } from "@/openapi/generated";

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

    @Prop()
    public horse?: FullHorseDto;

    public isUpdate(): boolean {
        return !!(this.horse && this.horse.uuid);
    }

    public isApp(): boolean {
        return !this.isUpdate;
    }
}
</script>
