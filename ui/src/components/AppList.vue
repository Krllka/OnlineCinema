<template>
  <div class="container">
    <div v-if="!items" class="error-message">
      Ошибка! Не удалось загрузить каталог.
    </div>
    <div v-else class="content">
      <h2 v-if="items.length">Фильмы, доступные к просмотру:</h2>
      <ul v-if="items.length">
        <li v-for="(item, index) in items" :key="index">
          <app-card
              :cardData="item"
              :isAdmin="isAdmin"
              @deleteCard="deleteMovie(item.id)"
          />
        </li>
      </ul>
      <div v-else-if="!items.length && isAdmin" class="empty-message">
        Каталог пуст. Чтобы добавить фильм, кликните на кнопку ниже:
      </div>
      <div v-else-if="!items.length && !isAdmin" class="empty-message">
        Каталог пуст. Зайдите позже.
      </div>
      <div v-if="isAdmin" class="add-movie" @click="addMovie">
        <div class="horizontal"></div>
        <div class="vertical"></div>
      </div>
    </div>
  </div>
</template>

<script>
import AppCard from "@/components/AppCard";
import axios from "axios";

export default {
  name: "AppList",
  components: { AppCard },
  props: {
    items: {
      type: Array,
      default: () => [],
    },
    isAdmin: {
      type: Boolean,
      default: false,
    },
  },
  methods: {
    addMovie() {
      console.log("Movie created");
    },
    deleteMovie(id) {
      axios
        .delete(`http://localhost:8080/products/${id}`)
        .then((response) => console.log(response));
    },
  },
};
</script>

<style lang="scss" scoped>
ul {
  margin-top: 30px;
  list-style: none;
  display: flex;
  flex-direction: column;
  align-items: center;
}

li {
  margin-bottom: 30px;
}

.add-movie {
  display: flex;
  justify-content: center;
  align-items: center;
  margin: 0 auto;
  width: 25px;
  height: 25px;
  background-color: #5d9000;
  border-radius: 100%;
  cursor: pointer;
  transition: 0.3s all;
  &:hover {
    background-color: #81c700;
  }
  .horizontal {
    width: 16px;
    height: 2px;
    background-color: black;
    transform: translateX(1px);
  }
  .vertical {
    height: 16px;
    width: 2px;
    background-color: black;
    transform: translateX(-8px);
  }
}

.empty-message {
  margin-top: 30vh;
  margin-bottom: 30px;
  text-align: center;
  font-size: 20px;
  font-weight: bold;
}

.error-message {
  margin-top: 30vh;
  text-align: center;
  font-size: 36px;
  font-weight: bold;
}
</style>
