<template>
  <nav class="navbar container">
    <a href="/" class="nav-logo">cameruptCaseCards</a>

    <div class="nav-menu">
      <ul class="nav-list">
        <router-link v-if="isLoggedIn" :to="{ name: 'friends' }" class="nav-item">
          <li class="nav-item">
            Friends
          </li>
        </router-link>
        <router-link :to="({ name: 'collections'})">
          <li class="nav-item">
            Card Collections
          </li>
        </router-link>
        <router-link v-if="!isLoggedIn" :to="({ name: 'login'})" class="nav-item">
          <li class="nav-item">
            Login
          </li>
        </router-link>
        <router-link v-if="!isLoggedIn" :to="{ name: 'register' }" class="nav-item">
          <li class="nav-item">
            Register
          </li>
        </router-link>
        <router-link v-if="isLoggedIn" :to="{ name: 'logout' }" class="nav-item">
          <li class="nav-item">
            Logout
          </li>
        </router-link>
        <div id="link-to-my-profile" @click="goToMyProfile()">
          <li id="logged-in-user-info" v-if="isLoggedIn">
            <div id="profile-holder-navbar">
              <p>{{$store.state.user.username}}</p>
            </div>
            <div class="profile-icon-holder">
              <profile-image :small="true" :pokemon="$store.state.user.profilePokemon" :class="'profile-icon'"></profile-image>
            </div>    
          </li>
        </div>
      </ul>
    </div>

  </nav>
</template>

<script>
import ProfileImage from './Edit Profile/ProfileImage.vue';
  export default {
    name: 'nav',
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
    },
    methods: {
      goToMyProfile() {
        this.$router.push({ name: 'profileWithId', params: {id: this.$store.state.user.id}})
        this.$router.go();
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

  font-size: small;
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
width: 42px;
height: 42px; 
}

.profile-icon {
  width: 100%;
  height: 100%;
/* crops the image with the same ratio */
  object-fit: cover;
}

.nav-list{
  display: flex;
  gap: 1rem;
  flex-wrap: wrap;
}

li {
  border: solid #e93d40 2px;
  border-radius: 5px;
  display: flex;
  align-items: center;
  padding: 8px;
  height: 70%;
  font-weight: 600;
}

/* li:first-child {
  border-left: none;
} */

#profile-link {
  display: flex;
  gap: 1rem;
}

#logged-in-user-info {
  display: flex;
  border-left: solid #e93d40 2px;
  justify-content: center;
  gap: 5px;
}

#profile-holder-navbar {
  color: black;
  font-size: small;
}

p {
  text-align: center;
}   

#link-to-my-profile:hover {
  cursor: pointer;
}
  
</style>