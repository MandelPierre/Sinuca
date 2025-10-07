package sinuca.example.model;

import java.util.List;

public class Partida {
    private List<String> jogadores;

    public Partida() {}

    public List<String> getJogadores() {
        return jogadores;
    }

    public void setJogadores(List<String> jogadores) {
        this.jogadores = jogadores;
    }
}