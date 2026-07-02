package br.com.screensound.controller;

import br.com.screensound.artista.ArtistaController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.util.Scanner;

@Controller
public class MenuController {

    private int opcao = 1;
    private Scanner read = new Scanner(System.in);

    @Autowired
    private ArtistaController artistaController;

    public void Menu() {}

    public void main(){
        while(opcao != 0){
            System.out.println("-----------------------");
            System.out.println("    Screen Sound       ");
            System.out.println("-----------------------");

            System.out.println("""

                    [1] Artistas
                    [2] Albuns
                    [3] Músicas

                    [0] Sair

                    """);

            opcao = read.nextInt();
            read.nextLine();

            switch (opcao){
                case 1:
                    artistaController.menu();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }


        }
    }
}
