<template>
    <div id="view-all-collections">
        <h1>View All Users' Collections</h1>
            <div class="user-Collections-table" v-for= "collection in collections" v-bind:key="collection.collectionId">
            <router-link :to="{name: 'collectionscomic', params: {collectionid: collection.collectionId}}" v-if="collection.collectionPrivacy == 'Public'"> <table>
               
                <tr>
                    <th>User ID</th>
                    <th>Collection Name</th>
                    <th>Privacy Settings</th>
                </tr>
                    <td>{{collection.userId }}</td>
                    <td>{{collection.collectionName}}</td>
                    <td>{{collection.collectionPrivacy}}</td>
            </table></router-link>
        </div>
  </div>
</template>
<script>
import collectionService from '../services/collectionService.js';
export default {
    name: 'collection-list',
    data(){ 
        return {
            collections: [],
            userCollections: []
        }
    },
    created(){
        collectionService.getAllCollections().then(response => {
                this.collections = response.data;
        });
}
}
</script>
<style>

h1 {
    color: white;
}
table {
    border-spacing: 0.5rem;
    width: 50em;
    margin: 15px auto;
    background-color: #3b021b;
    margin-left: auto;
    margin-right: auto;
    box-shadow: 10px 10px 10px rgba(0, 0, 0, 0.5);
}
.collections-list {
    display:table;
    padding-left: 500px;
    padding-top: 200px;
}
div#view-all-collections{
    padding-top: 150px;
    padding-left: 200px; 
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