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
          <app-input :inputData="item" v-model="item.value" />
        </div>
        <label>
          Обложка фильма:
          <input type="file" @change="addFile" />
        </label>
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
      moviesList: [],
      isAdmin: true,
      isModalVisible: false,
      modalTitle: "",
      selectedFile: null,
      inputData: [
        {
          placeholder: "Название фильма",
          type: "text",
          key: "name",
          value: "",
        },
        {
          placeholder: "Продолжительность фильма",
          type: "number",
          key: "durat",
          value: "",
        },
        {
          placeholder: "Год производства",
          type: "date",
          key: "releseDate",
          value: "",
        },
        {
          placeholder: "Рейтинг",
          type: "number",
          key: "age_restr_id",
          value: "",
        },
        {
          placeholder: "Оценка",
          type: "number",
          key: "rate",
          value: "",
        },
        {
          placeholder: "Цена",
          type: "number",
          key: "price",
          value: "",
        },
        {
          placeholder: "Количество просмотров",
          type: "number",
          key: "viewsCount",
          value: "",
        },
      ],
    };
  },
  created() {
    document.title = "Каталог фильмов";
    axios
      .get("http://localhost:8081/products")
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
      const allValuesEntered = this.inputData.every((item) => item.value);
      if (allValuesEntered) {
        const requestBody = {};
        this.inputData.forEach((item) => {
          requestBody[item.key] = item.value;
        });
        requestBody.poster = this.selectedFile.name; // Имя файла
        requestBody.file = this.selectedFile; // файл с картинкой
        axios
          .post("http://localhost:8081/products/add", requestBody)
          .then((response) => console.log(response))
          .catch((error) => console.log(error))
          .finally(() => {
            this.isModalVisible = false;
          });
      } else alert("Вы не указали все данные о фильме");
    },
    addFile(event) {
      this.selectedFile = event.target.files[0];
      console.log(this.selectedFile);
    },
  },
};
</script>

<style scoped>
label {
  font-size: 14px;
}
</style>
