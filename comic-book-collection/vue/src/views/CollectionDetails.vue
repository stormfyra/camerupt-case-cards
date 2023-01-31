<template>
    <div>
        <h1 class="collectionTitle">{{title}}</h1>
        <h2 class="collectionOwnerDeclaration">This collection is owned by {{ownerUsername}}</h2>
        <p class="collectionDescription"><em>{{description}}</em></p>
        <card-grid :cards='cards'/>
    </div>
</template>

<script>
import CardGrid from "../components/Collections/CardGrid.vue" 
import collectionWebService from '../services/CollectionService'


export default {
    components: {
        CardGrid,
    },
    data(){
        return {
           ownerUsername: '',
           title: '',
           description: '',
           isPrivate: '',
           cards: []
        }
    },

    created() {
        collectionWebService.getCollectionDetails(this.$route.params.collectionId)
                            .then(response => {
                                this.ownerUsername = response.data.ownerUsername;
                                this.title = response.data.title;
                                this.description = response.data.description;
                                this.isPrivate = response.data.private;
                                this.cards = response.data.cards;
                            })
    }
}

</script>

<style scoped>
card-grid {
    display: flex;
    justify-content: center;
}
.collectionTitle, .collectionOwnerDeclaration, .collectionDescription {
    text-align: center;
}
</style>