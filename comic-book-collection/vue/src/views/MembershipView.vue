<template>
    <div>
        <h1>Membership Page</h1>
        <membership-form></membership-form>
    </div>
</template>

<script>
import MembershipForm from '../components/MembershipForm.vue';


export default {
    name: "membership-view",
    components: {
        MembershipForm
    }
}

</script>

<style scoped>

</style>