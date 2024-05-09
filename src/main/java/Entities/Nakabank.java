package Entities;

public class Nakabank {
    private Integer n_conta, codigo_seguranca;
    private double saldo;

    public Integer getN_conta() {
        return n_conta;
    }

    public void setN_conta(Integer n_conta) {
        this.n_conta = n_conta;
    }

    public Integer getCodigo_seguranca() {
        return codigo_seguranca;
    }

    public void setCodigo_seguranca(Integer codigo_seguranca) {
        this.codigo_seguranca = codigo_seguranca;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Nakabank(Integer n_conta, Integer codigo_seguranca, double saldo) {
        this.n_conta = n_conta;
        this.codigo_seguranca = codigo_seguranca;
        this.saldo = saldo;
    }

    public void transferencia(Integer cod_destino, double valor){

    }

    public void deposito(double valor){
        this.saldo += valor;
    }

    public void pagamento(double valor_pedido, Integer cod_adm){

    }
}
