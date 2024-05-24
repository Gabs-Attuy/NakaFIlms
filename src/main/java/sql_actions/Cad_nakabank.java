package sql_actions;

import Entities.Nakabank;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Cad_nakabank {
    public static int Cad_conta_nakabank (Nakabank n) throws Exception {
        int nakabankId = -1; // valor padrão caso a inserção falhe
        try {
            SqlConnection conection = new SqlConnection();
            Connection cn = conection.openDB();
            PreparedStatement ps = cn.prepareStatement("INSERT INTO nakabank (n_conta, codigo_seguranca, saldo) VALUES (?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setInt(1, n.getN_conta());
            ps.setInt(2, n.getCodigo_seguranca());
            ps.setDouble(3, n.getSaldo());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                nakabankId = rs.getInt(1); // Obtém o ID gerado para o Nakabank inserido
            }

            System.out.println("Conta Nakabank cadastrada!");
            ps.close();
            cn.close();
        } catch (SQLException e) {
            throw new Exception("Falha ao acessar base de dados.\n" + e.getMessage());
        }
        return nakabankId; // Retorna o ID do Nakabank inserido
    }
}
