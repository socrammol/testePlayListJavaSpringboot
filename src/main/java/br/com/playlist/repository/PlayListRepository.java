package br.com.playlist.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.playlist.model.Usuario;
import br.com.playlist.model.playList;

@Repository
public interface PlayListRepository extends CrudRepository<playList, Long> {





}
