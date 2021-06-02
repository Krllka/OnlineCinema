<template>
  <div class="container">
    <app-login v-if="!isAuthorized" @signIn="signIn($event)" />
    <h3 v-else class="header">Привет, {{ userData.name }}</h3>
  </div>
</template>

<script>
// import axios from "axios";
import AppLogin from "@/components/AppLogin";

export default {
  name: "PageUserCabinet",
  components: {
    AppLogin,
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
    return {};
  },
  methods: {
    signIn(response) {
      this.$emit("signIn", response);
    },
  },
};
</script>

<style scoped lang="scss"></style>
