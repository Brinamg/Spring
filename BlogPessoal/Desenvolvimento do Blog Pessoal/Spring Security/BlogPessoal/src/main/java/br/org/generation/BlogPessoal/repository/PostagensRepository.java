package br.org.generation.BlogPessoal.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.generation.BlogPessoal.model.Postagem;

@Repository
	public interface PostagensRepository extends JpaRepository<Postagem, Long>{

	Object findAllByTituloContainingIgnoreCase(String titulo);

	}