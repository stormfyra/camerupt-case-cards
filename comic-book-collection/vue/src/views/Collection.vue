<template>
    <div id="collectionDetails">
        <h1 class="collectionTitle">{{title}}</h1>
        <p class="collectionOwnerDeclaration" v-if="!(ownerUsername == $store.state.user.username)">This collection is owned by 
          <strong id="ownerUsername" @click="goToUserProfile">{{ownerUsername}}</strong>
        </p>
        <p class="collectionDescription"><em>{{description}}</em></p>
        <div id="twoButtons">
          <button v-if="ownerUsername == $store.state.user.username" @click="showEditCollection">Edit</button>
          <button v-if="ownerUsername == $store.state.user.username" @click="showAddCard">Add A Card</button>
          <overlay :collection="collection" :collectionId="$route.params.collectionId" :collectedCardIds="cardIds" />
        <select v-model="selectedFilter" name="type-dropdown" id="">
          <option value="selectedFilter">Select A Filter</option>
          <option v-for='type in types' :key='type.id' :value='type'>{{type}}</option>
        </select>
        <div id="statistics-holder">
          Number of {{selectedFilter}} Cards : {{numberOfCardsInFilterSearch}}
        </div>
        </div>
        <div id=cardSpread>
          <card-grid :cards='cards' @deletecard="deleteCard" :ownedByMe="$store.state.user.username == ownerUsername"/>
        </div>
    </div>
</template>

<script>
import CardGrid from "../components/Collections/CardGrid.vue" 
import collectionWebService from '../services/CollectionService'
import UserService from '../services/UserService'
import Overlay from '../components/Overlay.vue'

export default {
  components: {
      CardGrid,
      Overlay
  },
  data(){
    return {
      ownerUsername: '',
      title: '',
      description: '',
      isPrivate: true,
      cards: [],
      types: ['Fire', 'Water', 'Grass', 'Lightning', 'Fighting', 'Psychic','Colorless', 'Darkness', 'Metal', 'Dragon', 'Fairy'],
      selectedFilter: ''
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
        cards: this.cards,
        id: this.$route.params.id
      }
    },
    cardIds() {
      let cardIds = new Set();
      for (let i = 0; i < this.cards.length; i++) {
        cardIds.add(this.cards[i].id);
      }
      return cardIds;
    },
    numberOfCardsInFilterSearch() {
      let filteredCards = this.cards.filter(card => {
          return card.types.includes(this.selectedFilter);
        })

      return filteredCards.length;
    },
    getUserId() {
      return UserService.getUserIdByUsername(this.ownerUsername);
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
                        });

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
    },
    goToUserProfile() {
      UserService.getUserIdByUsername(this.ownerUsername)
                .then(response => {
                  this.$router.push({name: 'profileWithId', params: {id: response.data}});
              })
    }
  }
}

</script>

<style scoped>
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

#ownerUsername {
  color: var(--site-red);
}

#ownerUsername:hover {
  cursor: pointer;
}

</style>