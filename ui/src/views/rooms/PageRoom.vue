<template>
  <div class="container">
    <app-loader v-if="loading" :animation="'rectangle'" />
    <div v-else>
      <h2 class="room__title">{{ roomData.name }}</h2>
      <div class="movie__title">{{ movieData.name }}</div>
      <div class="movie__video">
        <video
          v-if="movieData.mainFile"
          controls
          controlsList="nodownload"
          width="640"
          height="480"
          @error="videoError = !videoError"
        >
          <source
            :src="`http://localhost:8080/products/files/${movieData.mainFile}`"
            type="video/mp4"
          />
        </video>
        <div v-else class="message">Фильм не найден.</div>
      </div>
    </div>
  </div>
</template>

<script>
import AppLoader from "@/components/common/AppLoader";
export default {
  name: "PageRoom",
  components: { AppLoader },
  data() {
    return {
      roomData: {},
      movieData: {},
      videoError: false,
      loading: true,
    };
  },
  created() {
    this.axios
      .get(`http://localhost:8081/room/${this.$route.params.id}`)
      .then((response) => {
        this.roomData = response.data;
        this.getMovie(this.roomData.prod);
      })
      .catch((error) => console.log(error));
  },
  methods: {
    getMovie(id) {
      this.axios
        .get(`http://localhost:8081/products/${id}`)
        .then((response) => {
          this.movieData = response.data;
          console.log(this.movieData.mainFile);
          this.loading = false;
        })
        .catch((error) => {
          console.log(error);
          this.loading = false;
        });
    },
  },
};
</script>

<style scoped lang="scss">
.room__title {
  margin-top: 20px;
  text-align: center;
}
.movie__title {
  text-align: center;
  margin-top: 20px;
  font-size: 20px;
}
.movie__video {
  video {
    display: block;
    max-height: 300px;
    width: auto;
    margin: 20px auto;
  }
}
.message {
  text-align: center;
  margin: 25px auto;
  font-size: 20px;
  font-weight: 700;
}
</style>
