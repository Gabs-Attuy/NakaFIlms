package sql_actions;
import Entities.Usuario;
import com.sun.tools.javac.Main;

import javax.swing.*;
import java.sql.*;

public class Cad_usuario {
    public static void Cad_user (Usuario u) throws Exception {
        try {
            SqlConnection conection = new SqlConnection();
            Connection cn = conection.openDB();
            PreparedStatement ps = cn.prepareStatement("INSERT INTO usuario (cpf, rg, data_nascimento, nome, telefone, e_mail, senha) VALUES (?, ?, ?, ?, ?, ?, ?)");

            ps.setString(1, u.getCpf());
            ps.setString(2, u.getRg());
            ps.setDate(3, u.getData_de_nascimento());
            ps.setString(4, u.getNome());
            ps.setString(5, u.getTelefone());
            ps.setString(6, u.getEmail());
            ps.setString(7, u.getSenha());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuario cadastrado!");
            ps.close();
            cn.close();
        } catch (SQLException e) {
            throw new Exception("Falha ao acessar base de dados.\n" + e.getMessage());
        }
    }
}