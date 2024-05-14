package sql_actions;

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
