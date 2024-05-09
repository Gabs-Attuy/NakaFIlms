package sql_actions;

import Entities.Filme;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Cad_filme {
    public static void Cad_filme (Filme f) throws Exception {
        try {
            SqlConnection conection = new SqlConnection();
            Connection cn = conection.openDB();
            PreparedStatement ps = cn.prepareStatement("INSERT INTO filme (nome, duracao, elenco, diretor, genero, distribuidora, classificacao) VALUES (?, ?, ?, ?, ?, ?, ?)");

            ps.setString(1, f.getNome());
            ps.setString(2, f.getDuracao());
            ps.setString(3, f.getElenco());
            ps.setString(4, f.getDiretor());
            ps.setString(5, f.getGenero());
            ps.setString(6, f.getDistribuidora());
            ps.setString(7, f.getClassificacao());
            ps.executeUpdate();
            System.out.println("Filme cadastrado!");
            ps.close();
            cn.close();
        } catch (SQLException e) {
            throw new Exception("Falha ao acessar base de dados.\n" + e.getMessage());
        }
    }
}
