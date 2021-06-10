<template>
  <div class="container">
    <div v-if="isAuthorized">
      <app-loader v-if="loading" :animation="'rectangle'" />
      <div v-else>
        <div v-if="renderMoviesInCart.length">
          <h2 class="header">Мои товары:</h2>
          <app-data-table
            :dataHeaders="moviesData"
            :dataList="renderMoviesInCart"
            :filter="search"
            @deleteItem="deleteMovie"
          />
          <button class="button" @click="makeOrder">Оформить заказ</button>
        </div>
        <div v-else>
          <div class="message">
            Корзина пустая. Чтобы оформить заказ, добавьте фильм из
            <router-link to="/" class="link">каталога</router-link>.
          </div>
        </div>
      </div>
    </div>
    <div v-else class="message">
      <router-link to="/profile" class="link">Авторизируйтесь</router-link>,
      чтобы получить доступ к корзине.
    </div>
  </div>
</template>

<script>
import AppDataTable from "@/components/AppDataTable";
import AppLoader from "@/components/AppLoader";

export default {
  name: "PageCart",
  components: {
    AppDataTable,
    AppLoader,
  },
  props: {
    isAuthorized: {
      type: Boolean,
      default: false,
    },
    userData: {
      type: Object,
      default: () => {},
    },
  },
  data() {
    return {
      search: "",
      loading: true,
      moviesInCart: [],
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
    document.title = "Корзина";
    this.axios
      .get(`http://localhost:8081/library/basket/${this.userData.name}`)
      .then((response) => {
        this.moviesInCart = response.data;
        this.loading = false;
      })
      .catch((error) => console.log(error));
  },
  computed: {
    renderMoviesInCart() {
      return this.moviesInCart;
    },
  },
  methods: {
    deleteMovie(movie) {
      this.axios
        .delete(
          `http://localhost:8081/library/${this.userData.name}/${movie.name}`
        )
        .then((response) => {
          console.log(response);
          let movieIndex = this.moviesInCart.findIndex(
            (item) => item.name === movie.name
          );
          this.moviesInCart.splice(movieIndex, 1);
        })
        .catch((error) => console.log(error));
    },
    makeOrder() {
      const requestBody = {};
      this.loading = true;
      this.axios
        .post(`http://localhost:8081/orders/${this.userData.id}`, requestBody)
        .then(() => {
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
.header {
  font-size: 20px;
}

.message {
  text-align: center;
  margin-top: 25vh;
  font-size: 20px;
}
</style>
