<template>
  <div class="container">
    <div class="user__header">
      <h3 class="header">Привет, {{ userData.name }}</h3>
      <a v-if="userData.admin" @click="openAdminPanel" class="link"
        >Панель администратора</a
      >
    </div>
    <button class="button logout" @click="$emit('logOut')">
      Выйти из профиля
    </button>
  </div>
</template>

<script>
export default {
  name: "AppUserProfile",
  props: {
    userData: {
      type: Object,
      default: () => {},
    },
  },
  methods: {
    openAdminPanel() {
      this.$router.push("/catalog-admin");
      this.$emit("showAdminPanel");
    },
  },
};
</script>

<style scoped lang="scss">
.user__header {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.button {
  margin-top: 30px;
}
</style>
