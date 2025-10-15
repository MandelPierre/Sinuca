package sinuca.example.model;

public class Jogador {
    private String nome;
    private int partidas;
    private double valorFicha;

    public Jogador(String nome, int partidas, double valorFicha) {
        this.nome = nome;
        this.partidas = partidas;
        this.valorFicha = valorFicha;
    }

    public String getNome() { return nome; }
    public int getPartidas() { return partidas; }
    public double getValorFicha() { return valorFicha; }
}