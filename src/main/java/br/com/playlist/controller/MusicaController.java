package br.com.playlist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.playlist.dto.CriacaoMusicaDto;
import br.com.playlist.dto.CriacaoUsuarioDto;
import br.com.playlist.service.MusicaService;
import br.com.playlist.service.UsuarioService;

@RestController
@RequestMapping(path = "/musica")
@CrossOrigin(origins = {"http://localhost:*" }, allowCredentials = "true")
public class MusicaController {
	@Autowired
	MusicaService musicaService;
	
	//criação do usuario
	@PostMapping(path = "/criar")
	public Object criaMusica(@RequestBody CriacaoMusicaDto criacao){
		return musicaService.criaMusica(criacao);
	}

}
