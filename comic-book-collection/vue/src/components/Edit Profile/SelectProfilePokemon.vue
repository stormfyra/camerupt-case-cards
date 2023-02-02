<template>
    <select name="pokemon-rep" v-model="selectedPokemon" @change="updateProfilePokemon">
        <option v-for="pokemon in pokemons" :key="pokemon">{{pokemon}}</option>
    </select>
</template>

<script>
    import userService from '../../services/UserService';

    export default {
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
        methods: {
            updateProfilePokemon() {
                this.$store.commit('UPDATE_PROFILE_POKEMON', this.selectedPokemon);
                userService.updateProfilePokemon(this.selectedPokemon);
            }
        }
    }
</script>
