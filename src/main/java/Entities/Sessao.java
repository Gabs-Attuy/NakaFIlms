package Entities;

import java.sql.Date;
import java.sql.Time;

public class Sessao {
    private String idioma;
    private Date data_Sessao;
    private Time horario;
    private Integer sala;

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Date getData_Sessao() {
        return data_Sessao;
    }

    public void setData_Sessao(Date data_Sessao) {
        this.data_Sessao = data_Sessao;
    }

    public Time getHorario() {
        return horario;
    }

    public void setHorario(Time horario) {
        this.horario = horario;
    }

    public Integer getSala() {
        return sala;
    }

    public void setSala(Integer sala) {
        this.sala = sala;
    }

    public Sessao(String idioma, Date data_Sessao, Time horario, Integer sala) {
        this.idioma = idioma;
        this.data_Sessao = data_Sessao;
        this.horario = horario;
        this.sala = sala;
    }
}
