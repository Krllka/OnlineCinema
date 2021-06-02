<template>
  <div class="container">
    <div class="login__header">Войдите или зарегистрируйтесь:</div>
    <form v-if="loginForm" class="form auth" @submit.prevent>
      <div class="form__main">
        <label class="label">
          Логин:
          <input ref="login-log" type="text" class="input" />
        </label>
        <label class="label">
          Пароль:
          <input ref="password-log" type="password" class="input" />
        </label>
        <button class="button login">Войти</button>
      </div>
      <div class="form__footer">
        Еще не зарегистрированы? Нажмите
        <span @click="loginForm = !loginForm" class="form__link">здесь</span>.
      </div>
    </form>
    <form v-else class="form register" @submit.prevent>
      <label class="label">
        Имя:
        <input ref="name" type="text" class="input name" />
      </label>
      <label class="label">
        Логин:
        <input ref="login-reg" type="text" class="input" />
      </label>
      <label class="label">
        Адрес электронной почты:
        <input ref="email" type="email" class="input" />
      </label>
      <label class="label">
        Пароль:
        <input ref="password-reg" type="password" class="input" />
      </label>
      <button class="button register">Зарегистрироваться</button>
      <div class="form__footer">
        Уже зарегистрированы? Выполните
        <span @click="loginForm = !loginForm" class="form__link">вход</span>.
      </div>
    </form>
  </div>
</template>

<script>
export default {
  name: "AppLogin",
  data() {
    return {
      loginForm: true,
    };
  },
};
</script>

<style scoped lang="scss">
.login__header {
  text-align: center;
  font-size: 20px;
}

.form {
  margin: 20px auto;
  border: 1px solid black;
  border-radius: 6px;
  padding: 10px;
  width: 50%;
  .label,
  .input {
    display: block;
  }
  .input {
    width: 100%;
    margin: 5px 0;
  }
  .button {
    display: block;
    width: 20%;
    margin: 10px auto;
  }
  .register {
    width: 30%;
  }
  &__footer {
    margin-top: 20px;
    text-align: center;
  }
  &__link {
    cursor: pointer;
    border-bottom: 2px solid black;
    transition: 0.3s all;
    &:hover {
      color: rgba(0, 0, 0, 0.5);
      border-bottom: 2px solid rgba(0, 0, 0, 0.5);
    }
  }
}
</style>
