<template>
    <address v-if="address">
        {{ address.locationName }} <br v-if="address.locationName && address.locationName.trim().length > 0"/>
        {{ address.street }} {{ address.houseNumber }}<br v-if="address.street && address.street.trim().length > 0"/>
        {{ address.zipCode }} {{ address.city }}<br v-if="(address.zipCode && address.zipCode.trim().length > 0) || (address.city && address.city.trim().length > 0)" />
        {{ address.country }}
    </address>
</template>

<script lang="ts">
import { AddressDto } from "@/openapi/generated";
import { Component, Prop, Vue } from "vue-property-decorator";

@Component
export default class VAddress extends Vue {
    @Prop() address!: AddressDto;
}
</script>
