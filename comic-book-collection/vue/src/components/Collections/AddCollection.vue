<template>
    <div class="add-collection">
        <div class="form-popup" id="form">
            <form class="form-container">
                <h1>Add A New Collection</h1>
                <label for="title">Title</label>
                <!-- title should be required, but won't close if it's set with "required" -->
                <input 
                    type="text"
                    id="title"
                    placeholder="Title"
                    
                />
                <div id="radioButton">
                    <label for="private">Private</label>
                    <input
                        type="radio"
                        id="privacy"
                        name="privacy"
                    />
                    <label for="private">Public</label>
                    <input
                        type="radio"
                        id="privacy"
                        name="privacy"
                    />
                </div>
                <button id="submit">Submit</button>
                <button type="button" id="close" v-on:click="off()">Close</button>
            </form>
        </div>
    </div>
</template>

<script>

export default{
  name: 'add-collection',
  methods: {
      off() {
          document.getElementsByClassName("add-collection").style.display = "none";
      }
  }
};
</script>

<style scoped>
.form-container {
  max-width: 100%;
  margin: 10px;
  background-color: white;
  border-radius: 10px;
}

input{
  width: 90%;
  height: 20%;
  padding: 15px;
  margin: 5px 0 22px 0;
  border: none;
  background: #f1f1f1;
}

#radioButton{
    display: flex;
    justify-content: space-between;
}
</style>