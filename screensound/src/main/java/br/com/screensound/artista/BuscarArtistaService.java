package br.com.screensound.artista;

import br.com.screensound.exception.ArtistaNaoEncontradoException;
import br.com.screensound.repository.ArtistaRepository;
import br.com.screensound.service.ConsumoAPI;
import br.com.screensound.service.ConverteDados;
import br.com.screensound.service.UrlUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class BuscarArtistaService {

    private Scanner read = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConverteDados converteDados = new ConverteDados();
    private final String ENDERECO = "https://www.theaudiodb.com/api/v1/json/123/search.php?s=";
    private List<DadosArtista> dadosArtistas;
    private String nomeArtista;

    @Autowired
    private ArtistaRepository artistaRepository;


    public Optional<Artista> buscarArtista() {
        System.out.println("Digite o nome de Artista:");
        nomeArtista = read.nextLine();

        return artistaRepository.findByNomeIgnoreCase(nomeArtista);
    }



    public void printarArtista(){
        String cadastrarNovo = "";
        while (!cadastrarNovo.equalsIgnoreCase("n")){
            Optional<Artista> artistaOpt = buscarArtista();
            if(artistaOpt.isPresent()){
                System.out.println(encontrarArtistaNoBanco(artistaOpt.get()));
            }else {
                try {
                    System.out.println(encontrarArtistaNaAPI(UrlUtils.formatarArtista(nomeArtista)));
                }catch (ArtistaNaoEncontradoException ex){
                    System.out.println(ex.getMessage());
                }

            }
            System.out.println("Deseja continuar? (s/n)");
            cadastrarNovo = read.nextLine();
        }
    }

    private Artista encontrarArtistaNoBanco(Artista artista){
        return artista;
    }

    private Artista encontrarArtistaNaAPI(String nomeArtista) {
        var json = consumoAPI.obterDados(ENDERECO + nomeArtista);

        if (jsonExiste(json)) {
            ArtistaResposta artistaResposta = converteDados.obterDados(json, ArtistaResposta.class);

            if (artistaResposta.artists() == null || artistaResposta.artists().isEmpty()) {
                throw new ArtistaNaoEncontradoException("Artista não encontrado!");
            }

            DadosArtista dadosArtista = artistaResposta.artists().get(0);
            Artista artista = new Artista(dadosArtista);
            salvarArtistaNoBanco(artista);
            return artista;
        }
        return null;
    }

    private void salvarArtistaNoBanco(Artista artista) {
        Optional<Artista> artistaExistente = artistaRepository.findById(artista.getId());

        if (artistaExistente.isEmpty()) {
            artistaRepository.save(artista);
        } else {
            System.out.println("Artista já cadastrado: " + artista.getNome());
        }
    }

    private boolean jsonExiste(String json){
        return json != null && !json.isEmpty();
    }
}

