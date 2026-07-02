package br.com.screensound.artista;

import jakarta.persistence.*;

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

    @Column(name = "pais_origem")
    private String pais;

    @Column(name = "biografia",columnDefinition = "TEXT")
    private String biografia;

    @Column(name = "url_poster",columnDefinition = "TEXT")
    private String urlPoster;

    public Artista(DadosArtista dadosArtista){
        if (dadosArtista.id() != null){
            this.id = Long.parseLong(dadosArtista.id());
        }
        this.nome = dadosArtista.nome();
        this.estiloMusical = dadosArtista.estilo();
        this.anoFormacao = dadosArtista.anoFormacao();
        this.pais = dadosArtista.pais();
        this.biografia = dadosArtista.biografia();
        this.urlPoster = dadosArtista.urlPoster();
    }

    public Artista(){}

    public String getEstiloMusical() {
        return estiloMusical;
    }

    public String getAnoFormacao() {
        return anoFormacao;
    }

    public String getBiografia() {
        return biografia;
    }

    public String getUrlPoster() {
        return urlPoster;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
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
