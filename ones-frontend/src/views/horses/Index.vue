<template>
    <app-layout>
        <div class="max-w-6xl m-auto py-12">
            <div class="flex items-start">
                <page-header>{{ $t("horses.title") }}</page-header>

                <v-button type="button" class="ml-auto mr-6 lg:mr-0" @click.native="addHorse">
                    <span>{{ $t("horses.add") }}</span>
                </v-button>
            </div>

            <v-table class="mt-8">
                <thead class="bg-gray-50">
                <tr>
                    <v-th>{{ $t('data.horse.name') }}</v-th>
                    <v-th>{{ $t('data.horse.gender') }}</v-th>
                    <v-th>{{ $t('data.horse.breed') }}</v-th>
                    <v-th>{{ $t('data.horse.color') }}</v-th>
                    <v-th>{{ $t('data.horse.yearOfBirth') }}</v-th>
                    <v-th>{{ $t('data.horse.size') }}</v-th>
                </tr>
                </thead>
                <tbody class="bg-white divide-y divide-gray-200">
                <tr v-for="horse in horses.list" :key="horse.uuid" v-on:click="details(horse)" class="cursor-pointer">
                    <v-td>{{ horse.name }}</v-td>
                    <v-td>
                        <font-awesome-icon :icon="'mars'" v-if="horse.gender === 'MALE'"></font-awesome-icon>
                        <font-awesome-icon :icon="'venus'" v-if="horse.gender === 'FEMALE'"></font-awesome-icon>
                    </v-td>
                    <v-td>{{ horse.breed }}</v-td>
                    <v-td>{{ horse.color }}</v-td>
                    <v-td>{{ horse.yearOfBirth }}</v-td>
                    <v-td>{{ horse.size }} {{ $t("data.horse.sizeUnit") }}</v-td>
                </tr>
                </tbody>
            </v-table>
        </div>
    </app-layout>
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
import { vxm } from "@/store";
import Modal from "@/layouts/Modal.vue";
import { HorseDto } from "@/openapi/generated";
import VHorseHeader from "@/views/horses/modals/VHorseHeader.vue";
import VHorseContent from "@/views/horses/modals/VHorseContent.vue";
import VHorseFooter from "@/views/horses/modals/VHorseFooter.vue";
import VAddHorseHeader from "@/views/horses/modals/addHorse/VAddHorseHeader.vue";
import VAddHorseContent from "@/views/horses/modals/addHorse/VAddHorseContent.vue";
import VAddHorseFooter from "@/views/horses/modals/addHorse/VAddHorseFooter.vue";

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
export default class Profile extends Vue {
    horses = vxm.horses;

    mounted(): void {
        vxm.horses.fetch();
    }

    public details(horse: HorseDto): void {
        this.$vfm.show({
            bind: {
                name: "horse"
            },
            component: "Modal",
            slots: {
                header: {
                    component: VHorseHeader,
                    bind: {
                        text: horse.name
                    }
                },
                footer: {
                    component: VHorseFooter
                },
                default: {
                    component: VHorseContent,
                    bind: {
                        horse
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

    public addHorse(): void {
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
                    component: VAddHorseFooter
                },
                default: {
                    component: VAddHorseContent
                }
            },
            on: {
                cancel(close: () => void) {
                    close();
                }
            }
        });
    }

    public cancel(): void {
        this.$vfm.hide("show-selected-horse");
    }
}
</script>
