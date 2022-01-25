package LojaDeGamesRepository;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.generation.LojaDeGames.model.Categoria;

public interface CategoriaRepository {
	@Repository
	public interface categoriaRepository extends JpaRepository<Categoria, Long>{

	public  List<Categoria>  findAllByDescricaoContainingIgnoreCase(String tipo);

	public Optional<Categoria> existsById(@Valid Categoria categoria);
	
	
}

	public boolean existsById(Long id);

}	


	
