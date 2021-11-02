<template>
    <div class="w-full p-8">
        <div class="grid grid-cols-12 gap-4 mb-5">
            <div class="col-span-12">
                <h1 class="text-xl bold">{{ $t("horses.modals.add.masterData") }}</h1>
            </div>
            <div class="col-span-12 sm:col-span-6">
                <v-label>{{ $t("data.horse.name") }}</v-label>
                <v-input type="text" class="w-full" @input="update('name', $event)" :disabled="inputsDisabled"/>
            </div>

            <div class="col-span-6 sm:invisible"></div>

            <div class="col-span-12 sm:col-span-6">
                <v-label>{{ $t("data.horse.passportNumber") }}</v-label>
                <v-input type="text" class="w-full" @input="update('equinePassportNo', $event)" :disabled="inputsDisabled"/>
            </div>

            <div class="col-span-12 sm:col-span-6">
                <v-label>{{ $t("data.horse.chipNumber") }}</v-label>
                <v-input type="text" class="w-full" @input="update('chipNo', $event)" :disabled="inputsDisabled"/>
            </div>

            <div class="col-span-12 sm:col-span-6">
                <v-label>{{ $t("data.horse.gender") }}</v-label>
                <v-input type="text" class="w-full" @input="update('gender', $event)" :disabled="inputsDisabled"/>
            </div>

            <div class="col-span-12 sm:col-span-6">
                <v-label>{{ $t("data.horse.breed") }}</v-label>
                <v-input type="text" class="w-full" @input="update('breed', $event)" :disabled="inputsDisabled"/>
            </div>

            <div class="col-span-12 sm:col-span-6">
                <v-label>{{ $t("data.horse.color") }}</v-label>
                <v-input type="text" class="w-full" @input="update('color', $event)" :disabled="inputsDisabled"/>
            </div>

            <div class="col-span-12 sm:col-span-6">
                <v-label>{{ $t("data.horse.yearOfBirth") }}</v-label>
                <v-input type="text" class="w-full" @input="update('yearOfBirth', $event)" :disabled="inputsDisabled"/>
            </div>

            <div class="col-span-12 sm:col-span-6">
                <v-label>{{ $t("data.horse.size") }}</v-label>
                <v-input type="number" class="w-full" @input="update('size', $event)" :disabled="inputsDisabled"/>
            </div>

            <div class="col-span-12 mt-8">
                <h1 class="text-xl bold">{{ $t("horses.modals.add.stable") }}</h1>
            </div>
            <div class="col-span-12 sm:col-span-6">
                <v-label>{{ $t("data.address.street") }}</v-label>
                <v-input type="text" class="w-full" @input="update('stableStreet', $event)" :disabled="inputsDisabled"/>
            </div>

            <div class="col-span-12 sm:col-span-6">
                <v-label>{{ $t("data.address.houseNumber") }}</v-label>
                <v-input type="text" class="w-full" @input="update('stableHouseNumber', $event)" :disabled="inputsDisabled"/>
            </div>

            <div class="col-span-12 sm:col-span-6">
                <v-label>{{ $t("data.address.zipCode") }}</v-label>
                <v-input type="text" class="w-full" @input="update('stableZipCode', $event)" :disabled="inputsDisabled"/>
            </div>

            <div class="col-span-12 sm:col-span-6">
                <v-label>{{ $t("data.address.city") }}</v-label>
                <v-input type="text" class="w-full" @input="update('stableCity', $event)" :disabled="inputsDisabled"/>
            </div>

            <div class="col-span-6">
                <v-label>{{ $t("data.address.country") }}</v-label>
                <v-input type="text" class="w-full" @input="update('stableCountry', $event)" :disabled="inputsDisabled"/>
            </div>

            <div class="col-span-12 mt-8">
                <h1 class="text-xl bold">{{ $t("horses.modals.add.owner") }}</h1>
            </div>
            <div class="col-span-12 sm:col-span-6">
                <v-label>{{ $t("data.user.firstName") }}</v-label>
                <v-input type="text" class="w-full" @input="update('ownerFirstName', $event)" :disabled="inputsDisabled"/>
            </div>

            <div class="col-span-12 sm:col-span-6">
                <v-label>{{ $t("data.user.lastName") }}</v-label>
                <v-input type="text" class="w-full" @input="update('ownerLastName', $event)" :disabled="inputsDisabled"/>
            </div>

            <div class="col-span-12 sm:col-span-6">
                <v-label>{{ $t("data.user.phoneNumber") }}</v-label>
                <v-input type="text" class="w-full" @input="update('ownerPhoneNumber', $event)" :disabled="inputsDisabled"/>
            </div>

            <div class="col-span-12 sm:col-span-6">
                <v-label>{{ $t("data.user.phoneNumberMobile") }}</v-label>
                <v-input type="text" class="w-full" @input="update('ownerMobileNumber', $event)" :disabled="inputsDisabled"/>
            </div>

            <div class="col-span-12 sm:col-span-6">
                <v-label>{{ $t("data.address.street") }}</v-label>
                <v-input type="text" class="w-full" @input="update('ownerStreet', $event)" :disabled="inputsDisabled"/>
            </div>

            <div class="col-span-12 sm:col-span-6">
                <v-label>{{ $t("data.address.houseNumber") }}</v-label>
                <v-input type="text" class="w-full" @input="update('ownerHouseNumber', $event)" :disabled="inputsDisabled"/>
            </div>

            <div class="col-span-12 sm:col-span-6">
                <v-label>{{ $t("data.address.zipCode") }}</v-label>
                <v-input type="text" class="w-full" @input="update('ownerZipCode', $event)" :disabled="inputsDisabled"/>
            </div>

            <div class="col-span-12 sm:col-span-6">
                <v-label>{{ $t("data.address.city") }}</v-label>
                <v-input type="text" class="w-full" @input="update('ownerCity', $event)" :disabled="inputsDisabled"/>
            </div>

            <div class="col-span-6">
                <v-label>{{ $t("data.address.country") }}</v-label>
                <v-input type="text" class="w-full" @input="update('ownerCountry', $event)" :disabled="inputsDisabled"/>
            </div>
        </div>
    </div>
</template>

<script lang="ts">
import { Component, Vue } from "vue-property-decorator";
import VInput from "@/components/forms/VInput.vue";

@Component({
    components: {
        VInput
    }
})
export default class VAddHorseContent extends Vue {
    inputsDisabled = false;

    name = "";
    equinePassportNo = "";
    chipNo = "";
    gender = "";
    breed = "";
    color = "";
    yearOfBirth = "";
    size = 0;

    stableStreet = "";
    stableHouseNumber = "";
    stableZipCode = "";
    stableCity = "";
    stableCountry = "";

    ownerFirstName = "";
    ownerLastName = "";
    ownerPhoneNumber = "";
    ownerMobileNumber = "";
    ownerStreet = "";
    ownerHouseNumber = "";
    ownerZipCode = "";
    ownerCity = "";
    ownerCountry = "";

    public update(property: keyof this, value: string): void {
        // eslint-disable-next-line @typescript-eslint/no-explicit-any
        this[property] = value as any;
    }
}
</script>
