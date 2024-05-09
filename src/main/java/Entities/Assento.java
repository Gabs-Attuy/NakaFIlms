package Entities;

public class Assento {
    private Integer n_assento;
    private char fileira;
    private boolean status_assento;
    private double valor;

    public Integer getN_assento() {
        return n_assento;
    }

    public void setN_assento(Integer n_assento) {
        this.n_assento = n_assento;
    }

    public char getFileira() {
        return fileira;
    }

    public void setFileira(char fileira) {
        this.fileira = fileira;
    }

    public boolean isStatus_assento() {
        return status_assento;
    }

    public void setStatus_assento(boolean status_assento) {
        this.status_assento = status_assento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Assento(Integer n_assento, char fileira, boolean status_assento, double valor) {
        this.n_assento = n_assento;
        this.fileira = fileira;
        this.status_assento = status_assento;
        this.valor = valor;
    }
}
