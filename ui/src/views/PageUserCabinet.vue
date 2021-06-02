<template>
  <div class="container">
    <app-login v-if="!isAuthorized" @signIn="signIn($event)" />
    <h3 v-else class="header">Привет, {{ userData.name }}</h3>
  </div>
</template>

<script>
import axios from "axios";
import AppLogin from "@/components/AppLogin";

export default {
  name: "PageUserCabinet",
  components: {
    AppLogin,
  },
  data() {
    return {
      isAuthorized: false,
      isAdmin: false,
      userId: null,
      userData: {},
    };
  },
  methods: {
    signIn(response) {
      this.isAuthorized = response.access;
      this.isAdmin = response.admin;
      this.userId = response.id;
      this.getPersonalData();
    },
    getPersonalData() {
      if (this.userId) {
        axios
          .get(`http://localhost:8081/accounts/${this.userId}`)
          .then((response) => (this.userData = response.data))
          .catch((error) => console.log(error));
      }
    },
  },
};
</script>

<style scoped lang="scss"></style>
