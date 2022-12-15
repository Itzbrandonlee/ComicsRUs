<template>
<div class="border">
  <div id="register" class="text-center">
    <form class="form-register" @submit.prevent="register">
      <h1 class="h3 mb-3 font-weight-normal">Create Account</h1>
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
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
      <input
        type="password"
        id="confirmPassword"
        class="form-control"
        placeholder="Confirm Password"
        v-model="user.confirmPassword"
        required
      />
      <div id="premiumUser">
      <label class="premiumUserLabel" for="PremiumUser">Premium User</label>
      <input
        type="checkbox"
        id="premiumUser"
        name="premiumUser"
        class="premiumUser"
        />
        </div>
      <button class="btn btn-lg btn-primary btn-block" type="submit">
        Create Account
      </button>
      <router-link :to="{ name: 'login' }">Have an account?</router-link>
    </form>
  </div>
  </div>
</template>
<script>
import authService from '../services/AuthService';
export default {
  name: 'register',
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
</script>
<style>
 h1{
    font-size: 20px;
  }
  .text-center {
    display:flex;
    font-family: sans-serif;
    padding: 10px;
    background-color: white;
}
  /* .form-register {
    display: flex;
    flex-direction: column;
    align-items: center;
    align-content: space-around;
    width:30vh;
    flex-grow: 1;
  } */
  .premiumUserLabel {
    display:inline-block;
    margin-top: 10px;
    margin-bottom: 10px;
    background-color: white;
  }
  #premiumUser {
    background-color: white;
  }
  .premiumUserLabel.premiumUser{
    display: flex;
    flex-direction: row;

  }
  .sr-only {
    padding: 10px;
  }
  .confirmPassword{
    padding-bottom: 10px;
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
  height: 530px ;
  background: #FFFFFF;
  padding: 30px;
  margin: 50px auto;
  margin-left: auto;
  display: inline-block;
}
.form-register{
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
body{
  height: 100vh;
  width: 100%;
  padding: 0px;
  margin: 0px;
}
a:hover{background: #E0F3F6;}
</style>