<template>
  <div class="container">
    <app-loader v-if="loading" :animation="'rectangle'" />
    <div v-else>
      <div v-if="moviesList.length" class="catalog">
        <h2 class="header">Каталог фильмов:</h2>
        <input
          type="search"
          class="input search"
          placeholder="Поиск фильмов..."
          v-model="search"
        />
      </div>
      <div v-else-if="!moviesList" class="empty">
        Каталог пуст! Зайдите позже.
      </div>
      <app-list
        v-if="moviesList"
        :items="moviesList"
        :filter="search"
        :isAuthorized="isAuthorized"
        @openItemPage="openMoviePage"
        @addToCart="addToCart"
      />
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
  props: {
    isAuthorized: {
      type: Boolean,
      default: false,
    },
    userData: {
      type: Object,
      default: () => {},
    },
  },
  data() {
    return {
      moviesList: [],
      search: "",
      loading: true,
    };
  },
  created() {
    document.title = "Каталог";
    this.axios
      .get("http://localhost:8081/products")
      .then((response) => {
        this.moviesList = response.data;
        this.moviesList.forEach(
          (movie) =>
            (movie.genres = movie.genres.map((genre) => genre.name).join(", "))
        );
        this.loading = false;
      })
      .catch((error) => {
        console.log(error);
        this.moviesList = 0;
      });
  },
  methods: {
    openMoviePage(id) {
      console.log(id);
      this.$router.push({ path: `movies/${id}` });
    },
    addToCart(id) {
      const requestBody = {
        product: id,
        client: this.userData.id,
      };
      this.axios
        .post("http://localhost:8081/library", requestBody)
        .then((response) => console.log(response))
        .catch((error) => console.log(error));
    },
  },
};
</script>

<style scoped lang="scss">
.catalog {
  margin-bottom: 30px;
}

.header {
  margin-bottom: 15px;
}

.empty {
  margin-top: 40vh;
  font-size: 32px;
  text-align: center;
}
</style>
