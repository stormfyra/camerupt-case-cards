<template>
    <div>
        <profile-page-background />
        <overlay />
    </div>
</template>

<script>
import ProfilePageBackground from '../components/Edit Profile/ProfilePageBackground.vue';
import Overlay from './../components/Overlay.vue'

export default {
    components: {
        ProfilePageBackground,
        Overlay
    },
    data() {
        return {
            editProfile: false
        }
    }
}

</script>

<style scoped>

</style>