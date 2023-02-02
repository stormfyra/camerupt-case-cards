<template>
    <div id="collection-container" class="text-center">
        <button class="empty-card" v-on:click="showAddForm"><h1>+</h1></button>
        <!-- remove hideAddForm onclick; it makes the form not functional -->
        <div id="overlay" v-on:click="hideAddForm">
            <add-collection id="overlay-form" />
        </div>
        <div v-for="collection in collections" :key="collection.index"  class="collectionImage">
            <router-link class="title-holder" :to="{name: 'collectionDetails', params: {collectionId: collection.collectionId}}"> 
                    <p class="title">{{collection.title}}</p>
                    <p v-if="!ownedByMe"><em>Owner: {{collection.ownerUsername}}</em></p>
            </router-link>
            <router-link :to="{name: 'collectionDetails', params: {collectionId: collection.collectionId}}">    
                <img src="../../../resources/backOfPokemonCard.jpg" alt="" class="cardBack">
            </router-link>
            <router-link :to="{name: 'collectionDetails', params: {collectionId: collection.collectionId}}">
                <p class="privacyStatus" v-if="ownedByMe">{{ collection.isPrivate ? "private" : "public" }}</p>
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
        'ownedByMe'
    ],
    methods: {
        showAddForm() {
              document.getElementById("overlay").style.display = "block";
        },
        hideAddForm() {
            document.getElementById("overlay").style.display = "none";
        }
    }
  
}
</script>

<style scoped>

#collection-container {
    width: 100%;
    display: grid;
    justify-items: center;
    align-items: center;
    background-color: #879fee;
    height: auto + 40px;
    padding: 10px 12px;
}

.text-center {
    height: 330px;
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

button > h1 {
    font-size: 50pt;
    font-weight: 500;
    color: rgb(109, 109, 109);
}

#overlay {
  position: fixed;
  display: none;
  width: 100%;
  height: 100%;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background-color: rgba(0,0,0,0.5);
  z-index: 2;
  cursor: pointer;
}

#overlay-form{
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%,-50%);
  -ms-transform: translate(-50%,-50%);
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