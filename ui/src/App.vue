<template>
  <div id="app">
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  name: "App",
};
</script>

<style>
* {
  padding: 0;
  margin: 0;
  box-sizing: border-box;
  font-family: Arial, sans-serif;
}

.container {
  margin: 0 auto;
  width: 900px;
}
</style>
