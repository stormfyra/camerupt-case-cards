<template>
  <div class="profile-page-background">
      <div class="text-center page">
        <!-- card -->
      <profile-card :badges="badges" class="card"></profile-card>
      <!-- features -->
      <profile-features class="features" :badges="badges"></profile-features>
      </div>
  </div>
</template>

<script>
import ProfileCard from './ProfileCard.vue'
import ProfileFeatures from './ProfileFeatures.vue'
import UserService from '../../services/UserService'
import BadgeService from '../../services/BadgeService'


export default {
  name: "profile-page-background",
    components: {
        ProfileCard,
        ProfileFeatures
    },
    props: [

    ],
    data() {
    return {
        selectedPokemon: '',
        badges: []
    }
    },
    created() {
        UserService.getUserDetails(this.$route.params.id)
                    .then(response => {
                        // profile card details
                        this.username = response.data.username;
                        this.bio = response.data.bio;
                        this.selectedPokemon = response.data.profilePokemon;

                        // add pronouns, stats, and badges

                        // add profile feature content: featured cards, public collections, and friends
                    });
        BadgeService.getBadgesByUserId(this.$route.params.id)
                    .then(response => {
                        this.badges =(JSON.parse(JSON.stringify(response.data)));
                    }); 
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