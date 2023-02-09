<template>
<div class="collection-container">
  <div v-for="(card, index) in cards" :key="index">
    <img :src="card.images.small" :alt="card.cardName" class="card-image hover-shake" />
    <div id="quantity-div">
      <button v-if="ownedByMe" class="change-quantity" @click="updateQuantity(card, -1)">-</button>
      <p id="card-quantity"><strong>x{{card.quantity}}</strong></p>
      <button v-if="ownedByMe" class="change-quantity" @click="updateQuantity(card, 1)">+</button>
    </div>
  </div>
</div>
</template>

<script>
import collectionService from '../../services/CollectionService';
export default {
  name: 'card-grid',
  emits: ['deleteCard'],
  props: [
    "cards",
    "ownedByMe"
  ],
  methods: {
    updateQuantity(card, change) {
      const newQuantity = card.quantity + change;
      if (newQuantity < 1) {
        collectionService.deleteCardFromCollection(this.$route.params.collectionId, card.id);
        this.deleteCard(card);
      } else {
        card.quantity = newQuantity;
        collectionService.updateQuantity(this.$route.params.collectionId, card);
      }
    },
    deleteCard(card) {
      this.$emit('deletecard', card.id);
    }
  }
}
</script>

<style scoped>
.card-image {
  width: 200px;
  height: 280px;
  border-radius: 10px;
  margin: 10px;
  box-shadow:  0 0 3px -1px transparent, 0 0 2px 1px transparent
    , 0 0 5px 0px transparent, 0px 10px 20px -5px rgb(36, 35, 35)
    , 0 2px 15px -5px rgb(36, 35, 35), 0 0 20px 0px transparent;
  border: none;
}

#quantity-div {
  display: flex;
  flex-direction: row;
  margin: 10px;
  margin-top: -10px;
  gap: 5px;
  align-items: center;
}

.change-quantity {
  height: 50%;
  background-color: white;
  border-radius: 50%;
  width: 30px;
  color: var(--site-red);
  font-weight: bold;
}

#card-quantity {
  background-color: var(--site-red);
  color: white;
  text-align: center;
  border-radius: 8px;
  flex-grow: 1;
}
</style>