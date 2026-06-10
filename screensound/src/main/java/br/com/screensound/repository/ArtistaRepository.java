package br.com.screensound.repository;

import br.com.screensound.models.Artista;
import br.com.screensound.models.TipoArtista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {

    @Query("SELECT a FROM Artista a WHERE a.categoria = :tipoArtista")
    List<Artista> buscarPorCategoria(TipoArtista tipoArtista);

    Optional<Artista> findByNomeIgnoreCase(String nome);
}
