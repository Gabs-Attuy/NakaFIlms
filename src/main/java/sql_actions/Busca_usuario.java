package sql_actions;

import Entities.Usuario;
import ui_swing.Tela_login;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.sql.*;

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
}
