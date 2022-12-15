<template>
  <div id="app">
    <header>
      <img src="@/assets/comics r us final.png"/>
       <!-- <b-button class= 'logout' tag="router-link" to="/logout" type="is-link is-light" v-if="$store.state.token != ''">Logout</b-button><br /> -->
      
       <button class='logout-btn' @click="$router.push('/logout')" v-if="$store.state.token != ''">Logout</button>
       
        </header>
    <div id="nav">
      <navbar />
    </div>
    
    <router-view />
  
  </div>
</template>

<script>
import Navbar from "../src/components/NavBar.vue";
export default {
  components: {
    Navbar
  }
};
</script>
<style scoped>
header {
  background-color: #1d010d;
  display: flex;
  justify-content: space-between;
  width: 100%;
  position: fixed;
  box-shadow: 10px 10px 10px black;
}

header a {
  text-align: right;
}
#router-link-active {
  color: red;
}
#router-link-exact-active {
  color: red;
}
/* #nav { */
  /* background-color: #1d010d;
  text-align: right;
  height: 25px;
  box-shadow: 10px 10px 10px black; */

/* } */
#app {
  background-color: #451220;
  height: 100%;
  width: 100%;
  min-height: 100%;
 
   
}
.logout{
  margin-top: 15px;
  margin-left: 1600px;
  
}
.logout-btn{
  background-color: #E6DAC6;
    width: 5%;
    margin: 10px;
  font-family: "Open Sans", sans-serif;
  font-size: 13px;
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
}
.logout-btn:active {
  box-shadow: 0px 0px 0px 0px;
  top: 5px;
  left: 5px;
}
@media (min-width: 768px) {
  .logout-btn {
    padding: 0.25em 0.75em;
  }
}
.logout-btn:hover {
  box-shadow: #E70D11 0 -25px 18px -14px inset,#E70D11 0 1px 2px,#E70D11 0 2px 4px,#E70D11 0 4px 8px,#E70D11 0 8px 16px,#E70D11 0 16px 32px;
  transform: scale(1.05) rotate(-1deg);
}

</style>


