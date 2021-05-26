<template>
    <span>
        <span v-if="sameDay">
            {{ startDate.format("DD.MM.YYYY") }}
        </span>
        <span v-else-if="sameMonth">
            {{ startDate.format("DD.") }} - {{ endDate.format("DD.MM.YYYY") }}
        </span>
        <span v-else-if="sameYear">
            {{ startDate.format("DD.MM.") }} - {{ endDate.format("DD.MM.YYYY") }}
        </span>
        <span v-else>
            {{ startDate.format("DD.MM.YYYY") }} - {{ endDate.format("DD.MM.YYYY") }}
        </span>
    </span>
</template>

<script lang="ts">
import { Component, Prop, Vue } from "vue-property-decorator";
import moment from "moment";

@Component
export default class DateRange extends Vue {
    @Prop() private start!: string;
    @Prop() private end!: string;

    get sameDay(): boolean {
        return this.startDate.isSame(this.endDate, "day");
    }

    get sameMonth(): boolean {
        return this.startDate.isSame(this.endDate, "month");
    }

    get sameYear(): boolean {
        return this.startDate.isSame(this.endDate, "year");
    }

    get startDate(): moment.Moment {
        return moment(this.start);
    }

    get endDate(): moment.Moment {
        return moment(this.end);
    }
}
</script>
