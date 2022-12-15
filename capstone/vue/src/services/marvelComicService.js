import axios from 'axios';

const http = axios.create({
   baseURL : "http://localhost:9000"
});
export default {
    getAllComics(){
        return http.get('/comics')
    },
    searchByComics(title){
        return http.get(`/comic/bytitle/${title}`)
    }
}

