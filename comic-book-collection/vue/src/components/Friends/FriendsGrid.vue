<template>
    <div :class="'collection-container text-center'">
        <!-- display the user's friends -->
        <div v-for="user in filteredFriends" v-bind:key="user.index" :class="'collectionImage'">
            <div class="friend-card">
                <router-link :class="'profile-image'" :to="{name: 'profileWithId', params: {id: user.id}}">
                    <profile-image :pokemon="user.profilePokemon" height="40px" width="40px"></profile-image>
                </router-link>
                <router-link :class="'title-holder'" :to="{name: 'profileWithId', params: {id: user.id}}"> 
                    <p class="title">{{user.username}}</p>
                </router-link>
            </div>
        </div>
    </div>
</template>

<script>
import ProfileImage from '../Edit Profile/ProfileImage.vue';

export default {
    name: 'FriendsView',
    props: [
        'users',
        'smallView',
        'pokemon'
    ],
    components: {
        ProfileImage
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
.friend-card {

    /* will need to add more styles and swap between them if we implement
    changing the person's theme */
    background-color:#E45052;
    width: 200px;
    height: 280px;
    border: 12px solid #f5e55a;
    box-sizing: border-box;
    border-radius: 10px;
    margin: 0px;
    padding-top: 20px;

    display: flex;
    flex-direction: column;
    justify-content: space-between;
    align-items: center;
}
img {
    height: 80%;
    width: 80%;
    min-height: 125px;
    min-width: 125px;
}

.profile-image {
    align-self: center;
    border-radius: px;
    border: solid #D9D9D9 6px;
    background-color: #d9d9d9;
}



.collection-container {
    width: 100%;
    display: grid;
    justify-items: center;
    align-items: center;
    background-color: #fff;
    height: auto;
    padding: 10px 12px;
}

.small-collection-container {
    width: 100%;
    display: flex;
    justify-items: top;
    align-items: top;
    height: auto;
    flex-wrap: wrap;
    padding: 10px;
}

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

.smallCollectionImage {
    width: 100px;
    height: 100px;
    max-height: 330px;
    border: 2px solid black;
    position: relative;
    z-index: 1;
}
.smallCardBack {
    position: relative;
    top: 0;
    left: 0;
    width: 100px;
    height: 140px;
    border-radius: 10px;
}
p {
    margin: 5px;
}
.privacyStatus {
    z-index: 3;
    color: white;
    position: absolute;
    bottom: 0;
    right: 0;
}
.title-holder {
    background-color: rgba(0, 0, 0, 0.5);
    color: white;
    /* position: absolute;
    z-index: 2; */
    width: 100%;
    height: 25%;
    font-size: large;
    justify-content: center;
    align-items: center;

    display: flex;
    align-self: flex-end;
}

button > h1 {
    font-size: 50pt;
    font-weight: 500;
    color: rgb(109, 109, 109);
}



/* Extra small devices (phones, 600px and down) */
@media only screen and (max-width: 600px) {
    .collection-container {
        grid-template-columns: 1fr 1fr;
    }
}
/* Small devices (portrait tablets and large phones, 600px and up) */
@media only screen and (min-width: 600px) {
    .collection-container {
        grid-template-columns: 1fr 1fr;
    }
}
/* Medium devices (landscape tablets, 768px and up) */
@media only screen and (min-width: 800px) {
    .collection-container {
        grid-template-columns: 1fr 1fr 1fr;
    }
}
/* Large devices (laptops/desktops, 992px and up) */
@media only screen and (min-width: 1200px) {
    .collection-container {
        grid-template-columns: 1fr 1fr 1fr 1fr;
    }
}
/* Extra large devices (large laptops and desktops, 1200px and up) */
@media only screen and (min-width: 1400px) {
    .collection-container {
        grid-template-columns: 1fr 1fr 1fr 1fr 1fr;
    }
}
</style>