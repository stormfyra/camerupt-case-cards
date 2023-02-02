<template>
    <img :class="{ 'small' : small }" :src="source" alt="">
</template>

<script>

export default {
    props: [
        'pokemon',
        'small'
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

.small {
    height: 25px;
    width: 25px;
    min-height: 25px;
    min-width: 25px;
    border-radius: 50%;
    border: 1px solid black;
}

</style>