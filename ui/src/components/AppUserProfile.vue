<template>
  <div class="container">
    <div class="user__header">
      <h3 class="header">Привет, {{ userData.name }}</h3>
      <a v-if="userData.admin" @click="openAdminPanel" class="admin__link"
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

.admin__link {
  border-bottom: 2px solid black;
  cursor: pointer;
  transition: 0.5s all;
  &:hover {
    border-bottom: 2px solid rgba(0, 0, 0, 0.5);
    color: rgba(0, 0, 0, 0.5);
  }
}

.button {
  margin-top: 30px;
}
</style>
