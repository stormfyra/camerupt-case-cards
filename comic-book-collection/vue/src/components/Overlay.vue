<template>
    <div class="overlay" 
    v-if="$store.state.showEditProfile || $store.state.showAddCardForm || $store.state.showEditCollectionForm || 
    $store.state.showAddCollectionForm || $store.state.showGiveBadgeForm">
        <div class="overlay-form">
            <scrolly :style="{ width: '750px', height: '600px' }">
                <scrolly-viewport>
                    <div class="form-container">
                        <button id="close-overlay" @click="off">X</button>
                        <edit-profile v-if="$store.state.showEditProfile" />
                        <add-a-card v-if="$store.state.showAddCardForm" :collectionId="collectionId" :collectedCardIds="collectedCardIds" />
                        <edit-collection v-if="$store.state.showEditCollectionForm" :collection="collection" />
                        <add-collection v-if="$store.state.showAddCollectionForm" />
                        <give-badge v-if="$store.state.showGiveBadgeForm" />
                    </div>
                </scrolly-viewport>
                <scrolly-bar axis="y"></scrolly-bar>
                <scrolly-bar axis="x"></scrolly-bar>
            </scrolly>
        </div>
    </div>
</template>

<script>
import { Scrolly, ScrollyViewport, ScrollyBar } from 'vue-scrolly';
import EditProfile from './Edit Profile/EditProfile.vue';
import AddACard from './Collections/AddACard.vue';
import EditCollection from './Collections/EditCollection.vue';
import GiveBadge from './Edit Profile/features/GiveBadge.vue';
import AddCollection from './Collections/AddCollection.vue';

    export default {
        props: [
            'collection',
            'collectedCardIds',
            'collectionId'
        ],
        components: {
            Scrolly,
            ScrollyViewport,
            ScrollyBar,
            EditProfile,
            AddACard,
            EditCollection,
            GiveBadge,
            AddCollection
        },
        methods: {
            off() {
                this.$store.commit('CLOSE_OVERLAYS');
            }
        }
    }
</script>

<style scoped>
    scrolly:hover {
        cursor: default;
    }

    #close-overlay {
        width: 20px;
        height: 20px;
        align-self: flex-end;
        /* margin-right: 20px; */
    }

</style>