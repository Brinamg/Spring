package br.generation.blogpessoall.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import br.org.generation.blogpesoall.model.Usuario;
import br.org.generation.blogpesoall.repository.UsuarioRepository;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {
    
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@BeforeAll
	void start() {
		
		usuarioRepository.save(new Usuario(0L, "Maria Eduarda Alves", "maria@email.com.br", "15798456", " "));
				
		usuarioRepository.save(new Usuario(0L, "Arthur Alves", "arthur@email.com.br", "25798456", " "));
			
		usuarioRepository.save(new Usuario(0L, "Michele Alves", "michele@email.com.br", "14859845", " "));
	}

	@Test
	@DisplayName("Retorna 1 usuario")
	public void deveRetornarUmUsuario() {

		Optional<Usuario> usuario = usuarioRepository.findByUsuario("mari@email.com.br");
		assertTrue(usuario.get().getUsuario().equals("maria@email.com.br"));
	}

	@Test
	@DisplayName("Retorna 3 usuarios")
	public void deveRetornarTresUsuarios() {

		List<Usuario> listaDeUsuarios = usuarioRepository.findAllByNomeContainingIgnoreCase("Alves");
		assertEquals(3, listaDeUsuarios.size());
		assertTrue(listaDeUsuarios.get(0).getNome().equals("Maria Eduarda Alves"));
		assertTrue(listaDeUsuarios.get(1).getNome().equals("Arthur Alves"));
		assertTrue(listaDeUsuarios.get(2).getNome().equals("Michele Alves"));
		
	}

    @AfterAll
	public void end() {
		usuarioRepository.deleteAll();
	}
    
}