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
        artistaRepository.listarEstilosMusicais();

        System.out.println("Digite um Tipo:");
        String estilo = read.nextLine();

        estilo = estilo.toLowerCase();

        List<Artista> artistasPorTipo = artistaRepository.buscarPorEstilo(estilo);

        artistasPorTipo.forEach(System.out::println);

    }
}
