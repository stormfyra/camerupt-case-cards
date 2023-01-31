<template>
    <div>
        <h1 class="collectionTitle">{{title}}</h1>
        <h2 class="collectionOwnerDeclaration">This collection is owned by {{ownerUsername}}</h2>
        <p class="collectionDescription"><em>{{description}}</em></p>
        <!-- Rounded switch -->
        <div class="switch-div" v-if="ownedByMe">
            <p style="display: inline-block">public</p>
            <label class="switch">
                <input type="checkbox" v-model="isPrivate" v-on:change="togglePrivacy">
                <span class="slider round"></span>
            </label>
            <p style="display: inline-block">private</p>
        </div>
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
           isPrivate: true,
           cards: []
        }
    },
    computed: {
        ownedByMe() {
            return this.ownerUsername == this.$store.state.user.username;
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
    },
    methods: {
        togglePrivacy() {
            const collection = {
                collectionId: this.$route.params.collectionId,
                ownerUsername: this.ownerUsername,
                title: this.title,
                description: this.description,
                isPrivate: this.isPrivate,
                cards: []
            }
            collectionWebService.toggleCollectionPrivacyStatus(this.$route.params.collectionId, collection);
        }
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

.switch-div {
    display: flex;
    justify-content: flex-start;
    align-items: center;
    gap: 10px;
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
</style>