<template>
            <div class="form-container">
                <h2>Are you sure you want to delete this collection?</h2>
                <p>This action cannot be undone.</p>
                <div class="button-container">
                <button id="delete-collection" @click="deleteThisCollection">Yes, delete this</button>
                <button id="close-confirmation" @click="off">No, take me back</button>
                </div>
            </div>
</template>

<script>
import collectionService from '../../services/CollectionService.js'

export default {
    name: 'edit-collection',
    props: [
        'collection'
    ],
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
.hide-form {
    display: none;
}

.form-container {
max-width: 100%;
margin: 30px;
margin-top: 100px;
padding: 40px;
background-color: white;
border-radius: 10px;
display: flex;


justify-content: center;
align-content: center;
}

.button-container {
    display: flex;
    justify-content: space-between;
    gap: 30px;
}
button {
    padding: 0px 10px;
    width: 100%;
}
#delete-collection {
    color: #e93d40;
    background-color: white;
    border: solid #e93d40 2px;
}

input:checked + .slider {
  background-color: #2196F3;
}

input:focus + .slider {
  box-shadow: 0 0 1px #2196F3;
}

input:checked + .slider:before {
  -webkit-transform: translateX(26px);
  -ms-transform: translateX(26px);
  transform: translateX(26px);
}

.private-text {
    text-align: center;
}

button:hover{
    cursor: pointer;
}
h2{
    margin: 0px;
}

</style>