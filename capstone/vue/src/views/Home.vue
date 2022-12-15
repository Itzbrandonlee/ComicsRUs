<template>
  <div class="home">
    <div class="home-img">
      <img src="../assets/welcome radial.png" alt="logo">
    </div>
    <h1>Top Employee Picks</h1>
    <h2>search for these comics in all comics to add to your collection</h2>
    <Carousel />
    

  </div>
  
</template>

<script>
import Carousel from "../components/Carousel.vue"
export default {
  name: "home",
  components: {
    Carousel
  }
};
</script>

<style scoped>
.home-img{
  padding-top: 50px;
  padding-left: 180px;
  padding-bottom: 40px;
}
.home{
  height: 100;
  min-height: 100%;
  background-color: #451220;
}
h1 {
    color: white;
    font-size: 30px;
    text-transform: uppercase;
    font-family: "Open Sans", sans-serif;
    font-weight: bold;
    letter-spacing: 2px;
    padding-left: 200px;
}
h2{
  color: white;
    font-size: 13px;
    text-transform: uppercase;
    font-family: "Open Sans", sans-serif;
    font-weight: bold;
    letter-spacing: 2px;
    padding-left: 50px;
    padding-bottom: 0px;
    padding-left: 230px;
}
section{
  padding-top: 0px;
  padding-bottom: 50px;
}
</style>

