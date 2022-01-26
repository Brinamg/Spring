package br.org.generation.farmacia.repository;

import java.math.BigDecimal;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import br.org.generation.farmacia.model.produto;

public interface produtoRepository {
			
		@Repository
		public interface ProdutoRepository extends JpaRepository<produto, Long>{

		Object findAllByTituloContainingIgnoreCase(String nome);

		Optional<ResponseEntity<produto>> existsById(@Valid produto produto);

		Object findByPrecoBetween(BigDecimal start, BigDecimal end);


	}

}
