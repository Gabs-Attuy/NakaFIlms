package Entities;

import java.io.FileInputStream;
import java.sql.Blob;

public class Filme {
    private String nome, duracao, elenco, diretor, genero, distribuidora, classificacao, sinopse;
    private FileInputStream fis;
    private int tamanho;

    public FileInputStream getFis() {
        return fis;
    }

    public void setFis(FileInputStream fis) {
        this.fis = fis;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getElenco() {
        return elenco;
    }

    public void setElenco(String elenco) {
        this.elenco = elenco;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDistribuidora() {
        return distribuidora;
    }

    public void setDistribuidora(String distribuidora) {
        this.distribuidora = distribuidora;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public Filme(String nome, String duracao, String elenco, String diretor, String genero, String distribuidora, String classificacao, String sinopse, FileInputStream fis, int tamanho) {
        this.nome = nome;
        this.duracao = duracao;
        this.elenco = elenco;
        this.diretor = diretor;
        this.genero = genero;
        this.distribuidora = distribuidora;
        this.classificacao = classificacao;
        this.sinopse = sinopse;
        this.fis = fis;
        this.tamanho = tamanho;
    }
}
