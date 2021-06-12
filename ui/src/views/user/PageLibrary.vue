<template>
  <div class="container">
    <div v-if="isAuthorized">
      <app-loader v-if="loading" :animation="'rectangle'" />
      <div v-else>
        <div v-if="renderLibraryMovies.length">
          <div class="library">
            <h2 class="header">Мои фильмы:</h2>
            <input
              type="search"
              class="input search"
              placeholder="Поиск фильмов..."
              v-model="search"
            />
          </div>
          <app-list
            v-if="renderLibraryMovies.length"
            :items="renderLibraryMovies"
            :filter="search"
            :is-item-in-library="true"
            :is-authorized="isAuthorized"
            @openItemPage="openMoviePage"
          />
        </div>
        <div v-else class="empty">Вы еще не приобрели ни одного фильма.</div>
      </div>
    </div>
    <div v-else class="message">
      <router-link to="/profile" class="link">Авторизируйтесь</router-link>,
      чтобы получить доступ к библиотеке.
    </div>
  </div>
</template>

<script>
import AppLoader from "@/components/common/AppLoader";
import AppList from "@/components/common/AppList";

export default {
  name: "PageLibrary",
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
      loading: true,
      search: "",
      moviesInLibrary: [],
    };
  },
  created() {
    document.title = "Библиотека";
    this.axios
      .get(`http://localhost:8081/library/movies/${this.userData.name}`)
      .then((response) => {
        this.moviesInLibrary = response.data;
        this.loading = false;
        // this.moviesInLibrary.forEach(
        //   (movie) =>
        //     (movie.genres = movie.genres.map((genre) => genre.name).join(", "))
        // );
      })
      .catch((error) => {
        console.log(error);
        this.loading = false;
      });
  },
  computed: {
    renderLibraryMovies() {
      return this.moviesInLibrary;
    },
  },
  methods: {
    openMoviePage(id) {
      console.log(id);
      this.$router.push({ path: `movies/${id}` });
    },
  },
};
</script>

<style scoped lang="scss">
.header {
  font-size: 20px;
}

.library {
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

.message {
  text-align: center;
  margin-top: 25vh;
  font-size: 20px;
}
</style>
