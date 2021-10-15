<template>
    <app-layout>
        <div class="max-w-6xl m-auto py-12">
            <div class="flex items-start">
                <page-header>{{ $t("horses.title") }}</page-header>
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
                        <v-td>{{horse.name}}</v-td>
                        <v-td>
                            <font-awesome-icon :icon="'mars'" v-if="horse.gender === 'MALE'"></font-awesome-icon>
                            <font-awesome-icon :icon="'venus'" v-if="horse.gender === 'FEMALE'"></font-awesome-icon>
                        </v-td>
                        <v-td>{{horse.breed}}</v-td>
                        <v-td>{{horse.color}}</v-td>
                        <v-td>{{horse.yearOfBirth}}</v-td>
                        <v-td>{{horse.size}} {{ $t("data.horse.sizeUnit") }}</v-td>
                    </tr>
                </tbody>
            </v-table>
        </div>
        <modal v-model="showModal" @cancel="cancel" :closeText="$i18n.t('horses.modal.close')" v-if="selectedHorse">
            <template v-slot:title>{{ selectedHorse.name }}</template>
            <div>
                <div v-for="prop in horseProperties" :key="prop" class="flex">
                    <span>{{$t('data.horse.' + prop)}}: </span>

                    <span class="flex-grow text-right ml-8">
                        <span v-if="prop === 'gender'">
                            <font-awesome-icon :icon="'mars'" v-if="selectedHorse.gender === 'MALE'"></font-awesome-icon>
                            <font-awesome-icon :icon="'venus'" v-if="selectedHorse.gender === 'FEMALE'"></font-awesome-icon>
                        </span>
                        <span v-else>{{ selectedHorse[prop] }}</span>
                    </span>
                </div>
            </div>
        </modal>
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
    showModal = false;
    selectedHorse: HorseDto | null = null;

    mounted(): void {
        vxm.horses.fetch();
    }

    get horseProperties(): Array<keyof HorseDto> {
        return [
            "name",
            "passportNumber",
            "chipNumber",
            "gender",
            "breed",
            "color",
            "yearOfBirth",
            "size",
            "stableAddress",
            "owner"
        ];
    }

    public details(horse: HorseDto): void {
        this.selectedHorse = horse;
        this.showModal = true;
    }

    public cancel(close: () => void): void {
        close();
    }
}
</script>
