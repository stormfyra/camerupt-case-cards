<template>
    <div :class="smallView ? 'small-collection-container' : 'collection-container'">
        <button class="empty-card" v-on:click="showAddForm" v-if="!smallView"><h1>+</h1></button>
        <div class="overlay" v-if="$store.state.showAddCollectionForm">
            <add-collection class="overlay-form"/>
        </div>
        <div v-for="collection in collections" :key="collection.index"  :class="smallView ? 'smallCollecitonImage' : 'collectionImage'">
            <router-link :class="smallView ? 'small-title-holder' : 'title-holder'" :to="{name: 'collection', params: {collectionId: collection.collectionId}}"> 
                <p class="title">{{collection.title}}</p>
                <p v-if="!ownedByMe && !smallView"><em>Owner: {{collection.ownerUsername}}</em></p>
            </router-link>
            <router-link :to="{name: 'collection', params: {collectionId: collection.collectionId}}">    
                <img src="../../../resources/backOfPokemonCard.jpg" alt="" :class="smallView ? 'smallCardBack' : 'cardBack'">
            </router-link>
            <router-link :to="{name: 'collection', params: {collectionId: collection.collectionId}}">
                <p class="privacyStatus" v-if="ownedByMe">{{ collection.private ? "private" : "public" }}</p>
            </router-link>
        </div>
    </div>
</template>

<script>
import AddCollection from './AddCollection.vue';
export default {
  components: { AddCollection },
    name: 'CollectionGrid',
    props: [
        'collections',
        'ownedByMe',
        'smallView'
    ],
    methods: {
        showAddForm() {
              this.$store.commit('CHANGE_SHOW_COLLECTION_FORM');
        },
        // hideAddForm() {
        //     document.getElementById("overlay").style.display = "none";
        // }
    }
  
}
</script>

<style scoped>

.collection-container {
    width: 100%;
    display: grid;
    justify-items: center;
    align-items: center;
    background-color: #879fee;
    height: auto;
    padding: 10px 12px;
    border-radius: 30px;
    box-shadow:  0 0 3px -1px transparent, 0 0 2px 1px transparent
        , 0 0 5px 0px transparent, 0px 10px 15px -5px rgb(97, 94, 94)
        , 0 2px 20px -5px rgb(97, 94, 94), 0 0 20px 0px transparent;
}

.small-collection-container {
    width: 100%;
    display: flex;
    justify-items: top;
    align-items: top;
    height: auto;
    flex-wrap: wrap;
    padding: 10px;
}

.collectionImage {
    width: 200px;
    height: 280px;
    border: 2px solid black;
    border-radius: 10px;
    margin: 10px;
    position: relative;
    z-index: 1;
    display: flex;
    align-items: flex-end;
}

.cardBack {
    position: absolute;
    top: 0;
    left: 0;
    width: 200px;
    height: 280px;
    border-radius: 10px;
}

.smallCollectionImage {
    width: 100px;
    height: 100px;
    max-height: 330px;
    border: 2px solid black;
    position: relative;
    z-index: 1;
}
.smallCardBack {
    position: relative;
    top: 0;
    left: 0;
    width: 100px;
    height: 140px;
    border-radius: 10px;
}
p {
    margin: 5px;
}
.privacyStatus {
    z-index: 3;
    color: white;
    position: absolute;
    bottom: 0;
    right: 0;
}
.title-holder {
    background-color: rgba(0, 0, 0, 0.75);
    color: white;
    position: absolute;
    z-index: 2;
    width: 100%;
    height: 25%;
    font-size: large;
    text-align: center;
    padding-top: 5px;
}

.small-title-holder {
    background-color: rgba(0, 0, 0, 0.75);
    color: white;
    position: absolute;
    z-index: 2;
    width: 100px;
    font-size: x-small;
    height: 22px;
    text-align: center;
    padding-top: 5px;
    border-radius:10px 10px  0 0;
}

button > h1 {
    font-size: 50pt;
    font-weight: 500;
    color: rgb(109, 109, 109);
}



/* Extra small devices (phones, 600px and down) */
@media only screen and (max-width: 600px) {
    .collection-container {
        grid-template-columns: 1fr 1fr;
    }
}
/* Small devices (portrait tablets and large phones, 600px and up) */
@media only screen and (min-width: 600px) {
    .collection-container {
        grid-template-columns: 1fr 1fr;
    }
}
/* Medium devices (landscape tablets, 768px and up) */
@media only screen and (min-width: 800px) {
    .collection-container {
        grid-template-columns: 1fr 1fr 1fr;
    }
}
/* Large devices (laptops/desktops, 992px and up) */
@media only screen and (min-width: 1200px) {
    .collection-container {
        grid-template-columns: 1fr 1fr 1fr 1fr;
    }
}
/* Extra large devices (large laptops and desktops, 1200px and up) */
@media only screen and (min-width: 1400px) {
    .collection-container {
        grid-template-columns: 1fr 1fr 1fr 1fr 1fr;
    }
}
</style>