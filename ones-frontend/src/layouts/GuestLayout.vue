<template>
    <div class="font-sans text-gray-900 antialiased">
        <slot></slot>
    </div>
</template>

<script lang="ts">
import { Component, Vue } from "vue-property-decorator";
import Navigation from "@/layouts/partials/Navigation.vue";

@Component({
    components: { Navigation }
})
export default class GuestLayout extends Vue {
}
</script>
