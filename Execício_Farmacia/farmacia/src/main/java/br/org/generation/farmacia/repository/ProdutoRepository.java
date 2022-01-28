package br.org.generation.farmacia.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.generation.farmacia.model.produto;

@Repository
public interface ProdutoRepository extends JpaRepository<produto, Long> {
			
		
		public List<produto> findByPrecoBetween(BigDecimal start, BigDecimal end);

		public List<produto> findAllByNomeContainingIgnoreCase(String nome);
		
		
	}


