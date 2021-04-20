<template>
  <div>
    <the-header />
    <div class="container">
      <h2 class="header">Добро пожаловать в онлайн кинотеатр!</h2>
      <p class="text">Для выбора фильма перейдите в раздел "Каталог"</p>
    </div>
  </div>
</template>

<script>
import TheHeader from "@/components/TheHeader";

export default {
  name: "PageHome",
  components: {
    TheHeader,
  },
  created() {
    document.title = "Онлайн кинотеатр";
  },
};
</script>

<style scoped>
.header,
.text {
  text-align: center;
}

.text {
  margin-top: 20px;
}

.header {
  margin-top: 30vh;
}
</style>
