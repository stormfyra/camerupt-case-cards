<template>
    <div id="collection-container">
        <div v-for="collection in collections" :key="collection.index"  class="collectionImage">
            <router-link class="title-holder" :to="{name: 'collectionDetails', params: {collectionId: collection.collectionId}}"> 
                    <p class="title">{{collection.title}}</p>
                    <p> <em>Owner: {{collection.ownerUsername}}</em></p>
            </router-link>
            <router-link :to="{name: 'collectionDetails', params: {collectionId: collection.collectionId}}">    
                <img src="../../../resources/backOfPokemonCard.jpg" alt="" class="cardBack">
            </router-link> 
        </div>
    </div>
</template>

<script>

export default {
    name: 'CollectionGrid',
    props: [
        'collections'
    ],
    
}
</script>

<style scoped>
.collectionImage {
    width: 200px;
    height: 280px;
    border: 2px solid black;
    border-radius: 10px;
    margin: 10px;
    position: relative;
    z-index: 1;
    display: flex;
    justify-content: center;
    align-items: center;
}
.cardBack {
    position: absolute;
    top: 0;
    left: 0;
    width: 200px;
    height: 280px;
    border-radius: 10px;
}
p {
    margin: 5px;
}
.title-holder {
    background-color: rgb(0, 0, 0);
    color: white;
    position: absolute;
    z-index: 2;
    width: 86%;
    height: 25%;
    font-size: large;
    text-align: center;
    border-radius: 10px;
    border: solid  white;
}

#collection-container {
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
    #collection-container {
        grid-template-columns: 1fr 1fr;
    }
}
/* Small devices (portrait tablets and large phones, 600px and up) */
@media only screen and (min-width: 600px) {
    #collection-container {
        grid-template-columns: 1fr 1fr 1fr;
    }
}
/* Medium devices (landscape tablets, 768px and up) */
@media only screen and (min-width: 768px) {
    #collection-container {
        grid-template-columns: 1fr 1fr 1fr 1fr;
    }
}
/* Large devices (laptops/desktops, 992px and up) */
@media only screen and (min-width: 992px) {
    #collection-container {
        grid-template-columns: 1fr 1fr 1fr 1fr 1fr;
    }
}
/* Extra large devices (large laptops and desktops, 1200px and up) */
@media only screen and (min-width: 1200px) {
    #collection-container {
        grid-template-columns: 1fr 1fr 1fr 1fr 1fr 1fr 1fr 1fr;
    }
}
</style>