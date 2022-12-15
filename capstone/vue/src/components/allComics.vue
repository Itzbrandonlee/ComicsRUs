<template>
  <div class="all-comics">
        <section>
            <b-dropdown class= "select-collection" aria-role="list" v-model="collectionId">
                <template #trigger="{ active }">
                    <b-button class= "b-button"
                    label="Select collection to add"
                    type="is-light"
                    :icon-right="active ? 'menu-up' : 'menu-down'" />
                </template>
             <b-dropdown-item v-for= "collection in userCollections" v-bind:key="collection.collectionId" aria-role="listitem" v-model="collection.collectionId">{{collection.collectionName}}</b-dropdown-item>
        </b-dropdown>
    </section>


    <input
      class="search-bar-tool"
      type="text"
      name="search"
      placeholder=""
      src="src/assets/beige magnifying.png" 
      v-model="userInput"
      v-on:keyup.enter="searchComics"
    />

  <div class="loading" v-if="isLoading">
<img src="../assets/comic-yes.gif" alt="Loading">
      </div>


    <div class="grid-container" id="comicBody">
      <div
        class="grid-item"
        id="comicCover"
        v-for="(comic, i) in sortComicsByUserInput"
        v-bind:key="comic.marvelId">

      <div class="add-to-collection"><button v-bind:key="comic.comicTitle" v-on:click="addComicToCollection(), method_1($event, i)">Add to Collection</button></div>
          <div class="flip-card">
          <div class="flip-card-inner">
            <div class="flip-card-front">
              <img :src="comic.imageURL" alt="" class="comic-img" />
            </div>
            <div class="flip-card-back" v>
              <h1>{{ comic.comicTitle }}</h1>
                
            </div>
        </div>
      </div>
      </div>
    </div>

  </div>
</template>


<script>

import MarvelService from "@/services/marvelComicService";
import collectionService from "@/services/collectionService"

export default {
  name: "all-comics",
  data() {
    return {
        isloading: true,
    //   user_id: this.user.id,
      userInput: "",
      comic: {
        comicId: 0,
        marvelId: 0,
        comicTitle: "0",
        author: null,
        imageURL: "",
        releaseDate: null,
        creatorId: 0,
        seriesId: 0,
        description: "",
        extension: "jpg",
      },
      apiComics: [],
      userCollections: [],
      collection: {
        collectionId: 0,
        collectionName: "",
        userId: 0,
        collectionPrivacy: ""
      },
      comicIdToAdd: 0,
      collectionId: this.collectionId,
      marvelComic: {
          comicTitle: "",
          collectionComicId: 0,
          marvelId: 0,
          description: "",
          imageURL: "",
          creatorId: 0
      }
    }
  },

  computed: {
    sortComicsByUserInput() {
      return this.apiComics.filter((comic) =>
        comic.comicTitle.toLowerCase().includes(this.userInput.toLowerCase())
      );
    }
  },

  methods: {
      method_1: function(ev, i){
      console.log(ev)
      this.comic = Object.assign(this.apiComics[i])
      console.log(this.comic)
    
    },
    searchComics() {
      MarvelService.searchByComics(this.userInput).then((response) => {
        this.apiComics = response.data;
      });
    },
        addComicToCollection(){
        this.marvelComic.comicTitle= this.comic.comicTitle
        this.marvelComic.marvelId= this.comic.marvelId
        this.marvelComic.description= this.comic.description
        this.marvelComic.imageURL= this.comic.imageURL
        this.marvelComic.creatorId= this.comic.creatorId

        
      console.log(this.marvelComic.comicTitle)
      console.log(this.comic.comicTitle)
      collectionService.addComicToCollection(this.marvelComic, this.collectionId).then(response => {
        if(response.status === 200) {
          //
        }
      });
    },

  },

  created() {
      this.isLoading = true;
    MarvelService.searchByComics("I").then((response) => {
      this.apiComics = response.data;
      this.isLoading = false;
    }),

    collectionService.getMyCollections(this.$store.state.user.id).then((response) =>{
      this.userCollections = response.data;
    })
  }
}

</script>

<style scoped>

.loading{
    margin-top: 50px;
    margin-left: 250px;
}

.all-comics {
    height: 100;
    min-height: 100%;
    background-color: #451220;
}
/* This is the overall comic display list */
#comicCover {
  display: inline-block;
  font-family: "Contrail One", "Franklin Gothic Medium Extended", "sans-serif";
  letter-spacing: 1px;
  word-spacing: 2px;
}
/* displays images in a grid format and keeps each size the same*/
.grid-container {
  display: grid;
  grid-template-columns: 250px 250px 250px 250px 250px;
  grid-template-rows: 450px 450px 450px 450px 450px ;
  justify-content: center;
  padding-left: 250px;
  padding-top: 10px;
}



/* This is the title for each comic */
h2 {
  color: white;
  text-align: center;
  font-size: 20px;
  margin-right: 22px;
  margin-left: 22px;
  margin-bottom: 50px;
  margin-top: 0px;
  padding-bottom: 40px;
  padding-top: 0;
  
}

