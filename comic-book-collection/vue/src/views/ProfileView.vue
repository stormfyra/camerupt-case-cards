<template>
    <div>
        <profile-card :pokemon="selectedPokemon"></profile-card>
        <select name="pokemon-rep" v-model="selectedPokemon" @change="updateProfilePokemon">
            <option v-for="pokemon in pokemons" :key="pokemon">{{pokemon}}</option>
        </select>
    </div>
</template>

<script>
import profileCard from "../components/Edit Profile/ProfileCard.vue"
import userService from "../services/UserService"

export default {
    components: {
        profileCard
    },
    data() {
        return {
            selectedPokemon: 'Camerupt',
            pokemons: ['Camerupt',
                      'Bulbasaur',
                      'Squirtle',
                      'Charmander',
                      'Pikachu',
                      'Chikorita',
                      'Totodile',
                      'Cyndaquil',
                      'Treecko',
                      'Mudkip',
                      'Torchic']
        }
    },
    created() {
        this.selectedPokemon = this.$store.state.user.profilePokemon;
    },
    methods :{
        updateProfilePokemon() {
            this.$store.commit('UPDATE_PROFILE_POKEMON', this.selectedPokemon);
            userService.updateProfilePokemon(this.selectedPokemon);
        }
    }
}

</script>

<style scoped>

</style>