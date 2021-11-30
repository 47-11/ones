<template>
    <div class="flex w-full items-center">
        <h1 class="text-xl">
            {{ text }}
        </h1>

        <v-button class="ml-auto" color="secondary" @click.native="edit">
            <font-awesome-icon class="my-0.5" :icon="'pencil-alt'"></font-awesome-icon>
            &nbsp;
            {{ $t('modal.edit') }}
        </v-button>
    </div>
</template>
<script lang="ts">
import { Component, Prop, Vue } from "vue-property-decorator";
import VButton from "@/components/VButton.vue";
import VAddHorseHeader from "@/views/horses/modals/addHorse/VAddHorseHeader.vue";
import VAddHorseContent from "@/views/horses/modals/addHorse/VAddHorseContent.vue";
import VAddHorseFooter from "@/views/horses/modals/addHorse/VAddHorseFooter.vue";
import { HorseDto } from "@/openapi/generated";

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

    @Prop()
    public horse!: HorseDto;

    public edit(): void {
        let listener: null | (() => void) = null;
        const onConfirm = () => listener && listener();
        this.$vfm.show({
            bind: {
                name: "add-horse"
            },
            component: "Modal",
            slots: {
                header: {
                    component: VAddHorseHeader
                },
                footer: {
                    component: VAddHorseFooter,
                    bind: {
                        confirm: onConfirm
                    }
                },
                default: {
                    component: VAddHorseContent,
                    bind: {
                        addConfirmListener: (l: () => void) => {
                            listener = l;
                        },
                        horse: this.horse
                    }
                }
            },
            on: {
                cancel(close: () => void) {
                    close();
                }
            }
        });
    }
}
</script>
