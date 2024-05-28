package Entities;

public class Nakabank {
    private Integer n_conta, senha;
    private double saldo;

    public Integer getN_conta() {
        return n_conta;
    }

    public void setN_conta(Integer n_conta) {
        this.n_conta = n_conta;
    }

    public Integer getSenha() {
        return senha;
    }

    public void setSenha(Integer senha) {
        this.senha = senha;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Nakabank(Integer n_conta, Integer senha, double saldo) {
        this.n_conta = n_conta;
        this.senha = senha;
        this.saldo = saldo;
    }
}
