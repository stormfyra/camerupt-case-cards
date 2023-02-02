<template>
    <collection-grid :collections="personalCollections" :ownedByMe="true"></collection-grid>
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
            username: ''
        }
    },
    created() {
        this.username = this.$store.state.user.username;
        collectionService.getAllCollections()
                         .then(response => {
                            response.data.forEach(element => {
                                console.log(element);
                                console.log(this.username);
                                if (element.ownerUsername == this.username){
                                    this.personalCollections.push(element)
                                } 
                            });
                         });
    },

}
</script>