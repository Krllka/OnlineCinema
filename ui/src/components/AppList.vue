<template>
  <div class="container">
    <h2>Фильмы, доступные к просмотру:</h2>
    <ul>
      <li v-for="(item, index) in items" :key="index">
        {{ item }}
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  name: "AppList",
  props: {
    items: {
      type: Array,
      default: () => [],
    },
  },
};
</script>

<style scoped></style>
