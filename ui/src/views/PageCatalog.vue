<template>
  <div>
    <the-header />
    <div class="container">
      <app-modal
        v-if="isModalVisible && modalTitle === 'Добавить фильм'"
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

      <app-modal
        v-else-if="isModalVisible && modalTitle === 'Редактировать фильм'"
        @closeModal="closeModal"
        @createMovie="updateMovie"
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
        <!--        <app-input :editedMovie="editedMovie" :input-data="inputData[0]" v-model="editedMovie.name"></app-input>-->
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
import AppInput from "@/components/AppInput";
import axios from "axios";

export default {
  name: "PageCatalog",
  components: { AppInput, AppList, TheHeader, AppModal },
  data() {
    return {
      moviesList: [],
      ageRestriction: [],
      isAdmin: true,
      isModalVisible: false,
      editedMovie: "",
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
    editMovie(movie) {
      this.modalTitle = "Редактировать фильм";
      this.isModalVisible = true;
      this.editedMovie = movie;
      console.log(this.editedMovie);
      this.inputData[0].value = this.editedMovie.name;
      this.inputData[1].value = this.editedMovie.durat;
      this.inputData[2].value = this.editedMovie.releseDate;
      this.inputData[3].value = this.editedMovie.age_restr_id;
      this.inputData[4].value = this.editedMovie.rate;
      this.inputData[5].value = this.editedMovie.price;
      this.inputData[6].value = this.editedMovie.viewsCount;
      // axios.put(`http://localhost:8081/products/${movie.id}`, )
    },
    updateMovie() {
      this.editedMovie.name = this.inputData[0].value;
      this.editedMovie.durat = this.inputData[1].value;
      this.editedMovie.releseDate = this.inputData[2].value;
      this.editedMovie.age_restr_id = this.inputData[3].value;
      this.editedMovie.rate = this.inputData[4].value;
      this.editedMovie.price = this.inputData[5].value;
      this.editedMovie.viewsCount = this.inputData[6].value;
      this.editedMovie.poster = this.file.name;
      axios
        .put(
          `http://localhost:8081/products/${this.editedMovie.id}`,
          this.editedMovie
        )
        .then((response) => console.log(response))
        .catch((error) => console.log(error))
        .finally(() => {
          this.isModalVisible = false;
        });
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
  cursor: pointer;
}
</style>
