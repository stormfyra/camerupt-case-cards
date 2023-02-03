<template>
  <div class="profile-features">
    <div class="feature-holder">
        <div class="buttons-holder">
            <button @click="editProfile()">Edit Profile</button>          
            <button>Add Friend</button>
            <button>Message</button>
            <button>Give Badge</button>
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
                <button class="empty-card"></button>
                <button class="empty-card"></button>
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
export default {
  name: "profile-features",

  methods:{
      editProfile(){
          this.$router.push({name:'editProfile'})
      }
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