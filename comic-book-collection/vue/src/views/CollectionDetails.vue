<template>
    <div>
        <h1 class="collectionTitle">{{title}}</h1>
        <h2 class="collectionOwnerDeclaration">This collection is owned by {{ownerUsername}}</h2>
        <p class="collectionDescription"><em>{{description}}</em></p>
        <button @click="showEditCollection">Edit</button>
        <div id="overlay" v-if="$store.state.showEditCollectionForm">
            <edit-collection id="overlay-form" :collection="collection" />
        </div>
        <button @click="showAddCard">Add A card</button>
        <div id="overlay" v-if="$store.state.showAddCardForm" >
            <add-a-card id="overlay-form" @addSelectedCards='addSelectedCards' :collectionId="$route.params.collectionId" :collectedCardIds="cardIds" />
        </div>
        <card-grid :cards='cards' @deletecard="deleteCard" />
    </div>
</template>

<script>
import CardGrid from "../components/Collections/CardGrid.vue" 
import EditCollection from '../components/Collections/EditCollection.vue'
import collectionWebService from '../services/CollectionService'
import AddACard from '../components/Collections/AddACard.vue'


export default {
    components: {
        CardGrid,
        EditCollection,
        AddACard
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
        },
        collection() {
          return {
            ownerUsername: this.ownerUsername,
            title: this.title,
            description: this.description,
            isPrivate: this.isPrivate,
            cards: this.cards
          }
        },
        cardIds() {
          let cardIds = new Set();
          for (let i = 0; i < this.cards.length; i++) {
            cardIds.add(this.cards[i].id);
          }
          return cardIds;
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
        },
        deleteThisCollection() {
            collectionWebService.deleteCollection(this.$route.params.collectionId);
            this.$router.push({name: 'ViewCollections'})
                        .then(() => { this.$router.go() })
        },
        showEditCollection() {
          this.$store.commit('CHANGE_SHOW_EDIT_COLLECTION_FORM')
        },
        showAddCard() {
          this.$store.commit('CHANGE_SHOW_ADD_CARD')
        },
        addSelectedCards(selectedCards) {
          for (let card in selectedCards) {
            this.cards.push(card);
          }
          console.log(this.cards);

        },
        deleteCard(id) {
          this.cards = this.cards.filter(card => {
            return card.id != id;
          })
        }
    }
}

</script>

<style scoped>
.button-container {
  display: flex;
  justify-content: space-between;
}

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

#overlay {
  position: fixed;
  width: 100%;
  height: 100%;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background-color: rgba(0,0,0,0.5);
  z-index: 5;
}

#overlay-form{
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%,-50%);
  -ms-transform: translate(-50%,-50%);
}
</style>