<template>
  <div class="profile-features">
    <div class="feature-holder">
        <div class="buttons-holder">
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
  name: "profile-features"
};
</script>

<style scoped>
.empty-card {
    width: 100px;
    height: 140px;
}

.buttons-holder{
    display: flex;
    gap: 10px;
    padding-top: 50px;
    justify-content: center;
}
</style>