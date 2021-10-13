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
                    <v-th>{{ $t('data.horse.stockMeasure') }}</v-th>
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
import { HorseDto } from "@/openapi/generated/api";

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
        VTh
    }
})
export default class Profile extends Vue {
    horses = vxm.horses;

    mounted(): void {
        vxm.horses.fetch();
    }

    public details(horse: HorseDto): void {
        alert(`${horse.name} clicked`);
    }
}
</script>
