<template>
    <scrolly :style="{ width: '750px', height: '600px' }">
        <scrolly-viewport>
            <div class="form-container">
                <p>Are you sure you want to delete this collection? This action cannot be undone.</p>
                <button @click="deleteThisCollection">Yes, delete this</button>
                <button id="close-edit-collection" @click="off">No, take me back</button>
            </div>
        </scrolly-viewport>
        <scrolly-bar axis="y"></scrolly-bar>
        <scrolly-bar axis="x"></scrolly-bar>
    </scrolly>
</template>

<script>
import collectionService from '../../services/CollectionService.js'
import { Scrolly, ScrollyViewport, ScrollyBar } from 'vue-scrolly'

export default {
    name: 'confirm-delete',
    components: {
        Scrolly,
        ScrollyViewport,
        ScrollyBar,
    },
    methods: {
        off() {
        this.$store.commit('CHANGE_SHOW_DELETE_COLLECTION')
        this.$store.commit('CHANGE_SHOW_EDIT_COLLECTION_FORM')
        },
        deleteThisCollection() {
        collectionService.deleteCollection(this.$route.params.collectionId)
        this.off()
        this.$router.push({name: 'collections'})
                    .then(this.$router.go())
            }
        }
}
</script>

<style scoped>
</style>