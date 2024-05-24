package Entities;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;

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

    public Sessao(String idioma, Integer sala) {
        this.idioma = idioma;
        this.sala = sala;

    }

    public static int getAno(java.util.Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    public Time converterStringParaTime(String horaText) {
        try {
            // Definir o formato da hora
            SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");

            // Analisar a string da hora para um objeto Date
            java.util.Date date = formatoHora.parse(horaText);

            // Converter o objeto Date para um objeto Time
            return new java.sql.Time(date.getTime());
        } catch (ParseException e) {
            System.out.println("Formato de hora inválido: " + horaText);
            return null; // Ou lance uma exceção, ou trate conforme necessário
        }
    }

    public java.sql.Date transformaDataSQL(String data) {
        try {
            // Obter o ano atual
            java.util.Date dataAtual = new java.util.Date(); // data atual
            int ano = getAno(dataAtual);

            // Definir o formato da data sem o ano
            SimpleDateFormat formatoSemAno = new SimpleDateFormat("MM-dd");

            // Converter a string para um objeto Date do Java (sem ano)
            java.util.Date dataSemAno = formatoSemAno.parse(data);

            // Criar um calendário e definir o ano, mês e dia
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dataSemAno);
            calendar.set(Calendar.YEAR, ano);

            // Obter o objeto Date completo com o ano, mês e dia
            java.util.Date dataCompleta = calendar.getTime();

            // Converter o objeto Date do Java para um objeto Date do SQL
            java.sql.Date dataSessao = new java.sql.Date(dataCompleta.getTime());

            // Exibir a data convertida
            System.out.println("Data SQL: " + dataSessao);

            return dataSessao;
        } catch (Exception e) {
            System.out.println("Formato de data inválido.");
            return null;
        }
    }
}
