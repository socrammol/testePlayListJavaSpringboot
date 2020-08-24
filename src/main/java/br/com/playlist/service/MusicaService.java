package br.com.playlist.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.playlist.dto.ManutencaoPlayListDto;
import br.com.playlist.dto.CriacaoMusicaDto;
import br.com.playlist.dto.MusicaDto;
import br.com.playlist.error.ObjectNotFoundException;
import br.com.playlist.model.Musica;
import br.com.playlist.repository.MusicaRepository;

@Service
public class MusicaService {
	@Autowired
	MusicaRepository MusicaRepository;

	public Object criaMusica(CriacaoMusicaDto criacao) {
		validacao(criacao);
		Musica music = new Musica(criacao.getAlbum(), criacao.getArtista(), criacao.getNome());
		verificaSeMusicaJaEstaCadastrada(music);
		return MusicaRepository.save(music);
	}

	private void verificaSeMusicaJaEstaCadastrada(Musica music) {
		List<Musica> musica = MusicaRepository.findByNome(music.getNome());
		if (!musica.isEmpty()) {
			for (Musica musica2 : musica) {
				if (musica2.getAlbum().equals(music.getAlbum()) && musica2.getArtista().equals(music.getArtista())) {
					throw new ObjectNotFoundException("Musica ja cadastrada");
				}
			}

		}

	}

	private void validacao(CriacaoMusicaDto criacao) {
		if (criacao.getAlbum() == null || criacao.getAlbum().isBlank() || criacao.getAlbum().isEmpty()) {
			throw new ObjectNotFoundException("Album vazio ou nulo");
		}
		if (criacao.getArtista() == null || criacao.getArtista().isBlank() || criacao.getArtista().isEmpty()) {
			throw new ObjectNotFoundException("Artista vazio ou nulo");
		}
		if (criacao.getNome() == null || criacao.getNome().isBlank() || criacao.getNome().isEmpty()) {
			throw new ObjectNotFoundException("Nome da musica vazio ou nulo");
		}

	}

	public List<Musica> validaMusicas(List<MusicaDto> musicas) {
		List<Musica> musicasRetorno = new ArrayList<>();
		for (MusicaDto musicaDto : musicas) {
			Optional<Musica> music = MusicaRepository.findById(musicaDto.getId());
			if (!music.isPresent()) {
				throw new ObjectNotFoundException("musica nao existe");
			}
			if (!music.get().getAlbum().equals(musicaDto.getAlbum())
					&& !music.get().getArtista().equals(musicaDto.getArtista())) {
				throw new ObjectNotFoundException("musica nao cadastrada");
			}
			
			musicasRetorno.add(music.get());
		}
		return musicasRetorno;
	}

	public Musica validaMusicas(ManutencaoPlayListDto add) {
		Optional<Musica> music = MusicaRepository.findById(add.getIdMusica());
		if (!music.isPresent()) {
			throw new ObjectNotFoundException("musica nao existe");
		}
		if (!music.get().getAlbum().equals(add.getAlbum()) && !music.get().getArtista().equals(add.getArtista())) {
			throw new ObjectNotFoundException("musica nao cadastrada");
		}
		return music.get();

	}

}
