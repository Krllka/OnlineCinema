<template>
  <div class="card">
    <div class="card__poster-wrapper">
      <img :src="cardData.poster" :alt="cardData.name" class="card__poster" />
    </div>
    <div class="card__info">
      <h3 class="card__header">
        {{ cardData.name }}
      </h3>
      <div class="card__duration">
        {{ `Продолжительность: ${cardData.durat} мин` }}
      </div>
      <div class="card__releaseDate">
        {{ `Дата релиза: ${cardData.releseDate}` }}
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
};
</script>

<style scoped>
.card {
  display: flex;
}
</style>
