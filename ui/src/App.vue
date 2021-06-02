<template>
  <div id="app">
    <the-header
      :isAdmin="isAdmin"
      :isAdminPanel="isAdminPanel"
      @hideAdminPanel="isAdminPanel = false"
    ></the-header>
    <router-view
      :isAuthorized="isAuthorized"
      :userData="userData"
      :isAdmin="isAdmin"
      @signIn="signIn($event)"
      @logOut="logOut"
      @showAdminPanel="isAdminPanel = true"
    ></router-view>
  </div>
</template>

<script>
import TheHeader from "@/components/TheHeader";
import axios from "axios";

export default {
  name: "App",
  components: {
    TheHeader,
  },
  data() {
    return {
      isAuthorized: false,
      isAdmin: false,
      isAdminPanel: false,
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
    logOut() {
      this.isAuthorized = false;
      this.isAdmin = false;
      this.userId = null;
      this.userData = {};
      this.$router.push("/");
    },
  },
};
</script>
