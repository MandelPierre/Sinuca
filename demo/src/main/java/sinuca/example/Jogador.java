package sinuca.example;

public class Jogador {
    private String nome;
    private double valorDevido = 0;

    public Jogador(String nome) {
        this.nome = nome;
    }

    public void adicionarCusto(double valor) {
        this.valorDevido += valor;
    }

    public String getNome() {
        return nome;
    }

    public double getValorDevido() {
        return valorDevido;
    }
}
