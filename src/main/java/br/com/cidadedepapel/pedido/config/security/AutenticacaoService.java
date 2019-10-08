package br.com.cidadedepapel.pedido.config.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.cidadedepapel.pedido.models.Usuario;
import br.com.cidadedepapel.pedido.repository.UsuarioRepository;

@Service
public class AutenticacaoService implements UserDetailsService{

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> optional = usuarioRepository.findByEmail(username);
		
		if(optional.isPresent()) {
			return optional.get();
		}
		throw new UsernameNotFoundException("Dados Inválidos");
	}

}
