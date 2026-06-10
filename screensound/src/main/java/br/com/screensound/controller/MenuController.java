package br.com.screensound.controller;

import br.com.screensound.models.Artista;
import br.com.screensound.models.Musica;
import br.com.screensound.models.TipoArtista;
import br.com.screensound.repository.ArtistaRepository;
import br.com.screensound.repository.MusicaRepository;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class MenuController {

    private int opcao;
    private Scanner read = new Scanner(System.in);
    private ArtistaRepository artistaRepository;
    private MusicaRepository musicaRepository;

    public MenuController(ArtistaRepository artistaRepository, MusicaRepository musicaRepository) {
        this.artistaRepository = artistaRepository;
        this.musicaRepository = musicaRepository;
    }

    public void menu(){
        while(true){
            System.out.println("-----------------------");
            System.out.println("    Screen Sound       ");
            System.out.println("-----------------------");

            System.out.println("""
                    
                    [1] Cadastrar Artista
                    [2] Cadastrar Música
                    [3] Listar Músicas
                    [4] Listar Artistas por categoria
                    [5] Buscar musicas por artistas
                    
                    [0] Sair
                    
                    """);


            opcao = read.nextInt();
            read.nextLine();

            if(opcao == 0){
                break;
            }

            switch (opcao){
                case 1:
                    cadastrarArtista();
                    break;
                case 2:
                    cadastrarMusica();
                    break;
                case 3:
                    listarMusicas();
                    break;
                case 4:
                    listarArtistasPorCategoria();
                    break;
                case 5:
                    buscarMusicasPorArtista();
                    break;

                default:
                    System.out.println("! Digite uma opção válida !");
            }

    }
    }

    private void cadastrarArtista(){
        var cadastrarNovo = "s";

        while (true){
            System.out.println("Digite o nome de Artista:");
            var nomeArtista = read.nextLine();

            System.out.println("Digite seu tipo \n(Solo/Banda/Dupla):");
            String tipo = read.nextLine();

            TipoArtista tipoArtista = TipoArtista.valueOf(tipo.toUpperCase());

            Artista artista = new Artista(nomeArtista,tipoArtista);

            artistaRepository.save(artista);

            System.out.println("Deseja continuar? (s/n)");
            cadastrarNovo = read.nextLine();

            if (cadastrarNovo.equalsIgnoreCase("n")){
                break;
            }
        }

    }

    private void listarArtistasPorCategoria(){
        System.out.println("Digite um Tipo (Banda/Dupla/Solo)");
        var tipo = read.nextLine();

        TipoArtista tipoArtista = TipoArtista.valueOf(tipo.toUpperCase());

        List<Artista> artistasPorTipo = artistaRepository.buscarPorCategoria(tipoArtista);

        artistasPorTipo.forEach(System.out::println);

    }

    private void cadastrarMusica() {
        System.out.println("Digite o nome da musica: ");
        var nomeMusica = read.nextLine();

        System.out.println("Ela é de qual artista: ");
        var nomeArtista = read.nextLine();

        Optional<Artista> artistaEncontrado = artistaRepository.findByNomeIgnoreCase(nomeArtista);

        if(artistaEncontrado.isPresent()){
            Musica musica = new Musica(nomeMusica,artistaEncontrado.get());
            musicaRepository.save(musica);

        }
    }

    private void listarMusicas() {
        List<Musica> musicas = musicaRepository.findAll();

        musicas.forEach(m ->
                System.out.printf("%s | %s\n",m.getMusica(),m.getArtista().getNome()));
    }

    private void buscarMusicasPorArtista(){
        System.out.println("Qual é o nome do artista?");
        var nomeArtista = read.nextLine();
        Optional<Artista> artistaEncontrado = artistaRepository.findByNomeIgnoreCase(nomeArtista);

        if(artistaEncontrado.isPresent()){
            List<Musica> musicasDoArtista = musicaRepository.findByArtistaNomeIgnoreCase(nomeArtista);
            System.out.printf("Musicas do artista %s\n",nomeArtista);

            musicasDoArtista.forEach(m ->
                    System.out.printf("%s\n",m.getMusica()));
        }

    }
}
