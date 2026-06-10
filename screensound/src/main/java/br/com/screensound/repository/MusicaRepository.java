package br.com.screensound.repository;

import br.com.screensound.models.Musica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MusicaRepository extends JpaRepository<Musica,Long> {

    List<Musica> findByArtistaNomeIgnoreCase(String nome);
}
