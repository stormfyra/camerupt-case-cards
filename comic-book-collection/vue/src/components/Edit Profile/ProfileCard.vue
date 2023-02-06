<template>
    <div class="profile">
        <div class="profile-card">
            <div class="user-header">
                <div class="flexy">
                    <!-- hard-coded; replace with data from database -->
                    <p class="account-type">PREMIUM</p>
                    <h2 class="user-name">{{user.username}}</h2>
                </div>

                <div class="flexy">
                    <p class="cards">cards</p>
                    <!-- hard-coded; replace with data from database -->
                    <h2 class="card-count">347</h2>
                    
                </div>
            </div>
            <profile-image class="profile-image" :pokemon="user.profilePokemon"></profile-image>
            <div id="pronouns">
                <p>Pronouns: they/them</p>
            </div>
            <h2>Bio</h2>
            <em><p class="bio"> {{user.bio}}</p></em>
            <!-- to update: stats will go here -->
            <h2>User Stats</h2>
            <ul>
                <li>Collected 14% of Sun &amp; Moon series</li>
                <li>Collected 8.67% of all Poison-type Pokemon</li>
            </ul>

            <!-- to update: badges will go here -->
            <h2>Badges</h2>
            <badge-holder :badges='badges'/>
        </div>
        <div class="page">

        </div>
    </div>
</template>

<script>
import profileImage from './ProfileImage.vue'
import userService from '../../services/UserService'
import BadgeHolder from './features/BadgeHolder.vue'

export default {
    props: [
        'badges'
    ],
    components: {
        profileImage,
        BadgeHolder
    },
    data(){
        return {
            user: {
                username: '',
                imageLink: '',
                bio:'',
                profilePokemon: ''
            },
        }
    },
    created() {
        userService.getUserDetails(this.$route.params.id)
                                .then(response => {
                                    console.log(response.data);
                                    this.user = response.data;
                                });

    }
}

</script>

<style scoped>
#pronouns{
    display: flex;
    justify-content: center;
    background-color: #d9d9d9;
    border-radius: 0px 0px 10px 10px;
    width: 91%;
    min-width: 409px;
    margin: auto;

    font-size: 11pt;
    font-weight: 600;
    color: rgb(105, 105, 105);
}

.profile{
    padding-right: 10px;
    border-right: solid white;
    box-shadow: 10px 0px 10px -2px #dedede;
  
}

.profile-card {
    display: flex;
    flex-direction: column;
    border: solid #f5e55a 25px;
    border-radius: 20px;

    width: 450px;
    background-color: #e93d40;

    margin: auto;
    margin-top: 50px;
    margin-bottom: 50px;
    padding: 2% 5% 5% 5%;

    box-shadow: 5px 5px 10px rgb(226, 225, 225);

}
.profile-image {
    margin-top: 14px;
    align-self: center;
    border-radius: 10px 10px 0px 0px;
    border: solid #D9D9D9 10px;

}

img {
    min-height: 100%;
}

/* .bio {
    background-color: rgb(233, 76, 49);
    border-radius: 5px;
    border: solid rgb(231, 45, 12) 3px;
}
h3 {
    background-color: rgb(233, 76, 49);
    border-radius: 5px;
    border: solid rgb(231, 45, 12) 3px;
} */

button {
    font-size: 10pt !important;
}

h2 {
    margin-bottom: 0px;
    margin-top: 30px;
}

ul {
    margin: 10px 0px 0px 0px;
    padding-left: 25px;
}

p {
    margin-top: 8px;
}

.logo {
    width: 40px;
}

.user-header {
    display: flex;
    justify-content: space-between;
    margin-top: 8px;
}

.cards {
    display: flex;
    padding-top: 5px;
}

.empty-card {
width: 50px;
height: 50px;
margin-left: 0px;
margin-right: 15px;
}


.flexy {
    display: flex;
    align-items: center;
    justify-content: center;
    gap: 8px;
}

.flexy > p {
    margin: 0 !important;
}
.flexy > h2 {
    margin: 0 !important;
}
.account-type{
    background-color: #d9d9d9;
    border: 3px solid #9092A5;
    border-radius: 30px;
    padding: 7px;
    padding-right: 9px;
    font-size: 9pt;
    font-style: italic;
    font-weight: 600;
    color: #444;

    align-self: center;
}
badge-holder {
    display: flex;
    flex-wrap: wrap;
}


</style>