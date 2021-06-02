<template>
  <div class="container">
    <div class="panel">
      <button class="button add">Добавить фильм</button>
      <input
        type="search"
        class="input search"
        placeholder="Поиск фильмов..."
      />
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style scoped lang="scss">
.input {
  margin-left: 50px;
}
.add:hover {
  background-color: green;
}
</style>
