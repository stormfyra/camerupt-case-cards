<template>
  <div class="profile-page-background">
      <div class="text-center page">
        <!-- card -->
        <div class="profile">
            <profile-card :user="user" :badges="badges" class="card" :cards='cards' />
        </div>
        <!-- features -->
        <profile-features :cards='cards' class="features" :badges="badges" />
      </div>
  </div>
</template>

<script>
import ProfileCard from './ProfileCard.vue'
import ProfileFeatures from './ProfileFeatures.vue'
import userService from '../../services/UserService'

export default {
  name: "profile-page-background",
    components: {
        ProfileCard,
        ProfileFeatures
    },
    data() {
    return {
        selectedPokemon: '',
        badges: [],
        user: 'wait',
        cards: []
    }
    },
    created() { 
        userService.getUserDetails(this.$route.params.id)
                    .then(response => this.user = response.data);
        userService.getAllCardsForUser(this.$route.params.id)
                    .then(response => this.cards = response.data);
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

.profile{
    padding-right: 10px;
    border-right: solid white;
    box-shadow: 10px 0px 10px -2px #dedede; 
}
</style>