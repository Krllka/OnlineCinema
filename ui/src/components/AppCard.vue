<template>
  <div class="card" @click="$emit('openCardPage', cardData.id)">
    <h3 class="card__header">{{ cardData.name }}</h3>
    <div class="card__body">
      <img
        v-if="!imgError"
        :src="`http://localhost:8080/products/files/${cardData.poster}`"
        :alt="cardData.name"
        class="card__img"
        @error="imgError = !imgError"
      />
      <img
        v-else
        src="../assets/images/default-placeholder.png"
        alt="Обложка не найдена"
        class="card__img"
      />
      <div class="card__info">
        <div class="card__row">
          <span class="card__title">Жанр</span>
          <span class="card__value">{{ cardData.genres }}</span>
        </div>
        <div class="card__row">
          <span class="card__title">Год релиза</span>
          <span class="card__value">{{ cardData.releseDate }}</span>
        </div>
        <div class="card__row">
          <span class="card__title">Возрастное ограничение</span>
          <span class="card__value">{{ cardData.age_restr_id }}</span>
        </div>
        <div class="card__row">
          <span class="card__title">Оценка</span>
          <span class="card__value">{{ cardData.rate }}/10</span>
        </div>
      </div>
    </div>
    <div class="card__footer">
      <div class="card__price">
        <span class="card__title">Цена:</span> {{ cardData.price }}
      </div>
      <div class="card__views">
        <span class="card__title">Просмотров:</span> {{ cardData.viewsCount }}
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "AppCard",
  props: {
    cardData: {
      type: Object,
      default: () => {},
    },
  },
  data() {
    return {
      imgError: false,
    };
  },
};
</script>

<style scoped lang="scss">
.card {
  width: 500px;
  border: 1px solid black;
  border-radius: 6px;
  cursor: pointer;
  transition: 0.3s all;
  &:hover {
    box-shadow: 0 0 20px rgba(0, 0, 0, 0.5);
  }
  &__header {
    font-size: 15px;
    font-weight: 700;
    border-bottom: 1px solid black;
    padding: 10px;
  }
  &__body {
    display: flex;
    padding: 10px;
  }
  &__img {
    max-height: 200px;
    border: 1px solid black;
    border-radius: 6px;
  }
  &__info {
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    width: 100%;
    padding: 5px;
  }
  &__row {
    display: flex;
    justify-content: space-between;
    width: 100%;
    margin-left: 10px;
    padding-bottom: 3px;
    border-bottom: 1px solid black;
  }
  &__title {
    color: rgba(0, 0, 0, 0.5);
  }
  &__footer {
    display: flex;
    justify-content: space-between;
    padding: 10px;
    border-top: 1px solid black;
  }
}
</style>
