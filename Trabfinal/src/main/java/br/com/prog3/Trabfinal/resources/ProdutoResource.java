package br.com.prog3.Trabfinal.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.prog3.Trabfinal.domain.Produto;
import br.com.prog3.Trabfinal.service.ProdutoService;

@RestController
@RequestMapping("/Produto")
public class ProdutoResource {
	@Autowired
	private ProdutoService produtoService;

	@GetMapping
	public ResponseEntity<List<Produto>> findAll() {
		List<Produto> produtos = produtoService.findAll();
		if (produtos == null || produtos.isEmpty()) {
			return new ResponseEntity<List<Produto>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Produto>>(produtos, HttpStatus.OK);
	}

	@PostMapping
	public Produto create(@RequestBody Produto produto) {
		return produtoService.save(produto);
	}

	@GetMapping(path = { "/{id}" })
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		return produtoService.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Produto> update(@PathVariable("id") Integer id, @RequestBody Produto produto) {
		return produtoService.findById(id).map(record -> {
			record.setDescricao(produto.getDescricao());
			Produto updated = produtoService.save(record);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		return produtoService.findById(id).map(record -> {
			produtoService.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}

}
