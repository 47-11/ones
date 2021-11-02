<template>
  <app-layout>
    <div class="max-w-6xl m-auto py-12">
      <div class="flex items-start mx-4 lg:mx-0">
        <page-header>{{ $t("profile.title") }}</page-header>
        <v-button color="danger" class="ml-auto" v-if="user" @click.native="deleteAccount">{{ $t('profile.delete') }}
        </v-button>
        <v-button class="ml-4" v-if="user" @click.native="saveAccount">{{ $t('profile.save') }}</v-button>
      </div>

      <div class="grid grid-cols-1 md:grid-cols-2 gap-6 lg:grid-cols-6 mx-4 lg:mx-0" v-if="user">
        <div class="col-span-6" v-if="error">
            <error-message :error="error"/>
        </div>
        <div class="sm:col-span-1 md:col-span-2 lg:col-span-2">
          <h2 class="text-xl font-bold text-gray-700">{{ $t('profile.personalData') }}</h2>
          <card class="mt-3 overflow-x-hidden">
            <div class="px-5 py-3">
              <div class="mb-3">
                <v-label class="mb-1">{{ $t('data.user.vddNumber') }}</v-label>
                <v-input class="w-full" type="text" :disabled="true" v-model="user.vddNumber"></v-input>
              </div>

              <div class="mb-3">
                <v-label class="mb-1">{{ $t('data.user.fullName') }}</v-label>
                <v-input class="w-full" type="text" v-model="user.firstName" autocomplete="given-name"></v-input>
              </div>

              <div class="mb-3">
                <v-label class="mb-1">{{ $t('data.user.lastName') }}</v-label>
                <v-input class="w-full" type="text" v-model="user.lastName" autocomplete="family-name"></v-input>
              </div>

              <div class="mb-3">
                <v-label class="mb-1">{{ $t('data.user.birthName') }}</v-label>
                <v-input class="w-full" type="text" v-model="user.birthName"></v-input>
              </div>

              <div class="mb-3">
                <v-label class="mb-1">{{ $t('data.user.birthday') }}</v-label>
                <v-input class="w-full" type="text" :disabled="true" v-model="user.birthday"></v-input>
              </div>
            </div>
          </card>
        </div>
        <div class="sm:col-span-1 md:col-span-2 lg:col-span-2">
          <h2 class="text-xl font-bold text-gray-700">{{ $t('profile.contactInfo') }}</h2>
          <card class="mt-3 overflow-x-hidden">

            <div class="px-5 py-3 grid grid-cols-1 sm:grid-cols-12 gap-3">
              <div class="col-span-1 sm:col-span-8">
                <v-label class="mb-1">{{ $t('data.user.street') }}</v-label>
                <v-input class="w-full" type="text" v-model="user.address.street"
                         autocomplete="street-address"></v-input>
              </div>
              <div class="col-span-1 sm:col-span-4">
                <v-label class="mb-1">{{ $t('data.user.houseNumber') }}</v-label>
                <v-input class="w-full" type="text" v-model="user.address.houseNumber"></v-input>
              </div>
              <div class="col-span-1 sm:col-span-4">
                <v-label class="mb-1">{{ $t('data.user.zipCode') }}</v-label>
                <v-input class="w-full" type="text" v-model="user.address.zipCode" autocomplete="postal-code"></v-input>
              </div>
              <div class="col-span-1 sm:col-span-8">
                <v-label class="mb-1">{{ $t('data.user.city') }}</v-label>
                <v-input class="w-full" type="text" v-model="user.address.city"></v-input>
              </div>
              <div class="col-span-1 sm:col-span-12">
                <v-label class="mb-1">{{ $t('data.user.country') }}</v-label>
                <v-select v-model="user.address.country" class="w-full">
                  <option value="DE">{{ $t("shared.countries.germany") }}</option>
                  <option value="NL">{{ $t("shared.countries.netherlands") }}</option>
                  <option value="AT">{{ $t("shared.countries.austria") }}</option>
                  <option value="CH">{{ $t("shared.countries.switzerland") }}</option>
                </v-select>
              </div>
              <div class="col-span-1 sm:col-span-12">
                <v-label class="mb-1">{{ $t('data.user.phoneNumber') }}</v-label>
                <v-input class="w-full" type="tel" v-model="user.phoneNumber"></v-input>
              </div>
              <div class="col-span-1 sm:col-span-12">
                <v-label class="mb-1">{{ $t('data.user.phoneNumberMobile') }}</v-label>
                <v-input class="w-full" type="tel" v-model="user.phoneNumberMobile"></v-input>
              </div>
              <div class="col-span-1 sm:col-span-12 mb-3">
                <v-label class="mb-1">{{ $t('data.user.phoneNumberEmergency') }}</v-label>
                <v-input class="w-full" type="tel" v-model="user.phoneNumberEmergency"></v-input>
              </div>
            </div>
          </card>
        </div>
        <div class="sm:col-span-1 md:col-span-2 lg:col-span-2">
          <h2 class="text-xl font-bold text-gray-700">{{ $t('profile.otherData') }}</h2>
          <card class="mt-3 overflow-x-hidden">
            <div class="px-5 py-3">
              <div class="mb-3">
                <v-label class="mb-1">{{ $t('data.user.qualificationLevel') }}</v-label>
                <v-input class="w-full" type="text" :disabled="true" v-model="user.qualificationLevel"></v-input>
              </div>

              <div class="mb-3">
                <v-label class="mb-1">{{ $t('data.user.feiNo') }}</v-label>
                <v-input class="w-full" type="text" :disabled="true" v-model="user.feiNo"></v-input>
              </div>

              <div class="mb-3">
                <v-label class="mb-1">{{ $t('data.user.fnNo') }}</v-label>
                <v-input class="w-full" type="text" :disabled="true" v-model="user.fnNo"></v-input>
              </div>
            </div>
          </card>
        </div>
      </div>
      <div class="flex items-start flex-wrap-reverse mx-4 lg:mx-0 mt-6 gap-4">
        <v-button class="w-full sm:w-auto" color="secondary" @click.native="goBack">{{ $t('shared.back') }}</v-button>
        <v-button class="w-full sm:w-auto sm:ml-auto" color="danger" v-if="user" @click.native="deleteAccount">{{ $t('profile.delete') }}</v-button>
        <v-button class="w-full sm:w-auto" v-if="user" @click.native="saveAccount">{{ $t('profile.save') }}</v-button>
      </div>
    </div>
  </app-layout>
