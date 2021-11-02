<template>
    <div class="w-full p-8">
        <error-message :error="error"/>
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
                <v-select :value="gender" type="text" class="w-full" @input="update('gender', $event)" :disabled="inputsDisabled">
                    <option v-for="(gender, index) in genders" :key="index" :value="gender">
                        {{ $t("data.horse.genderOptions." + gender) }}
                    </option>
                </v-select>
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
                <v-input :value="yearOfBirth" type="number" class="w-full" @input="update('yearOfBirth', $event)" :disabled="inputsDisabled"/>
            </div>

            <div class="col-span-12 sm:col-span-6">
                <v-label>{{ $t("data.horse.size") }}</v-label>
                <v-input :value="size" type="number" class="w-full" @input="update('size', $event)" :disabled="inputsDisabled"/>
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
                <v-input type="number" class="w-full" @input="update('stableZipCode', $event)" :disabled="inputsDisabled"/>
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
                <v-input type="tel" class="w-full" @input="update('ownerPhoneNumber', $event)" :disabled="inputsDisabled"/>
            </div>

            <div class="col-span-12 sm:col-span-6">
                <v-label>{{ $t("data.user.phoneNumberMobile") }}</v-label>
                <v-input type="tel" class="w-full" @input="update('ownerMobileNumber', $event)" :disabled="inputsDisabled"/>
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

        <error-message :error="error"/>
    </div>
</template>

<script lang="ts">
import { Component, Prop, Vue } from "vue-property-decorator";
import VInput from "@/components/forms/VInput.vue";
import VSelect from "@/components/forms/VSelect.vue";
import VLabel from "@/components/forms/VLabel.vue";
import { vxm } from "@/store";
import { HorseDtoGenderEnum } from "@/openapi/generated";

@Component({
    components: {
        VInput,
        VSelect,
        VLabel
    }
})
export default class VAddHorseContent extends Vue {
    @Prop()
    addConfirmListener!: (l: () => void) => void;

    mounted(): void {
        this.addConfirmListener(this.setData.bind(this));
    }

    inputsDisabled = false;
    error: Error | null = null;

    name = "";
    equinePassportNo = "";
    chipNo = "";
    gender: HorseDtoGenderEnum = HorseDtoGenderEnum.Female;
    breed = "";
    color = "";
    yearOfBirth: number | null = null;
    size: number | null = null;

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

    genders = HorseDtoGenderEnum;

    public update(property: keyof this, value: string): void {
        // eslint-disable-next-line @typescript-eslint/no-explicit-any
        this[property] = value as any;
    }

    private async setData(): Promise<void> {
        try {
            this.assertRequiredFilled();
            this.assertAllInRange();
            await vxm.horses.add({
                passportNumber: this.equinePassportNo,
                chipNumber: this.chipNo,
                name: this.name,
                gender: this.gender,
                breed: this.breed,
                color: this.color,
                size: this.size || 0,
                yearOfBirth: this.yearOfBirth || 0,
                stableAddress: {
                    street: this.stableStreet,
                    houseNumber: this.stableHouseNumber,
                    zipCode: this.stableZipCode,
                    city: this.stableCity,
                    country: this.stableCountry
                },
                owner: {
                    firstName: this.ownerFirstName,
                    lastName: this.ownerLastName,
                    phoneNumber: this.ownerPhoneNumber,
                    phoneNumberMobile: this.ownerMobileNumber,
                    address: {
                        street: this.ownerStreet,
                        houseNumber: this.ownerHouseNumber,
                        zipCode: this.ownerZipCode,
                        city: this.ownerCity,
                        country: this.ownerCountry
                    }
                }
            });
            this.$vfm.hide("add-horse");
        } catch (error) {
            this.error = error as Error;
        }
    }

    assertRequiredFilled(): void {
        for (const prop of this.requiredProps) {
            const value = this[prop];
            if (!value || (typeof value === "string" && value.length === 0)) {
                throw new Error(prop + this.$t("horses.modals.add.errors.notFilled").toString());
            }
        }
    }

    get requiredProps(): Array<keyof this> {
        return [
            "name",
            "equinePassportNo",
            "chipNo",
            "gender",
            "breed",
            "color",
            "yearOfBirth",
            "size",
            "stableStreet",
            "stableHouseNumber",
            "stableZipCode",
            "stableCity",
            "stableCountry",
            "ownerFirstName",
            "ownerLastName",
            "ownerPhoneNumber",
            "ownerMobileNumber",
            "ownerStreet",
            "ownerHouseNumber",
            "ownerZipCode",
            "ownerCity",
            "ownerCountry"
        ];
    }

    assertAllInRange(): void {
        const currentYear = new Date().getFullYear();
        if (this.yearOfBirth && (this.yearOfBirth < (currentYear - 60) || this.yearOfBirth > currentYear)) {
            throw new Error(this.$t("horses.modals.add.errors.yearInvalid").toString());
        }
        if (this.size && (this.size < 40 || this.size > 250)) {
            throw new Error(this.$t("horses.modals.add.errors.sizeOutOfRange").toString());
        }
    }
}
</script>
