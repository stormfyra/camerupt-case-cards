<template>
    <div id="friends-container" class="text-center">
        <!-- add friend button + overlay -->
        <button class="empty-card" v-on:click="showAddForm"><h1>+</h1></button>
        <div id="overlay" v-if="$store.state.showAddCollectionForm">
            <add-collection id="overlay-form"/>
        </div>

        <!-- display all friends; TO-DO: change to the user's friends -->
        <div v-for="user in users" v-bind:key="user.index" class="collectionImage">
            <button class="empty-card">
                <router-link class="title-holder" :to="{name: 'profileWithId', params: {id: user.id}}"> 
                    <p class="title">{{user.username}}</p>
                </router-link>
            </button>
        </div>

    </div>
</template>

<script>
export default {
    name: 'FriendsView',
    // TO-DO: change to friends
    props: [
        'users'
    ],
    methods: {
        //TO-DO: change to add friends form
        showAddForm() {
              this.$store.commit('CHANGE_SHOW_COLLECTION_FORM');
        }
    }
  
}
</script>

<style scoped>

#friends-container {
    width: 100%;
    display: grid;
    align-items: center;
    height: 100%;
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
  width: 100%;
  height: 100%;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background-color: rgba(0,0,0,0.5);
  z-index: 5;
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
        grid-template-columns: 1fr 1fr;
    }
}
/* Medium devices (landscape tablets, 768px and up) */
@media only screen and (min-width: 768px) {
    #collection-container {
        grid-template-columns: 1fr 1fr 1fr;
    }
}
/* Large devices (laptops/desktops, 992px and up) */
@media only screen and (min-width: 992px) {
    #collection-container {
        grid-template-columns: 1fr 1fr 1fr;
    }
}
/* Extra large devices (large laptops and desktops, 1200px and up) */
@media only screen and (min-width: 1200px) {
    #collection-container {
        grid-template-columns: 1fr 1fr 1fr 1fr 1fr 1fr;
    }
}
</style>