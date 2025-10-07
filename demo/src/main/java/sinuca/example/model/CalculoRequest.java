package sinuca.example.model;

import sinuca.example.model.Partida;
import java.util.List;

public class CalculoRequest {
    private double valorFicha;
    private List<Partida> partidas;

    // Construtor vazio (necessário para o Spring)
    public CalculoRequest() {}

    // Getters e Setters
    public double getValorFicha() {
        return valorFicha;
    }

    public void setValorFicha(double valorFicha) {
        this.valorFicha = valorFicha;
    }

    public List<Partida> getPartidas() {
        return partidas;
    }

    public void setPartidas(List<Partida> partidas) {
        this.partidas = partidas;
    }
}