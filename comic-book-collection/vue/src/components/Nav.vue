<template>
  <nav class="navbar container">
    <a href="/" class="nav-logo">cameruptCaseCards</a>

    <div class="nav-menu">
      <ul class="nav-list">

        <!-- testing viewing other users' profiles! -->
        <li class="nav-item" v-for="user in users" v-bind:key="user.index">
          <router-link :to="{ name: 'profileWithId', params: {id: user.id} }" class="navbar-item">{{user.username}}</router-link>
        </li>
        <!-- testing viewing other users' profiles! -->

        <li class="nav-item">
          <router-link :to="{ name: 'ViewCollections' }" class="navbar-item">Card Collections</router-link>&nbsp;
        </li>
        <li  v-if="!isLoggedIn" class="nav-item">
          <router-link to="/login" class="navbar-item">Login</router-link>&nbsp;
        </li>
        <li v-if="!isLoggedIn" class="nav-item">
          <router-link  to="/register" class="navbar-item">Register</router-link>
        </li>
        <li v-if="isLoggedIn" class="nav-item">
          <router-link :to="{ name: 'logout' }" class="navbar-item">Logout</router-link>
        </li>
        <router-link  :to="{ name: 'profileWithId', params: {id: this.$store.state.user.id} }" class="navbar-item" id="profile-link">
          <li v-if="isLoggedIn" class="nav-item">
            My Profile
          </li>
          <li>
            <profile-image :small="true" :pokemon="$store.state.user.profilePokemon" v-if="isLoggedIn"></profile-image>
          </li>
        </router-link>
      </ul>
    </div>

  </nav>
</template>

<script>
import ProfileImage from './Edit Profile/ProfileImage.vue';
import userService from '../services/UserService'
  export default {
    name: 'Nav',
    data() {
      return {
        users: []
      }
    },
    components: {
      ProfileImage
    },
        created() {
        // This initialization calls the logged in user from the store and then contacts our server for all collecitons
        // Then sorts collections into user-ownd collections and public collections 
        this.username = this.$store.state.user.username;
        this.user = this.$store.state.user;
        userService.getAllUsers()
                         .then(response => {
                            response.data.forEach(element => {
                                if (element.ownerUsername != this.username){
                                    this.users.push(element)
                                }
                            });
                         });
        
      },
    computed: {
        isLoggedIn() {
        return this.$store.state.user.username != null;
      }
    }
  };
</script>

<style scoped>
  nav {
    display: flex;
    justify-content: space-between;
    align-items: center;
    border-bottom: solid #E45052;
    padding-top: 10px;
    padding-bottom: 10px;
    padding-left: 111px;
    padding-right: 111px;
    font-family: "Flexo-Regular",arial,sans-serif;
    color: #E45052;
  }

  a{
    text-decoration: none;
    color: #E45052;
  }

  ul{
    list-style: none;
  }

  .nav-logo{
    font-size: 1.4rem;
    font-weight: 500;
    color: black;
  }

  .nav-list{
    display: flex;
    gap: 1rem;
  }

  #profile-link {
    display: flex;
    gap: 1rem;
  }
  
</style>