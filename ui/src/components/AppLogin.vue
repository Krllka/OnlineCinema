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
                !signInData.name,
            }"
            @focus="signInData.loginFocus = true"
            @focusout="signInData.loginFocus = false"
            required
            v-model="signInData.name"
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
        <button class="button login" @click="signIn(signInData)">Войти</button>
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
          v-model="signUpData.name"
        />
      </label>
      <label class="label">
        Адрес электронной почты:
        <input
          ref="email"
          type="email"
          class="input"
          v-model="signUpData.mail"
        />
      </label>
      <label class="label">
        Пол:
        <select class="select" v-model="signUpData.sex" required>
          <option selected disabled value="Не выбрано">Не выбрано</option>
          <option
            v-for="(gender, index) in genders"
            :key="index"
            :value="gender.id"
          >
            {{ gender.name }}
          </option>
        </select>
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
      <button
        :disabled="!signUpFormCompleted"
        class="button register"
        @click="singUp"
      >
        Зарегистрироваться
      </button>
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
        name: "",
        password: "",
        loginFocus: false,
        passwordFocus: false,
      },
      signInResponse: {
        exist: "no data",
        access: "no data",
        admin: "no data",
        id: "no data",
      },
      signUpData: {
        name: "",
        mail: "",
        sex: "",
        password: "",
      },
      genders: null,
    };
  },
  created() {
    axios
      .get("http://localhost:8081/sex")
      .then((response) => {
        this.genders = response.data.sort((a, b) => a.id - b.id);
      })
      .catch((error) => console.log(error));
  },
  computed: {
    signUpFormCompleted() {
      return Object.values(this.signUpData).every((item) => item.length > 0);
    },
  },
  methods: {
    signIn(data) {
      axios
        .get(`http://localhost:8081/accounts/${data.name}/${data.password}`)
        .then((response) => {
          this.signInResponse = response.data;
        })
        .catch((error) => {
          console.log(error);
        })
        .finally(() => {
          data.name = "";
          data.password = "";
          this.signInDataValidation();
        });
    },
    signInDataValidation() {
      if (this.signInResponse.access) {
        console.log("access");
        this.$emit("signIn", this.signInResponse);
      }
    },
    singUp() {
      const requestBody = {};
      Object.assign(requestBody, this.signUpData);
      axios
        .post("http://localhost:8081/accounts", requestBody)
        .then((response) => {
          console.log(response);
          if (response.status === 200) {
            console.log("Successful!");
            this.signIn(this.signUpData);
          }
        })
        .catch((error) => console.log(error));
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

  .label {
    margin: 20px 0;
  }

  .input {
    width: 100%;
    margin: 5px 0;
  }

  .select {
    display: block;
    width: 100%;
    height: 30px;
    margin: 5px 0;
    outline: none;
    border: 1px solid black;
    border-radius: 3px;
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
