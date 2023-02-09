<template>
<form id="member-form">
  <h2>Membership Signup Form</h2>
  <p>We offer a membership option tailored to meet your
    specific needs. To signup for membership please
    complete and submit the applications below.</p>
  <div id="full-name">
    <label for="name">Name*</label>
    <input placeholder="First" type="text" />
    <input placeholder="Last" type="text" />
  </div>
  <div id="email">
    <label for="email">Email*</label>
    <input placeholder="Email" type="text" />
  </div>
  <div id="phone">
    <label for="Phone">Phone</label>
    <input placeholder="#### ### ####" type="text" />
  </div>
  <div id="address">
    <label for="address">Address</label>
    <input placeholder="Street Address" type="text" />
  </div>
  <div id="city-state">
    <input placeholder="City" type="text" id="city" />
    <input placeholder="State" type="text" id="state" />
  </div>
  <div id="post-country">
    <input placeholder="Postal/Zip Code" type="text" id="postal" />
    <input placeholder="Country" type="text" id="country" />
  </div>
  <div id="plans">
    <label for="plan">Membership Plans</label>
    <input v-model="premium" type="radio" id="standard" name="plan" value="false" />
    <label for="standard">Standard</label>
    <input v-model="premium" type="radio" id="premium" name="plan" value="true" />
    <label for="premium">Premium ($5/Month)</label>
  </div>
  <label for="card-information">Card Information</label>
  <div id="card-information">
    <input placeholder="Card Holder Name" type="text" id="card-name" />
    <input placeholder="Card Number" type="text" id="card-number" />
    <input placeholder="Expiration Date" type="text" id="expire" />
    <input placeholder="Security Code" type="text" id="security" />
    <input placeholder="Billing Zip" type="text" id="billing" />
  </div>
  <div id="buttons">
    <button id="submit" @click="changePremiumStatus">Submit</button>
  </div>
</form>
</template>

<script>
import userService from '../services/UserService';
export default {
  name: 'membership-form',
  data() {
    return {
      user: {},
      premium: ''
    }
  },
  created() {
    this.user = this.$store.state.user;
  },
  methods: {
    changePremiumStatus() {
      this.user.isPremium = this.premium == "true";
      this.$store.commit('SET_USER', this.user);
      userService.updateUserBio(this.user);
    }
  }
}
</script>

<style scoped>
#member-form {
  background-color: white;
  border-radius: 50px;
  width: 80%;
}

h2, p {
  text-align: center;
}

#full-name {
  display: grid;
  grid-template-columns: 50px 1fr 1fr;
  gap: 30px
}

#email {
  display: grid;
  grid-template-columns: 50px 2fr;
  gap: 30px;
}

#phone {
  display: grid;
  grid-template-columns: 50px 2fr;
  gap: 30px;
}

#address {
  display: grid;
  grid-template-columns: 50px 2fr;
  gap: 30px;
}

#city-state {
  display: grid;
  grid-template-columns: 58px 1fr 1fr;
  grid-template-areas: ". city state";
  gap: 20px;
}

#city {
  grid-area: city;
}

#state {
  grid-area: state;
}

#post-country {
  display: grid;
  grid-template-columns: 58px 1fr 1fr;
  grid-template-areas: ". postal country";
  gap: 20px;
}

#postal {
  grid-area: postal;
}

#country {
  grid-area: country;
}

#plans {
  display: flex;
  gap: 10px;  
}

#card-information {
  display: grid;
  grid-template-columns: 58px 1fr 1fr;
  grid-template-areas:". cardHolder cardHolder" 
    ". cardNumber expiration"
    ". security billing";
  gap: 15px;
}

#card-name {
  grid-area: cardHolder;
}

#card-number {
  grid-area: cardNumber;
}

#expire {
  grid-area: expiration;
}

#security {
  grid-area: security;
}

#billing {
  grid-area: billing;
}

#buttons {
  display: grid;
  grid-template-columns: 60px 1fr;
  grid-template-areas: ". submit";
  gap: 10px;
}

#submit {
  grid-area: submit;
}
</style>