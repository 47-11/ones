<template>
    <modal @cancel="cancel" name="show-selected-horse" v-if="horse">
        <card>
        </card>
    </modal>
</template>

<script lang="ts">
import { Component, Vue } from "vue-property-decorator";
import PageHeader from "@/components/PageHeader.vue";
import Card from "@/components/Card.vue";
import VButton from "@/components/VButton.vue";
import VLink from "@/components/VLink.vue";
import VInput from "@/components/forms/VInput.vue";
import VLabel from "@/components/forms/VLabel.vue";
import VSelect from "@/components/forms/VSelect.vue";
import VTable from "@/components/table/VTable.vue";
import VTd from "@/components/table/VTd.vue";
import VTh from "@/components/table/VTh.vue";
import BadgeCircle from "@/components/BadgeCircle.vue";
import AppLayout from "@/layouts/AppLayout.vue";
import Modal from "@/layouts/Modal.vue";

@Component({
    components: {
        PageHeader,
        AppLayout,
        Card,
        BadgeCircle,
        VButton,
        VLink,
        VInput,
        VLabel,
        VSelect,
        VTable,
        VTd,
        VTh,
        Modal
    }
})
export default class ShowHorse extends Vue {
    public cancel(): void {
        this.$vfm.hide("show-selected-horse");
    }
}
</script>
