<template>
    <div>
        <profile-card :pokemon="selectedPokemon"></profile-card>
        <select name="pokemon-rep" v-model="selectedPokemon">
            <option v-for="pokemon in pokemons" :key="pokemon">{{pokemon}}</option>
        </select>
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
    }
}

</script>

<style scoped>

</style>