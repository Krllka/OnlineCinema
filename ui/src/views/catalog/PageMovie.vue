<template>
  <div class="container">
    <app-loader v-if="loading" :animation="'rectangle'" />
    <div v-else class="movie">
      <h2 class="movie__title">{{ movieData.name }}</h2>
      <div class="movie__body">
        <img
          v-if="!imgError"
          :src="`http://localhost:8080/products/files/${movieData.poster}`"
          :alt="movieData.name"
          class="movie__img"
          @error="imgError = !imgError"
        />
        <img
          v-else
          src="../../assets/images/default-placeholder.png"
          alt="Обложка не найдена"
          class="movie__img"
        />
        <div class="movie__info">
          <div class="movie__row">
            <div class="row__title">Дата выхода</div>
            <div class="row__value">{{ movieData.releseDate }}</div>
          </div>
          <div class="movie__row">
            <div class="row__title">Страна</div>
            <div class="row__value">
              {{ movieData.country }}
            </div>
          </div>
          <div class="movie__row">
            <div class="row__title">Жанр</div>
            <div class="row__value">
              {{ movieData.genres }}
            </div>
          </div>
          <div class="movie__row">
            <div class="row__title">Длительность</div>
            <div class="row__value">{{ movieData.durat }} мин</div>
          </div>
          <div class="movie__row">
            <div class="row__title">Возраст</div>
            <div class="row__value">
              {{ movieData.age_restr_id }}
            </div>
          </div>
          <div class="movie__row">
            <div class="row__title">Актеры</div>
            <div class="row__value">
              {{ movieData.actors }}
            </div>
          </div>
          <div class="movie__row">
            <div class="row__title">Награды</div>
            <div class="row__value">
              {{ movieData.awards }}
            </div>
          </div>
          <div class="movie__row">
            <div class="row__title">Рейтинг</div>
            <div class="row__value">{{ movieData.rate }}/10</div>
          </div>
        </div>
      </div>
      <div class="movie__description">
        <h4 class="description__title">Описание:</h4>
        <div class="description__value">{{ movieData.decription }}</div>
      </div>
      <div class="movie__trailer">
        <h4 class="trailer__title">Трейлер:</h4>
        <video
          v-if="!trailerError"
          controls
          controlsList="nodownload"
          width="640"
          height="480"
          @error="trailerError = !trailerError"
        >
          <source
            :src="`http://localhost:8080/products/files/${movieData.trailer}`"
            type="video/mp4"
          />
        </video>
        <div v-else class="message">Трейлера, к сожалению, нет :(</div>
      </div>
    </div>
  </div>
</template>

<script>
import AppLoader from "@/components/common/AppLoader";

export default {
  name: "PageMovie",
  components: {
    AppLoader,
  },
  data() {
    return {
      loading: true,
      imgError: false,
      trailerError: false,
      movieData: {},
    };
  },
  created() {
    this.axios
      .get(`http://localhost:8081/products/${this.$route.params.id}`)
      .then((response) => {
        this.movieData = response.data;
        this.movieData.genres = this.movieData.genres
          .map((genre) => genre.name)
          .join(", ");
        this.movieData.actors = this.movieData.actors
          .map((actor) => actor.name)
          .join(", ");
        this.movieData.awards = this.movieData.awards
          .map((award) => award.name)
          .join(", ");
        this.loading = false;
        console.log(this.movieData.trailer);
        document.title = this.movieData.name;
      })
      .catch((error) => console.log(error));
  },
};
</script>

<style scoped lang="scss">
.movie {
  &__title {
    margin-bottom: 15px;
  }
  &__body {
    display: flex;
    justify-content: space-between;
    border-bottom: 1px solid black;
    padding: 10px 0 30px;
    margin-bottom: 15px;
  }
  &__img {
    width: 300px;
  }
  &__trailer {
    margin-top: 40px;
    video {
      display: block;
      max-height: 300px;
      width: auto;
      margin: 20px auto;
    }
  }
  .trailer__title {
    text-align: center;
    font-size: 20px;
  }
  .message {
    text-align: center;
    margin: 25px auto;
    font-size: 20px;
    font-weight: 700;
  }
  &__info {
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    width: 50%;
  }
  &__row {
    display: flex;
    border-bottom: 1px solid rgba(0, 0, 0, 0.5);
    padding-bottom: 3px;
    font-size: 14px;
  }
  .row {
    &__title {
      width: 250px;
      color: rgba(0, 0, 0, 0.5);
    }
  }
  .description__title {
    margin-bottom: 5px;
    font-size: 20px;
  }
  .description__value {
    //font-size: 20px;
    padding: 5px;
  }
}
</style>