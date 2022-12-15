<template>
  <div>
      <create-new-collection />
      <my-collections />

    </div>
</template>

<script>
import CreateNewCollection from '../components/CreateNewCollection.vue'
import MyCollections from '../components/MyCollections.vue'

export default {
  components: { 
    CreateNewCollection,
    MyCollections

}
}
</script>

