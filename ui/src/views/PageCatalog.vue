<template>
  <div class="container">
    <app-loader v-if="loading" :animation="'rectangle'" />
    <div v-else>
      <h2 v-if="moviesList.length" class="header">
        Каталог фильмов и сериалов:
      </h2>
      <div v-else-if="!moviesList" class="empty">
        Каталог пуст! Зайдите позже.
      </div>
      <app-list v-if="moviesList" :items="moviesList" />
    </div>
  </div>
</template>

<script>
import AppList from "@/components/AppList";
import AppLoader from "@/components/AppLoader";

export default {
  name: "PageCatalog",
  components: {
    AppList,
    AppLoader,
  },
  data() {
    return {
      moviesList: [],
      loading: true,
    };
  },
  created() {
    document.title = "Каталог";
    this.axios
      .get("http://localhost:8081/products")
      .then((response) => {
        this.moviesList = response.data;
        this.loading = false;
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
  margin-top: 40vh;
  font-size: 32px;
  text-align: center;
}
</style>
