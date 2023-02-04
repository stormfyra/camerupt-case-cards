<template>
    <div>
        <img v-for="badge in badges" :key="badge.id" :src="badgeSource(badge)" :alt="badge.badgeName" class="badge">
    </div>
    
</template>

<script>
import BadgeService from '../../../services/BadgeService'

export default {
    data() {
        return{
            badges: []
        }
    },
    created() {
        BadgeService.getBadgesByUserId(this.$route.params.id)
                    .then(response => {
                        this.badges =(JSON.parse(JSON.stringify(response.data)));
                    });           
    },
    methods: {
        badgeSource(badge) {
            return require(`../../../../resources/${badge.badgeName}.png`)
        }
    }
    
}
</script>

<style scoped>
img {
    height: 50px;
    width: 50px;
}

</style>