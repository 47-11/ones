<template>
  <app-layout>
    <div class="max-w-6xl m-auto py-12">
      <v-table>
        <thead class="bg-gray-50">
          <tr>
            <v-th>{{$t('events.start')}}</v-th>
            <v-th>{{$t('events.end')}}</v-th>
            <v-th>{{$t('events.ride')}}</v-th>
            <v-th>{{$t('events.documents')}}</v-th>
            <v-th></v-th>
          </tr>
        </thead>
        <tbody class="bg-white divide-y divide-gray-200">
          <tr v-for="event in events.list" :key="event.uuid">
            <v-td>{{
              new Date(event.start).toLocaleDateString(locale)
            }}</v-td>
            <v-td>{{ new Date(event.end).toLocaleDateString(locale) }}</v-td>
            <v-td>{{ event.title }}</v-td>
            <v-td>
              <v-link to="#">{{$t('events.callForTenders')}}</v-link>
            </v-td>
            <v-td>
              <router-link :to="'/events/' + event.uuid">
                <v-button>{{$t('events.details')}}</v-button>
              </router-link>
            </v-td>
          </tr>
        </tbody>

        <template v-slot:pagination>
          <div
            class="hidden sm:flex-1 sm:flex sm:items-center sm:justify-between"
          >
            <div>
              <p class="text-sm text-gray-700">
                <i18n path="events.pagination">
                  <template v-slot:from>
                    <span class="font-medium">1</span>
                  </template>

                  <template v-slot:to>
                    <span class="font-medium">10</span>
                  </template>

                  <template v-slot:of>
                    <span class="font-medium">97</span>
                  </template>
                </i18n>
              </p>
            </div>
            <pagination></pagination>
          </div>
        </template>
      </v-table>
    </div>
  </app-layout>
</template>

<script lang="ts">
import { Component, Vue } from "vue-property-decorator";
import Card from "@/components/Card.vue";
import AppLayout from "@/layouts/AppLayout.vue";
import VTable from "@/components/table/VTable.vue";
import VTh from "@/components/table/VTh.vue";
import VTd from "@/components/table/VTd.vue";
import Pagination from "@/components/Pagination.vue";
import VButton from "@/components/VButton.vue";
import VLink from "@/components/VLink.vue";
import { vxm } from "@/store";

@Component({
    components: {
        VLink,
        Pagination,
        VTable,
        VTh,
        VTd,
        AppLayout,
        Card,
        VButton
    }
})
export default class Home extends Vue {
    events = vxm.events;
    locale = window.navigator.language;

    mounted(): void {
        vxm.events.fetch();
    }
}
</script>
