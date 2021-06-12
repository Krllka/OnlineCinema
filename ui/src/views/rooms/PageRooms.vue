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
                v-model="roomName"
              />
              <app-select
                :select-title="'Выберите фильм'"
                :select-options="moviesList"
                :is-width-parent="true"
                v-model="roomMovie"
                @change="selectOption"
              />
              <button class="button">Создать</button>
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
      roomName: "",
      roomMovie: "",
      moviesList: [],
      roomsList: [],
    };
  },
  created() {
    document.title = "Мои комнаты";
    this.axios
      .get(`http://localhost:8081/library/movies/${this.userData.name}`)
      .then((response) => {
        this.moviesList = response.data;
        this.loading = false;
      })
      .catch((error) => {
        console.log(error);
        this.loading = false;
      });
  },
  methods: {
    createRoom() {
      this.isModalVisible = true;
    },
    closeModalWindow() {
      this.isModalVisible = false;
    },
    selectOption(value) {
      this.roomMovie = value;
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
