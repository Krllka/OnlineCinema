<template>
  <div class="container">
    <app-loader v-if="loading" :animation="'rectangle'" />
    <div v-else>
      <div class="panel">
        <input
          type="search"
          class="input search"
          placeholder="Поиск пользователей..."
          v-model="search"
        />
      </div>
      <app-data-table
        :data-headers="usersData"
        :data-list="usersList"
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
  name: "PageAdminUsers",
  components: {
    AppDataTable,
    AppLoader,
  },
  data() {
    return {
      search: "",
      loading: true,
      usersList: [],
      usersData: [
        {
          key: "name",
          value: "Имя пользователя",
        },
        {
          key: "id",
          value: "ID пользователя",
        },
        {
          key: "age",
          value: "Дата рождения",
        },
        {
          key: "mail",
          value: "Почтовый адрес",
        },
        {
          key: "password",
          value: "Пароль",
        },
        {
          key: "admin",
          value: "Админ",
        },
      ],
    };
  },
  created() {
    axios
      .get("http://localhost:8081/accounts")
      .then((response) => {
        response.data.map((item) => {
          if (item.admin) item.admin = "Да";
          else item.admin = "Нет";
        });
        this.usersList = response.data;
        this.loading = false;
      })
      .catch((error) => {
        console.log(error);
        this.usersList = 0;
      });
  },
};
</script>

<style scoped></style>
