<template>
  <div class="collections-list">

      <div class="loading" v-if="isLoading">
<img src="../assets/comic-yes.gif" alt="Loading">
      </div>

        <h1>View My Collections</h1>
        <div class="my-Collections-table" v-for= "collection in userCollections" v-bind:key="collection.collectionId">
            <router-link :to="{name: 'collectionscomic', params: {collectionid: collection.collectionId}}"><table>
                <tr>
                    <th>Table Name</th>
                    <th>Privacy Settings</th>
                </tr>
                
                    <td>{{collection.collectionName}}</td>
                    <td>{{collection.collectionPrivacy}}</td>
            </table> </router-link>    
        </div>
        <h1 class="comics-num">total comics in collections</h1>
        <comic-status-bar />
    </div>
</template>

<script>
import collectionService from '../services/collectionService.js';
import comicStatusBar from '../components/ComicStatusBar.vue'
export default {
    components: {
        comicStatusBar
    },
    data(){ 
        return {
            isLoading: true,
            collections: [],
            userCollections: []
        }
    },
    created(){
        this.isLoading = true;
        collectionService.getMyCollections(this.$store.state.user.id).then((response) =>{
                this.userCollections = response.data;
                this.isLoading = false;
    })
}
}
</script>

<style>

h1 {
    color: white;
    font-size: 50px;
    text-transform: uppercase;
    font-family: "Open Sans", sans-serif;
    font-weight: bold;
    letter-spacing: 2px;
}
table {
    border-spacing: 0.5rem;
    width: 50em;
    margin: auto;
    background-color: #3b021b;
    box-shadow: 10px 10px 10px rgba(0, 0, 0, 0.5);
    padding-left: 60px;
}
.collections-list {
    display:table;
    padding-left: 500px;
    padding-top: 100px;
    margin-left: 180px;
    height: 100;
    min-height: 100%;
    background-color: #451220;
    
}
div.collections-list{
    padding-top: 60px;
}
.comics-num{
    padding-top: 20px;
}

td, th {
    padding: 0.5rem;  
}

th {
    background-color: #1d010d;
}

tr {
    background-color: #3b021b;
}
td {
    color: beige;
}

</style>