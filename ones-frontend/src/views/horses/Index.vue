<template>
    <app-layout>
        <div class="max-w-6xl m-auto py-12">
            <div class="flex items-start">
                <page-header>{{ $t("horses.title") }}</page-header>

                <v-button type="button" class="ml-auto mr-6 lg:mr-0" @click.native="addHorse">
                    <span>{{ $t("horses.add") }}</span>
                </v-button>
            </div>

            <no-results v-if="horses.list.length === 0">
                {{ $t("horses.noHorses")}}
            </no-results>

            <v-table class="mt-8" v-else>
                <v-thead class="bg-gray-50">
                <v-tr>
                    <v-th>{{ $t('data.horse.name') }}</v-th>
                    <v-th>{{ $t('data.horse.gender') }}</v-th>
                    <v-th>{{ $t('data.horse.breed') }}</v-th>
                    <v-th>{{ $t('data.horse.color') }}</v-th>
                    <v-th>{{ $t('data.horse.yearOfBirth') }}</v-th>
                    <v-th>{{ $t('data.horse.size') }}</v-th>
                </v-tr>
                </v-thead>
                <v-tbody class="bg-white divide-y divide-gray-200">
                <v-tr v-for="horse in horses.list" :key="horse.uuid" v-on:click="details(horse)" class="cursor-pointer">
                    <v-td>{{ horse.name }}</v-td>
                    <v-td>{{ $t("data.horse.genderOptions." + horse.gender) }}</v-td>
                    <v-td>{{ horse.breed }}</v-td>
                    <v-td>{{ horse.color }}</v-td>
                    <v-td>{{ horse.yearOfBirth }}</v-td>
                    <v-td>{{ horse.size }} {{ $t("data.horse.sizeUnit") }}</v-td>
                </v-tr>
                </v-tbody>
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
import BadgeCircle from "@/components/BadgeCircle.vue";
import AppLayout from "@/layouts/AppLayout.vue";
import Modal from "@/layouts/Modal.vue";
import { FullHorseDto } from "@/openapi/generated";
import VHorseHeader from "@/views/horses/modals/VHorseHeader.vue";
import VHorseContent from "@/views/horses/modals/VHorseContent.vue";
import VHorseFooter from "@/views/horses/modals/VHorseFooter.vue";
import VAddHorseHeader from "@/views/horses/modals/addHorse/VAddHorseHeader.vue";
import VAddHorseContent from "@/views/horses/modals/addHorse/VAddHorseContent.vue";
import VAddHorseFooter from "@/views/horses/modals/addHorse/VAddHorseFooter.vue";
import { getVxm } from "@/store";

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
        Modal
    }
})
export default class Profile extends Vue {
    horses = getVxm().horses;

    mounted(): void {
        getVxm().horses.fetch();
    }

    public details(horse: FullHorseDto): void {
        this.$vfm.show({
            bind: {
                name: "horse"
            },
            component: "Modal",
            slots: {
                header: {
                    component: VHorseHeader,
                    bind: {
                        text: horse.name,
                        horse: horse
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
                        }
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

    public cancel(): void {
        this.$vfm.hide("show-selected-horse");
    }
}
</script>
