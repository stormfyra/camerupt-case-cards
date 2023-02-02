<template>
  <div class="profile-page-background">
      <div class="text-center page">
        <!-- card -->
      <profile-card :pokemon="selectedPokemon" class="card"></profile-card>
      <!-- features -->
      <profile-features></profile-features>
      </div>
  </div>
</template>

<script>
import ProfileCard from './ProfileCard.vue'
import ProfileFeatures from './ProfileFeatures.vue';
export default {
  name: "profile-page-background",
    components: {
        ProfileCard,
        ProfileFeatures
    },
    data() {
    return {
        selectedPokemon: 'Camerupt',
    }
    },
    created() {
        this.selectedPokemon = this.$store.state.user.profilePokemon;
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
    gap: 100px;
}

.card {
    grid-area: card;
}
</style>