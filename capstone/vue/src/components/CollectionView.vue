<template>
    <div id="collection-view">
        <h2>View Comics</h2>

   <div class="grid-container" id="collection-comics">
      <div
        class="grid-item"
        id="comicPhoto"
        v-for="comic in sortComicsWithoutTitle"
        v-bind:key="comic.comicTitle"
        >

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
import collectionService from "@/services/collectionService"
export default {
data(){
    return {
    comics:[],
    comic:{
        collectionComicId: 0,
        collectionId: 0,
        comicTitle: "",
        marvelId: 0,
        description: "",
        imageURL: "",
        creatorId: 0
    },
    collectionId: this.collectionId,
    }
},
created(){
    collectionService.getComicsFromCollection(this.$route.params.collectionid).then((response) => {
        this.comics = response.data;
    })
},
computed: {
      sortComicsWithoutTitle() {
      return this.comics.filter((comic) =>
        comic.comicTitle != 0 && comic.comicTitle != null)
      }
}
}
</script>

<style>
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
  padding-top: 200px;
}

@media (min-width: 768px) {
  .button-54 {
    padding: 0.25em 0.75em;
  }
}


/* This is the comic cover images */
.comic-img {
  height: 60%;
  width: 70%;
  border: 1px solid white;
  box-shadow: 10px 10px 10px black;
}


.select-collection {
  padding-top: 0px;
  padding-left: 0px;
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