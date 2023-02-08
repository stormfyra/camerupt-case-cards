<template>
    <div>
        <p v-if="badges.length == 0 && !small"><em>This user doesn't have any badges yet.</em></p>
        <img v-for="badge in badges" :key="badge.id" :src="badgeSource(badge)" :alt="badge" :class="small ? 'small-badge' : 'badge'">
    </div>
    
</template>

<script>
import BadgeService from '../../../services/BadgeService'


export default {
    name: 'badge-holder',

    props: [
        'user',
        'small'
    ],
    data(){
        return{
            badges: ''
        }
    },
    methods: {
        badgeSource(badge) {
            return require(`../../../../resources/${badge}.png`)
        }
    },
    created() {
        BadgeService.getBadgesByUserId(this.user.id)
                    .then(response => {
                        this.badges =(JSON.parse(JSON.stringify(response.data)));
            });
    }
    
}
</script>

<style scoped>
.badge {
    height: 40px;
    width: 40px;
}
.small-badge {
    height: 30px;
    width: 30px;
    margin-top: 10%;
}

</style>