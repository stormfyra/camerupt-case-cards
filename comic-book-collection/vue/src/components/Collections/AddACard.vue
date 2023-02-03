<template>
<scrolly :style="{ width: '750px', height: '600px' }">
    <scrolly-viewport>
        <div class="form-container">
                <input type="text" v-model="internalSearchParamater" />
                <div class="choose-a-card">
                    <img class="card-image" v-for="card in filteredCards" :key="card.cardId" :src="card.smallImage" />
                </div>
        </div>
    </scrolly-viewport>
    <scrolly-bar axis="y"></scrolly-bar>
    <scrolly-bar axis="x"></scrolly-bar>
</scrolly>
</template>

<script>
import cardService from "../../services/CardService"
import { Scrolly, ScrollyViewport, ScrollyBar } from 'vue-scrolly'


export default {
    data() {
        return {
            internalSearchParamater: '',
            cards: []
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