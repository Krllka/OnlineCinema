<template>
  <div>
    <h2 class="header">Домашняя страница</h2>
    <button class="btn" @click="$router.push('/catalog')">Перейти к каталогу фильмов</button>
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
.header {
  margin-top: 200px;
}

.btn {
  margin: 0 auto;
  display: block;
  width: 130px;
  height: 50px;
  cursor: pointer;
}
</style>
