<template>
  <div id="loginPage">
  <div id="login" class="text-center">
    <form class="form-signin" @submit.prevent="login">
      <h1 class="h3 mb-3 font-weight-normal">Please Sign In</h1>
      <div
        class="alert alert-danger"
        role="alert"
        v-if="invalidCredentials"
      >Invalid username and password!</div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >Thank you for registering, please sign in.</div>
      <label for="username" class="sr-only">Username</label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      <label for="password" class="sr-only">Password</label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />
      <router-link :to="{ name: 'register' }">Need an account?</router-link>
      <button type="submit">Login</button>
    </form>
  </div>
  <div id="pokePic">
    <img src="camerupt-removebg-preview.png" alt="pokemon picture here">
  </div>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style>

  #loginPage{
    display: grid;
    grid-template-columns: 1fr 1fr;
    grid-template-areas: "form pic";
  }

  .text-center{
    border-radius: 12px;
    box-shadow: 0px 20px 20px rgb(0 0 0 / 20%);
    
    width: 505px;
    height: 700px;

    display: grid;
    grid-area: form;
    justify-self: center;

  }

  .form-register, .form-signin{
    display: flex;
    gap: 20px;
    flex-direction: column;
    padding: 40px;
  }

  #pokePic{
    display: grid;
    grid-area: pic;
    align-items: center;
    justify-self: center;
    width: 120%;

  }

  button{
    background-color: #E45052;
    border: none;
    border-radius: 8px;
    text-align: center;
    height: 50px;
    color: aliceblue;
    
  }

  input{
    border-radius: 8px;
    height: 50px;
  }

  a{
    text-decoration: none;
    color: black;
    font-weight: bold;
  }

  


</style>
