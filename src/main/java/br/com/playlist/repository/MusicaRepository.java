package br.com.playlist.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.playlist.model.Musica;

@Repository
public interface MusicaRepository extends CrudRepository<Musica, Long> {

	List<Musica> findByNome(String nome);

}
