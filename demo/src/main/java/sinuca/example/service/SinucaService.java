package sinuca.example.service;

import java.util.*;
import org.springframework.stereotype.Service;
import sinuca.example.model.CalculoRequest;
import sinuca.example.model.Partida;
import sinuca.example.model.Jogador;

@Service
public class SinucaService {

    // Lista temporária para armazenar os jogadores registrados manualmente
    private List<Jogador> jogadores = new ArrayList<>();

    // === Parte 1: Registro e listagem ===

    public void registrarJogador(String nome, int partidas, double valorFicha) {
        Jogador j = new Jogador(nome, partidas, valorFicha);
        jogadores.add(j);
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }

    public void limparJogadores() {
        jogadores.clear();
    }

    // === Parte 2: Cálculo baseado nas partidas do CalculoRequest (o seu código) ===

    public Map<String, Double> calcular(CalculoRequest req) {
        Map<String, Double> totais = new LinkedHashMap<>();

        for (Partida partida : req.getPartidas()) {
            if (partida == null) continue;

            List<String> jogadores = partida.getJogadores();
            if (jogadores == null || jogadores.isEmpty()) continue;

            double porJogador = req.getValorFicha() / jogadores.size();

            for (String nome : jogadores) {
                totais.merge(nome, porJogador, Double::sum);
            }
        }
        return totais;
    }

    // === Parte 3: Cálculo simples dos jogadores registrados (opcional) ===

    public String calcularTotalRegistrados() {
        double total = 0;
        StringBuilder sb = new StringBuilder("Resumo dos Pagamentos:\n");

        for (Jogador j : jogadores) {
            double subtotal = j.getPartidas() * j.getValorFicha();
            total += subtotal;
            sb.append(String.format("%s: R$ %.2f%n", j.getNome(), subtotal));
        }

        sb.append(String.format("%nTotal Geral: R$ %.2f", total));
        return sb.toString();
    }
}