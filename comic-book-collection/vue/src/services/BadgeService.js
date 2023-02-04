import axios from 'axios'

const http = axios.create({  
    baseURL: 'http://localhost:8080'
});

export default {
    getBadgesByUserId(id){
        return http.get(`/badges/${id}`)
    }
}