package br.com.playlist.dto;

import java.util.ArrayList;
import java.util.List;

public class CriacaoPlayListDto {
	UsuarioDto user;
	List<MusicaDto> musicas = new ArrayList<>();

	public UsuarioDto getUser() {
		return user;
	}

	public void setUser(UsuarioDto user) {
		this.user = user;
	}

	public List<MusicaDto> getMusicas() {
		return musicas;
	}

	public void setMusicas(List<MusicaDto> musicas) {
		this.musicas = musicas;
	}

}
