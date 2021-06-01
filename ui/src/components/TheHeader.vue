<template>
  <header class="header">
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
  </header>
</template>

<script>
export default {};
</script>

<style scoped lang="scss">
.header {
  padding: 15px 0;
  border-bottom: 1px solid black;
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
    &__item a {
      font-size: 17px;
      transition: 0.3s all;
      &:hover {
        color: rgba(0, 0, 0, 0.5);
        border-bottom: 1px solid rgba(0, 0, 0, 0.5);
      }
    }
  }
}
</style>
