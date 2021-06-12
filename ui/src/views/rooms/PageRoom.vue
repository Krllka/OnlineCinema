<template>
  <div class="container">
    <h2 class="title">{{ roomData.name }}</h2>
    <div>{{ movieData.name }}</div>
  </div>
</template>

<script>
export default {
  name: "PageRoom",
  data() {
    return {
      roomData: {},
      movieData: {},
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
        })
        .catch((error) => console.log(error));
    },
  },
};
</script>

<style scoped lang="scss"></style>
