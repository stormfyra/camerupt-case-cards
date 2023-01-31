<template>
    <card-grid :cards='cards'/>
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
</style>