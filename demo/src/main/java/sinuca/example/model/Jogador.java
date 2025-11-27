package sinuca.example.model;

public class Jogador {

    private String nome;
    private int partidasJogadas;
    private double totalAPagar;

    public Jogador() {
    }

    public Jogador(String nome) {
        this.nome = nome;
    }

    // Getters e setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPartidasJogadas() {
        return partidasJogadas;
    }

    public void setPartidasJogadas(int partidasJogadas) {
        this.partidasJogadas = partidasJogadas;
    }

    public double getTotalAPagar() {
        return totalAPagar;
    }

    public void setTotalAPagar(double totalAPagar) {
        this.totalAPagar = totalAPagar;
    }

    public void adicionarPartida() {
        this.partidasJogadas++;
    }

    public void adicionarValor(double valor) {
        this.totalAPagar += valor;
    }
}