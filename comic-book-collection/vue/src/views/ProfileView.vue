<template>
    <div>
        <profile-card :pokemon="selectedPokemon"></profile-card>
    </div>
</template>

<script>
import profileCard from "../components/Edit Profile/ProfileCard.vue"

export default {
    components: {
        profileCard
    },
    data() {
        return {
            selectedPokemon: 'Camerupt',
        }
    },
    created() {
        this.selectedPokemon = this.$store.state.user.profilePokemon;
    }
}

</script>

<style scoped>

</style>