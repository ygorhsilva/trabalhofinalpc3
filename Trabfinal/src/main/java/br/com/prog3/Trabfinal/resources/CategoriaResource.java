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

import br.com.prog3.Trabfinal.domain.Categoria;
import br.com.prog3.Trabfinal.service.CategoriaService;


@RestController
@RequestMapping("/Categoria")
public class CategoriaResource {
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> findAll() {
		List<Categoria> categorias = categoriaService.findAll();
		if (categorias == null || categorias.isEmpty()) {
			return new ResponseEntity<List<Categoria>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Categoria>>(categorias, HttpStatus.OK);
	}

	@PostMapping
	public Categoria create(@RequestBody Categoria categoria) {
		return categoriaService.save(categoria);
	}

	@GetMapping(path = { "/{id}" })
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		return categoriaService.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Categoria> update(@PathVariable("id") Integer id, @RequestBody Categoria categoria) {
		return categoriaService.findById(id).map(record -> {
			Categoria updated = categoriaService.save(record);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		return categoriaService.findById(id).map(record -> {
			categoriaService.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}


}
