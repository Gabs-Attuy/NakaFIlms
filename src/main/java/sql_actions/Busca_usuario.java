package sql_actions;

import javax.swing.*;
import java.sql.*;
import java.util.Date;

public class Busca_usuario {
    public static boolean login (String email, String senha) throws Exception {
        try {
            SqlConnection conection = new SqlConnection();
            Connection cn = conection.openDB();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(
                    "SELECT id FROM usuario WHERE e_mail = '" + email + "' AND senha = '" + senha + "'"
            );
            return rs.next();
        } catch (SQLException e) {
            throw new Exception("Falha ao acessar base de dados.\n" + e.getMessage());
        }
    }

    public static JTable getUsers() {
        JTable tabela = new JTable();
        return tabela;
    }
    public static String getNome(int id) throws Exception {
        try {
            SqlConnection conection = new SqlConnection();
            Connection cn = conection.openDB();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(
                    "SELECT nome FROM usuario WHERE id = '" + id + "'"
            );
            if(rs.next()) {
                return rs.getString("nome");
            }
        } catch (SQLException e) {
            throw new Exception("Falha ao acessar base de dados.\n" + e.getMessage());
        }
        return null;
    }

    public static Date getDatadeNasc(int id) throws Exception{
        try {
            SqlConnection conection = new SqlConnection();
            Connection cn = conection.openDB();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(
                    "SELECT data_nascimento FROM usuario WHERE id = '" + id + "'"
            );
            if(rs.next()) {
                return rs.getDate("data_nascimento");
            }
        } catch (SQLException e) {
            throw new Exception("Falha ao acessar base de dados.\n" + e.getMessage());
        }
        return null;
    }
}
