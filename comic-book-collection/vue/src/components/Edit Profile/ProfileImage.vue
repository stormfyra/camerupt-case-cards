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

</style>