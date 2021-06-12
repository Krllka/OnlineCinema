import Vue from "vue";
import VueRouter from "vue-router";
import PageCatalog from "@/views/catalog/PageCatalog";
import PageUserCabinet from "@/views/user/PageUserCabinet";
import PageLibrary from "@/views/user/PageLibrary";
import PageOrders from "@/views/orders/PageOrders";
import PageAdminCatalog from "@/views/admin/PageAdminCatalog";
import PageAdminUsers from "@/views/admin/PageAdminUsers";
import PageMovie from "@/views/catalog/PageMovie";
import PageCart from "@/views/orders/PageCart";
import PageRooms from "@/views/rooms/PageRooms";

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
    path: "/cart",
    name: "Cart",
    component: PageCart,
  },
  {
    path: "/rooms",
    name: "Rooms",
    component: PageRooms,
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
