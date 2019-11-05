package br.com.prog3.Trabfinal.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.prog3.Trabfinal.domain.Categoria;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria,Integer>{

}
