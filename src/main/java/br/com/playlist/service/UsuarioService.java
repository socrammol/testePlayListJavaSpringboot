package br.com.playlist.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.playlist.dto.CriacaoUsuarioDto;
import br.com.playlist.dto.UsuarioDto;
import br.com.playlist.error.ObjectNotFoundException;
import br.com.playlist.model.Usuario;
import br.com.playlist.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	UsuarioRepository usuarioRepository;

	public Object criaUsuario(CriacaoUsuarioDto criacao) {
		if(criacao.getNome().isBlank()||criacao.getNome().isEmpty()||criacao.getNome() == null) {
			throw new ObjectNotFoundException("Usuario com campo nome vazio ou nulo");
		}
		Usuario user = new Usuario();
		user.setNome(criacao.getNome());
		return usuarioRepository.save(user);
	}

	public Usuario validaUser(UsuarioDto user) {
		Optional<Usuario> usuario = usuarioRepository.findById(user.getId());
		if(!usuario.isPresent()) {
			throw new ObjectNotFoundException("Usuario nao existe");
		}
		if(!usuario.get().getNome().equals(user.getNome())) {
			throw new ObjectNotFoundException("Usuario nao cadastrado");
		}
		return usuario.get();
		
	}

	public Usuario validaUser(Long id) {
		if(id == null) {
			throw new ObjectNotFoundException("Usuario nao cadastrado");
		}
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		if(!usuario.isPresent()) {
			throw new ObjectNotFoundException("Usuario nao existe");
		}
		return usuario.get();
	}

}
