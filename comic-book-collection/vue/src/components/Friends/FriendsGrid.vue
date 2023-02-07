<template>    
    <div id="tiny-friend-card-holder" >
        <router-link v-for="user in filteredFriends" v-bind:key="user.index" :to="{name: 'profileWithId', params: {id: user.id}}" :class="tinyCard ? 'tinyCollectionImage' : 'collectionImage'">
            <profile-card :class="smallView ? 'tiny-friend-card' : 'medium-card'" :user='user' :small='true' :tinyCard='smallView' ></profile-card>
        </router-link>
    </div>
</template>

<script>
import ProfileCard from '../Edit Profile/ProfileCard.vue'

export default {
    name: 'FriendsGrid',
    props: [
        'users',
        'smallView',
        'tinyCard'
    ],
    components: {
        ProfileCard
    },
    computed: {
        filteredFriends() {
            return this.users.filter(user => {
                return user.username != this.$store.state.user.username;
            })
        }
    }
}
</script>

<style scoped>

.collectionImage {
    width: 200px;
    height: 280px;
    border-radius: 10px;
    margin: 10px;
    position: relative;
    z-index: 1;
    display: flex;
    align-items: flex-end;
}

.tinyCollectionImage {
    width: 90px;
    height: 126px;
    border-radius: 10px;
    display: flex;
    align-items: flex-end;
}

.tiny-friend-card {
    width: 100%;
    height: 100%;
    border: 5px solid #f5e55a;
    border-radius: .25em;
    font-size: x-small;
}

.medium-card {
    height: 80%;
}

#tiny-friend-card-holder{
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    align-content: flex-start;
    gap: 2em;
    margin-top: 2em;
}

</style>