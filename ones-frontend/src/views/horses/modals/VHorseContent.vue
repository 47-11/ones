<template>
    <div class="w-full">
        <dl v-for="prop in horseProperties" :key="prop" class="w-full flex">
            <div
                class="w-full bg-white dark:bg-gray-700 border-b dark:border-gray-800 py-3 sm:grid sm:grid-cols-3 sm:gap-4 px-6">
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
</template>

<script lang="ts">
import { HorseDto } from "@/openapi/generated";
import { Component, Prop, Vue } from "vue-property-decorator";

@Component
export default class VHorseContent extends Vue {
    @Prop()
    horse!: HorseDto;

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
}
</script>
