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
  //background-color: #d9cdcd;
  outline: none;
  border-radius: 5px;
  border: 2px solid black;
  transition: 0.3s all;
  &:focus {
    box-shadow: 0 0 10px rgba(0, 0, 0, 1);
    //border: 2px solid #232222;
  }
  //color: black;
}
</style>
