<template>
  <header>
    <div class="container">
      <nav class="menu">
        <h1 class="menu__header" @click="clickHandler">Онлайн кинотеатр</h1>
        <ul class="menu__list">
          <li class="menu__item">
            <button
              class="menu__btn"
              @click="$router.push({ name: 'catalog' })"
              :disabled="$route.name === 'catalog'"
            >
              Каталог фильмов
            </button>
          </li>
          <li class="menu__item">
            <button
              class="menu__btn"
              @click="$router.push({ name: 'profile' })"
              :disabled="$route.name === 'profile'"
            >
              Личный кабинет
            </button>
          </li>
        </ul>
      </nav>
    </div>
  </header>
</template>

<script>
export default {
  name: "TheHeader",
  methods: {
    clickHandler() {
      if (this.$route.name !== "home") {
        this.$router.push({ name: "home" });
      }
    },
  },
};
</script>

<style lang="scss" scoped>
header {
  border-bottom: 1px solid;
  margin-bottom: 20px;
}
.menu {
  display: flex;
  justify-content: space-around;
  align-items: center;
  margin: 30px 15px;
  &__header {
    font-size: 36px;
    color: #333;
    cursor: pointer;
    &:hover {
      color: #6d6d6d;
    }
  }
  &__list {
    list-style: none;
    display: flex;
    justify-content: space-between;
    width: 300px;
    font-size: 20px;
  }
  &__btn {
    color: #333333;
    cursor: pointer;
    height: 35px;
    padding: 5px;
    &:disabled {
      color: rgba(51, 51, 51, 0.51);
    }
  }
}
</style>
