<template>
  <div id="app">
    <the-header></the-header>
    <router-view
      :isAuthorized="isAuthorized"
      :userData="userData"
      :isAdmin="isAdmin"
      @signIn="signIn($event)"
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
