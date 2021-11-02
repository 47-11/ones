<template>
    <div class="w-full p-8">
        <error-message :error="error"/>
        <div class="grid grid-cols-12 gap-4 mb-5">
            <div class="col-span-12">
                <h1 class="text-xl bold">{{ $t("horses.modals.add.masterData") }}</h1>
            </div>
            <div class="col-span-12 sm:col-span-6">
                <v-label>{{ $t("data.horse.name") }}</v-label>
                <v-input type="text" class="w-full" @input="updateHorse('name', $event)" :disabled="inputsDisabled"/>
            </div>

            <div class="col-span-6 sm:invisible"></div>

            <div class="col-span-12 sm:col-span-6">
                <v-label>{{ $t("data.horse.passportNumber") }}</v-label>
                <v-input type="text" class="w-full" @input="updateHorse('passportNumber', $event)" :disabled="inputsDisabled"/>
            </div>

            <div class="col-span-12 sm:col-span-6">
                <v-label>{{ $t("data.horse.chipNumber") }}</v-label>
                <v-input type="text" class="w-full" @input="updateHorse('chipNumber', $event)" :disabled="inputsDisabled"/>
            </div>

            <div class="col-span-12 sm:col-span-6">
                <v-label>{{ $t("data.horse.gender") }}</v-label>
                <v-select :value="horse.gender" type="text" class="w-full" @input="updateHorse('gender', $event)" :disabled="inputsDisabled">
                    <option v-for="(gender, index) in genders" :key="index" :value="gender">
                        {{ $t("data.horse.genderOptions." + gender) }}
                    </option>
                </v-select>
            </div>

            <div class="col-span-12 sm:col-span-6">
                <v-label>{{ $t("data.horse.breed") }}</v-label>
                <v-input type="text" class="w-full" @input="updateHorse('breed', $event)" :disabled="inputsDisabled"/>
            </div>

            <div class="col-span-12 sm:col-span-6">
                <v-label>{{ $t("data.horse.color") }}</v-label>
                <v-input type="text" class="w-full" @input="updateHorse('color', $event)" :disabled="inputsDisabled"/>
            </div>

            <div class="col-span-12 sm:col-span-6">
                <v-label>{{ $t("data.horse.yearOfBirth") }}</v-label>
                <v-input type="number" class="w-full" @input="updateHorse('yearOfBirth', $event)" :disabled="inputsDisabled" :placeholder="$t('horses.modals.add.yearPlaceholder')"/>
            </div>

            <div class="col-span-12 sm:col-span-6">
                <v-label>{{ $t("data.horse.size") }}</v-label>
                <v-input type="number" class="w-full" @input="updateHorse('size', $event)" :disabled="inputsDisabled" :placeholder="$t('horses.modals.add.sizePlaceholder')"/>
            </div>

            <div class="col-span-12 sm:col-span-6">
                <v-label>{{ $t("data.horse.feiNo") }}</v-label>
                <v-input type="text" class="w-full" @input="updateHorse('feiNumber', $event)" :disabled="inputsDisabled"/>
            </div>

            <div class="col-span-12 mt-8">
                <h1 class="text-xl bold">{{ $t("horses.modals.add.stable") }}</h1>
            </div>
            <div class="col-span-12 sm:col-span-6">
                <v-label>{{ $t("data.address.street") }}</v-label>
                <v-input type="text" class="w-full" @input="updateStable('street', $event)" :disabled="inputsDisabled"/>
            </div>

            <div class="col-span-12 sm:col-span-6">
                <v-label>{{ $t("data.address.houseNumber") }}</v-label>
                <v-input type="text" class="w-full" @input="updateStable('houseNumber', $event)" :disabled="inputsDisabled"/>
            </div>

            <div class="col-span-12 sm:col-span-6">
                <v-label>{{ $t("data.address.zipCode") }}</v-label>
                <v-input type="number" class="w-full" @input="updateStable('zipCode', $event)" :disabled="inputsDisabled"/>
            </div>

            <div class="col-span-12 sm:col-span-6">
                <v-label>{{ $t("data.address.city") }}</v-label>
                <v-input type="text" class="w-full" @input="updateStable('city', $event)" :disabled="inputsDisabled"/>
            </div>

            <div class="col-span-6">
                <v-label>{{ $t("data.address.country") }}</v-label>
                <v-input type="text" class="w-full" @input="updateStable('country', $event)" :disabled="inputsDisabled"/>
            </div>

            <div class="col-span-12 mt-8">
                <h1 class="text-xl bold">{{ $t("horses.modals.add.owner") }}</h1>
            </div>
            <div class="col-span-12 sm:col-span-6">
                <v-label>{{ $t("data.user.firstName") }}</v-label>
                <v-input type="text" class="w-full" @input="updateOwner('firstName', $event)" :disabled="inputsDisabled"/>
            </div>

            <div class="col-span-12 sm:col-span-6">
                <v-label>{{ $t("data.user.lastName") }}</v-label>
                <v-input type="text" class="w-full" @input="updateOwner('lastName', $event)" :disabled="inputsDisabled"/>
            </div>

            <div class="col-span-12 sm:col-span-6">
                <v-label>{{ $t("data.user.phoneNumber") }}</v-label>
                <v-input type="tel" class="w-full" @input="updateOwner('phoneNumber', $event)" :disabled="inputsDisabled"/>
            </div>

            <div class="col-span-12 sm:col-span-6">
                <v-label>{{ $t("data.user.phoneNumberMobile") }}</v-label>
                <v-input type="tel" class="w-full" @input="updateOwner('phoneNumberMobile', $event)" :disabled="inputsDisabled"/>
            </div>

            <div class="col-span-12 sm:col-span-6">
                <v-label>{{ $t("data.address.street") }}</v-label>
                <v-input type="text" class="w-full" @input="updateOwnerAddress('street', $event)" :disabled="inputsDisabled"/>
            </div>

            <div class="col-span-12 sm:col-span-6">
                <v-label>{{ $t("data.address.houseNumber") }}</v-label>
                <v-input type="text" class="w-full" @input="updateOwnerAddress('houseNumber', $event)" :disabled="inputsDisabled"/>
            </div>

            <div class="col-span-12 sm:col-span-6">
                <v-label>{{ $t("data.address.zipCode") }}</v-label>
                <v-input type="text" class="w-full" @input="updateOwnerAddress('zipCode', $event)" :disabled="inputsDisabled"/>
            </div>

            <div class="col-span-12 sm:col-span-6">
                <v-label>{{ $t("data.address.city") }}</v-label>
                <v-input type="text" class="w-full" @input="updateOwnerAddress('city', $event)" :disabled="inputsDisabled"/>
            </div>

            <div class="col-span-6">
                <v-label>{{ $t("data.address.country") }}</v-label>
                <v-input type="text" class="w-full" @input="updateOwnerAddress('country', $event)" :disabled="inputsDisabled"/>
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
import { AddressDto, HorseDto, HorseDtoGenderEnum, PersonDto } from "@/openapi/generated";

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

    horse: HorseDto = {
        gender: HorseDtoGenderEnum.Female,
        stableAddress: {},
        owner: {
            address: { }
        }
    };

    genders = HorseDtoGenderEnum;

    public updateHorse(property: keyof HorseDto, value: string): void {
        // eslint-disable-next-line @typescript-eslint/no-explicit-any
        this.horse[property] = value as any;
    }

    public updateStable(property: keyof AddressDto, value: string): void {
        // eslint-disable-next-line @typescript-eslint/no-non-null-assertion
        this.horse.stableAddress![property] = value;
    }

    public updateOwner(property: keyof PersonDto, value: string): void{
        // eslint-disable-next-line @typescript-eslint/no-non-null-assertion
        this.horse.owner![property] = value;
    }

    public updateOwnerAddress(property: keyof AddressDto, value: string): void {
        // eslint-disable-next-line @typescript-eslint/no-non-null-assertion
        this.horse.owner!.address![property] = value;
    }

    private async setData(): Promise<void> {
        try {
            this.assertRequiredFilled();
            this.assertAllInRange();

            await vxm.horses.add(this.horse);
            this.$vfm.hide("add-horse");
        } catch (error) {
            this.error = error as Error;
        }
    }

    assertRequiredFilled(): void {
        // eslint-disable-next-line @typescript-eslint/no-explicit-any
        const checkValue = (value: any) => {
            return !value || (typeof value === "string" && value.length === 0);
        };
        const notFilled = (propNameKey: string) => {
            return new Error(this.$t(propNameKey) + this.$t("horses.modals.add.errors.notFilled").toString());
        };

        for (const prop of this.requiredProps) {
            if (checkValue(this.horse[prop])) {
                throw notFilled("data.horse." + prop);
            }
        }

        for (const prop of this.requiredStableProps) {
            // eslint-disable-next-line @typescript-eslint/no-non-null-assertion
            if (checkValue(this.horse.stableAddress![prop])) {
                throw notFilled("data.address." + prop);
            }
        }

        for (const prop of this.requiredOwnerProps) {
            // eslint-disable-next-line @typescript-eslint/no-non-null-assertion
            if (checkValue(this.horse.owner![prop])) {
                throw notFilled("data.user." + prop);
            }
        }

        for (const prop of this.requiredOwnerAddressProps) {
            // eslint-disable-next-line @typescript-eslint/no-non-null-assertion
            if (checkValue(this.horse.owner!.address![prop])) {
                throw notFilled("data.address." + prop);
            }
        }
    }

    requiredProps: Array<keyof HorseDto> = [
        "name",
        "passportNumber",
        "chipNumber",
        "gender",
        "breed",
        "color",
        "yearOfBirth",
        "size",
        // eslint-disable-next-line @typescript-eslint/no-explicit-any
        "feiNumber" as any
    ];

    requiredStableProps: Array<keyof AddressDto> = [
        "street",
        "houseNumber",
        "zipCode",
        "city",
        "country"
    ];

    requiredOwnerProps: Array<keyof PersonDto> = [
        "firstName",
        "lastName",
        "phoneNumber",
        "phoneNumberMobile"
    ];

    requiredOwnerAddressProps = this.requiredStableProps;

    assertAllInRange(): void {
        const currentYear = new Date().getFullYear();
        if (this.horse.yearOfBirth && (this.horse.yearOfBirth < (currentYear - 60) || this.horse.yearOfBirth > currentYear)) {
            throw new Error(this.$t("horses.modals.add.errors.yearInvalid").toString());
        }
        if (this.horse.size && (this.horse.size < 40 || this.horse.size > 250)) {
            throw new Error(this.$t("horses.modals.add.errors.sizeOutOfRange").toString());
        }
    }
}
</script>
