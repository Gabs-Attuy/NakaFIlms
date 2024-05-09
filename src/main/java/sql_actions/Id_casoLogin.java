package sql_actions;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Id_casoLogin {
    public static int getUserId(String email, String senha) throws Exception{
        try {
            SqlConnection conection = new SqlConnection();
            Connection cn = conection.openDB();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(
                    "SELECT id FROM usuario WHERE e_mail = '" + email + "' AND senha = '" + senha + "'"
            );
            if (rs.next())
                return rs.getInt("id");
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
