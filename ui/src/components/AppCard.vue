<template>
  <div class="card">
    <div class="card__body">
      <img
        v-if="!imgError"
        :src="`http://localhost:8080/products/files/${cardData.poster}`"
        :alt="cardData.name"
        class="card__poster"
        @error="imgError = !imgError"
        height="200"
      />
      <img
        v-else
        src="../assets/default-placeholder.png"
        alt="Обложка не загружена"
        class="card__poster"
        height="200"
      />
      <div class="card__info">
        <div v-if="isAdmin" class="card__header-wrapper">
          <h3 class="card__header">
            {{ cardData.name }}
          </h3>
          <div v-if="isAdmin" class="card__admin-panel">
            <img src="../assets/draw.png" alt="Edit" class="card__edit" />
            <img
              src="../assets/cancel.png"
              alt="Edit"
              class="card__remove"
              @click="$emit('deleteCard')"
            />
          </div>
        </div>
        <h3 v-else class="card__header">
          {{ cardData.name }}
        </h3>
        <div class="card-row">
          <div class="card-row__header">Продолжительность:</div>
          <div class="card-row__value">
            {{ `${cardData.durat} мин` }}
          </div>
        </div>
        <div class="card-row">
          <div class="card-row__header">Год производства:</div>
          <div class="card-row__value">
            {{ cardData.releseDate }}
          </div>
        </div>
        <div class="card-row">
          <div class="card-row__header">Рейтинг:</div>
          <div class="card-row__value">
            {{ cardData.age_restr_id }}
          </div>
        </div>
        <div class="card-row">
          <div class="card-row__header">Оценка:</div>
          <div class="card-row__value">
            {{ `${cardData.rate}/10` }}
          </div>
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
    isAdmin: {
      type: Boolean,
      default: false,
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
  max-width: 500px;
  border: 1px solid #333333;
  border-radius: 6px;
  padding: 10px;
  &__header-wrapper {
    display: flex;
    justify-content: space-between;
  }
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
  &__price,
  &__views {
    max-width: 50%;
  }
  &__info {
    margin-left: 30px;
    min-width: 250px;
  }
  &-row {
    display: flex;
    justify-content: space-between;
    margin-top: 10px;
    padding: 10px 0 5px;
    font-size: 15px;
    border-bottom: 1px solid #a8a8a8;
    &__header {
      color: #a8a8a8;
    }
  }
  &__admin-panel {
    display: flex;
    justify-content: space-between;
    align-items: center;
    width: 50px;
  }
  &__edit,
  &__remove {
    height: 20px;
    padding: 5px;
    border-radius: 4px;
    cursor: pointer;
    transition: 0.3s all;
    &:hover {
      background-color: #d0d0d0;
    }
  }
}
</style>
