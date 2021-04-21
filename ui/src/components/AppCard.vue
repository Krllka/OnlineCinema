<template>
  <div class="card">
    <div class="card__body">
      <img
        v-if="!imgError"
        :src="cardData.poster"
        :alt="cardData.name"
        class="card__poster"
        @error="imgError = !imgError"
        height="300"
      />
      <img
        v-else
        src="../assets/default-placeholder.png"
        alt="Обложка не загружена"
        class="card__poster"
        height="300"
      />
      <div class="card__info">
        <h3 class="card__header">
          {{ cardData.name }}
        </h3>
        <div class="card__duration">
          {{ `Продолжительность: ${cardData.durat} мин` }}
        </div>
        <div class="card__releaseDate">
          {{ `Год производства: ${cardData.releseDate}` }}
        </div>
        <div class="card__age-restriction">
          {{ `Рейтинг: ${cardData.rating_id}` }}
        </div>
      </div>
    </div>
    <div class="card__footer">
      <div class="card__price">
        {{ `Цена: ${cardData.price} руб` }}
      </div>
      <div class="card__views">
        {{ `Просмотров: ${cardData.viewsCount}` }}
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

<style lang="scss" scoped>
.card {
  width: 600px;
  border: 1px solid #333333;
  border-radius: 6px;
  padding: 10px;

  &__body {
    display: flex;
    justify-content: space-between;
    border-bottom: 1px solid #6d6d6d;
    padding-bottom: 10px;
  }
  &__footer {
    margin-top: 10px;
    display: flex;
    justify-content: space-between;
  }
}
</style>
