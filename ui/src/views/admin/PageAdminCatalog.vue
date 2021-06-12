<template>
  <div class="container">
    <div v-if="!isAdmin" class="message">Доступ запрещен.</div>
    <div v-else>
      <app-loader v-if="loading" :animation="'rectangle'" />
      <div v-else>
        <div class="panel">
          <button class="button add" @click="openModalWindow">
            Добавить фильм
          </button>
          <input
            type="search"
            class="input search"
            placeholder="Поиск фильмов..."
            v-model="search"
          />
        </div>
        <app-data-table
          :dataHeaders="moviesData"
          :dataList="renderMovies"
          :filter="search"
          @clickTableItem="editMovie"
          @deleteItem="deleteMovie"
        />
        <app-modal-window
          v-if="isModalVisible"
          @closeModalWindow="closeModalWindow"
        >
          <template #title>{{
            editMode ? "Редактировать фильм" : "Добавить фильм"
          }}</template>
          <template #body>
            <app-movie-form
              @addMovie="addMovie"
              @updateMovie="updateMovie"
              @submitFile="submitFile"
              :edit-mode="editMode"
              :edit-movie-data="movieData"
              :ages-data="agesList"
            />
          </template>
        </app-modal-window>
      </div>
    </div>
  </div>
</template>

<script>
import AppDataTable from "@/components/common/AppDataTable";
import AppLoader from "@/components/common/AppLoader";
import AppModalWindow from "@/components/modal/AppModalWindow";
import AppMovieForm from "@/components/modal/AppMovieForm";

export default {
  name: "PageAdminCatalog",
  components: {
    AppDataTable,
    AppLoader,
    AppModalWindow,
    AppMovieForm,
  },
  props: {
    isAdmin: {
      type: Boolean,
      default: false,
    },
  },
  data() {
    return {
      search: "",
      loading: true,
      editMode: false,
      currentMovieId: 0,
      isModalVisible: false,
      moviesList: [],
      agesList: [],
      movieData: {},
      moviesData: [
        {
          key: "name",
          value: "Название фильма",
        },
        {
          key: "id",
          value: "ID фильма",
        },
        {
          key: "releseDate",
          value: "Год релиза",
        },
        {
          key: "durat",
          value: "Продолжительность",
        },
        {
          key: "age_restr_id",
          value: "Возрастное ограничение",
        },
        {
          key: "viewsCount",
          value: "Просмотры",
        },
        {
          key: "rate",
          value: "Оценка",
        },
        {
          key: "price",
          value: "Цена",
        },
      ],
    };
  },
  created() {
    document.title = "Управление каталогом";
    this.getMoviesList();
  },
  computed: {
    renderMovies() {
      return this.moviesList;
    },
  },
  methods: {
    getMoviesList() {
      const movies = this.axios.get("http://localhost:8081/products");
      const ages = this.axios.get("http://localhost:8081/age_restriction");
      this.axios
        .all([movies, ages])
        .then(
          this.axios.spread((moviesRes, agesRes) => {
            this.moviesList = moviesRes.data;
            this.agesList = agesRes.data;
            this.loading = false;
          })
        )
        .catch((error) => {
          console.log(error);
          this.moviesList = 0;
          this.loading = false;
        });
    },
    openModalWindow() {
      this.isModalVisible = true;
    },
    closeModalWindow() {
      this.isModalVisible = false;
      this.editMode = false;
      this.movieData = {};
    },
    addMovie(movieData) {
      this.axios
        .post("http://localhost:8081/products", movieData)
        .then(() => {
          movieData.id = +this.moviesList[this.moviesList.length - 1].id + 1;
          const age = this.agesList.find(
            (item) => item.id === movieData.age_restr_id
          );
          movieData.age_restr_id = age.name;
          this.moviesList.push(movieData);
        })
        .catch((error) => console.log(error));
      // this.getMoviesList();
      this.closeModalWindow();
      // this.loading = true;
    },
    editMovie(id) {
      this.editMode = true;
      this.axios
        .get(`http://localhost:8081/products/${id}`)
        .then((response) => (this.movieData = response.data));
      this.isModalVisible = true;
      this.currentMovieId = id;
    },
    updateMovie(movieData) {
      this.axios
        .put(`http://localhost:8081/products/${this.currentMovieId}`, movieData)
        .then(() => {
          let movieIndex = this.moviesList.findIndex(
            (movie) => movie.id === this.currentMovieId
          );
          const age = this.agesList.find(
            (item) => item.id === movieData.age_restr_id
          );
          movieData.age_restr_id = age.name;
          this.moviesList.splice(movieIndex, 1, movieData);
        })
        .catch((error) => console.log(error))
        .finally(() => (this.currentMovieId = 0));
      // this.getMoviesList();
      this.editMode = false;
      this.closeModalWindow();
      // this.loading = true;
    },
    deleteMovie(movie) {
      this.axios
        .delete(`http://localhost:8081/products/${movie.id}`)
        .then(() => {
          let movieIndex = this.moviesList.findIndex(
            (item) => item.id === movie.id
          );
          this.moviesList.splice(movieIndex, 1);
        })
        .catch((error) => console.log(error));
    },
    submitFile(file) {
      const formData = new FormData();
      formData.append("file", file);
      this.axios
        .post("http://localhost:8081/products/add", formData, {
          headers: { "Content-Type": "multipart/form-data" },
        })
        .then((response) => console.log(response))
        .catch((error) => console.log(error));
    },
  },
};
</script>

<style scoped lang="scss">
.input {
  margin-left: 50px;
}
.add {
  &:hover:enabled {
    background-color: green;
  }
}

.message {
  margin-top: 25vh;
  text-align: center;
  font-size: 30px;
  font-weight: 700;
}
</style>
