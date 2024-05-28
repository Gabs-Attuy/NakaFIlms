package Entities;

import java.sql.Blob;

public class SessaoItem {
    private int id;
    private String displayValue;
    private Blob foto;
    private String nome_filme;

    public SessaoItem(int id, String displayValue, Blob foto, String nome_filme) {
        this.id = id;
        this.displayValue = displayValue;
        this.foto = foto;
        this.nome_filme = nome_filme;
    }

    public int getId() {
        return id;
    }

    public Blob getFoto() {
        return foto;
    }

    public String getNome_filme() {
        return nome_filme;
    }

    @Override
    public String toString() {
        return displayValue;
    }
}
