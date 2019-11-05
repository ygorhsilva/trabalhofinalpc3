package br.com.prog3.Trabfinal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.prog3.Trabfinal.domain.Produto;
import br.com.prog3.Trabfinal.repository.ProdutoRepository;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository produtoRepository;

	
	
	public Produto save(Produto produto) {
		return produtoRepository.save(produto);
	}
	
	public List<Produto> findAll() {
		return (List<Produto>) produtoRepository.findAll();
	}
	
	public Optional<Produto> findById (Integer id){
		return produtoRepository.findById(id);
	}
	
	public Produto update(Produto produto) {
		return produtoRepository.save(produto);
	}
	
	public void deleteById(Integer id) {
		produtoRepository.deleteById(id);
	}

}
