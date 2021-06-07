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
          :dataList="moviesList"
          :filter="search"
        />
        <app-modal-window
          v-if="isModalVisible"
          @closeModalWindow="closeModalWindow"
        />
      </div>
    </div>
  </div>
</template>

<script>
import AppDataTable from "@/components/AppDataTable";
import AppLoader from "@/components/AppLoader";
import AppModalWindow from "@/components/AppModalWindow";

export default {
  name: "PageAdminCatalog",
  components: {
    AppDataTable,
    AppLoader,
    AppModalWindow,
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
      isModalVisible: false,
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
    document.title = "Управление каталогом";
    this.axios
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
  methods: {
    openModalWindow() {
      this.isModalVisible = true;
    },
    closeModalWindow() {
      this.isModalVisible = false;
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
