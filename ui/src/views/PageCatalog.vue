<template>
  <div>
    <the-header />
    <div class="container">
      <app-modal
        v-if="isModalVisible"
        @closeModal="closeModal"
        @createMovie="createMovie"
        :title="modalTitle"
      >
        <div v-for="(item, index) in inputData" :key="index" class="form">
          <app-input :placeholder="item.placeholder" v-model="item.value" />
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
      isButtonDisabled: false,
      inputData: [
        {
          placeholder: "Название фильма",
          key: "name",
          value: "",
        },
        {
          placeholder: "Продолжительность фильма",
          key: "durat",
          inputValue: "",
        },
        {
          placeholder: "Год производства",
          key: "releseDate",
          inputValue: "",
        },
        {
          placeholder: "Рейтинг",
          key: "age_restr_id",
          inputValue: "",
        },
        {
          placeholder: "Оценка",
          key: "rate",
          inputValue: "",
        },
        {
          placeholder: "Цена",
          key: "price",
          inputValue: "",
        },
        {
          placeholder: "Количество просмотров",
          key: "viewsCount",
          inputValue: "",
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
    createMovie() {
      const allValuesEntered = this.inputData.every(item => item.value);
      if (allValuesEntered) {
        const requestBody = {};
        this.inputData.forEach((item) => {
          requestBody[item.key] = item.value;
        });
        axios
            .post("http://localhost:8080/products", requestBody)
            .then((response) => console.log(response))
            .catch((error) => console.log(error))
            .finally(() => {
              this.isModalVisible = false;
            });
      } else alert('Вы не указали все данные о фильме');
    },
  },
};
</script>

<style scoped></style>
