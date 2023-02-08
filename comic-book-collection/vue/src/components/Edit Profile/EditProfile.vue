<template>
    <div id = "profile-page">
        <div id = "edit-profile">
            <div class="profile-pic">
            <h1>Edit Profile</h1><profile-image :small="false" :pokemon="$store.state.user.profilePokemon" id="profile-pic" />
            </div>

            <h2>Profile Information</h2>

            <form action="">
                <label for="username" class="input-label">Username
                    <input v-model="user.username" id="username" name="username">
                </label>
                <label for="select-profile-pokemon" class="input-label">Profile Pokemon
                    <select-profile-pokemon />
                </label>
                <label for="pronouns" class="input-label">Pronouns
                    <input v-model="user.pronouns" id="pronouns">
                </label>
                <label for="bio" class="input-label">Bio
                    <input v-model="user.bio" id="bio">
                </label>

                <h2>Shipping Information</h2>
                <label for="fullName" class="input-label">Full Name
                    <input v-model="user.fullName" type="text">
                </label>

                <label for="streetAddress" class="input-label">Full Address
                    <input v-model="user.shippingAddress" type="text">
                </label>
                <div class="button-div">
                    <button @click="updateProfile()" type="submit">Save</button>
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
    props: [
        'cards'
    ],
    created() {
            this.user = this.$store.state.user
    },
    methods: {
        updateProfile() {
            this.$store.commit('SET_USER', this.user)
            console.log(this.user);
            userService.updateUserBio(this.user)
            this.$router.push({name: 'profileWithId', params: {id: this.$store.state.user.id}})
            this.$router.go();
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

  .input-label {
      display: flex;
      flex-direction: column;
      gap: 0.25em;
  }
</style>
