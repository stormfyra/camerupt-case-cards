<template>
    <div>
        <div v-if="username != '' && personalCollections.length > 0">
            <h1>Your Collections</h1>
            <collection-grid :collections="personalCollections" :ownedByMe="true"></collection-grid>
        </div>
        <h1>Public Collections</h1>
        <collection-grid :collections="publicCollections" :ownedByMe="false"></collection-grid>
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

</style>