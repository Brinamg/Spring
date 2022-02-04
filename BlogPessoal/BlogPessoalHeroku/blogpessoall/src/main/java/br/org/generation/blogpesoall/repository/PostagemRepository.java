package br.org.generation.blogpesoall.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.generation.blogpesoall.model.Postagem;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long>{
	
	List<Postagem> findAllByTituloContainingIgnoreCase(String titulo);
	

}