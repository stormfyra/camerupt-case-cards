<template>
    <div>
        <form id=memberForm>
            <h2>Membership Sign-Up Form</h2>
            <p>We offer a membership option tailored to meet your
                specific needs.To sign-up for membership please
                complete and submit the applications below</p>
            <div id="fullName">
                <label for="name">Name*</label>
                <input placeholder="First" type="text">
                <input placeholder="Last" type="text">
            </div>
            <div id="email">
                <label for="email">Email*</label>
                <input placeholder="Email" type="text">
            </div>
            <div id="phone">
                <label for="Phone">Phone</label>
                <input placeholder="#### ### ####" type="text">
            </div>
            <div id="address">
                <label for="address">Address</label>
                <input placeholder="Street Address" type="text">
                <div id="cityState">
                    <input placeholder="City" type="text">
                    <input placeholder="State" type="text">
                </div>
                <div id="postCountry">
                    <input placeholder="Postal/Zip Code" type="text">
                    <input placeholder="Country" type="text">
                </div>
            </div>
            <div id="plans">
                <label for="memberPlan">Membership Plans*</label>
                <input type="radio" id="standard" name="fav_plan" value="standard">
                <label for="standard">Standard ($50/Year)</label>
                <input type="radio" id="premium" name="fav_plan" value="premium">
                <label for="premium">Premium ($100/year)</label>
            </div>
            <div>
                <label for="creditCard">Card Information*</label>
            </div>
        </form>
    </div>
</template>

<script>


export default({
    name: 'MembershipForm'
})
</script>
