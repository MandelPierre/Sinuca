package sinuca.example.model;

import java.util.*;

public class CalculoRequest {
    private List<Partida> partidas;
    private double valorFicha;
    private List<String> nomesJogadores;

    public List<Partida> getPartidas() {
        return partidas;
    }

    public void setPartidas(List<Partida> partidas) {
        this.partidas = partidas;
    }

    public double getValorFicha() {
        return valorFicha;
    }

    public void setValorFicha(double valorFicha) {
        this.valorFicha = valorFicha;
    }

    public List<String> getNomesJogadores() {
        return nomesJogadores;
    }

    public void setNomesJogadores(List<String> nomesJogadores) {
        this.nomesJogadores = nomesJogadores;
    }
}
