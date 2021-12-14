<template>
    <div class="flex w-full items-center">
        <h1 class="text-xl">
            <span v-if="isUpdate">{{ $t('horses.modals.edit.title') }}</span>
            <span v-else>{{ $t('horses.modals.add.title') }}</span>
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
        return !!this.horse?.uuid;
    }
}
</script>
