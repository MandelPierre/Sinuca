package sinuca.example.service;

import java.util.*;

import org.springframework.stereotype.Service;
import sinuca.example.model.CalculoRequest;
import sinuca.example.model.Partida;

@Service
public class SinucaService {
    public Map<String, Double> calcular(CalculoRequest req) {
        Map<String, Double> totais = new LinkedHashMap<>();
        for (Partida partida : req.getPartidas()) {
            if (partida == null) continue;

            // supondo que cada Partida tenha uma lista de nomes dos jogadores
            List<String> jogadores = partida.getJogadores();

            if (jogadores == null || jogadores.isEmpty()) continue;

            double porJogador = req.getValorFicha() / jogadores.size();

            for (String nome : jogadores) {
                totais.merge(nome, porJogador, Double::sum);
            }
        }
        return totais;
    }
}