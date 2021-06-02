<template>
  <header class="header">
    <div v-if="!isAdminPanel" class="user">
      <div class="container">
        <router-link to="/">Онлайн-кинотеатр</router-link>
        <nav class="menu">
          <ul class="menu__list">
            <li class="menu__item">
              <router-link to="/">Каталог</router-link>
            </li>
            <li class="menu__item">
              <router-link to="/library">Библиотека</router-link>
            </li>
            <li class="menu__item">
              <router-link to="/orders">Заказы</router-link>
            </li>
            <li class="menu__item">
              <router-link to="/profile">Мой профиль</router-link>
            </li>
          </ul>
        </nav>
      </div>
    </div>
    <div v-else-if="isAdmin && isAdminPanel" class="admin">
      <div class="container">
        <div class="admin__header">Панель администратора</div>
        <nav class="menu">
          <ul class="menu__list extend">
            <li class="menu__item">
              <router-link to="/catalog-admin"
                >Управление каталогом</router-link
              >
            </li>
            <li class="menu__item">
              <router-link to="/users">Список пользователей</router-link>
            </li>
            <li class="menu__item">
              <a @click="closeAdminPanel">Назад в профиль</a>
            </li>
          </ul>
        </nav>
      </div>
    </div>
  </header>
</template>

<script>
export default {
  name: "TheHeader",
  props: {
    isAdmin: {
      type: Boolean,
      default: false,
    },
    isAdminPanel: {
      type: Boolean,
      default: false,
    },
  },
  methods: {
    closeAdminPanel() {
      this.$router.push("/profile");
      this.$emit("hideAdminPanel");
    },
  },
};
</script>

<style scoped lang="scss">
.header {
  padding: 15px 0;
  border-bottom: 1px solid black;
  margin-bottom: 20px;
  .container {
    display: flex;
    justify-content: space-between;
    align-items: center;
    & > a {
      cursor: pointer;
      font-size: 36px;
      font-weight: 700;
      transition: 0.3s all;
      &:hover {
        color: rgba(0, 0, 0, 0.5);
      }
    }
  }
  .menu {
    &__list {
      display: flex;
      justify-content: space-between;
      width: 25vw;
    }
    .extend {
      width: 35vw;
    }
    &__item a {
      font-size: 17px;
      cursor: pointer;
      transition: 0.3s all;
      &:hover {
        color: rgba(0, 0, 0, 0.5);
        border-bottom: 1px solid rgba(0, 0, 0, 0.5);
      }
    }
  }
}

.admin {
  &__header {
    font-size: 30px;
    font-weight: 700;
  }
}
</style>
