<template>
  <div>
    <ul class="list">
      <li
        v-for="(item, index) in filteredItems"
        :key="index"
        class="list__item"
      >
        <app-card
          :card-data="item"
          @openCardPage="$emit('openItemPage', item.id)"
        />
      </li>
    </ul>
  </div>
</template>

<script>
import AppCard from "@/components/AppCard";

export default {
  name: "AppList",
  components: {
    AppCard,
  },
  props: {
    items: {
      type: Array,
      default: () => [],
    },
    filter: {
      type: String,
      default: "",
    },
  },
  computed: {
    filteredItems() {
      const search = this.filter.toLowerCase();
      return this.items.filter((item) => {
        if (Object.values(item).join("").toLowerCase().includes(search))
          return item;
      });
    },
  },
};
</script>

<style scoped lang="scss">
.list {
  display: flex;
  justify-content: space-between;
  align-items: center;
  flex-wrap: wrap;
  &__item {
    margin-bottom: 20px;
  }
}
</style>
