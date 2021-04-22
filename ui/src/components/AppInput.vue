<template>
  <div>
    <label>
      <input
        class="input"
        required
        :placeholder="inputData.placeholder"
        :type="inputData.type"
        :value="inputData.value"
        @input="$emit('input', $event.target.value)"
      />
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
    inputData: {
      type: Object,
      default: () => {},
    },
    editedMovie: {
      type: Object,
      default: () => {},
    }
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
