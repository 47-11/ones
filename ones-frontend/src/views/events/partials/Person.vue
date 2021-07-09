<template>
    <div class="leading-5 mt-1" v-if="person">
        {{ person.name }} <br>
        <span class="text-xs text-gray-400">
            {{ person.address.street }} -
            {{ person.address.zipCode }}
            {{ person.address.city }} ({{ person.address.country }})
        </span>

        <br>

        <table class="mt-3">
            <tr v-if="person.phoneNumber">
                <td>
                    <font-awesome-icon :icon="'phone'" class="text-gray-400"/>
                </td>
                <td class="pl-3">
                    {{ person.phoneNumber }}
                </td>
            </tr>
            <tr v-if="person.emailAddress">
                <td>
                    <font-awesome-icon :icon="'at'" class="text-gray-400"/>
                </td>
                <td class="pl-3 text-indigo-500">
                    <a :href="`mailto:${person.emailAddress}`">
                        {{ person.emailAddress }}
                    </a>
                </td>
            </tr>
        </table>
    </div>
</template>

<script lang="ts">
import { Component, Prop, Vue } from "vue-property-decorator";
import { PersonDto } from "@/openapi/generated/api";

@Component
export default class Person extends Vue {
    @Prop() public person!: PersonDto;
}
</script>
