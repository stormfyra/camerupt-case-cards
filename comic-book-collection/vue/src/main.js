import Vue from 'vue'
import App from './App.vue'
import router from './router/index'
import store from './store/index'
import axios from 'axios'

Vue.config.productionTip = false

axios.defaults.baseURL = process.env.VUE_APP_REMOTE_API;

new Vue({
  router,
  store,
  render: h => h(App),
  watch:{
    '$route' (to) {
       if(to.currentRoute.meta.reload==true){window.location.reload()}
    }
  }
}).$mount('#app')
