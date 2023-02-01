<template>
    <img :src="source" alt="">
</template>

<script>

export default {
    props: [
        'pokemon'
    ],
    data() {
        return{
            imageSource: ''
        }
    },
    computed: {
        source() {
           return require('../../../resources/' + this.pokemon.toLowerCase() + '.png')
        }
    }
}
</script>

<style scoped>

img {
    height: 66%;
    width: 66%;
    min-height: 389.59px;
    min-width: 389.59px;
}

</style>