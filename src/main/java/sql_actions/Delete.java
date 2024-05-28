package sql_actions;

import run_main.Main;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {
    public static void sessao(int id_sessao) throws Exception {
        try {
            SqlConnection conection = new SqlConnection();
            Connection cn = conection.openDB();
            // Excluir assentos associados
            String deleteAssentosSQL = "DELETE FROM assento WHERE FK_sessao_id = ?";
            PreparedStatement deleteAssentosStmt = cn.prepareStatement(deleteAssentosSQL);
            deleteAssentosStmt.setInt(1, id_sessao);
            deleteAssentosStmt.executeUpdate();

            // Excluir sessão
            String deleteSessaoSQL = "DELETE FROM sessao WHERE id = ?";
            PreparedStatement deleteSessaoStmt = cn.prepareStatement(deleteSessaoSQL);
            deleteSessaoStmt.setInt(1, id_sessao);
            deleteSessaoStmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Sessão e assentos excluídos com sucesso!");
            deleteAssentosStmt.close();
            deleteSessaoStmt.close();
            cn.close();
        } catch (SQLException e) {
            throw new Exception("Falha ao acessar base de dados.\n" + e.getMessage());
        }
    }

    public static void pedido(int id_pedido) throws Exception {
        try {
            SqlConnection conection = new SqlConnection();
            Connection cn = conection.openDB();
            PreparedStatement ps = cn.prepareStatement("DELETE FROM pedido_novo WHERE id = ?");
            ps.setInt(1, id_pedido);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Pedido cancelado!");
            ps.close();
            cn.close();
        } catch (SQLException e) {
            throw new Exception("Falha ao acessar base de dados.\n" + e.getMessage());
        }
    }

    public static void usuario() throws Exception {
        try {
            SqlConnection conection = new SqlConnection();
            Connection cn = conection.openDB();
            PreparedStatement ps = cn.prepareStatement("DELETE FROM usuario WHERE id = ?");
            ps.setInt(1, Main.getId());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuário excluído com sucesso!");
            Main.setId(-1);
            Main.getCardLayout().show(Main.getCards(), "inicio");
            ps.close();
            cn.close();
        } catch (SQLException e) {
            throw new Exception("Falha ao acessar base de dados.\n" + e.getMessage());
        }
    }

    public static void filme(int id) throws Exception {
        try {
            SqlConnection conection = new SqlConnection();
            Connection cn = conection.openDB();
            PreparedStatement ps = cn.prepareStatement("DELETE FROM filme WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Filme excluído com sucesso!");
            ps.close();
            cn.close();
        } catch (SQLException e) {
            throw new Exception("Falha ao acessar base de dados.\n" + e.getMessage());
        }
    }
}
