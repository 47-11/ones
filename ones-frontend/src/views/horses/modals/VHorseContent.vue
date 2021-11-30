<template>
  <div class="w-full">
    <div class="w-full mb-5">
      <div class="w-full bg-white dark:bg-gray-700 border-b dark:border-gray-800 py-3 sm:grid sm:grid-cols-3 sm:gap-4 px-6">
        <h1 class="text-xl bold">{{ $t("horses.modals.add.masterData") }}</h1>
      </div>
      <div class="w-full bg-white dark:bg-gray-700 border-b dark:border-gray-800 py-3 sm:grid sm:grid-cols-3 sm:gap-4 px-6">
        <dt class="text-sm font-medium text-gray-500 dark:text-gray-300">{{ $t("data.horse.name") }}</dt>
        <dd class="mt-1 text-sm sm:mt-0 sm:col-span-2 text-gray-800">{{ horse.name }}</dd>
      </div>
      <div class="w-full bg-white dark:bg-gray-700 border-b dark:border-gray-800 py-3 sm:grid sm:grid-cols-3 sm:gap-4 px-6">
        <dt class="text-sm font-medium text-gray-500 dark:text-gray-300">{{ $t("data.horse.passportNumber") }}</dt>
        <dd class="mt-1 text-sm sm:mt-0 sm:col-span-2 text-gray-800">{{ horse.passportNumber }}</dd>
      </div>
      <div class="w-full bg-white dark:bg-gray-700 border-b dark:border-gray-800 py-3 sm:grid sm:grid-cols-3 sm:gap-4 px-6">
        <dt class="text-sm font-medium text-gray-500 dark:text-gray-300">{{ $t("data.horse.chipNumber") }}</dt>
        <dd class="mt-1 text-sm sm:mt-0 sm:col-span-2 text-gray-800">{{ horse.chipNumber }}</dd>
      </div>
      <div class="w-full bg-white dark:bg-gray-700 border-b dark:border-gray-800 py-3 sm:grid sm:grid-cols-3 sm:gap-4 px-6">
        <dt class="text-sm font-medium text-gray-500 dark:text-gray-300">{{ $t("data.horse.gender") }}</dt>
        <dd class="mt-1 text-sm sm:mt-0 sm:col-span-2 text-gray-800">{{$t("data.horse.genderOptions." + horse.gender) }}</dd>
      </div>
      <div class="w-full bg-white dark:bg-gray-700 border-b dark:border-gray-800 py-3 sm:grid sm:grid-cols-3 sm:gap-4 px-6">
        <dt class="text-sm font-medium text-gray-500 dark:text-gray-300">{{ $t("data.horse.breed") }}</dt>
        <dd class="mt-1 text-sm sm:mt-0 sm:col-span-2 text-gray-800">{{ horse.breed }}</dd>
      </div>
      <div class="w-full bg-white dark:bg-gray-700 border-b dark:border-gray-800 py-3 sm:grid sm:grid-cols-3 sm:gap-4 px-6">
        <dt class="text-sm font-medium text-gray-500 dark:text-gray-300">{{ $t("data.horse.color") }}</dt>
        <dd class="mt-1 text-sm sm:mt-0 sm:col-span-2 text-gray-800">{{ horse.color }}</dd>
      </div>
      <div class="w-full bg-white dark:bg-gray-700 border-b dark:border-gray-800 py-3 sm:grid sm:grid-cols-3 sm:gap-4 px-6">
        <dt class="text-sm font-medium text-gray-500 dark:text-gray-300">{{ $t("data.horse.yearOfBirth") }}</dt>
        <dd class="mt-1 text-sm sm:mt-0 sm:col-span-2 text-gray-800">{{ horse.yearOfBirth }}</dd>
      </div>
      <div class="w-full bg-white dark:bg-gray-700 border-b dark:border-gray-800 py-3 sm:grid sm:grid-cols-3 sm:gap-4 px-6">
        <dt class="text-sm font-medium text-gray-500 dark:text-gray-300">{{ $t("data.horse.size") }}</dt>
        <dd class="mt-1 text-sm sm:mt-0 sm:col-span-2 text-gray-800">{{ horse.size }}</dd>
      </div>
        <div class="w-full bg-white dark:bg-gray-700 border-b dark:border-gray-800 py-3 sm:grid sm:grid-cols-3 sm:gap-4 px-6">
            <dt class="text-sm font-medium text-gray-500 dark:text-gray-300">{{ $t("data.horse.feiNo") }}</dt>
            <dd class="mt-1 text-sm sm:mt-0 sm:col-span-2 text-gray-800">{{ horse.feiNo }}</dd>
        </div>
      <div class="w-full bg-white dark:bg-gray-700 border-b dark:border-gray-800 py-3 sm:grid sm:grid-cols-3 sm:gap-4 px-6">
        <dt class="text-sm font-medium text-gray-500 dark:text-gray-300">{{ $t("data.horse.stableAddress") }}</dt>
        <dd class="mt-1 text-sm sm:mt-0 sm:col-span-2 text-gray-800"><v-address :address="horse.stableAddress"></v-address></dd>
      </div>
    </div>
    <div class="w-full mb-5">
      <div class="w-full bg-white dark:bg-gray-700 border-b dark:border-gray-800 py-3 sm:grid sm:grid-cols-3 sm:gap-4 px-6 mt-8">
        <h1 class="text-xl bold">{{ $t("data.horse.owner") }}</h1>
      </div>
      <div class="w-full bg-white dark:bg-gray-700 border-b dark:border-gray-800 py-3 sm:grid sm:grid-cols-3 sm:gap-4 px-6">
        <dt class="text-sm font-medium text-gray-500 dark:text-gray-300">{{ $t("data.user.firstName") }}</dt>
        <dd class="mt-1 text-sm sm:mt-0 sm:col-span-2 text-gray-800">{{ horse.owner.firstName }}</dd>
      </div>

      <div class="w-full bg-white dark:bg-gray-700 border-b dark:border-gray-800 py-3 sm:grid sm:grid-cols-3 sm:gap-4 px-6">
        <dt class="text-sm font-medium text-gray-500 dark:text-gray-300">{{ $t("data.user.lastName") }}</dt>
        <dd class="mt-1 text-sm sm:mt-0 sm:col-span-2 text-gray-800">{{ horse.owner.lastName }}</dd>
      </div>

      <div class="w-full bg-white dark:bg-gray-700 border-b dark:border-gray-800 py-3 sm:grid sm:grid-cols-3 sm:gap-4 px-6">
        <dt class="text-sm font-medium text-gray-500 dark:text-gray-300">{{ $t("data.user.phoneNumber") }}</dt>
        <dd class="mt-1 text-sm sm:mt-0 sm:col-span-2 text-gray-800">{{ horse.owner.phoneNumber }}</dd>
      </div>

      <div class="w-full bg-white dark:bg-gray-700 border-b dark:border-gray-800 py-3 sm:grid sm:grid-cols-3 sm:gap-4 px-6">
        <dt class="text-sm font-medium text-gray-500 dark:text-gray-300">{{ $t("data.user.phoneNumberMobile") }}</dt>
        <dd class="mt-1 text-sm sm:mt-0 sm:col-span-2 text-gray-800">{{ horse.owner.phoneNumberMobile }}</dd>
      </div>

        <div class="w-full bg-white dark:bg-gray-700 border-b dark:border-gray-800 py-3 sm:grid sm:grid-cols-3 sm:gap-4 px-6">
            <dt class="text-sm font-medium text-gray-500 dark:text-gray-300">{{ $t("data.horse.ownerAddress") }}</dt>
            <dd class="mt-1 text-sm sm:mt-0 sm:col-span-2 text-gray-800"><v-address :address="horse.owner.address"></v-address></dd>
        </div>
    </div>
  </div>
</template>

<script lang="ts">
import { FullHorseDto } from "@/openapi/generated";
import { Component, Prop, Vue } from "vue-property-decorator";
import VAddress from "@/components/VAddress.vue";
@Component({
    components: { VAddress }
})
export default class VHorseContent extends Vue {
    private needsSetup = true;

    mounted(): void {
        this.horse.stableAddress = this.horse.stableAddress || {};
        this.horse.owner = this.horse.owner || {};
        this.horse.owner.address = this.horse.owner.address || {};
        this.needsSetup = false;
    }

    @Prop({
        default: () => {
            return {};
        }
    })
    horse!: HorseDto;
}
</script>
