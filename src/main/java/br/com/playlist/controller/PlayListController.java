package br.com.playlist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.playlist.dto.ManutencaoPlayListDto;
import br.com.playlist.dto.CriacaoPlayListDto;
import br.com.playlist.service.PlayLIstService;

@RestController
@RequestMapping(path = "/playlist")
@CrossOrigin(origins = { "http://localhost:*" }, allowCredentials = "true")
public class PlayListController {
	@Autowired
	PlayLIstService playLIstService;

	// criação do usuario
	@PostMapping(path = "/criar")
	public Object criaPlayList(@RequestBody CriacaoPlayListDto criacao) {
		return playLIstService.criaPlayList(criacao);
	}

	// adicionar item na lista
	@PostMapping(path = "/add")
	public Object adicionarPlayList(@RequestBody ManutencaoPlayListDto add) {
		return playLIstService.addPlayList(add);
	}

	// remove item na lista
	@PostMapping(path = "/remove")
	public Object RemoverPlayList(@RequestBody ManutencaoPlayListDto add) {
		return playLIstService.removePlayList(add);
	}
	
	//mostrando as musicas de uma playList
	@GetMapping(path = "/vermusicaplay/{id}")
	public Object verMusicasDaPlaylistPlayList(@PathVariable Long id) {
		return playLIstService.verMusicaPlayList(id);
	}
	//mostrando as playLists do usuario
	@GetMapping(path = "/verplay/{id}")
	public Object verPlayList(@PathVariable Long id) {
		return playLIstService.verPlayListUser(id);
	}
}
