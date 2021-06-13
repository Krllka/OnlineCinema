<template>
  <div class="container">
    <h2 class="room__title">{{ roomData.name }}</h2>
    <div class="movie__title">{{ movieData.name }}</div>
    <div class="movie__video">
      <video
        v-if="!videoError"
        controls
        controlsList="nodownload"
        width="640"
        height="480"
        @error="videoError = !videoError"
      >
        <source
          type="video/mp4"
          :src="`http://localhost:8080/products/files/${videoData.filePath}`"
        />
      </video>
      <div v-else class="message">Фильм не найден.</div>
    </div>
  </div>
</template>

<script>
export default {
  name: "PageRoom",
  data() {
    return {
      roomData: {},
      movieData: {},
      videoData: {},
      videoError: false,
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
      const movieURL = this.axios.get(`http://localhost:8081/products/${id}`);
      const videoURL = this.axios.get(`http://localhost:8081/mainFiles/${id}`);
      this.axios
        .all([movieURL, videoURL])
        .then(
          this.axios.spread((movieRes, videoRes) => {
            this.movieData = movieRes.data;
            this.videoData = videoRes.data;
          })
        )
        .catch((error) => {
          console.log(error);
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
