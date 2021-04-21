<template>
  <div>
    <the-header />
    <div class="container">
      <app-modal
        v-if="isModalVisible"
        @closeModal="closeModal"
        :title="modalTitle"
      >
        <div v-for="(item, index) in inputData" :key="index" class="input-list">
          <app-input :placeholder="item.placeholder" />
        </div>
      </app-modal>
      <app-list :items="moviesList" :isAdmin="isAdmin" @addItem="addMovie" />
    </div>
  </div>
</template>

<script>
import TheHeader from "@/components/TheHeader";
import AppList from "@/components/AppList";
import AppModal from "@/components/AppModal";
import axios from "axios";
import AppInput from "@/components/AppInput";

export default {
  name: "PageCatalog",
  components: { AppInput, AppList, TheHeader, AppModal },
  data() {
    return {
      moviesList: null,
      isAdmin: true,
      isModalVisible: false,
      modalTitle: "",
      inputData: [
        {
          placeholder: "Название фильма",
        },
        {
          placeholder: "Продолжительность фильма",
        },
        {
          placeholder: "Год производства",
        },
        {
          placeholder: "Рейтинг",
        },
        {
          placeholder: "Оценка",
        },
        {
          placeholder: "Цена",
        },
        {
          placeholder: "Количество просмотров",
        },
      ],
    };
  },
  created() {
    document.title = "Каталог фильмов";
    axios
      .get("http://localhost:8080/products")
      .then((response) => {
        this.moviesList = response.data;
      })
      .catch((error) => console.log(error));
  },
  methods: {
    addMovie() {
      this.modalTitle = "Добавить фильм";
      this.isModalVisible = true;
    },
    closeModal() {
      this.isModalVisible = false;
    },
  },
};
</script>

<style scoped></style>
