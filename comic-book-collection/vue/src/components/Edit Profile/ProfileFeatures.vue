<template>
  <div class="profile-features">
    <div class="feature-holder">
        <div class="buttons-holder">
            <button v-if="$store.state.user.id == $route.params.id" @click="editProfile()">Edit Profile</button>          
            <button v-if="!($store.state.user.id == $route.params.id)" @click="addFriend">Add Friend</button>
            <button v-if="!($store.state.user.id == $route.params.id)">Message</button>
            <button v-if="!($store.state.user.id == $route.params.id)" @click="showGiveBadgeForm">Give Badge</button>
            <div class="overlay" v-if="$store.state.showGiveBadgeForm">
                <give-badge class="overlay-form" :badgesUserHas='badges' />
            </div> 
        </div>
        <div class="featured-cards-holder">
            <h3>Featured Cards</h3>
            <div class="featured-cards">
                <img v-for="card in cards.slice(0, 4)" :key="card" :src="card.images.small" style="width: 100px; height: 140px;" />
            </div>
        </div>
        <div class="public-collections">
            <h3>Public Collections</h3>
            <div>
                <collection-grid :smallView="true" :collections="publicCollections"></collection-grid>
            </div>
        </div>
        <div class="friends">
            <h3>Friends</h3>
            <div>
                <friends-grid :users="friends" />
            </div>
        </div>
    </div>
  </div>
</template>

<script>
import userService from '../../services/UserService'
import collectionService from '../../services/CollectionService'
import CollectionGrid from '../Collections/CollectionGrid.vue'
import GiveBadge from './features/GiveBadge.vue'
import FriendsGrid from '../Friends/FriendsGrid.vue'

export default {
    name: "profile-features",
    data() {
        return {
            publicCollections: {},
            cards: [],
            friends: []
        }
    },
    props: [
        'badges'
    ],
    components: {
        CollectionGrid,
        GiveBadge,
        FriendsGrid
    },
    methods:{
        editProfile(){
            this.$store.commit('CHANGE_SHOW_EDIT_PROFILE');
        },
        addFriend() {
            userService.addFriend({userFrom: this.$store.state.user.id, userTo: this.$route.params.id});
        },
        showGiveBadgeForm(){
            this.$store.commit('CHANGE_SHOW_GIVE_BADGE_FORM');
        }
    },
    created(){
        collectionService.getPublicCollectionsByUserId(this.$route.params.id)
                        .then(response => this.publicCollections = response.data);
        userService.getAllCardsForUser(this.$route.params.id)
                        .then(response => this.cards = response.data);
        userService.getFriends(this.$route.params.id)
                        .then(response => this.friends = response.data);
    }
};
</script>

<style scoped>
button{
    width: 20%;
}
.empty-card {
    width: 100px;
    height: 140px;
}

.buttons-holder{
    display: flex;
    gap: 10px;
    justify-content: left;
    margin-bottom: 50px;
}

h3 {
    margin-bottom: 10px;
}

.feature-holder {
    display:flex;
    flex-direction: column;
    width: 100%;
    height: 100%;
    justify-content: top;
    margin-top: 70px;
}

.featured-cards {
    display: flex;
    flex-direction: row;
    gap: 1em;
    margin-left: 10px;
}
</style>
