<template>
  <div class="container">
    <h2 v-if="moviesList.length" class="header">Каталог фильмов и сериалов:</h2>
    <span v-else-if="!moviesList" class="empty"
      >Каталог пуст. Зайдите позже</span
    >
    <app-list :items="moviesList" />
  </div>
</template>

<script>
import axios from "axios";
import AppList from "@/components/AppList";

export default {
  name: "PageCatalog",
  components: {
    AppList,
  },
  data() {
    return {
      moviesList: [],
    };
  },
  created() {
    document.title = "Онлайн-кинотеатр | Каталог";
    axios
      .get("https://online-kino.herokuapp.com/products")
      .then((response) => {
        this.moviesList = response.data;
      })
      .catch((error) => {
        console.log(error);
        this.moviesList = 0;
      });
  },
};
</script>

<style scoped lang="scss">
.header {
  margin-bottom: 30px;
}

.empty {
  text-align: center;
}
</style>
