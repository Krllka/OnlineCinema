<template>
  <div class="select-wrapper">
    <p class="title">{{ selectTitle }}:</p>
    <select
      class="input"
      :class="{ 'w-100': isWidthParent }"
      :multiple="multiple"
      @change="$emit('change', $event.target.value)"
    >
      <option value="" disabled selected>Не выбрано</option>
      <option
        v-for="(option, index) in selectOptions"
        :key="index"
        :value="option.id"
      >
        {{ option.name }}
      </option>
    </select>
  </div>
</template>

<script>
export default {
  name: "AppSelect",
  props: {
    selectTitle: {
      type: String,
      default: "",
    },
    selectOptions: {
      type: Array,
      default: () => [],
    },
    multiple: {
      type: Boolean,
      default: false,
    },
    isWidthParent: {
      type: Boolean,
      default: false,
    },
  },
};
</script>

<style scoped lang="scss">
.select-wrapper {
  margin-bottom: 15px;
}
.title {
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
</style>
