package sql_actions;

import Entities.*;
import run_main.Main;
import ui_swing.Metodos_swing;

import javax.swing.*;
import java.sql.*;

public class Create {
    private static int id_filme = 23;

    public static int getId_filme() {
        return id_filme;
    }

    public static void setId_filme(int id_filme) {
        Create.id_filme = id_filme;
    }

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
                setId_filme(id_filme);
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

    public static void Cad_sessao(Sessao s, double valor) throws Exception {
        int id_sessao = -1;
        try {
            SqlConnection conection = new SqlConnection();
            Connection cn = conection.openDB();
            PreparedStatement ps = cn.prepareStatement("INSERT INTO sessao (idioma, data_sessao, horario, FK_filme_id, sala) VALUES (?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setString(1, s.getIdioma());
            ps.setDate(2, s.getData_Sessao());
            ps.setTime(3, s.getHorario());
            ps.setInt(4, getId_filme());
            ps.setInt(5, s.getSala());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                id_sessao = rs.getInt(1);
            }

            JOptionPane.showMessageDialog(null, "Sessão cadastrada!");
            ps.close();
            cn.close();
        } catch (SQLException e) {
            throw new Exception("Falha ao acessar base de dados.\n" + e.getMessage());
        }
        cad_assento(id_sessao, valor);
    }

    private static void cad_assento(int id_sessao, double valor) throws Exception {
        char[] fileiras = {'a', 'b', 'c', 'd', 'e'};
        int assentos_fileira = 5;
        int total_assentos = 1;
        boolean statusPadrao = false;

        try {
            SqlConnection conection = new SqlConnection();
            Connection cn = conection.openDB();
            PreparedStatement ps = cn.prepareStatement("INSERT INTO assento (n_assento, fileira, status_assento, valor, FK_sessao_id) VALUES (?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);

            for (char fileira : fileiras) {
                for (int i = 1; i <= assentos_fileira; i++) {
                    Assento assento = new Assento(total_assentos++, fileira, statusPadrao, valor);

                    ps.setInt(1, assento.getN_assento());
                    ps.setString(2, String.valueOf(assento.getFileira()));
                    ps.setBoolean(3, assento.isStatus_assento());
                    ps.setDouble(4, assento.getValor());
                    ps.setInt(5, id_sessao);
                    ps.executeUpdate();
                }
            }

            JOptionPane.showMessageDialog(null, "Assentos cadastrados!");
            ps.close();
            cn.close();
        } catch (SQLException e) {
            throw new Exception("Falha ao acessar base de dados.\n" + e.getMessage());
        }
    }

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
