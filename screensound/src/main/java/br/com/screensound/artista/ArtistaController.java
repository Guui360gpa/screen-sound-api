package br.com.screensound.artista;

import br.com.screensound.service.ConsumoAPI;
import org.springframework.stereotype.Controller;
import java.util.Scanner;

@Controller
public class ArtistaController {
    private int opcao;
    private Scanner read = new Scanner(System.in);

    private final BuscarArtistaService buscarArtista;
    private final ListarArtistaPorEstiloService listarArtistaPorEstilo;

    public ArtistaController(BuscarArtistaService buscarArtista,ListarArtistaPorEstiloService listarArtistaPorEstilo){
        this.buscarArtista = buscarArtista;
        this.listarArtistaPorEstilo = listarArtistaPorEstilo;
    }

    public void menu(){
        while(true){
            System.out.println("-----------------------");
            System.out.println("    Screen Sound       ");
            System.out.println("-----------------------");

            System.out.println("""
                    
                    [1] Buscar Artista
                    [2] Listar Artistas por estilo
                    
                    [0] Sair
                    
                    """);


            opcao = read.nextInt();
            read.nextLine();

            if(opcao == 0){
                break;
            }

            switch (opcao){
                case 1:
                    buscarArtista.printarArtista();
                    break;
                case 2:
                    listarArtistaPorEstilo.listar();
                    break;

                default:
                    System.out.println("! Digite uma opção válida !");
            }

        }
    }
}
