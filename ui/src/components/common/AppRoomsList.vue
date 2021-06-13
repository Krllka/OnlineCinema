<template>
  <div class="rooms__wrapper">
    <ul class="rooms__list">
      <li
        @click="getIntoRoom(room.id)"
        v-for="(room, index) in renderRoomsList"
        :key="index"
        class="rooms__item"
      >
        <div class="room__info">
          <div class="room__name">{{ room.name }}</div>
          <div class="room__movie">
            {{ getMovieName(room.prod) }},
            <span class="room__duration"
              >{{ getMovieDuration(room.prod) }} мин</span
            >
          </div>
        </div>
        <div class="room__delete" @click.stop="$emit('deleteRoom', room.id)">
          &#10006;
        </div>
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
  computed: {
    renderRoomsList() {
      return this.roomsList;
    },
  },
  methods: {
    getMovieName(id) {
      const movie = this.moviesList.find((item) => item.id === id);
      if (movie) {
        return movie.name;
      }
    },
    getMovieDuration(id) {
      const movie = this.moviesList.find((item) => item.id === id);
      if (movie) {
        return movie.durat;
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
    min-width: 300px;
    max-width: 600px;
    margin: 40px auto;
  }
  &__list {
    max-width: 100%;
  }
  &__item {
    display: flex;
    justify-content: space-between;
    align-items: center;
    border: 1px solid black;
    padding: 20px;
    border-radius: 6px;
    margin-bottom: 15px;
    transition: 0.3s all;
    cursor: pointer;
    &:hover {
      background-color: #cccccc;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
      .room__delete {
        color: rgba(0, 0, 0, 0.5);
      }
    }
  }
  .room {
    &__name {
      font-size: 25px;
      font-weight: bold;
      margin-bottom: 5px;
    }
    &__duration {
      font-size: 15px;
    }
    &__delete {
      font-size: 20px;
      color: transparent;
      transition: 0.3s all;
      padding: 10px;
      &:hover {
        color: black;
      }
    }
  }
}
</style>
