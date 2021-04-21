<template>
  <div>
    <label>
      <input class="input" required :placeholder="placeholder" @input="$emit('input', $event.target.value)"/>
    </label>
  </div>
</template>

<script>
export default {
  name: "AppInput",
  data() {
    return {};
  },
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
