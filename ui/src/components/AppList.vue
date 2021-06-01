<template>
  <div>
    <ul class="list">
      <li v-for="(item, index) in items" :key="index" class="list__item">
        <app-card :card-data="item" />
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
