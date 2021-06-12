import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import "./assets/styles/index.scss";
import axios from "axios";
import vSelect from "vue-select";

Vue.prototype.axios = axios;
Vue.component("v-select", vSelect);
Vue.config.productionTip = false;

new Vue({
  router,
  render: (h) => h(App),
}).$mount("#app");
