import axios from 'axios'

const http = axios.create({  
    baseURL: 'http://localhost:8080'
});

export default {
    updateUserBio(user) {
        delete user.authorities
        return http.put(`/users/update-profile`, user)
    }
}