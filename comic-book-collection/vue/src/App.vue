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

Nav {
  margin-bottom: 30px;
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
  box-shadow: 0px 10px 10px rgb(0 0 0 / 20%);
  
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
  color: #f7f8f7;

  font-size: 12pt;
  font-weight: 500;
  
}

.empty-card {
    background-color:#bebebe;
    border: solid 1px;
    width: 200px;
    height: 280px;
    border: 3px solid rgb(109, 109, 109);
    border-radius: 10px;
    margin: 10px;
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

button {
  cursor: pointer;
}

.overlay {
  position: fixed;
  width: 100%;
  height: 100%;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background-color: rgba(0,0,0,0.5);
  z-index: 5;
}

.overlay-form{
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%,-50%);
  -ms-transform: translate(-50%,-50%);
}

.form-container {
    max-width: 100%;
    margin: 10px;
    background-color: white;
    border-radius: 10px;
    display: flex;
    flex-direction: column;
    padding-top: 20px;
    padding-bottom: 20px;
}
</style>
