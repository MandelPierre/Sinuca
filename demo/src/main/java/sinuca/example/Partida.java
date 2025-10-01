package sinuca.example;

import java.util.List;

public class Partida {
    private List<Jogador> jogadores;

    public Partida(List<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }
}
