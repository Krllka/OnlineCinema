<template>
  <div class="container">
    <div v-if="isAuthorized">
      <app-loader v-if="loading" :animation="'rectangle'" />
      <div v-else>
        <div v-if="renderOrdersList.length">
          <div class="library">
            <h2 class="header">Мои заказы:</h2>
          </div>
          <app-data-table
            :can-delete-items="false"
            :data-list="ordersList"
            :data-headers="orderHeaders"
          />
        </div>
        <div v-else class="empty">Вы еще не делали заказов.</div>
      </div>
    </div>
    <div v-else class="message">
      <router-link to="/profile" class="link">Авторизируйтесь</router-link>,
      чтобы получить доступ к заказам.
    </div>
  </div>
</template>

<script>
import AppLoader from "@/components/AppLoader";
import AppDataTable from "@/components/AppDataTable";

export default {
  name: "PageOrders",
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
      loading: true,
      ordersList: [],
      orderHeaders: [
        {
          key: "id",
          value: "№ Заказа",
        },
        {
          key: "date",
          value: "Дата покупки",
        },
        {
          key: "price",
          value: "Цена",
        },
        {
          key: "status",
          value: "Статус заказа",
        },
      ],
    };
  },
  created() {
    document.title = "Заказы";
    this.axios
      .get(`http://localhost:8081/orders/get/${this.userData.name}`)
      .then((response) => {
        this.loading = false;
        this.ordersList = response.data;
        // console.log(this.ordersList.prods);
        // this.ordersList.prods = this.ordersList.prods
        //   .map((item) => item.name)
        //   .join(", ");
        // eslint-disable-next-line no-unused-vars
        // this.ordersList.forEach((order) => {
        //   order = order.map((item) => item.name).join(", ");
        // });
      })
      .catch((error) => {
        console.log(error);
        this.loading = false;
      });
  },
  computed: {
    renderOrdersList() {
      return this.ordersList;
    },
  },
};
</script>

<style scoped lang="scss">
.header {
  font-size: 20px;
}

.empty {
  margin-top: 40vh;
  font-size: 32px;
  text-align: center;
}

.message {
  text-align: center;
  margin-top: 25vh;
  font-size: 20px;
}
</style>
