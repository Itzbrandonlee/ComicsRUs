<template>
    <b-progress
        class="stats"
        type="is-danger"
        :value='this.allComics.length'
        size="is-medium"
        show-value>
        {{this.allComics.length}} / 100
    </b-progress>
</template>

<script>
import collectionService from '../services/collectionService'
export default {
    data(){
        return {
            allComics:[]
        }
    },
    created(){
    
        collectionService.getAllComicsFromUser(this.$store.state.user.id).then(response => {
            this.allComics = response.data;
        });
    }

}
</script>

<style>
.stats{
    padding-top: 15px;
    box-shadow: 10px 10px 10px rgba(0, 0, 0, 0.5);
}
p.progress-value{
    padding-top: 15px;
}

</style>