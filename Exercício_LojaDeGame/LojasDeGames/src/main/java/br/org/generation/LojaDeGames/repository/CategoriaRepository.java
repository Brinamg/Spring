package br.org.generation.LojaDeGames.repository;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.generation.LojaDeGames.model.Categoria;



	@Repository
	public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
		
		public List <Categoria> findAllByTipoContainingIgnoreCase (String tipo);

		public Optional<Categoria> existsById(@Valid Categoria categoria);

	}
