package br.com.playlist.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.playlist.dto.ManutencaoPlayListDto;
import br.com.playlist.dto.CriacaoMusicaDto;
import br.com.playlist.dto.CriacaoPlayListDto;
import br.com.playlist.dto.MusicaDto;
import br.com.playlist.dto.UsuarioDto;
import br.com.playlist.error.ObjectNotFoundException;
import br.com.playlist.model.Musica;
import br.com.playlist.model.Usuario;
import br.com.playlist.model.playList;
import br.com.playlist.repository.PlayListRepository;

@Service
public class PlayLIstService {
	@Autowired
	PlayListRepository playListRepository;
	@Autowired
	UsuarioService user;
	@Autowired
	MusicaService music;

	public Object criaPlayList(CriacaoPlayListDto criacao) {
		validaUsuario(criacao);
		List<Musica> music = validaMusicas(criacao);
		playList play = criaPlayListNova(criacao, music);
		return play;
	}

	private playList criaPlayListNova(CriacaoPlayListDto criacao, List<Musica> music) {
		playList play = new playList();
		Usuario user = geraUsuario(criacao.getUser());
		play.setMusicas(music);
		play.setUser(user);
		return playListRepository.save(play);
	}

	private Usuario geraUsuario(UsuarioDto user2) {
		Usuario user = new Usuario();
		user.setId(user2.getId());
		user.setNome(user2.getNome());
		return user;
	}

	private List<Musica> gerarMusicas(List<MusicaDto> musicas) {
		List<Musica> music = new ArrayList<>();
		for (Musica musica : music) {
			music.add(musica);
		}
		return music;
	}

	private List<Musica> validaMusicas(CriacaoPlayListDto criacao) {
		return music.validaMusicas(criacao.getMusicas());

	}

	private Usuario validaUsuario(CriacaoPlayListDto criacao) {
		return user.validaUser(criacao.getUser());

	}

	public Object addPlayList(ManutencaoPlayListDto add) {
		Optional<playList> play = playListRepository.findById(add.getIdPlayList());
		if (play.isPresent()) {
			Musica musica = geraMusica(add);
			play.get().setMusica(musica);
			return playListRepository.save(play.get());
		}
		throw new ObjectNotFoundException("PlayList nao cadastrada");
	}

	private Musica geraMusica(ManutencaoPlayListDto add) {
		Musica musica = music.validaMusicas(add);
		return musica;
	}

	public Object removePlayList(ManutencaoPlayListDto add) {
		Optional<playList> play = playListRepository.findById(add.getIdPlayList());
		if (play.isPresent()) {
			Musica musica = geraMusica(add);
			play.get().setRemoveMusica(musica);
			return playListRepository.save(play.get());
		}
		throw new ObjectNotFoundException("PlayList nao cadastrada");
	}

	public Object verMusicaPlayList(Long id) {
		Optional<playList> play = playListRepository.findById(id);
		if (play.isPresent()) {
			return play.get().getMusicas();
		}
		throw new ObjectNotFoundException("PlayList nao cadastrada");
	}

	public Object verPlayListUser(Long id) {
		Usuario usuario = user.validaUser(id);
		List<playList> playRetorno = new ArrayList<>();
		List<playList> play = (List<playList>) playListRepository.findAll();
		if (play.isEmpty()) {
			throw new ObjectNotFoundException("PlayList nao cadastrada");
		}
		for (playList playList : play) {
			if (playList.getUser().equals(usuario)) {
				playRetorno.add(playList);
			}
		}
		return playRetorno;

	}
}
