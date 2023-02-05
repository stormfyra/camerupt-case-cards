<template>
    <div id="card-container">
        <div v-for="(card, index) in cards" :key="index">
            <img :src="card.images.small" :alt="card.cardName" class="cardImage" />
            <div id="quantity-div">
                <button v-if="ownedByMe" class="change-quantity" @click="updateQuantity(card, -1)">-</button>
                <p id="cardQuantity"><strong>x{{card.quantity}}</strong></p>
                <button v-if="ownedByMe" class="change-quantity" @click="updateQuantity(card, 1)">+</button>
            </div>
        </div>
    </div>
</template>

<script>
import collectionService from '../../services/CollectionService';
export default {
    name: 'CardGrid',
    emits: ['deleteCard'],
    props: [
        "cards",
        "ownedByMe"
    ],
    methods: {
        updateQuantity(card, change) {
            const newQuantity = card.quantity + change;
            if (newQuantity < 1) {
                collectionService.deleteCardFromCollection(this.$route.params.collectionId, card.id);
                this.deleteCard(card);
            } else {
                card.quantity = newQuantity;
                collectionService.updateQuantity(this.$route.params.collectionId, card);
            }
        },
        deleteCard(card) {
            this.$emit('deletecard', card.id);
        }
    }
}
</script>

<style scoped>
.cardImage {
    width: 200px;
    height: 280px;
    border: 2px solid black;
    border-radius: 10px;
    margin: 10px;
}

#card-container {
    width: 100%;
    display: flex;
    flex-wrap: wrap;
    justify-content: space-evenly;
    align-items: center;
    background-color: #87CEEE;
    height: auto + 40px;
    padding: 10px 0px;
}

#cardQuantity {
    background-color: #000000;
    color: #FFFFFF;
    text-align: center;
    border-radius: 45%;
    flex-grow: 1;
}

/* Extra small devices (phones, 600px and down) */
@media only screen and (max-width: 600px) {
    #card-container {
        grid-template-columns: 1fr 1fr;
    }
}
/* Small devices (portrait tablets and large phones, 600px and up) */
@media only screen and (min-width: 600px) {
    #card-container {
        grid-template-columns: 1fr 1fr;
    }
}
/* Medium devices (landscape tablets, 768px and up) */
@media only screen and (min-width: 768px) {
    #card-container {
        grid-template-columns: 1fr 1fr 1fr;
    }
}
/* Large devices (laptops/desktops, 992px and up) */
@media only screen and (min-width: 992px) {
    #card-container {
        grid-template-columns: 1fr 1fr 1fr;
    }
}
/* Extra large devices (large laptops and desktops, 1200px and up) */
@media only screen and (min-width: 1200px) {
    #card-container {
        grid-template-columns: 1fr 1fr 1fr 1fr 1fr 1fr;
    }
}

#quantity-div {
    display: flex;
    flex-direction: row;
    margin: 10px;
    margin-top: -10px;
    gap: 5px;
    align-items: center;
}

.change-quantity {
    height: 50%;
    background-color: blue;
    border-radius: 50%;
}
</style>