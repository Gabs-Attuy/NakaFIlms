package sql_actions;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Busca_filme {
    public static String getClassificacao(int id) throws Exception{
        try {
            SqlConnection conection = new SqlConnection();
            Connection cn = conection.openDB();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(
                    "SELECT classificacao FROM filme WHERE id = '" + id + "'"
            );
            if(rs.next()) {
                return rs.getString("classificacao");
            }
        } catch (SQLException e) {
            throw new Exception("Falha ao acessar base de dados.\n" + e.getMessage());
        }
        return null;
    }
}
