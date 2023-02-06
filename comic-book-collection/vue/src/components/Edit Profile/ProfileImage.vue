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
           return require('../../../resources/pokemon/' + this.pokemon.toLowerCase() + '.png')
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
    min-height: 40px;
    min-width: 40px;
    height: 40px;
    width: 40px;
    border-radius: 50%;
    border: 1px solid black;
}

</style>