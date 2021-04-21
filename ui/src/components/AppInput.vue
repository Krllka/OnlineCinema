<template>
  <div>
    <label>
      <input class="input" :placeholder="placeholder" />
    </label>
  </div>
</template>

<script>
export default {
  name: "AppInput",
  props: {
    placeholder: {
      type: String,
      default: "Введите данные",
    },
  },
};
</script>

<style lang="scss" scoped>
.input {
  margin: 5px 0;
  height: 30px;
  width: 100%;
  padding: 5px;
}
</style>
