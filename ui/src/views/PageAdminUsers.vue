<template>
  <div class="container">
    <div v-if="!isAdmin" class="message">Доступ запрещен.</div>
    <div v-else>
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
          :data-list="renderUsers"
          :filter="search"
          @deleteItem="deleteUser"
        />
      </div>
    </div>
  </div>
</template>

<script>
import AppDataTable from "@/components/AppDataTable";
import AppLoader from "@/components/AppLoader";

export default {
  name: "PageAdminUsers",
  components: {
    AppDataTable,
    AppLoader,
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
    document.title = "Аккаунты";
    this.axios
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
  methods: {
    deleteUser(user) {
      this.axios
        .delete(`http://localhost:8080/accounts/${user.id}`)
        .then(() => {
          let userIndex = this.usersList.findIndex(
            (item) => item.id === user.id
          );
          this.usersList.splice(userIndex, 1);
        })
        .catch((error) => console.log(error));
    },
  },
  computed: {
    renderUsers() {
      return this.usersList;
    },
  },
};
</script>

<style scoped lang="scss">
.message {
  margin-top: 25vh;
  text-align: center;
  font-size: 30px;
  font-weight: 700;
}
</style>
