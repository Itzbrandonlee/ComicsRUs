<template>
    <div id="create-new-collection"> 
        <form class="form-inline" v-on:submit="addCollection">
            <label class="name" for="collectionName">Collection Name: </label>
            <input type="text" name="collectionName" id="collectionName" class="form-input" v-model="newCollection.collectionName" required>
            <label for="privacy" class="privacy">Private? </label>
            <input type="checkbox" name="privacy" id="privacy" class="form-input" v-model="newCollection.collectionPrivacy" @change="isPrivate($event)">
            <button class="submit" id="submit" type="submit" value="Submit">Submit</button>
        </form>
    </div>
</template>

<script>
import collectionService from '../services/collectionService.js'
export default {
    name: 'new-collection',
    data() {
        return {
            newCollection: {
                collectionId: 0,
                collectionName: "",
                userId: 0,
                collectionPrivacy: ""
            },
        }
    },
    methods: {
        isPrivate($event){
            const checked = $event.target.checked

            if(checked)
                this.newCollection.collectionPrivacy = "Private"
            if(!checked)
                this.newCollection.collectionPrivacy = "Public"
            },
        addCollection(){
            this.newCollection.userId = this.$store.state.user.id
            console.log(this.newCollection)
            collectionService.addCollection(this.newCollection).then((response)=>{
                if(response.status === 200){
                    //
                }
            });
        },

    },
}
</script>

<style scoped>

.form-inline{
  width: 300px;
  margin-left: 800px;
  padding-top: 200px;
   display: flex;
    flex-direction: row;
  
}
.form-inline input {
   display: inline-flex;
    margin: 10px;
    font-size: 1rem;
    width: 200px;
    box-shadow: 10px 10px 10px rgba(0, 0, 0, 0.5);
    border: 3px solid;
}

.form-inline button {
  display: flex;
  flex-flow: row wrap;
  align-items: center;
  padding: 6px 25px;
  background-color: #e6dac6;
  font-family: "Open Sans", sans-serif;
  font-weight: bold;
  letter-spacing: 2px;
  text-transform: uppercase;
  margin: 5px;
  border: 3px solid;
  color:black;
  box-shadow: 10px 10px 10px rgba(0, 0, 0, 0.5);
}
.form-inline button:hover{
  box-shadow: #E70D11 0 -25px 18px -14px inset,#E70D11 0 1px 2px,#E70D11 0 2px 4px,#E70D11 0 4px 8px,#E70D11 0 8px 16px,#E70D11 0 16px 32px;
  transform: scale(1.05) rotate(-1deg);  
}

.privacy{
    width: 60px;
    padding-top: 8px;
    padding-left: 10px;
    color: white;
}
input#privacy.form-input{
    margin-top: 14px;
}
.name{
    width: 100px;
    overflow: hidden;
    white-space: nowrap;
    padding-right: 120px;
    padding-top: 10px;
    color: white;
}
.create-new-collection{
    margin-right: 1000px;
}

</style>