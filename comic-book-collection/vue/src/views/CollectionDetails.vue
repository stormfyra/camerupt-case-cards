<template>
    <div id="collectionDetails">
        <h1 class="collectionTitle">{{title}}</h1>
        <h2 class="collectionOwnerDeclaration">This collection is owned by {{ownerUsername}}</h2>
        <p class="collectionDescription"><em>{{description}}</em></p>
        <div id="twoButtons">
          <button v-if="ownerUsername == $store.state.user.username" @click="showEditCollection">Edit</button>
          <div class="overlay" v-if="$store.state.showEditCollectionForm">
              <edit-collection class="overlay-form" :collection="collection" />
          </div>
          <button v-if="ownerUsername == $store.state.user.username" @click="showAddCard" id="btn2">Add A card</button>
          <div class="overlay" v-if="$store.state.showAddCardForm" >
              <add-a-card class="overlay-form" @addSelectedCards='addSelectedCards' :collectionId="$route.params.collectionId" :collectedCardIds="cardIds" />
          </div>
        </div>
        <div id=cardSpread>
          <card-grid :cards='cards' @deletecard="deleteCard" :ownedByMe="$store.state.user.username == ownerUsername"/>
        </div>
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

#btn2{
  background-color: white;
  color: #E45052;
  border: 2px solid #E45052;
}

#collectionDetails{
  display: flex;
  flex-direction: column;
}

#twoButtons{
  display: grid;
  grid-template-columns: 200px 200px;
  gap: 10px;
}

#cardSpread{
  margin-top: 20px;
}

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

</style>