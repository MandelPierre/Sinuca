package sinuca.example.service;

import java.util.*;
import org.springframework.stereotype.Service;
import sinuca.example.model.CalculoRequest;
import sinuca.example.model.Partida;
import sinuca.example.model.Jogador;
import sinuca.example.repository.SinucaRepository;

@Service
public class SinucaService {

    private final SinucaRepository repository;

    public SinucaService(SinucaRepository repository) {
        this.repository = repository;
    }
    
    public Map<Jogador, Double> calcular(CalculoRequest req) {

        Map<String, Jogador> jogadoresPorNome = new LinkedHashMap<>();

        if (req.getPartidas() == null) {
            return Collections.emptyMap();
        }

        for (Partida partida : req.getPartidas()) {
            if (partida == null) continue;

            List<String> nomes = partida.getJogadores();
            if (nomes == null || nomes.isEmpty()) continue;

            Long idPartida = repository.salvarPartida(partida.getNome());

            double porJogador = req.getValorFicha() / nomes.size();

            for (String nome : nomes) {

                Long idJogador = repository.buscarOuCriarJogador(nome);

                Jogador jog = jogadoresPorNome
                        .computeIfAbsent(nome, n -> new Jogador(n));
                jog.adicionarPartida();
                jog.adicionarValor(porJogador);

                repository.salvarParticipacao(idPartida, idJogador, porJogador);
            }
        }

        Map<Jogador, Double> totais = new LinkedHashMap<>();
        for (Jogador j : jogadoresPorNome.values()) {
            totais.put(j, j.getTotalAPagar());
        }

        return totais;
    }

    public String gerarResumo(Map<Jogador, Double> totais) {
        StringBuilder sb = new StringBuilder();
        sb.append("<h2 style='margin-top: 0;'>Valor a pagar</h2>");
        sb.append("<ul>");
        double totalGeral = 0;

        for (Map.Entry<Jogador, Double> entry : totais.entrySet()) {
            Jogador j = entry.getKey();
            double valor = entry.getValue();

            sb.append(String.format(
                "<li>%s: R$ %.2f (partidas: %d)</li>",
                j.getNome(), valor, j.getPartidasJogadas()
            ));

            totalGeral += valor;
        }

        sb.append("</ul>");
        sb.append(String.format(
            "<p><strong>Total geral:</strong> R$ %.2f</p>",
            totalGeral
        ));
        return sb.toString();
    }
}