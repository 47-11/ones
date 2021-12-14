<template>
    <div class="flex w-full items-center">
        <h1 class="text-xl">
            <span v-if="isAdd">{{ $t('horses.modals.add.title') }}</span>
            <span v-if="isUpdate">{{ $t('horses.modals.edit.title') }}</span>
        </h1>
    </div>
</template>
<script lang="ts">
import { FullHorseDto } from "@/openapi/generated";
import { Component, Prop, Vue } from "vue-property-decorator";

@Component({
    components: { }
})
export default class VTitle extends Vue {
    @Prop()
    public horse?: FullHorseDto;

    public isUpdate(): boolean {
        return !!(this.horse && this.horse.uuid);
    }

    public isAdd(): boolean {
        return !this.isUpdate;
    }
}
</script>
