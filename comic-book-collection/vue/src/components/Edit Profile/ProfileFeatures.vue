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
                <button class="empty-card"></button>
                <button class="empty-card"></button>
                <button class="empty-card"></button>
                <button class="empty-card"></button>
            </div>
        </div>
        <div class="public-collections">
            <h3>Public Collections</h3>
            <div class="featured-cards">
                <collection-grid :smallView="true" :collections="publicCollections"></collection-grid>
            </div>
        </div>
        <div class="friends">
            <h3>Friends</h3>
            <div class="featured-cards">
                <button class="empty-card"></button>
                <button class="empty-card"></button>
                <button class="empty-card"></button>
            </div>
        </div>
    </div>
  </div>
</template>

<script>
import userService from '../../services/UserService'
import CollectionService from '../../services/CollectionService'
import CollectionGrid from '../Collections/CollectionGrid.vue'
import GiveBadge from './features/GiveBadge.vue'

export default {
    name: "profile-features",
    data() {
        return {
            publicCollections: {}
        }
    },
    props: [
        'badges'
    ],
    components: {
        CollectionGrid,
        GiveBadge
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
        CollectionService.getPublicCollectionsByUserId(this.$route.params.id)
                        .then(response => this.publicCollections = response.data)
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
</style>
 