<template>
    <collection-grid :collections="collections"></collection-grid>
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
            collections: []
        }
    },
    created() {
        collectionService.getAllCollections()
                         .then(response => {
                             this.collections = response.data
                         });
    }
}
</script>

    
    

<style scoped>

</style>