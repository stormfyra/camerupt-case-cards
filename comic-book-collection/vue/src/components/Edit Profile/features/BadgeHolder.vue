<template>
    <div>
        <img v-for="badge in badges" :key="badge.id" :src="badgeSource(badge)" :alt="badge" class="badge">
    </div>
    
</template>

<script>


export default {

    props: [
        'badges'
    ],
    methods: {
        badgeSource(badge) {
            return require(`../../../../resources/${badge}.png`)
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