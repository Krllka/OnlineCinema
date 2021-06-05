<template>
  <div class="container">
    <app-loader v-if="loading" :animation="'rectangle'" />
    <div v-else>
      <div class="panel">
        <button class="button add">Добавить фильм</button>
        <input
          type="search"
          class="input search"
          placeholder="Поиск фильмов..."
          v-model="search"
        />
      </div>
      <app-data-table
        :dataHeaders="moviesData"
        :dataList="moviesList"
        :filter="search"
      />
    </div>
  </div>
</template>

<script>
import AppDataTable from "@/components/AppDataTable";
import AppLoader from "@/components/AppLoader";
import axios from "axios";

export default {
  name: "PageAdminCatalog",
  components: {
    AppDataTable,
    AppLoader,
  },
  data() {
    return {
      search: "",
      loading: true,
      moviesList: [],
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
    axios
      .get("http://localhost:8081/products")
      .then((response) => {
        this.moviesList = response.data;
        this.loading = false;
      })
      .catch((error) => {
        console.log(error);
        this.moviesList = 0;
      });
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
</style>
