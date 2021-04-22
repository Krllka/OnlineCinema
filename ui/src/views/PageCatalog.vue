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
          <button @click="submitFile">Загрузить файл</button>
        </label>
      </app-modal>
      <app-list
        :items="moviesList"
        :isAdmin="isAdmin"
        @addItem="addMovie"
        @editItem="editMovie"
      />
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
      ageRestriction: [],
      isAdmin: true,
      isModalVisible: false,
      modalTitle: "",
      file: null,
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
          placeholder: "Возрастное ограничение",
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

    // В будущем, возможно, понадобится
    // axios
    //   .get("http://localhost:8081/age_restriction")
    //   .then((response) => {
    //     this.ageRestriction = response.data;
    //   })
    //   .catch((error) => console.log(error));
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
        // const formData = new FormData();
        this.inputData.forEach((item) => {
          requestBody[item.key] = item.value;
        });
        requestBody.poster = this.file.name; // Имя файла
        // formData.append('file', this.selectedFile);
        // requestBody.file = this.selectedFile; // файл с картинкой
        axios
          .post("http://localhost:8081/products", requestBody)
          .then((response) => console.log(response))
          .catch((error) => console.log(error))
          .finally(() => {
            this.isModalVisible = false;
          });
      } else alert("Вы не указали все данные о фильме");
    },
    addFile(event) {
      this.file = event.target.files[0];
      console.log(this.file);
    },
    submitFile() {
      const formData = new FormData();
      formData.append("file", this.file);
      axios
        .post("http://localhost:8081/products/add", formData, {
          headers: { "Content-Type": "multipart/form-data" },
        })
        .then((response) => console.log(response))
        .catch((error) => console.log(error));
    },
    editMovie(id) {
      console.log(id);
    },
  },
};
</script>

<style scoped>
label {
  font-size: 14px;
}
button {
  padding: 5px;
}
</style>
