package br.com.playlist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.playlist.dto.CriacaoUsuarioDto;
import br.com.playlist.service.UsuarioService;

@RestController
@RequestMapping(path = "/usuario")
@CrossOrigin(origins = {"http://localhost:*" }, allowCredentials = "true")
public class UserController {
	@Autowired
	UsuarioService usuarioService;
	
	//criação do usuario
	@PostMapping(path = "/criar")
	public Object criaUsuario(@RequestBody CriacaoUsuarioDto criacao){
		return usuarioService.criaUsuario(criacao);
	}
}
