<template>
    <div id="edit-collection">
        <scrolly :style="{ width: '600px', height: '600px' }">
            <scrolly-viewport>
                <form class="form-container">
                    <h1>Edit Your Collection</h1>
                    <label for="title">Title</label>
                    <!-- title should be required, but won't close if it's set with "required" -->
                    <input 
                        type="text"
                        id="title"
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
                        <p style="display: inline-block">public</p>
                        <label class="switch">
                            <input type="checkbox" v-model="isPrivate" />
                            <span class="slider round" />
                        </label>
                        <p style="display: inline-block">private</p>
                    </div>
                    <div v-for="card in this.updatedCollection.cards" :key="card.card.cardId">
                        <p>{{card.card.cardName}} (ID#: {{card.card.cardId}})</p>
                        <input type="number" v-model="card.quantity" />
                    </div>
                    <button id="submit" @click.prevent="onSubmit">Submit</button>
                    <button type="button" id="close" v-on:click="off()">Close</button>
                    <button @click="deleteThisCollection">DELETE</button>
                </form>
            </scrolly-viewport>
            <scrolly-bar axis="y"></scrolly-bar>
            <scrolly-bar axis="x"></scrolly-bar>
            </scrolly>
    </div>
</template>

<script>
import collectionService from '../../services/CollectionService.js'
import { Scrolly, ScrollyViewport, ScrollyBar } from 'vue-scrolly';

export default{
  name: 'edit-collection',
  components: {
      Scrolly,
      ScrollyViewport,
      ScrollyBar
  },
  data() {
      return {
          updatedCollection: {}
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
      }
  },
};
</script>

<style scoped>
    .hide-form {
        display: none;
    }

    .form-container {
    max-width: 100%;
    margin: 10px;
    background-color: white;
    border-radius: 10px;
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

#edit-collection {
    max-height: 0%;
}
</style>