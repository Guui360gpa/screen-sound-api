package br.com.screensound.artista;

import br.com.screensound.musica.Musica;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "artistas")
public class Artista {

    @Id
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "estilo_musical")
    private String estiloMusical;

    @Column(name = "ano_formacao")
    private String anoFormacao;

    @Column(name = "biografia",columnDefinition = "TEXT")
    private String biografia;

    @Column(name = "url_poster",columnDefinition = "TEXT")
    private String urlPoster;

    @OneToMany(mappedBy = "artista")
    List<Musica> musicas = new ArrayList<>();

    public Artista(DadosArtista dadosArtista){
        if (dadosArtista.id() != null){
            this.id = Long.parseLong(dadosArtista.id());
        }
        this.nome = dadosArtista.nome();
        this.estiloMusical = dadosArtista.estilo();
        this.anoFormacao = dadosArtista.anoFormacao();
        this.biografia = dadosArtista.biografia();
        this.urlPoster = dadosArtista.urlPoster();
    }

    public Artista(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoriaArtista() {
        return estiloMusical;
    }

    public void setCategoriaArtista(String estiloMusical) {
        this.estiloMusical = estiloMusical;
    }

    public List<Musica> getMusicas() {
        return musicas;
    }

    public void setMusicas(List<Musica> musicas) {
        this.musicas = musicas;
    }

    @Override
    public String toString() {
        return """
            🎵 %s
            🎸 Estilo: %s
            📅 Ano de Formação: %s
            📖 Biografia: %s
            """.formatted(nome, estiloMusical, anoFormacao, biografia);
    }
}
