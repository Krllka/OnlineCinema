<template>
  <div>
    <the-header />
    <div class="container">
      <app-list :items="moviesList" :isAdmin="isAdmin" />
    </div>
  </div>
</template>

<script>
import TheHeader from "@/components/TheHeader";
import AppList from "@/components/AppList";
import axios from "axios";

export default {
  name: "PageCatalog",
  components: { AppList, TheHeader },
  data() {
    return {
      moviesList: null,
      isAdmin: true,
    };
  },
  created() {
    document.title = "Каталог фильмов";
    axios
      .get("http://localhost:8080/products")
      .then((response) => {
        this.moviesList = response.data;
      })
      .catch((error) => console.log(error));
  },
};
</script>

<style scoped></style>
