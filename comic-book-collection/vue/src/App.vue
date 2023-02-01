<template>
  <div id="app">
    <!-- <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
      <router-link v-bind:to="{ name: 'login' }">Login</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'register' }">Register</router-link>&nbsp;
    </div> -->
    <Nav />
    <router-view />
  </div>
</template>

<script>
import Nav from './components/Nav.vue';

export default{
  name: 'app',
  components: {
    Nav,
  },
};
</script>

<style>
/* Main font: Montserrat */
@import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@400;500;700&display=swap');

* {
  font-family: 'Montserrat', sans-serif;
}

body {
  background-color: #F7F8F7;
  margin: 0 10%;
}

form {
  display: flex;
  gap: 20px;
  flex-direction: column;
  padding: 40px;
}

.text-center{
  background-color: #FFFFFF;
  border-radius: 12px;
  box-shadow: 0px 20px 20px rgb(0 0 0 / 20%);
  
  width: 505px;
  height: 580px;

  display: grid;
  justify-self: center;

}

h1 {
  font-style: bold;
}

a {
  color: #E45052;
}

input{
  border-radius: 8px;
  height: 50px;
}

button{
  background-color: #E45052;
  border: none;
  border-radius: 8px;
  text-align: center;
  height: 50px;
  color: aliceblue;
  
}

#cancel-button {
    background-color: #ffffff;
    border: solid 2px #E45052;
    color: #E45052;
}

.cardImage {
  width: 200px;
  height: 280px;
  border: 2px solid black;
  border-radius: 10px;
  margin: 10px;
}
#card-container {
  width: 100%;
  display: grid;
  justify-items: center;
  align-items: center;
  background-color: #87CEEE;
  height: auto + 40px;
  padding: 10px 0px;
}

</style>
