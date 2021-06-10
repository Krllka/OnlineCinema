import Vue from "vue";
import VueRouter from "vue-router";
import PageCatalog from "@/views/PageCatalog";
import PageUserCabinet from "@/views/PageUserCabinet";
import PageLibrary from "@/views/PageLibrary";
import PageOrders from "@/views/PageOrders";
import PageAdminCatalog from "@/views/PageAdminCatalog";
import PageAdminUsers from "@/views/PageAdminUsers";
import PageMovie from "@/views/PageMovie";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Catalog",
    component: PageCatalog,
  },
  {
    path: "/profile",
    name: "Profile",
    component: PageUserCabinet,
  },
  {
    path: "/library",
    name: "Library",
    component: PageLibrary,
  },
  {
    path: "/orders",
    name: "Orders",
    component: PageOrders,
  },
  {
    path: "/catalog-admin",
    name: "Admin Catalog",
    component: PageAdminCatalog,
  },
  {
    path: "/users",
    name: "Users Management",
    component: PageAdminUsers,
  },
  {
    path: "/movies/:id",
    name: "Movie Page",
    component: PageMovie,
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
