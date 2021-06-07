<template>
  <div class="container">
    <div v-if="isAuthorized">
      <h2 class="header">Мои заказы:</h2>
    </div>
    <div v-else class="message">
      <router-link to="/profile" class="link">Авторизируйтесь</router-link>,
      чтобы получить доступ к заказам.
    </div>
  </div>
</template>

<script>
export default {
  name: "PageOrders",
  props: {
    isAuthorized: {
      type: Boolean,
      default: false,
    },
  },
  created() {
    document.title = "Заказы";
  },
};
</script>

<style scoped lang="scss">
.header {
  font-size: 20px;
}

.message {
  text-align: center;
  margin-top: 25vh;
  font-size: 20px;
}
</style>
