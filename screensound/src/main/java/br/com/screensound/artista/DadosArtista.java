package br.com.screensound.artista;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosArtista(@JsonAlias("idArtist") String id,
                           @JsonAlias("strArtist") String nome,
                           @JsonAlias("strGenre") String estilo,
                           @JsonAlias("intFormedYear") String anoFormacao,
                           @JsonAlias("strCountry") String pais,
                           @JsonAlias("strBiography") String biografia,
                           @JsonAlias("strArtistThumb") String urlPoster) {
}
