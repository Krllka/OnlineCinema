<template>
  <div class="container">
    <app-login v-if="!isAuthorized" @signIn="signIn($event)" />
    <app-user-profile v-else :userData="userData" @logOut="$emit('logOut')" />
  </div>
</template>

<script>
// import axios from "axios";
import AppLogin from "@/components/AppLogin";
import AppUserProfile from "@/components/AppUserProfile";

export default {
  name: "PageUserCabinet",
  components: {
    AppLogin,
    AppUserProfile,
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
