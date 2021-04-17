<template>
  <div>
   <h2>Каталог фильмов</h2>
  <button @click="$router.push('/')">На главную</button>
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
h2 {
  margin-top: 200px;
}
button {
  margin: 0 auto;
  display: block;
  width: 130px;
  height: 50px;
  cursor: pointer;
}
</style>
