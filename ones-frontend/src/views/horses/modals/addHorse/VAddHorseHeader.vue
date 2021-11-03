<template>
    <div class="flex w-full items-center">
        <h1 class="text-xl">
            {{ $t('horses.modals.add.title') }}
        </h1>
    </div>
</template>
<script lang="ts">
import { Component, Vue } from "vue-property-decorator";

@Component({
    components: { }
})
export default class VTitle extends Vue {}
</script>
