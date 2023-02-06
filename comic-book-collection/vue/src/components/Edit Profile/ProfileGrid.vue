<template>
    <div id = "profile-page">
        <div id = "edit-profile" class="text-center">
            <div class="profile-pic">
            <h1>Edit Profile</h1><profile-image :small="false" :pokemon="$store.state.user.profilePokemon" id="profile-pic" />
            </div>

            <h4>Profile Information</h4>
            <select-profile-pokemon />

            <form action="">
                <label for="username">Username</label>
                <input v-model="user.username" id="username">
                <label for="bio">Bio</label>
                <input v-model="user.bio" id="bio">

                <label for=""><h4>Featured Cards</h4></label>
                <div class="featured-cards">
                    <img src="../../../resources/backOfPokemonCard.jpg" alt="placeholder">
                    <img src="../../../resources/backOfPokemonCard.jpg" alt="placeholder">
                    <img src="../../../resources/backOfPokemonCard.jpg" alt="placeholder">
                    <img src="../../../resources/backOfPokemonCard.jpg" alt="placeholder">
                </div>

                <h4>Shipping Information</h4>
                <label for="firstName">First Name</label>
                <input v-model="user.fullName" type="text">
                <label for="lastName">Last Name</label>
                <input type="text">

                <label for="streetAddress">Street Address</label>
                <input v-model="user.shippingAddress" type="text">
                <label for="city">City</label>
                <input type="text">
                <label for="state">State</label>
                <input type="text">
                <label for="zipCode">Zip Code</label>
                <input type="text">

                <div class="checkbox">
                <input type="checkbox" name="showCity" id="checkboxCity" value="Show city on profile">
                <label for="checkboxCity">Show city on profile</label>
                </div>

                <div class="button-div">
                <button @click="updateProfile()" type="submit">Save</button>
                <button id="cancel-button" @click="cancel()">Cancel</button>
                </div>

            </form>

        </div>
    </div>
</template>

<script>
import userService from "../../services/UserService"
import ProfileImage from './ProfileImage.vue'
import SelectProfilePokemon from './SelectProfilePokemon.vue'

export default {
    components: {
        SelectProfilePokemon,
        ProfileImage
    },
    data() {
        return{
            user: {}
        }
    },
    created() {
            this.user = this.$store.state.user
    },
    methods: {
        updateProfile() {
            this.$store.commit('SET_USER', this.user)
            console.log(this.user);
            userService.updateUserBio(this.user)
            this.$router.push({name: 'profileWithId', params: {id: this.$store.state.user.id}})
        },
        cancel(){
            this.$router.push({name: 'profileWithId', params: {id: this.$store.state.user.id}})
        }
    }
}
</script>

<style scoped>

  #profile-page {
    /* position: fixed; */
    top: 15%;
    align-items: center;
  }

  #edit-profile {
      padding: 5%;
      margin-top: 5%;
  }

  form { 
    padding: 0px;
  }

  #checkboxCity {
      height: 20px;
      width: 20px;
  }

  .text-center {
      height: 100%;
      width: 85%;  
  }

  .button-div {
      display: flex;
      gap: 15px;
      text-align: center;
  }

    button {
      width: 100%;
  }

  .profile-pic {
      display: flex;
      gap: 15px;
      justify-content: space-between;
  }

  .featured-cards {
      display: flex;
      justify-content: space-between;
  }

  img {
      width: 20%;
  }
</style>
