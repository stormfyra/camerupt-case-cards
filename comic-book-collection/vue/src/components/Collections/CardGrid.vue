<template>
    <div id="card-container">
        <img v-for="(card, index) in cards" :key="index" :src="card.smallImage" :alt="card.cardName"/> 
    </div>
</template>

<script>

export default {
    name: 'CardGrid',
    props: [
        "cards"
    ],


}
</script>

<style scoped>

</style>