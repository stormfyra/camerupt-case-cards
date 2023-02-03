<template>
<scrolly :style="{ width: '750px', height: '600px' }">
    <scrolly-viewport>
        <div class="form-container">
                <input type="text" v-model="internalSearchParamater" />
                <label for="search-all-cards">Not finding the right card?</label>
                <button name="search-all-cards" @click="searchAllCards">Search all cards</button>
                <button @click="off">Close</button>
                <div class="choose-a-card">
                    <img class="card-image" v-for="card in filteredCards" :key="card.cardId" :src="card.smallImage" />
                    <img class="card-image" v-for="card in externalCards" :key="card.cardId" :src="card.images.small" />
                </div>    
        </div>
    </scrolly-viewport>
    <scrolly-bar axis="y"></scrolly-bar>
    <scrolly-bar axis="x"></scrolly-bar>
</scrolly>
</template>

<script>
import cardService from "../../services/CardService"
import externalPokemonCardService from "../../services/ExternalPokemonCardService"
import { Scrolly, ScrollyViewport, ScrollyBar } from 'vue-scrolly'


export default {
    data() {
        return {
            internalSearchParamater: '',
            cards: [],
            externalCards: []
        }
    },
     components: {
      Scrolly,
      ScrollyViewport,
      ScrollyBar,
     },
    computed: {
        filteredCards(){
            return this.cards.filter(card => {
               return card.cardName.toLowerCase().includes(this.internalSearchParamater.toLowerCase())
            })
        }
    },
    created() {
        cardService.getAllCards()
                    .then(response => {
                        console.log(response)
                        this.cards = response.data
                    })
    },
    methods: {
        searchAllCards() {
            externalPokemonCardService.getCardByNamePart(this.internalSearchParamater).then(response => {
                this.externalCards = response.data.data;
                this.filterExternalCards();
            }).bind(this)
        },
        off() {
            this.externalCards = [];
            this.$store.commit('CHANGE_SHOW_ADD_CARD')
        },
        filterExternalCards() {
            const idsWeAlreadyHave = new Set();
            for (let i = 0; i < this.cards.length; i++) {
                idsWeAlreadyHave.add(this.cards[i].cardId);
            }
            this.externalCards = this.externalCards.filter(card => {
                return !idsWeAlreadyHave.has(card.id);
            })
        }
    }
}
</script>

<style scoped>
.choose-a-card {
    display: flex;
    flex-wrap: wrap;
    justify-content: space-evenly;
}

.form-container {
    max-width: 100%;
    margin: 10px;
    background-color: white;
    border-radius: 10px;
}

.card-image {
    width: 200px;
    height: 280px;
    border: 2px solid black;
    border-radius: 10px;
    margin: 10px;
}

</style>