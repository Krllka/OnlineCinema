import VueRouter from "vue-router";

import PageHome from "@/views/PageHome";
import PageCatalog from "@/views/PageCatalog";
import PageUserCabinet from "@/views/PageUserCabinet";

export default new VueRouter({
  mode: "history",
  routes: [
    {
      path: "/",
      name: "home",
      component: PageHome,
    },
    {
      path: "/catalog",
      name: "catalog",
      component: PageCatalog,
    },
    {
      path: "/profile",
      name: "profile",
      component: PageUserCabinet,
    },
  ],
});
