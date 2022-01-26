package br.org.generation.farmacia.repository;

import java.math.BigDecimal;
import java.util.List;

import br.org.generation.farmacia.model.produto;

public interface categoriaRepository {
		

		public List<produto> findAllByNomeContainingIgnoreCase (String nome);
		
		public List<produto> findByPrecoBetween (BigDecimal start, BigDecimal end);

	}
