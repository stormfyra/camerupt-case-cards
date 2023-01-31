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
  div {
    font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
  }
</style>
