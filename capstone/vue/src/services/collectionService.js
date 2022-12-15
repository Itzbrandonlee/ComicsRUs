import axios from 'axios';

const http = axios.create({
   baseURL : "http://localhost:9000"
});
export default {
    getAllCollections(){
        return http.get('/collections/all')
    },
    addComicToCollection(marvelComic, collectionId){
        return http.post(`/collections/${collectionId}/addComic/`, marvelComic)
    },
    getMyCollections(user_id){
         return http.get(`/collections/user/${user_id}`)
     },
    addCollection(newCollection){
        return http.post('/collections/new', newCollection)
    },
    getComicsFromCollection(collectionId){
        return http.get(`/collections/comics/${collectionId}`)
    },
    getAllComicsFromUser(userId){
        return http.get(`/collections/count/${userId}`)
    }
}