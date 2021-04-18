<template>
  <div>
    <button @click="$router.push('/')">На главную</button>
    <h2>Каталог фильмов</h2>
  </div>
</template>

<script>
import axios from "axios";
export default {
  name: "Catalog",
  created() {
    axios
      .get("http://localhost:8080/accounts")
      .then((response) => console.log(response.data))
      .catch((error) => {
        if (!error.response) {
          // network error
          this.errorStatus = "Error: Network Error";
        } else {
          this.errorStatus = error.response.data.message;
        }
      });
  },
};
</script>

<style scoped>
h2 {
  /*margin-top: 200px;*/
}
button {
  margin: 0 auto;
  display: block;
  width: 130px;
  height: 50px;
  cursor: pointer;
}
</style>
