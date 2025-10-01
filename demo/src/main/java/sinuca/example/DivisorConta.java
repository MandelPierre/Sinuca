package sinuca.example;

import java.util.List;

public class DivisorConta {
    public static void dividir(List<Partida> partidas, double valorTotal) {
        double valorPorPartida = valorTotal / partidas.size();

        for (Partida partida : partidas) {
            double valorPorJogador = valorPorPartida / partida.getJogadores().size();
            for (Jogador jogador : partida.getJogadores()) {
                jogador.adicionarCusto(valorPorJogador);
            }
        }

        //Resultado
        System.out.println("Resultado da divisão: ");
        partidas.stream()
                .flatMap(p -> p.getJogadores().stream())
                .distinct()
                .forEach(j -> System.out.println(j.getNome() + " deve pagar  R$ " + String.format("%.2f", j.getValorDevido())));
    }
}
