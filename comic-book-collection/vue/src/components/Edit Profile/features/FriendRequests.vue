<template>
    <div>
        <div style="display: flex; flex-direction: row; gap: 20px;" v-for="friendRequest in friendRequests" :key="friendRequest">
            <p>{{friendRequest.username}}</p>
            <button @click="accept(friendRequest.id)">Accept</button>
            <button @click="reject(friendRequest.id)">Reject</button>
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

</style>