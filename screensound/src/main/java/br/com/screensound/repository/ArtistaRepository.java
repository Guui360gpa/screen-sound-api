package br.com.screensound.repository;

import br.com.screensound.artista.Artista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {

    @Query("SELECT a FROM Artista a WHERE a.estiloMusical = :estilo")
    List<Artista> buscarPorEstilo(String estilo);

    @Query("SELECT DISTINCT a.estiloMusical FROM Artista a")
    List<String> listarEstilosMusicais();

    Optional<Artista> findByNomeIgnoreCase(String nome);
}
