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
        :userData="userData"
        @showAdminPanel="$emit('showAdminPanel')"
        @logOut="$emit('logOut')"
      />
    </div>
  </div>
</template>

<script>
import AppLogin from "@/components/AppLogin";
import AppUserProfile from "@/components/AppUserProfile";
import AppLoader from "@/components/AppLoader";

export default {
  name: "PageUserCabinet",
  components: {
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
  created() {
    document.title = "Личный кабинет";
  },
  methods: {
    signIn(response) {
      this.$emit("signIn", response);
    },
  },
};
</script>

<style scoped lang="scss"></style>
