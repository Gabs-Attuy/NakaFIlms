package Entities;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Usuario {
    private String nome, cpf, rg, telefone, email, senha;
    private Date data_de_nascimento;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getData_de_nascimento() {
        return data_de_nascimento;
    }

    public void setData_de_nascimento(Date data_de_nascimento) {
        this.data_de_nascimento = data_de_nascimento;
    }

    public Usuario(String nome, String cpf, String rg, String telefone, String email, String senha, Date data_de_nascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
        this.data_de_nascimento = data_de_nascimento;
    }

    public Usuario(String nome, String cpf, String rg, String telefone, String email, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
    }
    public Date transformaDataSQL(String data) {
        try {
            // Definir o formato da data
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

            // Converter a string para um objeto Date do Java
            java.util.Date dataUtil = formato.parse(data);

            // Converter o objeto Date do Java para um objeto Date do SQL
            data_de_nascimento = new java.sql.Date(dataUtil.getTime());

            // Exibir a data convertida
            System.out.println("Data SQL: " + data_de_nascimento);

            return data_de_nascimento;
        } catch (Exception e) {
            System.out.println("Formato de data inválido.");
            return null;
            // Tratamento de exceção, se o formato da data inserida pelo usuário for inválido
        }
    }
}

