import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'
import userService from '../services/UserService'

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if(currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    token: currentToken || '',
    user: currentUser || {},
    showAddCollectionForm: false,
    showEditCollectionForm: false,
    showAddCardForm: false,
    showDeleteCollection: false,
    showGiveBadgeForm: false,
    showEditProfile: false
  },
  mutations: {
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user',JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    },
    UPDATE_PROFILE_POKEMON(state, pokemon){
      state.user.profilePokemon = pokemon;
      userService.updateUserBio(state.user);
    },
    CHANGE_SHOW_COLLECTION_FORM(state){
      state.showAddCollectionForm = !state.showAddCollectionForm;
    },
    CHANGE_SHOW_DELETE_COLLECTION(state){
      state.showDeleteCollection = !state.showDeleteCollection;
    },
    CHANGE_SHOW_EDIT_COLLECTION_FORM(state){
      state.showEditCollectionForm = !state.showEditCollectionForm;
    },
    CHANGE_SHOW_ADD_CARD(state){
      state.showAddCardForm = !state.showAddCardForm;
    },
    CHANGE_SHOW_GIVE_BADGE_FORM(state){
      state.showGiveBadgeForm = !state.showGiveBadgeForm;
    },
    CHANGE_SHOW_EDIT_PROFILE(state) {
      state.showEditProfile = !state.showEditProfile;
    },
    CLOSE_OVERLAYS(state) {
      state.showAddCollectionForm = false;
      state.showEditCollectionForm = false;
      state.showAddCardForm = false;
      state.showGiveBadgeForm = false;
      state.showEditProfile = false;
    }
  }
})
