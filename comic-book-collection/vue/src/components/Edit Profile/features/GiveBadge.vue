<template>
    <div class="overlay-form">
        <div id="give-badge-holder" v-for="badge in badgesToGive" :key="badge.id">
            <img  :src="badgeSource(badge)" :alt="badge.badgeName" class="badge">
            <button>Give {{badge.badgeName}}</button>
        </div>
    </div>
</template>

<script>
import BadgeService from '../../../services/BadgeService'

export default {
    data() {
        return {
            badgesToGive: []
        }
    },
    created() {
        BadgeService.getGivableBadgesByUserId(this.$store.state.user.id)
                    .then(response => this.badgesToGive = response.data)
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
    height: 100px;
    width: 100px;
}

#give-badge-holder {
    display: flex;
    flex-direction: column;
    background-color: white;
    border-radius: 20px;
    align-items: center;
}

.overlay-form {
    display: flex;
    justify-content: center;
    gap: 15px;
}

</style>