package sinuca.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Quantos jogadores pariciparam? ");
        int qtdJogadores = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= qtdJogadores; i++) {
            System.out.println("Digite o nome dos jogadores " + i + " : ");
            String nome = sc.nextLine();


            System.out.println("Jogador cadastro: " + nome);
        }

        sc.close();
    }
}