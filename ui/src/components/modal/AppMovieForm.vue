<template>
  <div class="form">
    <app-loader v-if="loading" :animation="'rectangle'" />
    <div v-else>
      <div class="input-group">
        <div class="input-row">
          <app-input
            :input-title="'Название фильма'"
            :input-type="'text'"
            v-model="movieData.name"
          />

          <div class="select-wrapper">
            <p class="title">Жанр:</p>
            <v-select
              multiple
              label="name"
              :options="genres"
              class="select"
              v-model="movieData.genres"
            />
          </div>

          <app-input
            :input-title="'Дата выхода'"
            :input-type="'date'"
            v-model="movieData.releseDate"
          />

          <app-input
            :input-title="'Длительность'"
            :input-type="'number'"
            v-model="movieData.durat"
          />

          <app-input
            :input-title="'Цена'"
            :input-type="'number'"
            v-model="movieData.price"
          />
        </div>
        <div class="input-row">
          <app-input
            :input-title="'Рейтинг'"
            :input-type="'number'"
            :input-min-value="0"
            :input-max-value="10"
            v-model="movieData.rate"
          />

          <app-input
            :input-title="'Страна'"
            :input-type="'text'"
            v-model="movieData.country"
          />

          <div class="select-wrapper">
            <p class="title">Возрастное ограничение:</p>
            <v-select
              label="name"
              :options="agesData"
              :reduce="(agesData) => agesData.id"
              class="select"
              v-model="movieData.age_restr_id"
            />
          </div>

          <div class="select-wrapper">
            <p class="title">Актеры:</p>
            <v-select
              multiple
              label="name"
              :options="actors"
              class="select"
              v-model="movieData.actors"
            />
          </div>

          <div class="select-wrapper">
            <p class="title">Награды:</p>
            <v-select
              multiple
              label="name"
              :options="awards"
              class="select"
              v-model="movieData.awards"
            />
          </div>

          <app-input
            :input-title="'Количество просмотров'"
            :input-type="'number'"
            v-model="movieData.viewsCount"
          />
        </div>
        <div class="input-row">
          <div class="input-wrapper">
            <p class="title">Обложка фильма:</p>
            <input type="file" @change="addFilePoster" />
          </div>
          <div class="input-wrapper">
            <p class="title">Трейлер:</p>
            <input type="file" @change="addFileTrailer" />
          </div>
          <div class="input-wrapper">
            <p class="title">Видеодорожка:</p>
            <input type="file" @change="addFileMovie" />
          </div>
        </div>
      </div>
      <div class="textarea-wrapper">
        <p class="title">Описание фильма:</p>
        <textarea
          class="textarea input"
          maxlength="120"
          v-model="movieData.decription"
        ></textarea>
      </div>
      <button v-if="!editMode" class="button submit" @click="addMovie">
        Сохранить
      </button>
      <button v-else class="button submit" @click="editMovie">Сохранить</button>
    </div>
  </div>
</template>

<script>
import AppInput from "@/components/input/AppInput";
// import AppSelect from "@/components/input/AppSelect";
import AppLoader from "@/components/common/AppLoader";

export default {
  name: "AppMovieForm",
  components: {
    AppLoader,
    AppInput,
  },
  props: {
    editMovieData: {
      type: Object,
      default: () => {},
    },
    agesData: {
      type: Array,
      default: () => [],
    },
    editMode: {
      type: Boolean,
      default: false,
    },
  },
  data() {
    return {
      loading: true,
      ratings: [],
      genres: [],
      actors: [],
      awards: [],
      filePoster: null,
      fileTrailer: null,
      fileMovie: null,
      movieData: {
        id: "",
        name: "",
        releseDate: "",
        durat: "",
        age_restr_id: "",
        viewsCount: "",
        trailer: "",
        mainFiles: "",
        country: "",
        decription: "",
        poster: "",
        price: "",
        rate: "",
        genres: [],
        actors: [],
        awards: [],
      },
    };
  },
  watch: {
    editMovieData(movie) {
      const ageId = this.agesData.find(
        (item) => item.name === movie.age_restr_id
      );
      movie.actors.forEach((actor) => (actor.prof = actor.prof.id));
      this.movieData.id = movie.id;
      this.movieData.age_restr_id = ageId.id;
      this.movieData.name = movie.name;
      this.movieData.releseDate = movie.releseDate;
      this.movieData.durat = String(movie.durat);
      this.movieData.viewsCount = String(movie.viewsCount);
      this.movieData.trailer = movie.trailer;
      this.movieData.country = movie.country;
      this.movieData.decription = movie.decription;
      this.movieData.poster = movie.poster;
      this.movieData.price = String(movie.price);
      this.movieData.rate = String(movie.rate);
      this.movieData.genres = movie.genres;
      this.movieData.actors = movie.actors;
      this.movieData.awards = movie.awards;
    },
  },
  created() {
    const ratingsURL = this.axios.get("http://localhost:8081/age_restriction");
    const genresURL = this.axios.get("http://localhost:8081/genre");
    const actorsURL = this.axios.get("http://localhost:8081/actors");
    const awardsURL = this.axios.get("http://localhost:8081/awards");
    this.axios
      .all([ratingsURL, genresURL, actorsURL, awardsURL])
      .then(
        this.axios.spread((ratingsRes, genresRes, actorsRes, awardsRes) => {
          this.ratings = ratingsRes.data;
          this.genres = genresRes.data;
          this.actors = actorsRes.data;
          this.awards = awardsRes.data;
          this.actors.forEach((actor) => (actor.prof = actor.prof.id));
          this.loading = false;
        })
      )
      .catch((errors) => {
        console.log(errors);
        this.loading = false;
      });
  },
  methods: {
    selectOption(value) {
      this.movieData.age_restr_id = value;
    },
    addFilePoster(event) {
      this.filePoster = event.target.files[0];
      this.movieData.poster = this.filePoster.name;
      this.$emit("submitFile", this.filePoster);
    },
    addFileTrailer(event) {
      this.fileTrailer = event.target.files[0];
      this.movieData.trailer = this.fileTrailer.name;
      this.$emit("submitFile", this.fileTrailer);
    },
    addFileMovie(event) {
      this.fileMovie = event.target.files[0];
      this.movieData.mainFiles = this.fileMovie.name;
      this.$emit("submitFile", this.fileMovie);
    },
    addMovie() {
      this.$emit("addMovie", this.movieData);
    },
    editMovie() {
      this.$emit("updateMovie", this.movieData);
    },
  },
};
</script>

<style scoped lang="scss">
.input-group {
  display: flex;
  justify-content: space-between;
}

.input-row {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
}

.select {
  width: 170px;
  &:focus {
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
  }
}

.textarea-wrapper {
  margin-bottom: 15px;
}

.textarea {
  width: 100%;
  resize: none;
  height: 150px;
  border: 1px solid rgba(60, 60, 60, 0.26);
  &:focus {
    box-shadow: none;
  }
}

.select-wrapper,
.input-wrapper {
  margin-bottom: 15px;
}
.title {
  margin-bottom: 5px;
  font-size: 15px;
}
</style>
