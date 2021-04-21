<template>
  <div class="container">
    <h2>Фильмы, доступные к просмотру:</h2>
    <ul>
      <li v-for="(item, index) in items" :key="index">
        <app-card :cardData="item" />
      </li>
    </ul>
  </div>
</template>

<script>
import AppCard from "@/components/AppCard";
export default {
  name: "AppList",
  components: { AppCard },
  props: {
    items: {
      type: Array,
      default: () => [],
    },
  },
};
</script>

<style scoped>
ul {
  margin-top: 30px;
  list-style: none;
  display: flex;
  flex-direction: column;
  align-items: center;
}

li {
  margin-bottom: 30px;
}
</style>
