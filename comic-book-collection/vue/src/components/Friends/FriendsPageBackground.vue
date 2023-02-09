<template>
<div>
  <div class="collection-container text-center">
    <friends-grid :smallView='false' :tinyCard='false' :users='users' />
  </div>
</div>
</template>

<script>
import userService from '../../services/UserService';
import FriendsGrid from './FriendsGrid.vue';
export default {
  name: "friends-page-background",
  components: {
    FriendsGrid
  },
  data() {
    return {
      users: []
    }
  },
  created() {
    userService.getFriends(this.$store.state.user.id).then(response => {
      this.users = response.data;
    });
  }
}
</script>