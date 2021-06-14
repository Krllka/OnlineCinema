<template>
  <div class="window-container" @mousedown.self="$emit('closeModalWindow')">
    <div class="modal" :class="{ 'w-20': widthContent }">
      <div class="modal__header">
        <div class="modal__title">
          <slot name="title">Диалоговое окно</slot>
        </div>
        <div class="modal__close" @click="$emit('closeModalWindow')">
          &#10006;
        </div>
      </div>
      <div class="modal__body">
        <slot name="body"></slot>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "AppModalWindow",
  props: {
    widthContent: {
      type: Boolean,
      default: false,
    },
  },
};
</script>

<style scoped lang="scss">
.window-container {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100vw;
  height: 100vh;
  background-color: rgba(0, 0, 0, 0.3);
  position: fixed;
  top: 0;
  left: 0;
  z-index: 20;
}

.modal {
  width: 50%;
  display: flex;
  flex-direction: column;
  background-color: white;
  border: 1px solid black;
  border-radius: 6px;
  z-index: 100;
  &__header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    border-bottom: 1px solid black;
    font-size: 20px;
  }
  &__close {
    cursor: pointer;
    transition: 0.3s all;
    &:hover {
      color: rgba(0, 0, 0, 0.5);
    }
  }
  &__header,
  &__body {
    padding: 10px;
  }
  &__body {
    flex-grow: 1;
  }
}

.w-20 {
  width: 20%;
}
</style>
