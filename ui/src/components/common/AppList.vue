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
          :library-items="libraryItems"
          :is-card-in-library="isItemInLibrary"
          :isAuthorized="isAuthorized"
          @openCardPage="$emit('openItemPage', item.id)"
          @addToCart="$emit('addToCart', item.id)"
        />
      </li>
    </ul>
  </div>
</template>

<script>
import AppCard from "@/components/common/AppCard";

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
    libraryItems: {
      type: Array,
      default: () => [],
    },
    isItemInLibrary: {
      type: Boolean,
      default: false,
    },
    filter: {
      type: String,
      default: "",
    },
    isAuthorized: {
      type: Boolean,
      default: false,
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
