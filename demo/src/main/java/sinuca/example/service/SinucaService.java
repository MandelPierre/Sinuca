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

            List<String> jogadores = partida.getJogadores();
            if (jogadores == null || jogadores.isEmpty()) continue;

            double porJogador = req.getValorFicha() / jogadores.size();

            for (String nome : jogadores) {
                totais.merge(nome, porJogador, Double::sum);
            }
        }
        return totais;
    }

    public String gerarResumo(Map<String, Double> totais) {
        StringBuilder sb = new StringBuilder();
        sb.append("<h2>Valor a pagar</h2>");
        sb.append("<ul>");
        double totalGeral = 0;

        for (Map.Entry<String, Double> entry : totais.entrySet()) {
            sb.append(String.format("<li>%s: R$ %.2f</li>", entry.getKey(), entry.getValue()));
            totalGeral += entry.getValue();
        }

        sb.append("</ul>");
        sb.append(String.format("<p><strong>Total geral:</strong> R$ %.2f</p>", totalGeral));
        return sb.toString();
    }
}
