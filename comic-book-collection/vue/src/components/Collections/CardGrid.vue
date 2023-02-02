<template>
    <div id="card-container">
        <img v-for="(card, index) in cards" :key="index" :src="card.smallImage" :alt="card.cardName" class="cardImage" />
    </div>
</template>

<script>

export default {
    name: 'CardGrid',
    props: [
        "cards"
    ]
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
    display: grid;
    justify-items: center;
    align-items: center;
    background-color: #87CEEE;
    height: auto + 40px;
    padding: 10px 0px;
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
</style>