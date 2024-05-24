package sql_actions;

import Entities.Filme;
import run_main.Main;
import ui_swing.Metodos_swing;

import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.*;

public class Cad_filme extends Component {

    public static void Cad_filmes (Filme f) throws Exception {
        int id_filme = -1;
        Blob foto = null;
        try {
            SqlConnection conection = new SqlConnection();
            Connection cn = conection.openDB();
            PreparedStatement ps = cn.prepareStatement("INSERT INTO filme (nome, duracao, elenco, diretor, genero, distribuidora, classificacao, sinopse, foto) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setString(1, f.getNome());
            ps.setString(2, f.getDuracao());
            ps.setString(3, f.getElenco());
            ps.setString(4, f.getDiretor());
            ps.setString(5, f.getGenero());
            ps.setString(6, f.getDistribuidora());
            ps.setString(7, f.getClassificacao());
            ps.setString(8, f.getSinopse());
            ps.setBlob(9, f.getFis(), f.getTamanho());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                id_filme = rs.getInt(1);
                Cad_sessoes.setId_filme(id_filme);
            }

            if (id_filme != -1) {
                PreparedStatement psFoto = cn.prepareStatement("SELECT foto FROM filme WHERE id = ?");
                psFoto.setInt(1, id_filme);
                ResultSet rsFoto = psFoto.executeQuery();
                if (rsFoto.next()) {
                    foto = rsFoto.getBlob("foto");
                    Metodos_swing.cartaz(id_filme, foto);
                }
                psFoto.close();
            }

            System.out.println("Filme cadastrado!");
            ps.close();
            cn.close();
        } catch (SQLException e) {
            throw new Exception("Falha ao acessar base de dados.\n" + e.getMessage());
        }
        Main.getCardLayout().show(Main.getCards(), "cad_sessao");
    }
}