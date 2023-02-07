<template>
    <div id="overall-badge-holder">
        <div id="give-badge-holder" v-for="badge in badgesToGive" :key="badge.id" >
            <img  :src="badgeSource(badge)" :alt="badge" class="badge">
            <button :class="badgesUserHas.includes(badge) ? 'disabled' : ''" @click="giveUserBadge(badge)">Give {{badge}}</button>
            <h3 id="given-away-all-badges" v-if="badgesToGive.size == 0">You have given away all of your badges</h3>
        </div>
    </div>
</template>

<script>
import BadgeService from '../../../services/BadgeService'

export default {
    data() {
        return {
            badgesToGive: [],
            badgesUserHas: []
        }
    },
    created() {
        BadgeService.getGivableBadgesByUserId(this.$store.state.user.id)
                    .then(response => this.badgesToGive = response.data);

        BadgeService.getBadgesByUserId(this.$route.params.id)
                    .then(response => {
                        this.badgesUserHas =(JSON.parse(JSON.stringify(response.data)));
                    }); 
    },
    methods: {
        badgeSource(badge) {
            return require(`../../../../resources/${badge}.png`)
        },

        giveUserBadge(badge){
            BadgeService.giveUserBadge(parseInt(this.$route.params.id), this.$store.state.user.id, badge);
            this.$router.go();
        },
        closeGiveBadgeForm(){
            this.$store.commit('CHANGE_SHOW_GIVE_BADGE_FORM')
        }
    }
}
</script>


<style scoped>
img {
    height: 100px;
    width: 100px;
}

#give-badge-holder {
    display: flex;
    flex-wrap: wrap;
    flex-direction: column;
    background-color: white;
    border-radius: 20px;
    align-items: center;
}

#given-away-all-badges {
    background-color: white;
    border-radius: 20px;
}

.overlay-form {
    display: flex;
    justify-content: center;
    gap: 15px;
}

.disabled {
    background-color: grey;
    pointer-events: none;
}

#overall-badge-holder {
    display: grid;
    grid-template-columns: 1fr 1fr 1fr;
    row-gap: 2%;
}

</style>