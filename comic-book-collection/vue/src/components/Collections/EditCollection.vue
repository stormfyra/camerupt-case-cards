<template>
    <div id="edit-collection">
<<<<<<< HEAD
<<<<<<< HEAD
        <scrolly :style="{ width: '600px', height: '700px' }">
            <scrolly-viewport>
                <form class="form-container">
                    <div id="title-and-close">
                      <h1 id="title">Edit Your Collection</h1>
                      <button id="close-edit-collection" @click="off">X</button>
                    </div>
                    <label for="title">Title</label>
                    <input 
                        type="text"
                        name="title"
                        placeholder="Title"
                        v-model="updatedCollection.title"
                    />
                    <label for="description">Description</label>
                    <input 
                        type="text"
                        id="description"
                        placeholder="Description"
                        v-model="updatedCollection.description"
                    />
                    <div class="switch-div">
                        <p class="private-text" style="display: inline-block">public</p>
                        <label class="switch">
                            <input type="checkbox" v-model="updatedCollection.isPrivate" />
                            <span class="slider round" />
                        </label>
                        <p class="private-text" style="display: inline-block">private</p>
                    </div>
                    <button id="submit" @click.prevent="onSubmit">Submit</button>
                    <button @click.prevent="showDeleteCollection">Delete</button>
                    <div class="overlay" v-if="$store.state.showDeleteCollection">
                      <confirm-delete class="overlay-form" :collection="collection" />
                    </div>
                </form>
            </scrolly-viewport>
            <scrolly-bar axis="y"></scrolly-bar>
            <scrolly-bar axis="x"></scrolly-bar>
            </scrolly>

            
=======
=======
>>>>>>> 1ec2fba022b3931461f14208a1df9c03385c6a4a
      <h1>Edit Your Collection</h1>
      <label for="title">Title</label>
      <input 
          type="text"
          name="title"
          placeholder="Title"
          v-model="updatedCollection.title"
      />
      <label for="description">Description</label>
      <input 
          type="text"
          id="description"
          placeholder="Description"
          v-model="updatedCollection.description"
      />
      <div class="switch-div">
          <p class="private-text" style="display: inline-block">public</p>
          <label class="switch">
              <input type="checkbox" v-model="updatedCollection.isPrivate" />
              <span class="slider round" />
          </label>
          <p class="private-text" style="display: inline-block">private</p>
      </div>
      <button id="submit" @click.prevent="onSubmit">Submit</button>
      <button @click="deleteThisCollection">DELETE</button>       
<<<<<<< HEAD
>>>>>>> 1ec2fba022b3931461f14208a1df9c03385c6a4a
=======
>>>>>>> 1ec2fba022b3931461f14208a1df9c03385c6a4a
    </div>
</template>

<script>
import collectionService from '../../services/CollectionService.js'
<<<<<<< HEAD
<<<<<<< HEAD
import { Scrolly, ScrollyViewport, ScrollyBar } from 'vue-scrolly'
import confirmDelete from './ConfirmDelete.vue'

export default{
  name: 'edit-collection',
  components: {
      Scrolly,
      ScrollyViewport,
      ScrollyBar,
      confirmDelete
  },
=======

export default{
  name: 'edit-collection',
>>>>>>> 1ec2fba022b3931461f14208a1df9c03385c6a4a
=======

export default{
  name: 'edit-collection',
>>>>>>> 1ec2fba022b3931461f14208a1df9c03385c6a4a
  data() {
      return {
          updatedCollection: {},
      }
  },
  props: [
      'collection'
  ],
  created() {
      this.updatedCollection = this.collection;
  },
  methods: {
      off() {
          this.$store.commit('CHANGE_SHOW_COLLECTION_FORM')
      },
      onSubmit() {
        collectionService.updateCollection(
              this.$route.params.collectionId, this.updatedCollection
            );
        this.off();
        this.$router.go()
      },
      showDeleteCollection() {
        this.$store.commit('CHANGE_SHOW_DELETE_COLLECTION')
      },
  },
};
</script>

<style scoped>
.hide-form {
    display: none;
}

<<<<<<< HEAD
<<<<<<< HEAD
.form-container {
max-width: 100%;
margin: 15px;
padding-bottom: 40px;
background-color: white;
border-radius: 10px;
display: flex;
}

#title-and-close {
display: flex;
align-items: center;
justify-content: space-between;
}

#close-edit-collection {
    width: 25px;
    height: 25px;
}

=======
>>>>>>> 1ec2fba022b3931461f14208a1df9c03385c6a4a
=======
>>>>>>> 1ec2fba022b3931461f14208a1df9c03385c6a4a
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
.switch-div{
    display: flex;
    align-items: center;
    gap: 5px;
}
    /* The switch - the box around the slider */
.switch {
  position: relative;
  display: inline-block;
  width: 60px;
  height: 34px;
}

/* Hide default HTML checkbox */
.switch input {
  opacity: 0;
  width: 0;
  height: 0;
}

/* The slider */
.slider {
  position: absolute;
  cursor: pointer;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background-color: #ccc;
  -webkit-transition: .4s;
  transition: .4s;
}

.slider:before {
  position: absolute;
  content: "";
  height: 26px;
  width: 26px;
  left: 4px;
  bottom: 4px;
  background-color: white;
  -webkit-transition: .4s;
  transition: .4s;
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

/* Rounded sliders */
.slider.round {
  border-radius: 34px;
}

.slider.round:before {
  border-radius: 50%;
}

.private-text {
    text-align: center;
}

button:hover{
    cursor: pointer;
}

<<<<<<< HEAD

=======
#close-edit-collection {
    width: 20px;
    height: 20px;
    align-self: flex-end;
    margin-right: 20px;
}

#edit-collection {
  display: flex;
  flex-direction: column;
  gap: 1em;
}
<<<<<<< HEAD
>>>>>>> 1ec2fba022b3931461f14208a1df9c03385c6a4a
=======
>>>>>>> 1ec2fba022b3931461f14208a1df9c03385c6a4a
</style>