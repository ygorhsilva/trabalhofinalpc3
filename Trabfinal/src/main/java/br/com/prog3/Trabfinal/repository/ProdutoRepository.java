package br.com.prog3.Trabfinal.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.prog3.Trabfinal.domain.Produto;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Integer>{

}
