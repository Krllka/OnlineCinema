import VueRouter from "vue-router";

import Catalog from "@/views/Catalog";
import Home from "@/views/Home";

export default new VueRouter({
  mode: "history",
  routes: [
    {
      path: "/",
      component: Home,
    },
    {
      path: "/catalog",
      component: Catalog,
    },
  ],
});
