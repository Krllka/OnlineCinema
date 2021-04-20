<template>
  <div>
    <the-header />
    <div class="container">
      <app-list :items="moviesList" />
    </div>
  </div>
</template>

<script>
import TheHeader from "@/components/TheHeader";
import axios from "axios";
import AppList from "@/components/AppList";

export default {
  name: "PageCatalog",
  components: { AppList, TheHeader },
  data() {
    return {
      moviesList: null,
    };
  },
  created() {
    document.title = "Каталог фильмов";
    axios.get("http://localhost:8080/products").then((response) => {
      this.moviesList = response.data;
    });
  },
};
</script>

<style scoped></style>