</template>

<script lang="ts">
import { Component, Vue } from "vue-property-decorator";
import PageHeader from "@/components/PageHeader.vue";
import Card from "@/components/Card.vue";
import VAddress from "@/components/VAddress.vue";
import VButton from "@/components/VButton.vue";
import VLink from "@/components/VLink.vue";
import VInput from "@/components/forms/VInput.vue";
import VLabel from "@/components/forms/VLabel.vue";
import VSelect from "@/components/forms/VSelect.vue";
import BadgeCircle from "@/components/BadgeCircle.vue";
import AppLayout from "@/layouts/AppLayout.vue";
import { vxm } from "@/store";
import { AddressDto, UserDto } from "@/openapi/generated";

@Component({
    components: {
        PageHeader,
        AppLayout,
        Card,
        BadgeCircle,
        VAddress,
        VButton,
        VLink,
        VInput,
        VLabel,
        VSelect
    }
})
export default class ProfileEdit extends Vue {
    private readonly requiredProperties: (keyof UserDto)[] = [
        "firstName",
        "lastName",
        "phoneNumber",
        "phoneNumberMobile",
        "phoneNumberEmergency"
    ];

    private readonly requiredAddressProperties: (keyof AddressDto)[] = [
        "street",
        "houseNumber",
        "zipCode",
        "city",
        "country"
    ];

    private error: Error | null = null;

    get user(): UserDto | null {
        return vxm.user.current;
    }

    mounted(): void {
        vxm.user.fetchCurrent();
    }

    goBack(): void {
        this.$router.push("/profile");
    }

    async saveAccount(): Promise<void> {
        try {
            await this.trySaveAccount();
        } catch (e) {
            this.error = e;
        }
    }

    async trySaveAccount(): Promise<void> {
        this.assertUserValid();
        await vxm.user.setPersonalData(this.user as UserDto);
        await this.$router.push("/profile");
    }

    async deleteAccount(): Promise<void> {
        const deleteAccount = confirm(this.$i18n.t("profile.confirmDelete").toString());
        if (deleteAccount) {
            await vxm.user.deleteAccount();
            this.$router.push("/logout");
        }
    }

    private assertUserValid(): void {
        if (this.user == null) {
            throw new Error(this.$i18n.t("data.user") + this.$i18n.t("editUser.lengthNull").toString());
        }
        try {
            this.assertValid(this.user, this.requiredProperties);
            this.assertValid(this.user.address, this.requiredAddressProperties);
        } catch (e) {
            throw new Error(this.$i18n.t("data.user." + e.message).toString() + this.$i18n.t("profile.lengthNull").toString());
        }
    }

    private assertValid<T>(obj: T | null | undefined, requiredKeys: (keyof T)[]) {
        if (obj == null) {
            throw new Error();
        }
        for (const property of requiredKeys) {
            const propertyValue = obj[property] ?? null;
            if (propertyValue == null || (propertyValue as unknown as string).length === 0) {
                throw new Error("" + property);
            }
        }
    }
}
</script>
