<template>
  <div class="container">
    <div v-if="isAuthorized">
      <app-loader v-if="loading" :animation="'rectangle'" />
      <div v-else>
        <div v-if="moviesList.length" class="rooms">
          <h2 class="header">Мои комнаты:</h2>
          <button class="button" @click="createRoom">Создать комнату</button>
          <app-modal-window
            v-if="isModalVisible"
            @closeModalWindow="closeModalWindow"
          >
            <template #title>Создать комнату</template>
            <template #body>
              <app-input
                :input-type="'text'"
                :input-title="'Название комнаты'"
                :is-width-parent="true"
                v-model="room.name"
              />
              <app-input
                :input-type="'password'"
                :input-title="'Пароль от комнаты'"
                :is-width-parent="true"
                v-model="room.pass"
              />
              <app-select
                :select-title="'Выберите фильм'"
                :select-options="moviesList"
                :is-width-parent="true"
                v-model="room.prod"
                @change="selectOption"
              />
              <button @click="addRoom" class="button">Создать</button>
            </template>
          </app-modal-window>
        </div>
      </div>
    </div>
    <div v-else class="message">
      <router-link to="/profile" class="link">Авторизируйтесь</router-link>,
      чтобы получить доступ к списку своих комнат.
    </div>
  </div>
</template>

<script>
import AppLoader from "@/components/common/AppLoader";
import AppModalWindow from "@/components/modal/AppModalWindow";
import AppInput from "@/components/input/AppInput";
import AppSelect from "@/components/input/AppSelect";

export default {
  name: "PageRooms",
  components: {
    AppSelect,
    AppInput,
    AppLoader,
    AppModalWindow,
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
      isModalVisible: false,
      room: {
        name: "",
        pass: "",
        prod: "",
      },
      moviesList: [],
      roomsList: [],
    };
  },
  created() {
    document.title = "Мои комнаты";
    const movies = this.axios.get(
      `http://localhost:8081/library/movies/${this.userData.name}`
    );
    const rooms = this.axios.get("http://localhost:8081/room");
    this.axios
      .all([movies, rooms])
      .then(
        this.axios.spread((moviesRes, roomsRes) => {
          this.moviesList = moviesRes.data;
          this.roomsList = roomsRes.data;
          this.loading = false;
        })
      )
      .catch((error) => {
        console.log(error);
        this.loading = false;
      });
  },
  methods: {
    createRoom() {
      this.isModalVisible = true;
    },
    getRoomsList() {
      this.axios
        .get("http://localhost:8081/room")
        .then((response) => {
          this.roomsList = response.data;
        })
        .catch((error) => {
          console.log(error);
        });
    },
    addRoom() {
      this.axios
        .post("http://localhost:8081/room", this.room)
        .then((response) => {
          console.log(response);
          this.getRoomsList();
        })
        .catch((error) => {
          console.log(error);
        });
      this.closeModalWindow();
    },
    closeModalWindow() {
      Object.keys(this.room).forEach((prop) => (this.room[prop] = ""));
      this.isModalVisible = false;
    },
    selectOption(value) {
      this.room.prod = value;
    },
  },
};
</script>

<style scoped lang="scss">
.message {
  text-align: center;
  margin-top: 25vh;
  font-size: 20px;
}

.header {
  font-size: 20px;
  margin-bottom: 15px;
}
</style>
