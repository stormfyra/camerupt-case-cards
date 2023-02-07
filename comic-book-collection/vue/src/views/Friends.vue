<template>
    <div>
        <h1>Friend Request</h1>
        <div v-if="pendingRequest">
            <h3>Pending Friend Requests</h3>
            <friend-requests />
        </div>
        <h1>Friends</h1>
        <friends-page-background></friends-page-background>
    </div>
</template>

<script>
import FriendsPageBackground from '../components/Friends/FriendsPageBackground.vue';
import FriendRequests from '../components/Edit Profile/features/FriendRequests.vue'
import UserService from '../services/UserService';

export default {
    components: {
        FriendsPageBackground,
        FriendRequests
    },
    data(){
        return{pendingRequest:''}
    },
    created(){
        UserService.getFriendRequests(this.$store.state.user.id)
        .then(response => this.pendingRequest = response.data)
    }
}

</script>

<style scoped>

</style>