<template>
    <div class="profile">
        <div class="profile-card">
            <div class="user-header">
                <div class="flexy">
                    <!-- hard-coded; replace with data from database -->
                    <p class="account-type">Premium</p>
                    <h1 class="user-name">{{user.username}}</h1>
                </div>

                <div class="flexy">
                    <p class="card">cards</p>
                    <!-- hard-coded; replace with data from database -->
                    <h1 class="card-count">347</h1>
                    
                </div>
            </div>
            <profile-image class="profile-image" :pokemon="pokemon"></profile-image>
            <div id="nickname">
                <p>Nickname: smitty | Prounouns:they/them</p>
            </div>
            <h1>Bio</h1>
            <em><p class="bio"> {{user.bio}}</p></em>
            <h3>{{user.fullName}}</h3>
            <h3>{{user.shippingAddress}}</h3>
        </div>
        <div class="page">

        </div>
    </div>
</template>

<script>
import profileImage from './ProfileImage.vue'

export default {
    props: [
        'pokemon'
    ],
    components: {
        profileImage
    },
    data(){
        return {
            user: {
                username: '',
                imageLink: '',
                bio:'',
                email: '',
                fullName: '',
                shippingAddress: '',
                profilePokemon: ''
            },
        }
    },
    created() {
        this.user = this.$store.state.user;
        console.log(this.user);
    }
}

</script>

<style scoped>
#nickname{
    display: flex;
    justify-content: center;
    background-color: #d9d9d9;
    border-radius: 0px 0px 10px 10px;
    width: 91%;
    min-width: 409px;
    margin: auto;
}

.profile{
    border-right: solid white;
    box-shadow: 10px 0px 10px -2px #dedede;
  
}

.profile-card {
    display: flex;
    flex-direction: column;
    border: solid #f5e55a 23px;
    border-radius: 20px;
    width: 450px;
    background-color: #FF494C;
    margin: auto;
    margin-top: 50px;
    margin-bottom: 50px;
    padding: 2% 5% 5% 5%;

}
.profile-image {
    align-self: center;
    border-radius: 10px 10px 0px 0px;
    border: solid #D9D9D9 10px;
}
.bio {
    background-color: rgb(233, 76, 49);
    border-radius: 5px;
    border: solid rgb(231, 45, 12) 3px;
}
h3 {
    background-color: rgb(233, 76, 49);
    border-radius: 5px;
    border: solid rgb(231, 45, 12) 3px;
}

h1 {
    margin-bottom: 0px;
}

.logo {
    width: 40px;
}

.user-header {
    display: flex;
    justify-content: space-between;
}

/* fix meeee; go to bottom */
.card {
    display: flex;
    align-self:unset !important;
    margin-bottom: auto;
}


.flexy {
    display: flex;
    align-items: center;
    gap: 10px;
}

.flexy > p {
    margin: 0 !important;
}
.flexy > h1 {
    margin: 0 !important;
}
.account-type{
    background-color: #d9d9d9;
    border: 1px solid #444c5c;
    border-radius: 30px;
    padding: 8px;
    font-size: 10pt;
    font-style: italic;
    font-weight: 600;
    color: #444c5c;
}


</style>