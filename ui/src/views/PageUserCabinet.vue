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
        @logOut="$emit('logOut')"
        @changeUserData="changeUserData"
      />
      <app-modal-window
        v-if="isModalVisible"
        @closeModalWindow="closeModalWindow"
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
    </div>
  </div>
</template>

<script>
import AppLogin from "@/components/AppLogin";
import AppUserProfile from "@/components/AppUserProfile";
import AppLoader from "@/components/AppLoader";
import AppModalWindow from "@/components/AppModalWindow";
import AppInput from "@/components/AppInput";

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
      isModalVisible: false,
      userDataEdit: {
        name: "",
        mail: "",
        sex: "",
        age: "",
        password: "",
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
    changeUserData() {
      this.isModalVisible = true;
      this.userDataEdit.name = this.userData.name;
      this.userDataEdit.mail = this.userData.mail;
      this.userDataEdit.sex = this.userData.Sex.id;
      this.userDataEdit.age = this.userData.age;
      this.userDataEdit.password = this.userData.password;
      this.axios
        .get("http://localhost:8081/sex")
        .then((response) => (this.genders = response.data))
        .catch((error) => console.log(error));
    },
    closeModalWindow() {
      this.isModalVisible = false;
    },
    clearInput() {
      this.userDataEdit.age = "";
      this.userDataEdit.mail = "";
      this.userDataEdit.sex = "";
    },
    submitUserData() {
      // delete this.userDataEdit.name;
      // delete this.userDataEdit.password;
      console.log(this.userDataEdit);
      this.axios
        .put(
          `http://localhost:8081/accounts/${this.userData.id}`,
          this.userDataEdit
        )
        .then((response) => console.log(response))
        .catch((error) => console.log(error));
      this.closeModalWindow();
      this.axios
        .get(`http://localhost:8081/accounts/${this.userData.id}`)
        .then((response) => this.$emit("updateUserData", response.data))
        .catch((error) => console.log(error));
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

.btn-group {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-top: 30px;
}
</style>
