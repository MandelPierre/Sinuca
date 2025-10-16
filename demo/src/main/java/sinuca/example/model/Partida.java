package sinuca.example.model;

import java.util.*;

public class Partida {
    private String nome;
    private List<String> jogadores;

    public Partida() {}

    public Partida(String nome, List<String> jogadores) {
        this.nome = nome;
        this.jogadores = jogadores;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<String> getJogadores() {
        return jogadores;
    }

    public void setJogadores(List<String> jogadores) {
        this.jogadores = jogadores;
    }
}
