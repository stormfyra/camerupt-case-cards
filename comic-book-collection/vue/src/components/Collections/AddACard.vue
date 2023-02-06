<template>
<scrolly :style="{ width: '750px', height: '600px' }">
    <scrolly-viewport>
        <div class="form-container">
                <button id="close-add-card" @click="off">X</button>
                <input type="text" v-model="internalSearchParamater" id="searchbar" />
                <div id="button-bar">
                    <button @click="addSelectedCards">Add selected</button>
                    <label for="search-all-cards">Not finding the right card?
                        <button name="search-all-cards" @click="searchAllCards">Search all cards</button>
                    </label>
                </div>
                <div class="choose-a-card">
                    <img class="card-image selected-card" v-for="card in selectedCards" :key="card.id" :src="card.images.small" @click="removeFromSelectedCards(card)" />
                    <img class="card-image" v-for="card in filteredCards" :key="card.id" :src="card.images.small" @click="addToSelectedCards(card)" />
                    <img class="card-image" v-for="card in filteredExternalCards" :key="card.id" :src="card.images.small" @click="addToSelectedCards(card)" />
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
            internalCards: [],
            externalCards: [],
            selectedCards: []
        }
    },
    props: [
        'collectionId',
        'collectedCardIds'
    ],
    components: {
        Scrolly,
        ScrollyViewport,
        ScrollyBar,
    },
    computed: {
        filteredCards(){
            let filteredCards = this.internalCards.filter(card => {
               return card.name.toLowerCase().includes(this.internalSearchParamater.toLowerCase())
            });
            filteredCards = filteredCards.filter(card => {
                return !this.selectedIds.has(card.id);
            });
            filteredCards = filteredCards.filter(card => {
                return !this.collectedCardIds.has(card.id);
            })
            return filteredCards;
        },
        selectedIds() {
            const selectedIds = new Set();
            for (let i = 0; i < this.selectedCards.length; i++) {
                selectedIds.add(this.selectedCards[i].id)
            }
            return selectedIds;
        },
        filteredCardIds() {
            const idsFromFilteredCards = new Set();
            for (let i = 0; i < this.filteredCards.length; i++) {
                idsFromFilteredCards.add(this.filteredCards[i].id)
            }
            return idsFromFilteredCards;
        },
        filteredExternalCards() {
            return this.externalCards.filter(card => {
                return !this.selectedIds.has(card.id) && !this.filteredCardIds.has(card.id) && !this.collectedCardIds.has(card.id);
            })
        }
    },
    created() {
        cardService.getAllCards()
                    .then(response => {
                        console.log(response)
                        this.internalCards = response.data
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
        addToSelectedCards(card) {
            this.selectedCards.push(card);
        },
        removeFromSelectedCards(card) {
            this.selectedCards.pop(card);
        },
        addSelectedCards() {
            cardService.addCards(this.collectionId, this.selectedCards);
            this.selectedCards = [];
            this.off();
            this.$router.go();
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
    display: flex;
    flex-direction: column;
    padding-top: 20px;
    padding-bottom: 20px;
}

.card-image {
    width: 200px;
    height: 280px;
    border: 2px solid black;
    border-radius: 10px;
    margin: 10px;
}

.selected-card {
    border: blue 10px solid;
}

scrolly:hover {
    cursor: default;
}

.card-image:hover{
    cursor: pointer;
}

#close-add-card {
    width: 20px;
    height: 20px;
    align-self: flex-end;
    margin-right: 20px;
}

#searchbar {
    width: 80%;
    align-self: center;
    margin-bottom: 20px;
}

#button-bar {
    display: flex;
    justify-content: space-around;
    margin-bottom: 10px;
}
</style>