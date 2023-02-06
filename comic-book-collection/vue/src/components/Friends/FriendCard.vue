<template>
    <router-link :class="'profile-image'" :to="{name: 'profileWithId', params: {id: user.id}}">
        <div class="friend-card">
            <profile-image :pokemon="user.profilePokemon" ></profile-image>
            <p class="title">{{user.username}}</p>  
        </div>
    </router-link>
</template>

<script>
import ProfileImage from '../Edit Profile/ProfileImage.vue'

export default {
    components: {
        ProfileImage
    },
    props: [
        'user'
    ]
}
</script>

<style scoped>

img {
    /* width: auto; */
    min-height: 125px;
    min-width: 125px;
}

.profile-image {
    align-self: center;
    border-radius: px;
    border: solid #D9D9D9 6px;
    background-color: #d9d9d9;
}
</style>