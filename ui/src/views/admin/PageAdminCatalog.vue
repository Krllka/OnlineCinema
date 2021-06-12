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
      this.axios
        .get("http://localhost:8081/products")
        .then((response) => {
          this.moviesList = response.data;
          this.loading = false;
        })
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
    },
    addMovie(movieData) {
      console.log(movieData);
      this.axios
        .post("http://localhost:8081/products", movieData)
        .then(() => {
          this.moviesList.push(movieData);
          // console.log(this.moviesList);
          // console.log(movieData);
        })
        .catch((error) => console.log(error));
      this.getMoviesList();
      this.closeModalWindow();
      this.loading = true;
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
      console.log(movieData);
      this.axios
        .put(`http://localhost:8081/products/${this.currentMovieId}`, movieData)
        .then(() => {
          let movieIndex = this.moviesList.findIndex(
            (movie) => movie.id === this.currentMovieId
          );
          this.moviesList.splice(movieIndex, 1, movieData);
        })
        .catch((error) => console.log(error));
      this.getMoviesList();
      this.currentMovieId = 0;
      this.editMode = false;
      this.closeModalWindow();
      this.loading = true;
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
