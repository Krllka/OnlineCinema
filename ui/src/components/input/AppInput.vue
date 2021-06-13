<template>
  <div class="input-wrapper">
    <p class="input__title">{{ inputTitle }}:</p>
    <input
      v-if="inputType !== 'file'"
      :type="inputType"
      :disabled="inputDisabled"
      @input="inputHandler"
      :class="{ input: inputType !== 'file', 'w-100': isWidthParent }"
      :value="value"
      :min="inputMinValue"
      :max="inputMaxValue"
      :autocomplete="inputAutoComplete"
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
    inputMinValue: {
      type: Number,
    },
    inputMaxValue: {
      type: Number,
    },
    inputDisabled: {
      type: Boolean,
      default: false,
    },
    inputAutoComplete: {
      type: String,
      default: "off",
    },
    value: {
      type: String,
      default: "",
    },
    isWidthParent: {
      type: Boolean,
      default: false,
    },
  },
  methods: {
    inputHandler(event) {
      if (event.target.value > this.inputMaxValue) {
        event.target.value = 10;
      }
      if (event.target.value < this.inputMinValue) {
        event.target.value = "";
      }
      if (event.target.value.length > 0 && event.target.value[0] === "0") {
        event.target.value = 0;
      }
      this.$emit("input", event.target.value);
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

.w-100 {
  width: 100%;
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
