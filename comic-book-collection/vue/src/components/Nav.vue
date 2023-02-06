<template>
  <nav class="navbar container">
    <a href="/" class="nav-logo">cameruptCaseCards</a>

    <div class="nav-menu">
      <ul class="nav-list">

        <li v-if="isLoggedIn" class="nav-item">
          <router-link :to="{ name: 'friends' }" class="navbar-item">Friends</router-link>
        </li>
        <li class="nav-item">
          <a :href="$router.resolve({ name: 'ViewCollections'}).href" class="navbar-item">Card Collections</a>&nbsp;
        </li>
        <li v-if="!isLoggedIn" class="nav-item">
          <a :href="$router.resolve({ name: 'login'}).href" class="navbar-item">Login</a>&nbsp;
        </li>
        <li v-if="!isLoggedIn" class="nav-item">
          <router-link :to="{ name: 'register' }" class="navbar-item">Register</router-link>
        </li>
        <li v-if="isLoggedIn" class="nav-item">
          <router-link :to="{ name: 'logout' }" class="navbar-item">Logout</router-link>
        </li>
        <!-- <router-link  :to="{ name: 'profileWithId', params: {id: this.$store.state.user.id} }" class="navbar-item" id="profile-link"> -->
          <a :href="$router.resolve({ name: 'profileWithId', params: {id: this.$store.state.user.id} }).href"  class="navbar-item" id="profile-link">

          <li id="logged-in-user-info" v-if="isLoggedIn">
            <div id="profile-holder-navbar">
              <p>{{$store.state.user.username}}</p>
            </div>
            <div class="profile-icon-holder">
              <profile-image :small="true" :pokemon="$store.state.user.profilePokemon" :class="'profile-icon'"></profile-image>
            </div>
            
          </li>
        </a>
      </ul>
    </div>

  </nav>
</template>

<script>
import ProfileImage from './Edit Profile/ProfileImage.vue';
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
    border-bottom: solid #e93d40;
    padding-top: 10px;
    padding-bottom: 10px;
    font-family: "Flexo-Regular",arial,sans-serif;
    color: #e93d40;
  }

  a{
    text-decoration: none;
    color: #e93d40;
  }

  ul{
    list-style: none;
  }

  .nav-logo{
    font-size: 1.4rem;
    font-weight: 500;
    color: black;
  }

  .profile-icon-holder {
  width: 40px; /*any size*/
  height: 40px; /*any size*/
}

.profile-icon {
  width: 100%;
  height: 100%;
  object-fit: cover; /*magic*/
}

  .nav-list{
    display: flex;
    gap: 1rem;
  }
  li {
    border-left: solid #e93d40 2px;
    display: flex;
    align-items: center;
    padding-left: 5px;
  }

  li:first-child {
    border-left: none;
  }

  #profile-link {
    display: flex;
    gap: 1rem;
  }

  #logged-in-user-info {
    display: flex;
    border-left: solid #e93d40 2px;
    justify-content: flex-end;
  }

  #profile-holder-navbar {
    color: black;
    font-size: small;
  }

  p {
    margin-right: 5px;
  }
  
</style>