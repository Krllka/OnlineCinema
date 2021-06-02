<template>
  <div class="container">
    <app-login v-if="!isAuthorized" @signIn="signIn($event)" />
  </div>
</template>

<script>
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
    };
  },
  methods: {
    signIn(response) {
      this.isAuthorized = response.access;
      this.isAdmin = response.admin;
      this.userId = response.id;
    },
  },
};
</script>

<style scoped lang="scss"></style>
