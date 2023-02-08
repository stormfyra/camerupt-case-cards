<template>
  <div id="loginPage">
  <div id="bg">
    <div id="login" class="text-center">
      <form class="form-signin" @submit.prevent="login">
        <h1 class="h3 mb-3 font-weight-normal">Log In</h1>
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
        <router-link :to="{ name: 'register' }">Need an account? Click here to register!</router-link>
        <button type="submit">Login</button>
      </form>
    </div>
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
            this.$router.push({ name: 'collections' });
            this.$router.go();
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

<style scoped>
  #loginPage {
    width: 100%;
    height: 800px;
    overflow: hidden;
  }

  #bg {
  width: 100vw;
  height: 100%;
  margin-left: -10%;
  margin-top: -30px;
  position: fixed;
  background-image: url("../../resources/backgrounds/aggron.jpg");
  background-size: cover;
  background-position: 0 18%;
}

 form {
  display: flex;
  gap: 20px;
  flex-direction: column;
  align-content: center;

  padding: 40px;
  margin: 0 3%;
}
.text-center{
  background-color: #FFFFFF;
  border-radius: 12px;
  box-shadow: 0px 10px 10px rgb(0 0 0 / 20%);
  
  width: 430px;
  height: 530px;
  margin: 0 6%;

  display: flex;
  margin-top: 200px;
}
h1 {
  margin-top: 10px;
}

  a{
    text-decoration: none;
    color: black;
    font-weight: bold;
  }

  #password, #confirmPassword{
    font-family: Verdana, Geneva, Tahoma, sans-serif;
    font-size: 0.1ch;
    font-size: 15px;
    color: rgb(117, 166, 223);
  }

  #password:focus{
    outline: 0;
    box-shadow: 0 0 0 3px #E45052;
  }

  #username:focus{
    outline: 0;
    box-shadow: 0 0 0 3px #E45052;
  }

  #confirmPassword:focus{
    outline: 0;
    box-shadow: 0 0 0 3px #E45052;
  }



</style>
