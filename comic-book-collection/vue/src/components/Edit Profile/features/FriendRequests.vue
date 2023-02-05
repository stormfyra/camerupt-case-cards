<template>
    <div>
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
        name: 'FriendRequests',
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
            },
            reject(userFrom) {
                userService.deleteFriendRequest(userFrom, this.$store.state.user.id);
            }
        }
    }
</script>

<style scoped>
p {
    margin-left: 5%;
    background-color: #bebebe; 
}

#individual-request {
    width: audto;
    display: flex;
    align-items: center;
    background-color: #bebebe; 
    margin: 5px;
    border-radius: 10px;
    border: solid rgb(109, 109, 109) 3px
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