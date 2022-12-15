<template>
     <div class="sidebar-page">
        <section class="sidebar-layout">
             <b-sidebar
                position="static"
                :mobile="mobile"
                :expand-on-hover="expandOnHover"
                :reduce="reduce"
                :delay="expandWithDelay ? 500 : null"
                type="is-light"
                open
            >
                <div class="p-1">
                    <b-menu class="is-custom-mobile">
                        <b-menu-list label="Menu">
                            <b-menu-item tag="router-link" to='/' icon="information-outline" label="Home"></b-menu-item>
                            <b-menu-item tag="router-link" to='/allcomics/' icon="account-box" label="All Comics"></b-menu-item>
                        </b-menu-list>
                        <b-menu-list>
                            <b-menu-item tag="router-link" to='/mycollections/' icon="link" label="My Collections"></b-menu-item>
                            <b-menu-item tag="router-link" to='/collections/' label="Collections" icon="link"></b-menu-item>
                        </b-menu-list>
                    </b-menu>
                </div>
            </b-sidebar>
        </section>
    </div>
</template>

<script>
export default {
data() {
    return {
      expandOnHover: false,
      expandWithDelay: false,
      mobile: "reduce",
      reduce: false
    };
  }
};
</script>

<style>
.p-1{
    background-color: #1d010d;
    box-shadow: 10px 10px 10px black;
}
.is-custom-mobile{
    background-color: #1d010d;
    height:100vh;
   
    
}
.block{
    background-color: #1d010d;
    box-shadow: 10px 10px 10px rgba(0, 0, 0, 0.5);

}
.sidebar-page {
    text-align: center;
    text-transform: uppercase;
    float:left;
    margin-right: 10px;
    margin-left: 0px;
    display: block;
    padding-top: 25px;
    height:100px;
    text-transform: uppercase;
    font-family: "Open Sans", sans-serif;
    font-weight: bold;
    letter-spacing: 2px;
  
}

.sidebar-layout {
    position: fixed;
    padding-top: 45px;
}
img {
    height: 50px;
}
.menu-list {
    margin-right: 28px;
}
p.menu-label {
    padding-top: 30px;
    font-size: 20px;
    font-weight: bold;

}

</style>