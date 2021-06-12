<template>
  <div class="rooms__wrapper">
    <ul class="rooms__list">
      <li
        @click="getIntoRoom(room.id)"
        v-for="(room, index) in roomsList"
        :key="index"
        class="rooms__item"
      >
        <div class="room__name">{{ room.name }}</div>
        <div class="room__movie-name">{{ getMovieName(room.prod) }}</div>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  name: "AppRoomsList",
  props: {
    roomsList: {
      type: Array,
      default: () => [],
    },
    moviesList: {
      type: Array,
      default: () => [],
    },
  },
  methods: {
    getMovieName(id) {
      const movie = this.moviesList.find((item) => item.id === id);
      if (movie) {
        return movie.name;
      }
    },
    getIntoRoom(id) {
      this.$router.push(`/room/${id}`);
    },
  },
};
</script>

<style scoped lang="scss">
.rooms {
  &__wrapper {
    margin: 50px 0;
  }
  &__list {
    width: 300px;
    //padding: 5px 0;
    margin: 0 auto;
    border: 1px solid rgba(0, 0, 0, 0.5);
    border-radius: 6px;
  }
  &__item {
    min-height: 50px;
    border-bottom: 1px solid rgba(0, 0, 0, 0.5);
    //padding: 5px 0;
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 0 10px;
    transition: 0.3s all;
    cursor: pointer;
    &:hover {
      background-color: #cccccc;
    }
    &:last-child {
      border-bottom: none;
    }
  }
  .room {
    &__name {
      border-right: 1px solid rgba(0, 0, 0, 0.5);
      height: 100%;
      width: 50%;
    }
  }
}
</style>
