<template>
    <div class="profile-card">
        <h1 class="user-name">{{user.username}}</h1>
        <img class="profile-image" :src='pokemonImages[pokemon]' alt="">
        <em><p class="bio"> {{user.bio}}</p></em>
        <h3>{{user.email}}</h3>
        <h3>{{user.fullName}}</h3>
        <h3>{{user.shippingAddress}}</h3>
    </div>
</template>

<script>

export default {
    props: [
        'pokemon'
    ],
    data(){
        return {
            user: {
                username: '',
                imageLink: '',
                bio:'',
                email: '',
                fullName: '',
                shippingAddress: ''
            },
            pokemonImages: {
                'Camerupt': '/img/camerupt.ea9cad37.png',
                'Bulbasaur': '/img/bulbasaur.f0b06b8f.png',
                'Squirtle': '/img/squirtle.6a3d8153.png',
                'Charmander': '/img/charmander.603508ed.png',
                'Pikachu': '/img/pikachu.2f64e2bf.png',
                'Chikorita': '/img/chikorita.93ba3edf.png',
                'Totodile': '/img/totodile.4c7b2c45.png',
                'Cyndaquil': '/img/cyndaquil.647a8e91.png',
                'Treecko': '/img/treecko.8890fffb.png',
                'Mudkip': '/img/mudkip.926b74e1.png',
                'Torchic': '/img/torchic.e9c21fc4.png'
            }
        }
    },
    // computed: {
    //     imgSrc() {
    //         return require.context('../../../resources' + this.pokemon + '.png');
    //     }
    // },
    created() {
        this.user = this.$store.state.user;
    }
}

</script>

<style scoped>

.profile-card {
    display: flex;
    flex-direction: column;
    border: solid rgb(255, 208, 0) 15px;
    border-radius: 20px;
    width: 560px;
    background-color: tomato;
    margin: auto;
    margin-top: 50px;
    padding: 3%;
}
.profile-image {
    flex-grow: 4;
    height: 240px;
    width: 90%;
    margin-left: 5%;
    border-radius: 10px;
}
.bio {
    background-color: rgb(233, 76, 49);
    border-radius: 5px;
    border: solid rgb(231, 45, 12) 3px;
}
h3 {
    background-color: rgb(233, 76, 49);
    border-radius: 5px;
    border: solid rgb(231, 45, 12) 3px;
}

</style>