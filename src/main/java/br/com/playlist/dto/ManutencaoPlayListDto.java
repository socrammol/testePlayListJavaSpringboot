package br.com.playlist.dto;

public class ManutencaoPlayListDto {
	private Long idPlayList;
	private Long idMusica;
	private String nome;
	private String artista;
	private String album;

	public Long getIdPlayList() {
		return idPlayList;
	}

	public void setIdPlayList(Long idPlayList) {
		this.idPlayList = idPlayList;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public Long getIdMusica() {
		return idMusica;
	}

	public void setIdMusica(Long idMusica) {
		this.idMusica = idMusica;
	}

}
