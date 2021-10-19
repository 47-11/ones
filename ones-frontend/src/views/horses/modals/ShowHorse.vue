<template>
    <modal @cancel="cancel" name="show-selected-horse" v-if="horse">
        <card>
            <template v-slot:header>
                <div class="flex w-full justify-center">
                    <h1 class="text-xl">
                        {{ horse.name }}
                    </h1>

                    <v-button class="ml-auto" color="secondary">
                        {{ $t('modal.edit') }}
                    </v-button>
                </div>
            </template>

            <div class="w-full">
                <dl v-for="prop in horseProperties" :key="prop" class="w-full flex">
                    <div
                        class="w-full bg-white dark:bg-gray-700 border-b dark:border-gray-800 px-4 py-5 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-6">
                        <dt class="text-sm font-medium text-gray-500 dark:text-gray-300">
                            {{ $t(`data.horse.${prop}`) }}
                        </dt>
                        <dd class="mt-1 text-sm sm:mt-0 sm:col-span-2 text-gray-800">
                            <div v-if="prop === 'gender'">
                                <font-awesome-icon :icon="'mars'"
                                                   v-if="horse.gender === 'MALE'"></font-awesome-icon>
                                <font-awesome-icon :icon="'venus'"
                                                   v-if="horse.gender === 'FEMALE'"></font-awesome-icon>
                            </div>
                            <span v-else>{{ horse[prop] }}</span>
                        </dd>
                    </div>
                </dl>
            </div>

            <template v-slot:footer>
                <v-button @click.native="cancel" class="ml-auto">
                    {{ $t('modal.close') }}
                </v-button>
            </template>
        </card>
    </modal>
</template>

<script lang="ts">
import { Component, Vue } from "vue-property-decorator";
import PageHeader from "@/components/PageHeader.vue";
import Card from "@/components/Card.vue";
import VButton from "@/components/VButton.vue";
import VLink from "@/components/VLink.vue";
import VInput from "@/components/forms/VInput.vue";
import VLabel from "@/components/forms/VLabel.vue";
import VSelect from "@/components/forms/VSelect.vue";
import VTable from "@/components/table/VTable.vue";
import VTd from "@/components/table/VTd.vue";
import VTh from "@/components/table/VTh.vue";
import BadgeCircle from "@/components/BadgeCircle.vue";
import AppLayout from "@/layouts/AppLayout.vue";
import Modal from "@/layouts/Modal.vue";
import { HorseDto } from "@/openapi/generated";

@Component({
    components: {
        PageHeader,
        AppLayout,
        Card,
        BadgeCircle,
        VButton,
        VLink,
        VInput,
        VLabel,
        VSelect,
        VTable,
        VTd,
        VTh,
        Modal
    }
})
export default class ShowHorse extends Vue {
    horse: HorseDto | null = null;

    mounted(): void {
        console.log("Modal is there but horse?", this.horse);
    }

    get horseProperties(): Array<keyof HorseDto> {
        return [
            "passportNumber",
            "chipNumber",
            "yearOfBirth",

            "gender",
            "breed",
            "color",
            "size",
            "stableAddress",
            "owner"
        ];
    }

    public cancel(): void {
        this.$vfm.hide("show-selected-horse");
    }
}
</script>
