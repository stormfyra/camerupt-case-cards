<template>
  <nav class="navbar container">
    <a href="/" class="nav-logo">cameruptCaseCards</a>

    <div class="nav-menu">
      <ul class="nav-list">
        <li class="nav-item">
          <router-link :to="{ name: 'ViewCollections' }" class="navbar-item">Card Collections</router-link>&nbsp;
        </li>
        <li class="nav-item">
          <router-link to="/login" class="navbar-item">Login</router-link>&nbsp;
        </li>
        <li class="nav-item">
          <router-link to="/register" class="navbar-item">Register</router-link>
        </li>
        <li class="nav-item">
          <router-link :to="{ name: 'logout' }" class="navbar-item">Logout</router-link>
        </li>
      </ul>
    </div>

  </nav>
</template>

<script>
  export default {
    name: 'Nav',
  };
</script>

<style scoped>
  nav {
    display: flex;
    justify-content: space-between;
    align-items: center;
    border-bottom: solid #E45052;
    padding-top: 10px;
    padding-bottom: 10px;
    padding-left: 111px;
    padding-right: 111px;
    font-family: "Flexo-Regular",arial,sans-serif;
    color: #E45052;
  }

  a{
    text-decoration: none;
    color: #E45052;
  }

  ul{
    list-style: none;
  }

  .nav-logo{
    font-size: 1.4rem;
    font-weight: 500;
    color: black;
  }

  .nav-list{
    display: flex;
    gap: 1rem;
  }


  
</style>