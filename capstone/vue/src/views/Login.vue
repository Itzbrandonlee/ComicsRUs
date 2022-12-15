<template>
<body bgcolor="#2c0703">
<div class="border">
  
  <div id="login" class="text-center" >
    <form class="form-signin" @submit.prevent="login">
      <h1 class="h3 mb-3 font-weight-normal">Welcome Back!</h1>
      <div
        class="alert alert-danger"
        role="alert"
        v-if="invalidCredentials"
      >Invalid username and password!</div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >Thank you for registering, please sign in.</div>
      <label for="username" class="sr-only">Username</label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      <label for="password" class="sr-only">Password</label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />
      <button type="submit">Sign in</button>
      <router-link :to="{ name: 'register' }">Need an account?</router-link>
      
    </form>
  </div>
  
  </div>
  </body>
 
</template>


<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  created() {
    document.body.style.backgroundColor= "rgb(44, 7, 3)";
  },
  components: {},
  data() {
    return {

      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style scoped>
  h1{
    font-size: 20px; 
    text-align: center;
  }
 
  .text-center {
    display:flex;
    font-family: sans-serif;
    padding: 10px;
    background-color:white;
  }

  .sr-only {
    padding: 10px;
  }

  .form-control#password {
    margin-bottom: 10px;
  }

  button {
    margin-top: 10px;
  width: 100%;
	height: 100%;
	border: 1px solid black;
	font-size: 15px;
	margin-bottom: 10px;
  background-color:#749d62;
  }


*{
	text-align: center;
	margin: 0px;
	padding: 0px;
	box-sizing: border-box;

}

.border{
	width: 400px;
	height: 430px ;
	background: #ffffff;
	padding: 30px;
	margin: 50px auto;
  margin-left: auto;
  display: inline-block;
}

.form-signin{
	width: 200px;
	height: 50px;
	margin-top: 20px;
	margin: 30px auto;
}

input
{
	width: 100%;
	height: 100%;
	border: 1px solid black;
	font-size: 15px;
	margin-bottom: 10px;
}


.check{
	width: 35%;
	height: 35%;
	font-size: 10px;
}

.signup
{
	text-align: center;
	
}
body {
   background-color: #451220;
   margin: 0px;
   padding: 0px;
   height: 100vh;
   width: 100%;

}

a:hover{background: #E0F3F6;}

</style>
