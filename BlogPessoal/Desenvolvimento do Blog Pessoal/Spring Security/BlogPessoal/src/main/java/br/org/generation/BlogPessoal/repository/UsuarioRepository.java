package br.org.generation.BlogPessoal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.generation.BlogPessoal.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario , Long> {
	
		public Object getAll = null;

		public Optional<Usuario> FindByUsuario(String usuario);

		public Optional<Usuario> findById();

}
