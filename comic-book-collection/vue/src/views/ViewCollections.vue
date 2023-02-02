<template>
    <div>
        <div v-if="username != '' && personalCollections.length > 0">
            <h1>Your Collections</h1>
            <collection-grid :collections="personalCollections" :ownedByMe="true"></collection-grid>
        </div>
        <h1>Public Collections</h1>
        <collection-grid :collections="publicCollections" :ownedByMe="false"></collection-grid>
        <h1>Add A New Collection</h1>
        <div class="form-popup" id="form">
            <form class="form-container">
                <label for="title">Title</label>
                <input 
                    type="text"
                    id="title"
                    placeholder="Title"
                    required
                />
                <div id="radioButton">
                    <label for="private">Private</label>
                    <input
                        type="radio"
                        id="privacy"
                        name="privacy"
                    />
                    <label for="private">Public</label>
                    <input
                        type="radio"
                        id="privacy"
                        name="privacy"
                    />
                </div>
                <button id="submit">Submit</button>
                <button id="close" onClick="off()">Close</button>
            </form>
        </div>
    </div>
</template>

<script>
import CollectionGrid from "../components/Collections/CollectionGrid.vue"
import collectionService from "../services/CollectionService"

export default {
    components: {
        CollectionGrid
    },
    data() {
        return {
            personalCollections: [],
            publicCollections: [],
            username: ''
        }
    },
    created() {
        // This initialization calls the logged in user from the store and then contacts our server for all collecitons
        // Then sorts collections into user-ownd collections and public collections 
        this.username = this.$store.state.user.username;
        collectionService.getAllCollections()
                         .then(response => {
                            response.data.forEach(element => {
                                console.log(element);
                                console.log(this.username);
                                if (element.ownerUsername == this.username){
                                    this.personalCollections.push(element)
                                } else {
                                    this.publicCollections.push(element)
                                }
                            });
                         });
    }
}
</script>

    
    

<style scoped>

.form-container {
  max-width: 300px;
  padding: 10px;
  background-color: white;
}

input{
  width: 90%;
  height: 20%;
  padding: 15px;
  margin: 5px 0 22px 0;
  border: none;
  background: #f1f1f1;
}

#radioButton{
    display: flex;
    justify-content: space-between;
}
</style>