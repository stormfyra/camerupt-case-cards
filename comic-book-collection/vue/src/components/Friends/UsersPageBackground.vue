<template>
<div>
  <div class="collection-container text-center">
    <friends-grid :smallView='false' :tinyCard='false' :users='filteredUsers' />
  </div>
</div>
</template>

<script>
import userService from '../../services/UserService';
import FriendsGrid from './FriendsGrid.vue';
export default {
  name: "users-page-background",
  components: {
    FriendsGrid
  },
  data() {
    return {
      users: [],
      friends: []
    }
  },
  created() {
    userService.getAllUsers(this.$store.state.user.id).then(response => {
      this.users = response.data;
    });
    userService.getFriends(this.$store.state.user.id).then(response => {
      this.friends = response.data;
    });
  },
  computed: {
    filteredUsers() {
      if (!this.$store.state.user) {
        return this.users;
      }
      return this.users.filter(user => {
        if (user.id == this.$store.state.user.id) {
          return false;
        }
        for (let friend of this.friends) {
          if (user.id == friend.id) {
            return false;
          }
        }
        return true;
      });
    }
  }  
}
</script>

<style scoped>
.collection-container {
  flex-direction: row;
  padding: 10px 12px;
  margin-bottom: 30px;
  border-radius: 30px;
}
</style>