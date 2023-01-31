import axios from 'axios'

const http = axios.create({  
    baseURL: 'http://localhost:8080'
});

export default {
    
    getCollectionDetails(collectionId) {
        return http.get(`/collections/${collectionId}`)
    },

    getAllCollections() {
        return http.get(`/collections`)
    }
}