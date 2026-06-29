package br.com.screensound.musica;

import br.com.screensound.artista.Artista;
import jakarta.persistence.*;

@Entity
@Table(name = "musicas")
public class Musica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "musica")
    private String musica;

    @ManyToOne
    @JoinColumn(name = "artista_id")
    private Artista artista;

    public Musica(String musica,Artista artista) {
        this.musica = musica;
        this.artista = artista;
    }

    public Musica(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMusica() {
        return musica;
    }

    public void setMusica(String musica) {
        this.musica = musica;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    @Override
    public String toString() {
        return musica + " - " +
                "Artista: " + artista;
    }
}
