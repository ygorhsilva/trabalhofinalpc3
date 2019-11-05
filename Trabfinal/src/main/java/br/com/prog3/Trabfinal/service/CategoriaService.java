package br.com.prog3.Trabfinal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.prog3.Trabfinal.domain.Categoria;
import br.com.prog3.Trabfinal.repository.CategoriaRepository;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria save(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
	
	public List<Categoria> findAll() {
		return (List<Categoria>) categoriaRepository.findAll();
	}
	
	public Optional<Categoria> findById (Integer id){
		return categoriaRepository.findById(id);
	}
	
	public Categoria update(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
	
	public void deleteById(Integer id) {
		categoriaRepository.deleteById(id);
	}


}
