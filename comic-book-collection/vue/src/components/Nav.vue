<template>
  <nav class="navbar container">
    <button id="home">
    <router-link to="/" class="navbar-item">Home</router-link>
    </button>&nbsp;
    <button id="login" class="sign-up">
    <router-link to="/login" class="navbar-item">Login</router-link>
    </button>&nbsp;
    <button id="register" class="sign-up">
    <router-link to="/register" class="navbar-item">Register</router-link>
    </button>
  </nav>
</template>

<script>
  export default {
    name: 'Nav',
  };
</script>

<style>
  nav {
    display: flex;
    justify-content: space-between;
    align-items: center;
    width: 100vw;
    border-bottom: solid #E45052;
    padding-left: 30px;
    padding-right: 30px;
  
  }

  .sign-up{
    display: inline-block;
    padding: 10px 15px;
    text-decoration: none;
    color: white;
  }
</style>