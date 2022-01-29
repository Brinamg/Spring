package br.org.generation.BlogPessoal.seguranca;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.org.generation.BlogPessoal.model.Usuario;
import br.org.generation.BlogPessoal.model.UsuarioLogin;
import br.org.generation.BlogPessoal.repository.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		Optional<Usuario> usuario = userRepository.FindByUsuario(userName);
	  
		usuario.orElseThrow(() -> new UsernameNotFoundException(userName + " not found."));

		return usuario.map(UserDetailsImpl::new).get();
	}

	public Optional<UsuarioLogin> autenticarUsuario(Optional<UsuarioLogin> user) {
		
		return null;
	}

	public Optional<UsuarioLogin> atualizarUsuario(@Valid Usuario usuario) {

		return null;
	}

	public Optional<UsuarioLogin> cadastrarUsuario(@Valid Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
