<template>
  <div class="profile-page-background">
      <div class="text-center page">
        <!-- grids -->
      <friends-grid></friends-grid>
      </div>
  </div>
</template>

<script>
import UserService from '../../services/UserService'
import FriendsGrid from './FriendsGrid.vue';

export default {
  name: "profile-page-background",
    components: {
        FriendsGrid
    },
    props: [

    ],
    data() {
    return {
        selectedPokemon: 'Camerupt',
    }
    },
    created() {
        // TO-DO: change this to show only user's friends; getAllUsers just for testing
        UserService.getAllUsers()
                    .then(response => {
                        // profile card details
                        this.username = response.data.username;
                        this.bio = response.data.bio;
                        this.profilePokemon = response.data.profilePokemon;

                        // add pronouns, stats, and badges

                        // add profile feature content: featured cards, public collections, and friends
                    })
    }
};
</script>
<style scoped>
.page {
    display: grid;
    grid-template-columns: 1fr 1fr;
    grid-template-areas: "card features";
    width: 100%;
    height: 95%;
    gap: 50px;
}

.card {
    grid-area: card;
}

.features {
    grid-area: features;
    padding-left: 3%;
}
</style>