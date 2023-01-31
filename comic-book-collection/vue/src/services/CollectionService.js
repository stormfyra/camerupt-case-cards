import axios from 'axios'

const http = axios.create({  
    baseURL: 'http://localhost:8080'
});

export default {
    
    getCollectionDetails() {
        return http.get('/collections/1')
    },

    getAllCollections() {
        return http.get(`/collections`)
    }
}