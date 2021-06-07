<template>
  <form class="form">
    <label class="label">
      Название:
      <input type="text" class="input" v-model="movieData.name" />
    </label>
    <label class="label">
      Дата производства:
      <input type="date" class="input" />
    </label>
  </form>
</template>

<script>
export default {
  name: "AppMovieForm",
  data() {
    return {
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
      },
    };
  },
};
</script>

<style scoped lang="scss">
.label,
.input {
  display: block;
}
.label {
  margin-bottom: 10px;
}

.input {
  margin: 5px 0;
  width: 170px;
}
</style>
