<template>
    <div class="min-h-screen bg-gray-100">

        <div class="shadow bg-white">
            <navigation/>

            <header v-if="hasHeader()">
                <div class="max-w-7xl mx-auto py-6 px-4 sm:px-6 lg:px-8 flex items-center flex-col sm:flex-row">
                    <slot name="header"></slot>
                </div>
            </header>
        </div>

        <main>
            <!-- Page Content -->
            <slot></slot>
        </main>

        <div class="w-full">
            <div class="mx-auto py-8 text-center">
                <a href="/data-policy">
                    Datenschutz
                </a>
            </div>
        </div>
    </div>
</template>

<script lang="ts">
import { Component, Vue } from "vue-property-decorator";
import Navigation from "@/layouts/partials/Navigation.vue";

@Component({
    components: { Navigation }
})
export default class AppLayout extends Vue {
    hasHeader(): boolean {
        return Boolean(this.$slots.header);
    }
}
</script>
