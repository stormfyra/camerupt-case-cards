<template>
    <div v-if="friendRequests.length > 0">
        <h1>Pending Friend Requests</h1>
        <div id="individual-request" style="display: flex; flex-direction: row; gap: 20px;" v-for="friendRequest in friendRequests" :key="friendRequest.id">
            <p id="friend-requester-name">{{friendRequest.username}}</p>
            <button id="accept-friend-request" @click="accept(friendRequest.id)">&#x2713;</button>
            <button id="reject-friend-request" @click="reject(friendRequest.id)">X</button>
        </div>
    </div>
</template>

<script>
    import userService from '../../../services/UserService'
    export default {
        name: 'friend-requests',
        data() {
            return {
                friendRequests: []
            }
        },
        created() {
            userService.getFriendRequests(this.$store.state.user.id).then(response => {
                this.friendRequests = response.data;
            });
        },
        methods: {
            accept(userFrom) {
                userService.acceptFriendRequest({userFrom: userFrom, userTo: this.$store.state.user.id})
                window.location.reload();
            },
            reject(userFrom) {
                userService.deleteFriendRequest(userFrom, this.$store.state.user.id);
                window.location.reload();
            }
        }
    }
</script>

<style scoped>
p {
    font-weight: 500;
    margin-left: 5%;
}

#individual-request {
    width: audto;
    display: flex;
    align-items: center;
    background-color: #e0dede; 
    margin: 5px;
    border-radius: 10px;
    border: solid rgb(156, 156, 156) 3px
}

#accept-friend-request {
    background-color: rgb(75, 182, 75);
    height: 25px;
    width: 25px;
    border-radius: 100%
}
#reject-friend-request {
    background-color: rgb(241, 52, 19);
    height: 25px;
    width: 25px;
    border-radius: 100%
}

</style>