.add-to-collection button {
  font-family: "Open Sans", sans-serif;
  font-size: 11px;
  font-weight: bold;
  letter-spacing: 2px;
  text-decoration: none;
  text-transform: uppercase;
  color: black;
  cursor: pointer;
  border: 3px solid;
  padding: 0.25em 0.5em;
  box-shadow: 1px 1px 0px 0px, 2px 2px 0px 0px, 3px 3px 0px 0px, 4px 4px 0px 0px, 5px 5px 0px 0px;
  position: relative;
  user-select: none;
  -webkit-user-select: none;
  touch-action: manipulation;
  background-color: #e6dac6;
    width: 45%;
    margin: 10px;
}
.add-to-collection button:hover {
  box-shadow: #E70D11 0 -25px 18px -14px inset,#E70D11 0 1px 2px,#E70D11 0 2px 4px,#E70D11 0 4px 8px,#E70D11 0 8px 16px,#E70D11 0 16px 32px;
  transform: scale(1.05) rotate(-1deg);
}
.add-to-collection button:active {
  box-shadow: 0px 0px 0px 0px;
  top: 5px;
  left: 5px;
}
@media (min-width: 768px) {
  .button-54 {
    padding: 0.25em 0.75em;
  }
}
.select-collection button:hover {
  box-shadow: lightgreen 0 -25px 18px -14px inset,lightgreen 0 1px 2px,lightgreen 0 2px 4px,lightgreen 0 4px 8px,lightgreen 0 8px 16px,lightgreen 0 16px 32px;
  transform: scale(1.05) rotate(-1deg);
}

/* This is the comic cover images */
.comic-img {
  height: 60%;
  width: 70%;
  border: 1px solid white;
  box-shadow: 10px 10px 10px black;
}


/* Search Bar - need to change out  */
 .search-bar-tool[type="text"] {
  width: 20%;
  height: 50px;
  background-color: #e6dac6;
  font-family: "Open Sans", sans-serif;
  font-weight: bold;
  letter-spacing: 2px;
  text-transform: uppercase;
  text-align: center;
  border: 4px solid;
  border-radius: 16px;
  border-image: linear-gradient(#2c0703, #2c0703) 1;
  border-style: double;
  background-color: transparent;
  color: white;
  -webkit-transition: width 0.4s ease-in-out;
  transition: width 0.4s ease-in-out;
  padding: 5.5px;
  background-image: url(https://i.imgur.com/mcDRNUe.png);
  background-size: contain;
  background-repeat: no-repeat;
  outline: 0;
  background-size: 30px;
  background-position: 12px;
  flex-direction: row;
  display: flex;
  align-self: center;
  justify-content: center;
  margin: auto;
  margin-top: 3%;
  margin-bottom: 5%;
  margin-left: 930px;
} 

/* Search Bar */
/* When the input field gets focus, change its width to 100% - need to change */
.search-bar-tool[type="text"]:focus {
  width: 25%;
  background-color: #e6dac6;
  font-family: "Open Sans", sans-serif;
  font-weight: bold;
  letter-spacing: 2px;
  text-transform: uppercase;
 border-image: linear-gradient(#e70d11, #e70d) 1;
  text-align: center;
  border: 5px (#e70d11, #e70d);
  border-style: inset;
  border-radius: 16px;
  background-color: transparent;

  color: white;
} 
input.search-bar-tool {
  align-items: center;
}

::placeholder {
  /* "Search Cosmic Comics"*/
  color: white;
  font-family: "Bangers";
  letter-spacing: 2px;
}

.select-collection {
  padding-top: 150px;
  padding-left: 0px;
  background-color: transparent;
  margin-left: 220px;
}
.select-collection .b-button {
  background-color: #E6DAC6;
  font-weight: bold;
  font-family: "Open Sans", sans-serif;
  letter-spacing: 2px;
  text-transform: uppercase;
  border: 3px solid;
  color:black;
  font-size: 17px;
 box-shadow: 10px 10px 10px rgba(0, 0, 0, 0.5);
  }

@-webkit-keyframes fadeIn {
  from {
    opacity: 0;
  }
  to {
    opacity: 1;
  }
}

@keyframes fadeIn {
  from {
    opacity: 0;
  }
  to {
    opacity: 1;
  }
}

/* .grid-item {
  position: relative;
  z-index: -1;
} */

.flip-card:hover .flip-card-inner {
  transform: rotateY(180deg);
}

.flip-card {
  background-color: transparent;
  width: 100%;
  height: 100%;
  
}

.flip-card-inner {
  position: relative;
  width: 100%;
  height: 100%;
  text-align: center;
  transition: transform 0.8s;
  transform-style: preserve-3d;
}


/* Position the front and back side */
.flip-card-front, .flip-card-back {
  position: absolute;
  width: 100%;
  height: 100%;
  -webkit-backface-visibility: hidden; /* Safari */
  backface-visibility: hidden;
}

/* Style the back side */
.flip-card-back {
  background-color: rgb(8, 8, 5);
  font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
  font-size: 18px;
  /* color:#749D82; */
  color: white;
  transform: rotateY(180deg);
  font-weight: bold;
  height: 280px;
  width: 190px;
  box-shadow: 10px 10px 10px #749d82;
  margin-left: 12%;
  font-style: oblique;
  padding-top: 10px;
  
}

</style>

