package br.com.screensound.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "artistas")
public class Artista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nome")
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(name = "categoria")
    private TipoArtista categoria;

    @OneToMany(mappedBy = "artista")
    List<Musica> musicas = new ArrayList<>();

    public Artista(String nome, TipoArtista categoriaArtista) {
        this.nome = nome;
        this.categoria = categoriaArtista;
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

    public TipoArtista getCategoriaArtista() {
        return categoria;
    }

    public void setCategoriaArtista(TipoArtista categoriaArtista) {
        this.categoria = categoriaArtista;
    }

    public List<Musica> getMusicas() {
        return musicas;
    }

    public void setMusicas(List<Musica> musicas) {
        this.musicas = musicas;
    }

    @Override
    public String toString() {
        return nome + " - "  + categoria;
    }
}
