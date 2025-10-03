package sinuca.example;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Qua valor da ficha (Cada paritda)? ");
        double valorFicha = sc.nextDouble();
        sc.nextLine();

        System.out.println("Quantos jogadores pariciparam? ");
        int qtdJogadores = sc.nextInt();
        sc.nextLine();

        List<Jogador> jogadores = new ArrayList<>();


        for (int i = 1; i <= qtdJogadores; i++) {
            System.out.println("Digite o nome dos jogadores " + i + " : ");
            String nome = sc.nextLine();
            jogadores.add(new Jogador(nome));
        }

        System.out.println("Quantas partidas foram jogadas? ");
        int qtdPartidas = sc.nextInt();
        sc.nextLine();
        
        List<Partida> partidas = new ArrayList<>();

        //Cada partida perguntar quem jogou
        for (int p = 1; p <= qtdPartidas; p++) {
            System.out.println("-----Partida "+ p + "-----");
            System.out.print("Quantos jogadores jogaram esta partida? ");
            int qtdJogadoresPartida = sc.nextInt();
            sc.nextLine();

            List<Jogador> jogadoresDaPartida = new ArrayList<>();

            for (int j = 1; j <= qtdJogadoresPartida; j++) {
                // Mostrar lista de jogadores cadastrados
                System.out.println("Escolha o número do jogador:");
                for (int k = 0; k < jogadores.size(); k++) {
                    System.out.println((k+1) + " - " + jogadores.get(k).getNome()) ;
                }

                int escolha = sc.nextInt();
                sc.nextLine();
                jogadoresDaPartida.add(jogadores.get(escolha - 1));
            }

            //Criar a partida com os jogadores selecionados
            partidas.add(new Partida (jogadoresDaPartida));
        }

        //Dividir a conta
        DivisorConta.dividir(partidas, valorFicha * qtdPartidas);

        sc.close();
    }
}