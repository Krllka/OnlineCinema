<template>
  <div class="input-wrapper">
    <p class="input__title">{{ inputTitle }}:</p>
    <input
      v-if="inputType !== 'file'"
      :type="inputType"
      @input="$emit('input', $event.target.value)"
      :class="{ input: inputType !== 'file' }"
    />
  </div>
</template>

<script>
export default {
  name: "AppInput",
  props: {
    inputType: {
      type: String,
      default: "text",
    },
    inputTitle: {
      type: String,
      default: "",
    },
  },
};
</script>

<style scoped lang="scss">
.input__title {
  margin-bottom: 5px;
  font-size: 15px;
}

.input {
  width: 170px;
  border: 1px solid rgba(60, 60, 60, 0.26);
}

.input-wrapper {
  margin-bottom: 15px;
}

.custom-file-upload {
  border: 1px solid #ccc;
  display: inline-block;
  padding: 6px 12px;
  cursor: pointer;
}
</style>
