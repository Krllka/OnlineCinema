<template>
  <div class="form">
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
          v-model="movieData.rate"
        />
        <app-input
          :input-title="'Страна'"
          :input-type="'text'"
          v-model="movieData.country"
        />
        <app-select
          :select-title="'Возрастное ограничение'"
          :select-options="ratings"
          v-model="movieData.age_restr_id"
          @change="selectOption"
        />
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
        v-model="movieData.decription"
      ></textarea>
    </div>
    <div class="button-wrapper">
      <button class="button clear" type="reset">Сброс</button>
      <button class="button submit" @click="addMovie">Сохранить</button>
    </div>
  </div>
</template>

<script>
import AppInput from "@/components/AppInput";
import AppSelect from "@/components/AppSelect";

export default {
  name: "AppMovieForm",
  components: {
    AppInput,
    AppSelect,
  },
  data() {
    return {
      ratings: [],
      genres: [],
      actors: [],
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
  created() {
    this.axios
      .get("http://localhost:8081/age_restriction")
      .then((response) => (this.ratings = response.data))
      .catch((error) => console.log(error));
    this.axios
      .get("http://localhost:8081/genre")
      .then((response) => (this.genres = response.data))
      .catch((error) => console.log(error));
    this.axios
      .get("http://localhost:8081/prodBy")
      .then((response) => (this.actors = response.data))
      .catch((error) => console.log(error));
  },
  methods: {
    selectOption(value) {
      this.movieData.age_restr_id = value;
    },
    addFilePoster(event) {
      this.filePoster = event.target.files[0];
      this.movieData.poster = this.filePoster.name;
    },
    addFileTrailer(event) {
      this.fileTrailer = event.target.files[0];
      this.movieData.trailer = this.filePoster.name;
    },
    addFileMovie(event) {
      this.fileMovie = event.target.files[0];
    },
    addMovie() {
      this.$emit("addMovie", this.movieData);
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

.button-wrapper {
  display: flex;
  justify-content: space-between;
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
