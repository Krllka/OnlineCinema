<template>
  <div class="container">
    <div class="login__header">Войдите или зарегистрируйтесь:</div>
    <form v-if="loginForm" class="form auth" @submit.prevent>
      <div class="form__main">
        <label class="label">
          <span v-if="!signInResponse.exist" class="labelFail"
            >Неверное имя пользователя!</span
          >
          <span v-else>Логин:</span>
          <input
            ref="login-log"
            type="text"
            class="input"
            :class="{
              inputFail:
                !signInResponse.exist &&
                !signInData.loginFocus &&
                !signInData.login,
            }"
            @focus="signInData.loginFocus = true"
            @focusout="signInData.loginFocus = false"
            required
            v-model="signInData.login"
          />
        </label>
        <label class="label">
          <span v-if="!signInResponse.access" class="labelFail"
            >Неверный пароль!</span
          >
          <span v-else>Пароль:</span>
          <input
            ref="password-log"
            type="password"
            class="input"
            :class="{
              inputFail:
                !signInResponse.access &&
                !signInData.passwordFocus &&
                !signInData.password,
            }"
            @focus="signInData.passwordFocus = true"
            @focusout="signInData.passwordFocus = false"
            required
            v-model="signInData.password"
          />
        </label>
        <button class="button login" @click="signIn">Войти</button>
      </div>
      <div class="form__footer">
        Еще не зарегистрированы? Нажмите
        <span @click="loginForm = !loginForm" class="form__link">здесь</span>.
      </div>
    </form>
    <form v-else class="form register" @submit.prevent>
      <label class="label">
        Логин:
        <input
          ref="login-reg"
          type="text"
          class="input"
          required
          v-model="signUpData.login"
        />
      </label>
      <label class="label">
        Адрес электронной почты:
        <input
          ref="email"
          type="email"
          class="input"
          required
          v-model="signUpData.email"
        />
      </label>
      <label class="label">
        Пароль:
        <input
          ref="password-reg"
          type="password"
          class="input"
          required
          v-model="signUpData.password"
        />
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
import axios from "axios";

export default {
  name: "AppLogin",
  data() {
    return {
      loginForm: true,
      signInData: {
        login: "",
        password: "",
        loginFocus: false,
        passwordFocus: false,
      },
      signInResponse: {
        exist: "no data",
        access: "no data",
        admin: "no data",
      },
      signUpData: {
        login: "",
        email: "",
        password: "",
      },
    };
  },
  methods: {
    signIn() {
      axios
        .get(
          `http://localhost:8081/accounts/${this.signInData.login}/${this.signInData.password}`
        )
        .then((response) => {
          this.signInResponse = response.data;
        })
        .catch((error) => {
          console.log(error);
        })
        .finally(() => {
          this.signInData.login = "";
          this.signInData.password = "";
          this.signInDataValidation();
        });
    },
    signInDataValidation() {
      // if (this.signInResponse.access) {
      // }
    },
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

  .inputFail {
    border: 1px solid red;
    box-shadow: 0 0 10px rgba(208, 0, 0, 0.5);
  }

  .labelFail {
    color: red;
    font-size: 12px;
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
