<template>
  <div class="container">
    <app-login v-if="!isAuthorized" @signIn="signIn($event)" />
    <div v-else>
      <app-loader
        v-if="!Object.keys(userData).length"
        :animation="'rectangle'"
      />
      <app-user-profile
        v-else
        :userData="getUserInfo"
        @showAdminPanel="$emit('showAdminPanel')"
        @logOut="logOut"
        @changeUserData="openChangeUserDataWindow"
        @changeUserPassword="openChangeUserPasswordWindow"
      />
      <app-modal-window
        v-if="isModalVisibleForData"
        :width-content="true"
        @closeModalWindow="closeModalWindowData"
      >
        <template #title>Личные данные</template>
        <template #body>
          <app-input
            :input-type="'text'"
            :input-disabled="true"
            :input-title="'Имя'"
            :is-width-parent="true"
            v-model="userDataEdit.name"
          />
          <app-input
            :input-type="'text'"
            :input-title="'Эл. почта'"
            :is-width-parent="true"
            v-model="userDataEdit.mail"
          />
          <div class="select-wrapper">
            <p class="title">Пол</p>
            <v-select
              label="name"
              :options="genders"
              :reduce="(genders) => genders.id"
              v-model="userDataEdit.sex"
            />
          </div>
          <app-input
            :input-type="'date'"
            :input-title="'Дата рождения'"
            :is-width-parent="true"
            v-model="userDataEdit.age"
          />
          <div class="btn-group">
            <button class="button" @click="clearInput">Сброс</button>
            <button class="button" @click="submitUserData">Сохранить</button>
          </div>
        </template>
      </app-modal-window>
      <app-modal-window
        v-if="isModalVisibleForPass"
        :width-content="true"
        @closeModalWindow="closeModalWindowPass"
      >
        <template #title>Смена пароля</template>
        <template #body>
          <app-input
            :input-type="'password'"
            :input-title="'Введите текущий пароль'"
            :is-width-parent="true"
            v-model="oldPassword"
          />
          <app-input
            :input-type="'password'"
            :input-title="'Введите новый пароль'"
            :is-width-parent="true"
            v-model="newPassword"
          />
          <app-input
            :input-type="'password'"
            :input-title="'Подтвердите новый пароль'"
            :is-width-parent="true"
            v-model="confirmedPassword"
          />
          <div class="btn-group">
            <button @click="submitUserPassword" class="button">
              Сохранить
            </button>
            <div v-if="passwordError" class="error">
              Ошибка! Данные не совпадают
            </div>
          </div>
        </template>
      </app-modal-window>
    </div>
  </div>
</template>

<script>
import AppLogin from "@/components/layouts/AppLogin";
import AppUserProfile from "@/components/layouts/AppUserProfile";
import AppLoader from "@/components/common/AppLoader";
import AppModalWindow from "@/components/modal/AppModalWindow";
import AppInput from "@/components/input/AppInput";

export default {
  name: "PageUserCabinet",
  components: {
    AppInput,
    AppModalWindow,
    AppLogin,
    AppUserProfile,
    AppLoader,
  },
  props: {
    isAuthorized: {
      type: Boolean,
      default: false,
    },
    userData: {
      type: Object,
      default: () => {},
    },
    isAdmin: {
      type: Boolean,
      default: false,
    },
  },
  data() {
    return {
      isModalVisibleForData: false,
      isModalVisibleForPass: false,
      oldPassword: "",
      newPassword: "",
      confirmedPassword: "",
      passwordError: false,
      userDataEdit: {
        name: "",
        mail: "",
        sex: "",
        age: "",
        password: "",
        admin: this.isAdmin,
      },
      genders: [],
    };
  },
  created() {
    document.title = "Личный кабинет";
  },
  computed: {
    getUserInfo() {
      return this.userData;
    },
  },
  methods: {
    signIn(response) {
      this.$emit("signIn", response);
    },
    fillUserData() {
      this.userDataEdit.name = this.userData.name;
      this.userDataEdit.mail = this.userData.mail;
      this.userDataEdit.sex = this.userData.Sex.id;
      this.userDataEdit.age = this.userData.age;
      this.userDataEdit.password = this.userData.password;
      this.userDataEdit.admin = this.userData.admin;
    },
    openChangeUserDataWindow() {
      this.isModalVisibleForData = true;
      this.fillUserData();
      this.axios
        .get("http://localhost:8081/sex")
        .then((response) => (this.genders = response.data))
        .catch((error) => console.log(error));
    },
    openChangeUserPasswordWindow() {
      this.isModalVisibleForPass = true;
    },
    closeModalWindowData() {
      this.isModalVisibleForData = false;
    },
    closeModalWindowPass() {
      this.isModalVisibleForPass = false;
      this.oldPassword = "";
      this.newPassword = "";
      this.confirmedPassword = "";
      this.passwordError = false;
    },
    clearInput() {
      this.userDataEdit.age = "";
      this.userDataEdit.mail = "";
      this.userDataEdit.sex = "";
    },
    submitUserData() {
      console.log(this.userDataEdit);
      this.axios
        .put(
          `http://localhost:8081/accounts/${this.userData.id}`,
          this.userDataEdit
        )
        .then((response) => console.log(response))
        .catch((error) => console.log(error));
      this.closeModalWindowData();
      this.axios
        .get(`http://localhost:8081/accounts/${this.userData.id}`)
        .then((response) => this.$emit("updateUserData", response.data))
        .catch((error) => console.log(error));
    },
    submitUserPassword() {
      if (
        this.oldPassword === this.userData.password &&
        this.newPassword === this.confirmedPassword
      ) {
        this.passwordError = false;
        this.fillUserData();
        this.userDataEdit.password = this.newPassword;
        console.log(this.userDataEdit);
        this.axios
          .put(
            `http://localhost:8081/accounts/${this.userData.id}`,
            this.userDataEdit
          )
          .then((response) => console.log(response))
          .catch((error) => console.log(error));
        this.oldPassword = "";
        this.newPassword = "";
        this.confirmedPassword = "";
        this.closeModalWindowPass();
        this.axios
          .get(`http://localhost:8081/accounts/${this.userData.id}`)
          .then((response) => this.$emit("updateUserData", response.data))
          .catch((error) => console.log(error));
      } else {
        this.passwordError = true;
      }
    },
    logOut() {
      Object.keys(this.userDataEdit).forEach(
        (key) => (this.userDataEdit[key] = "")
      );
      this.$emit("logOut");
    },
  },
};
</script>

<style scoped lang="scss">
.title {
  margin-bottom: 5px;
  font-size: 15px;
}

.select-wrapper {
  margin-bottom: 15px;
}

.error {
  font-size: 15px;
  color: red;
}

.btn-group {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-top: 30px;
}
</style>
