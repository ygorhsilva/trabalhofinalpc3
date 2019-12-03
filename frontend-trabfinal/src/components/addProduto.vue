<template>
  <div class="submitform">
    <div v-if="!submitted">
      <div class="form-group">
        <label for="nome">Nome</label>
        <input
          type="text"
          class="form-control"
          id="nome"
          required
          v-model="produto.nome"
          name="nome"
        />
      </div>
      <div class="form-group">
        <label for="codigo">Codigo</label>
        <input
          type="number"
          class="form-control"
          id="codigo"
          required
          v-model="produto.codigo"
          name="codigo"
        />
      </div>
      <button v-on:click="salvarProduto" class="btn btn-success">Salvar</button>
    </div>
    <div v-else>
      <h4>Salvo com sucesso.</h4>
      <button class="btn btn-success" v-on:click="novoProduto">Adicionar</button>
    </div>
  </div>
</template>
<script>
export default {
  name: "add-produto",
  data() {
    return {
      produto: {
        codigo: 0,
        nome: "",
        descricao: "",
        precoCompra: 0.0,
        precoVenda: 0.0,
        desconto: 0.0,
        imagem: "",
        garantia: "",
        fabricante: "",
        ativo: false
      },
      submitted: false
    };
  },
  methods: {
    novoProduto() {
      this.submitted = false;
      this.produto = {};
    }
  }
};
</script>
<style>
.submitform {
  max-width: 300px;
  margin: auto;
}
</style>