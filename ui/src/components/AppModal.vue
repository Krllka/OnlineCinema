<template>
  <div class="modal">
    <div class="modal__header">
      <span class="modal__title">{{ title }}</span>
      <img
        src="../assets/images/cancel.png"
        alt="Cancel"
        class="modal__remove"
        @click="$emit('closeModal')"
      />
    </div>
    <div class="modal__body">
      <slot></slot>
    </div>
    <div class="modal__footer">
      <button class="modal__close button" @click="$emit('closeModal')">
        Закрыть
      </button>
      <button class="modal__submit button" @click="$emit('createMovie')">
        Сохранить
      </button>
    </div>
  </div>
</template>

<script>
export default {
  name: "AppModal",
  props: {
    title: {
      type: String,
      default: "Модальное окно",
    },
  },
};
</script>

<style lang="scss" scoped>
.modal {
  padding: 16px;
  position: fixed;
  top: 100px;
  left: 40vw;
  width: 400px;
  box-shadow: 0 0 30px 0 black;
  background: linear-gradient(
    112deg,
    rgba(181, 175, 178, 1) 0%,
    rgba(180, 163, 137, 1) 100%
  );
  z-index: 10;
  &__header,
  &__footer {
    display: flex;
    justify-content: space-between;
    align-items: center;
  }
  &__header {
    margin-bottom: 15px;
  }
  &__title {
    font-weight: bold;
  }
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
  &__body {
    //display: flex;
    //justify-content: center;
    //align-items: center;
    margin: 20px 0;
  }
  &__submit,
  &__close {
    padding: 8px;
    cursor: pointer;
    //background-color: #042258;
    //color: #ffffff;
  }
}
</style>
