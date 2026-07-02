package br.com.screensound.artista;

import br.com.screensound.repository.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Scanner;

@Service
public class ListarArtistaPorEstiloService {

    private Scanner read = new Scanner(System.in);

    @Autowired
    private ArtistaRepository artistaRepository;

    public void listar(){
        listarEstilosMusicais().forEach(e ->
                System.out.printf("%s\n",e));

        System.out.println("Digite um Tipo:");
        String estilo = read.nextLine();

        listarArtistasPorEstilo(estilo);

    }

    private List<String> listarEstilosMusicais(){
        return artistaRepository.listarEstilosMusicais();
    }

    private void listarArtistasPorEstilo(String estilo){
        artistaRepository.buscarPorEstilo(estilo).forEach(a ->
                System.out.printf("""           
                🎵 %s
                📅 Ano de Formação: %s
                """,a.getNome(),a.getAnoFormacao()));
    }

}
