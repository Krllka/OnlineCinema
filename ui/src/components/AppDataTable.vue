<template>
  <table class="table">
    <thead class="table__head">
      <tr class="table__row">
        <th
          v-for="(header, index) in dataHeaders"
          :key="index"
          class="table__header"
        >
          {{ header.value }}
        </th>
      </tr>
    </thead>
    <tbody class="table__body">
      <template v-if="filteredList.length">
        <tr
          v-for="(item, index) in filteredList"
          :key="index"
          class="table__row data"
        >
          <td
            v-for="(column, index) in dataHeaders"
            :key="index"
            class="table__cell"
          >
            <slot :name="column.key" :movie="item" :index="index">
              {{ item[column.key] }}
            </slot>
          </td>
        </tr>
      </template>
      <template v-else>
        <tr class="table__row">
          <td class="table__cell" :colspan="dataHeaders.length">
            <div class="empty">Нет совпадений.</div>
          </td>
        </tr>
      </template>
    </tbody>
  </table>
</template>

<script>
export default {
  name: "AppDataTable",
  props: {
    dataList: {
      type: Array,
      default: () => [],
    },
    dataHeaders: {
      type: Array,
      default: () => [],
    },
    filter: {
      type: String,
      default: "",
    },
  },
  computed: {
    filteredList() {
      const search = this.filter.toLowerCase();
      return this.dataList.filter((item) => {
        if (Object.values(item).join("").toLowerCase().includes(search))
          return item;
      });
    },
  },
};
</script>

<style scoped lang="scss">
.table {
  margin: 20px auto;
  width: 100%;
  border-spacing: 0;
  border: 1px solid rgba(0, 0, 0, 0.5);
  border-radius: 3px;
  &__header {
    text-align: left;
  }
  &__header,
  &__cell {
    padding: 10px;
    border-bottom: 1px solid rgba(0, 0, 0, 0.5);
    overflow-wrap: break-word;
  }
  &__row:last-child > &__cell {
    border-bottom: none;
  }
  &__row.data {
    cursor: pointer;
    &:hover {
      background-color: rgba(0, 0, 0, 0.1);
    }
  }
  .empty {
    font-size: 16px;
    font-weight: 500;
    text-align: center;
    margin: 25px 0;
  }
}
</style>
