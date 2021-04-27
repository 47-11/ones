<template>
    <app-layout>
        <div class="max-w-3xl m-auto py-12">
            <card>
                <template v-slot:header>
                    <h1 class="text-xl">Das ist eine Card</h1>
                </template>

                <div class="px-6 py-5">
                    Helloooo
                </div>

                <template v-slot:footer>
                    Footer
                </template>
            </card>
        </div>
    </app-layout>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';
import Card from '@/components/Card.vue';
import AppLayout from '@/layouts/AppLayout.vue';

@Component({
    components: {
        AppLayout,
        Card
    }
})
export default class Home extends Vue {
}
</script>
