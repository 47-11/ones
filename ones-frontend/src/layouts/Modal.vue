<template>
    <vue-final-modal
        v-slot="{ params }"
        v-bind="$attrs"
        classes="modal-container"
        content-class="modal-content"
        v-on="$listeners"
    >
        <div class="fixed inset-0 z-40 overflow-y-auto">
            <div class="flex items-center justify-center min-h-screen px-4 pt-4 pb-10 text-center sm:block sm:p-0">
                <div class="fixed inset-0 transition-all transform">
                    <div class="absolute inset-0 bg-gray-500 dark:bg-black opacity-75"></div>
                </div>

                <span class="hidden sm:inline-block sm:align-middle sm:h-screen" aria-hidden="true">&#8203;</span>

                <div
                    class="inline-block max-w-3xl align-bottom bg-white rounded-md overflow-hidden dark:bg-gray-800 rounded-lg mb-10 sm:mb-8 text-left shadow-xl transform transition-all sm:my-8 sm:align-middle sm:w-full">

                    <card>
                        <template v-slot:header>
                            <slot name="header"></slot>
                        </template>

                        <div class="modal__content">
                            <slot v-bind:params="params"></slot>
                        </div>

                        <template v-slot:footer>
                            <slot name="footer"></slot>
                        </template>
                    </card>
                </div>
            </div>
        </div>
    </vue-final-modal>
</template>

<script lang="ts">
import { Component, Vue } from "vue-property-decorator";
import VButton from "@/components/VButton.vue";
import Card from "@/components/Card.vue";

@Component({
    components: {
        Card,
        VButton
    }
})
export default class Modal extends Vue {
}
</script>
