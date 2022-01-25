package LojaDeGamesRepository;


import java.util.Optional;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import br.org.generation.LojaDeGames.model.Produto;


public interface produtoRepository {
	
	@Repository
	public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	Object findAllByTituloContainingIgnoreCase(String nome);

	Optional<ResponseEntity<Produto>> existsById(@Valid Produto produto);


}
}