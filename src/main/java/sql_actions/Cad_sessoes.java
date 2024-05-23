package sql_actions;

import Entities.Assento;
import Entities.Sessao;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Cad_sessoes {
    private static int id_filme;

    public static int getId_filme() {
        return id_filme;
    }

    public static void setId_filme(int id_filme) {
        Cad_sessoes.id_filme = id_filme;
    }

    public static void Cad_sessao(Sessao s, double valor) throws Exception {
        int id_sessao = -1;
        try {
            SqlConnection conection = new SqlConnection();
            Connection cn = conection.openDB();
            PreparedStatement ps = cn.prepareStatement("INSERT INTO sessao (idioma, data, horario, FK_filme_id, sala) VALUES (?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setString(1, s.getIdioma());
            ps.setDate(2, s.getData_Sessao());
            ps.setTime(3, s.getHorario());
            ps.setInt(4, getId_filme());
            ps.setInt(5, s.getSala());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                id_sessao = rs.getInt(1);
            }

            JOptionPane.showMessageDialog(null, "Sessão cadastrada!");
            ps.close();
            cn.close();
        } catch (SQLException e) {
            throw new Exception("Falha ao acessar base de dados.\n" + e.getMessage());
        }
        cad_assento(id_sessao, valor);
    }

    private static void cad_assento(int id_sessao, double valor) throws Exception {
        char[] fileiras = {'a', 'b', 'c', 'd', 'e'};
        int assentos_fileira = 5;
        int total_assentos = 1;
        boolean statusPadrao = false;

        try {
            SqlConnection conection = new SqlConnection();
            Connection cn = conection.openDB();
            PreparedStatement ps = cn.prepareStatement("INSERT INTO assento (n_assento, fileira, status_assento, valor, FK_sessao_id) VALUES (?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);

            for (char fileira : fileiras) {
                for (int i = 1; i <= assentos_fileira; i++) {
                    Assento assento = new Assento(total_assentos++, fileira, statusPadrao, valor);

                    ps.setInt(1, assento.getN_assento());
                    ps.setString(2, String.valueOf(assento.getFileira()));
                    ps.setBoolean(3, assento.isStatus_assento());
                    ps.setDouble(4, assento.getValor());
                    ps.setInt(5, id_sessao);
                    ps.executeUpdate();
                }
            }

            JOptionPane.showMessageDialog(null, "Assentos cadastrados!");
            ps.close();
            cn.close();
        } catch (SQLException e) {
            throw new Exception("Falha ao acessar base de dados.\n" + e.getMessage());
        }
    }
}
