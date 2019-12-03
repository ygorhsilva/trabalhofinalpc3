
<template>
  <div class="searchform">
    <h4>Busca por codigo</h4>
    <div class="form-group">
      <input type="number" class="form-control" id="codigo" required v-model="codigo" name="codigo" />
    </div>
    <div class="btn-group">
      <button v-on:click="pesquisarprodutos" class="btn btn-success">Pesquisar</button>
    </div>
    <ul class="search-result">
      <li v-for="(produto, index) in produtos" :key="index">
        <h6>{{produto.nome}} ({{produto.codigo}})</h6>
      </li>
    </ul>
  </div>
</template>
<script>
import http from "../http-common";
export default {
  name: "pesquisar-produto",
  data() {
    return {
      codigo: 0,
      produtos: []
    };
  },
  methods: {
    pesquisarprodutos() {
      http
        .get("/produtos/codigo/" + this.codigo)
        .then(response => {
          this.produtos = response.data; // JSON are parsed automatically.
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    }
  }
};
</script>
<style>
.searchform {
  max-width: 300px;
  margin: auto;
}
.search-result {
  margin-top: 20px;
  text-align: left;
}
</style>