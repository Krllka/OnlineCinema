<template>
  <div class="container">
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
    ></app-data-table>
  </div>
</template>

<script>
import AppDataTable from "@/components/AppDataTable";
import axios from "axios";

export default {
  name: "PageAdminUsers",
  components: {
    AppDataTable,
  },
  data() {
    return {
      search: "",
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
      })
      .catch((error) => {
        console.log(error);
        this.usersList = 0;
      });
  },
};
</script>

<style scoped></style>
