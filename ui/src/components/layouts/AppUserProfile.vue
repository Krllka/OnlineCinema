<template>
  <div class="container">
    <div class="user__header">
      <h3 class="header">Привет, {{ userData.name }}</h3>
      <a v-if="userData.admin" @click="openAdminPanel" class="link"
        >Панель администратора</a
      >
    </div>
    <div class="body">
      <div class="user__body">
        <div class="user__row">
          <div class="user__title">Имя</div>
          <div class="user__value">{{ userData.name }}</div>
        </div>
        <div class="user__row">
          <div class="user__title">Эл. почта</div>
          <div class="user__value">{{ userData.mail }}</div>
        </div>
        <div class="user__row">
          <div class="user__title">Пол</div>
          <div class="user__value">{{ userData.sex }}</div>
        </div>
        <div class="user__row">
          <div class="user__title">Дата рождения</div>
          <div class="user__value">{{ userData.age }}</div>
        </div>
      </div>
      <div class="btn-group">
        <button class="button logout" @click="$emit('logOut')">
          Выйти из профиля
        </button>
        <button class="button" @click="$emit('changeUserData')">
          Изменить данные
        </button>
        <button class="button">Изменить пароль</button>
      </div>
    </div>
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
.user {
  &__header {
    display: flex;
    justify-content: space-between;
    align-items: center;
  }
  &__body {
    width: 100%;
    border: 1px solid black;
    border-radius: 6px;
    padding: 15px;
  }
  &__row {
    display: flex;
    justify-content: space-between;
    padding: 2px;
    border-bottom: 1px solid rgba(0, 0, 0, 0.5);
    margin-bottom: 10px;
  }
}

.body {
  margin: 15vh auto 0;
  width: 50%;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  align-items: center;
}

.btn-group {
  width: 100%;
  margin-top: 30px;
  display: flex;
  justify-content: space-between;
}
</style>
