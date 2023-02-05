import axios from 'axios'

const http = axios.create({  
    baseURL: 'http://localhost:8080'
});

export default {
    getBadgesByUserId(id){
        return http.get(`/badges/${id}`)
    },

    giveUserBadge(id, badge){
        return http.post(`/badges/${id}`, badge)
    },

    getGivableBadgesByUserId(id){
        return http.get(`/badges/give/${id}`)
    }
}