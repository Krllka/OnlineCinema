<template>
  <div class="animations">
    <div v-if="animation === 'rectangle'" class="lds-facebook">
      <div></div>
      <div></div>
      <div></div>
    </div>
    <div v-if="animation === 'ring'" class="lds-ring">
      <div></div>
      <div></div>
      <div></div>
      <div></div>
    </div>
  </div>
</template>

<script>
export default {
  name: "AppLoader",
  props: {
    animation: {
      type: String,
      default: "",
    },
  },
};
</script>

<style scoped lang="scss">
/* Rectangle */
.lds-facebook {
  display: flex;
  justify-content: center;
  align-items: center;
  margin: 25vh auto;
  position: relative;
  width: 80px;
  height: 80px;
  z-index: 100;
}
.lds-facebook div {
  display: inline-block;
  position: absolute;
  left: 8px;
  width: 16px;
  background: #000;
  animation: lds-facebook 1.2s cubic-bezier(0, 0.5, 0.5, 1) infinite;
}
.lds-facebook div:nth-child(1) {
  left: 8px;
  animation-delay: -0.24s;
}
.lds-facebook div:nth-child(2) {
  left: 32px;
  animation-delay: -0.12s;
}
.lds-facebook div:nth-child(3) {
  left: 56px;
  animation-delay: 0;
}
@keyframes lds-facebook {
  0% {
    top: 8px;
    height: 64px;
  }
  50%,
  100% {
    top: 24px;
    height: 32px;
  }
}

/* Ring */
.lds-ring {
  display: inline-block;
  position: relative;
  width: 13px;
  height: 13px;
  z-index: 100;
}
.lds-ring div {
  box-sizing: border-box;
  display: block;
  position: absolute;
  width: 13px;
  height: 13px;
  //margin: 8px;
  margin-top: 2px;
  border: 2px solid #000;
  border-radius: 50%;
  animation: lds-ring 1.2s cubic-bezier(0.5, 0, 0.5, 1) infinite;
  border-color: #000 transparent transparent transparent;
}
.lds-ring div:nth-child(1) {
  animation-delay: -0.45s;
}
.lds-ring div:nth-child(2) {
  animation-delay: -0.3s;
}
.lds-ring div:nth-child(3) {
  animation-delay: -0.15s;
}
@keyframes lds-ring {
  0% {
    transform: rotate(0deg);
  }
  100% {
    transform: rotate(360deg);
  }
}
</style>
