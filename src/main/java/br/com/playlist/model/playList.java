package br.com.playlist.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import br.com.playlist.service.MusicaService;

@Entity
public class playList {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToMany
	List<Musica> musicas = new ArrayList<>();
	@ManyToOne
	Usuario user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Musica> getMusicas() {
		return musicas;
	}

	public void setMusicas(List<Musica> musicasRecebidas) {
		for (Musica musica : musicasRecebidas) {
			musicas.add(musica);
		}
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public void setMusica(Musica musica) {
		this.musicas.add(musica);
		
	}

	public void setRemoveMusica(Musica musica) {
		this.musicas.remove(musica);
		
	}

}
