package sql_actions;

import Entities.SessaoItem;
import run_main.Main;
import ui_swing.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.*;
import java.util.Date;
import java.util.HashMap;

public class Read {
    public static void Busca_assento(int sessao_id){
        HashMap<JCheckBox, Integer> assentoMap = Tela_selecao_lugar.getAssentoMap();

        try {
            SqlConnection conection = new SqlConnection();
            Connection cn = conection.openDB();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(
                    "SELECT * FROM assento WHERE FK_sessao_id = '" + sessao_id + "'"
            );
            if(rs != null) {
                Tela_selecao_lugar.getPainelCheckBox().removeAll();
                while(rs.next()) {
                    int id = rs.getInt("id");
                    double valor_assento = rs.getDouble(5);
                    boolean ocupado = rs.getBoolean(4);
                    // Criar JCheckBox para o assento
                    JCheckBox checkBox = new JCheckBox();

                    if(ocupado) {
                        checkBox.setSelected(true);
                        checkBox.setEnabled(false);
                    }

                    checkBox.addItemListener(new ItemListener() {
                        @Override
                        public void itemStateChanged(ItemEvent e) {
                            if (e.getStateChange() == ItemEvent.SELECTED) {
                                Tela_selecao_lugar.incrementarQtdd();
                                Tela_selecao_lugar.incrementarValorPedido(valor_assento);
                            } else {
                                Tela_selecao_lugar.decrementarQtdd();
                                Tela_selecao_lugar.decrementarValorPedido(valor_assento);
                            }
                        }
                    });
                    // Adicionar JCheckBox ao painel
                    Tela_selecao_lugar.getPainelCheckBox().add(checkBox);

                    // Mapear JCheckBox para o ID do assento
                    assentoMap.put(checkBox, id);
                }
            }
            // Percorrer os resultados da consulta e criar JCheckBox para cada assento
            // Fechar recursos
            assert rs != null;
            rs.close();
            st.close();
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Main.getCardLayout().show(Main.getCards(), "selecao_lugar");
    }

    public static String getNome(int id) throws Exception {
        try {
            SqlConnection conection = new SqlConnection();
            Connection cn = conection.openDB();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(
                    "SELECT nome FROM usuario WHERE id = '" + id + "'"
            );
            if(rs.next()) {
                return rs.getString("nome");
            }
        } catch (SQLException e) {
            throw new Exception("Falha ao acessar base de dados.\n" + e.getMessage());
        }
        return null;
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

    public static void getFilme(int id) throws Exception {
        SqlConnection conection = new SqlConnection();
        Connection cn = conection.openDB();
        Statement st = null;
        ResultSet rs = null;
        PreparedStatement psComboBox = null;
        ResultSet rsComboBox = null;
        Blob foto = null;
        String nome_filme = null;
        try {
            st = cn.createStatement();
            rs = st.executeQuery(
                    "SELECT * FROM filme WHERE id = " + id
            );

            if (rs.next()) { // Usando if para checar a existência do resultado
                nome_filme = rs.getString(2);
                String duracao = rs.getString(3);
                String elenco = rs.getString(4);
                String diretor = rs.getString(5);
                String genero = rs.getString(6);
                String distribuidora = rs.getString(7);
                String classificacao = rs.getString(8);
                foto = rs.getBlob(9);
                String sinopse = rs.getString(10);

                Tela_filme_escolhido.getSinopse().setText(sinopse);
                Tela_filme_escolhido.getNomeDiretor().setText(diretor);
                Tela_filme_escolhido.getNomeClassificacao().setText(classificacao);
                Tela_filme_escolhido.getNomeDistribuicao().setText(distribuidora);
                Tela_filme_escolhido.getNomeGenero().setText(genero);
                Tela_filme_escolhido.getNomeElenco().setText(elenco);
                Tela_filme_escolhido.getTempoDuracao().setText(duracao);
                Tela_filme_escolhido.getLblCartaz().setIcon(Metodos_swing.recuperaFoto(foto));
            }

            if (id != -1) {
                psComboBox = cn.prepareStatement("SELECT * FROM sessao WHERE FK_filme_id = ?");
                psComboBox.setInt(1, id);
                rsComboBox = psComboBox.executeQuery();

                Tela_filme_escolhido.getComboSecoes().removeAllItems();

                while (rsComboBox.next()) {
                    int idSessao = rsComboBox.getInt(1); // Supondo que a primeira coluna seja o ID da sessão
                    String idioma = rsComboBox.getString(2);
                    java.sql.Date data = rsComboBox.getDate(3);
                    Time horario = rsComboBox.getTime(4);
                    int sala = rsComboBox.getInt(5);

                    String informacoes = idioma + ", " + data + ", " + horario + ", sala " + sala;
                    SessaoItem item = new SessaoItem(idSessao, informacoes, foto, nome_filme);
                    Tela_filme_escolhido.getComboSecoes().addItem(item);
                }
            }
        } catch (SQLException e) {
            throw new Exception("Falha ao acessar base de dados.\n" + e.getMessage());
        } finally {
            // Fechando recursos para evitar vazamentos
            if (rs != null) try { rs.close(); } catch (SQLException ignore) {}
            if (st != null) try { st.close(); } catch (SQLException ignore) {}
            if (rsComboBox != null) try { rsComboBox.close(); } catch (SQLException ignore) {}
            if (psComboBox != null) try { psComboBox.close(); } catch (SQLException ignore) {}
            if (cn != null) try { cn.close(); } catch (SQLException ignore) {}
        }
    }

    public static void getFilmeCartaz() throws Exception{
        try {
            SqlConnection conection = new SqlConnection();
            Connection cn = conection.openDB();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(
                    "SELECT * FROM filme"
            );
            if(rs != null) {
                while (rs.next()) {
                    int id = rs.getInt(1);
                    Blob foto = (Blob) rs.getBlob(9);
                    Metodos_swing.cartaz(id, foto);
                }
            }
        } catch (SQLException e) {
            throw new Exception("Falha ao acessar base de dados.\n" + e.getMessage());
        }
    }

    public static void getUserId(String email, String senha) throws Exception {
        String sql = "SELECT * FROM usuario WHERE e_mail = ? AND senha = ?";
        try {
            SqlConnection connection = new SqlConnection();
            Connection cn = connection.openDB();
            PreparedStatement pstmt = cn.prepareStatement(sql);
            pstmt.setString(1, email);
            pstmt.setString(2, senha);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                boolean isAdin = rs.getBoolean("isAdmin"); // Nome da coluna correto
                Main.setId(id);
                Main.setIsAdin(isAdin);
            } else {
                Main.setId(-1); // Usuário não encontrado
            }

            rs.close();
            pstmt.close();
            cn.close();
        } catch (SQLException e) {
            throw new Exception("Erro ao acessar o banco de dados: " + e.getMessage());
        }
    }

    public static int getNakabank(int id) throws Exception {
        try {
            SqlConnection conection = new SqlConnection();
            Connection cn = conection.openDB();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(
                    "SELECT FK_nakabank_id FROM usuario WHERE id = " + id
            );
            if (rs.next()) {
                int fk_nakabank_id = rs.getInt("FK_nakabank_id");
                if (rs.wasNull()) {
                    return -1; // FK_nakabank_id é nulo
                } else {
                    return fk_nakabank_id;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Erro ao acessar o banco de dados.");
        }
        return -1;
    }

    public static void getNakabankInforms(int id_naka) throws Exception {
        try {
            SqlConnection conection = new SqlConnection();
            Connection cn = conection.openDB();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(
                    "SELECT * FROM nakabank WHERE id = '" + id_naka + "'"
            );
            if (rs.next()){
                int n_conta = rs.getInt(2);
                double saldo = rs.getDouble(4);
                Tela_nakabank.getNumerodaContaAQUI().setText(String.valueOf(n_conta));
                Tela_nakabank.getValorSaldo().setText(String.valueOf(saldo));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        Main.getCardLayout().show(Main.getCards(), "nakabank");
    }

    public static double getSaldo(int id_naka) throws Exception {
        double saldo = -1;
        try {
            SqlConnection conection = new SqlConnection();
            Connection cn = conection.openDB();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(
                    "SELECT * FROM nakabank WHERE id = '" + id_naka + "'"
            );
            if (rs.next()){
                saldo = rs.getDouble(4);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return saldo;
    }
    public static int getSenhaNakabank(int id_naka) {
        int senha = -1;
        try {
            SqlConnection conection = new SqlConnection();
            Connection cn = conection.openDB();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(
                    "SELECT * FROM nakabank WHERE id = '" + id_naka + "'"
            );
            if (rs.next()){
                return senha = rs.getInt(3);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return senha;
    }

    public static void getMeusPedidos() {
        DefaultTableModel tableModel = new DefaultTableModel();
        JTable table = new JTable(tableModel);
        try {
            SqlConnection conection = new SqlConnection();
            Connection cn = conection.openDB();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(
                    "SELECT * FROM pedido_novo WHERE FK_usuario_id = '" + Main.getId() + "'"
            );

            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Adicionando colunas ao modelo de tabela
            for (int column = 1; column <= columnCount; column++) {
                tableModel.addColumn(metaData.getColumnName(column));
            }
            while (rs.next()) {
                Object[] row = new Object[columnCount];
                for (int column = 1; column <= columnCount; column++) {
                    row[column - 1] = rs.getObject(column);
                }
                tableModel.addRow(row);
            }

            rs.close();
            st.close();
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Tela_apagar_filmes.getjPanel1().removeAll();
        JScrollPane scrollPane = new JScrollPane(table);
        Tela_apagar_filmes.getjPanel1().add(scrollPane, BorderLayout.CENTER);

        // Atualizar o painel
        Tela_apagar_filmes.getjPanel1().revalidate();
        Tela_apagar_filmes.getjPanel1().repaint();
    }

    public static void getUser() {
        try {
            SqlConnection conection = new SqlConnection();
            Connection cn = conection.openDB();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(
                    "SELECT * FROM usuario WHERE id = '" + Main.getId() + "'"
            );

            if(rs.next()) {
                String nome = rs.getString(5);
                String telefone = rs.getString(6);
                String email = rs.getString(7);
                String senha = rs.getString(8);
                String cpf = rs.getString(2);
                String rg = rs.getString(3);
                Date datanasc = rs.getDate(4);

                Tela_atualiza_usuario.getNomeAqui().setText(nome);
                Tela_atualiza_usuario.getCPFaqui().setText(cpf);
                Tela_atualiza_usuario.getNumeroTelefone1().setText(telefone);
                Tela_atualiza_usuario.getSenha().setText(senha);
                Tela_atualiza_usuario.getRGaqui().setText(rg);
                Tela_atualiza_usuario.getDataNascimentoaqui().setText(String.valueOf(datanasc));
                Tela_atualiza_usuario.getEmailAqui().setText(email);
            }

            rs.close();
            st.close();
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static double obterValorAssento(int assentoId, Connection cn) throws SQLException {
        PreparedStatement ps = cn.prepareStatement("SELECT valor FROM assento WHERE id = ?");
        ps.setInt(1, assentoId);
        ResultSet rs = ps.executeQuery();
        double valor = 0;
        if (rs.next()) {
            valor = rs.getDouble("valor");
        }
        rs.close();
        ps.close();
        return valor;
    }

    public static void getPedidos() {
        DefaultTableModel tableModel = new DefaultTableModel();
        JTable table = new JTable(tableModel);
        try {
            SqlConnection conection = new SqlConnection();
            Connection cn = conection.openDB();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM pedido_novo");

            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Adicionando colunas ao modelo de tabela
            for (int column = 1; column <= columnCount; column++) {
                tableModel.addColumn(metaData.getColumnName(column));
            }

            // Adicionando linhas ao modelo de tabela
            while (rs.next()) {
                Object[] row = new Object[columnCount];
                for (int column = 1; column <= columnCount; column++) {
                    row[column - 1] = rs.getObject(column);
                }
                tableModel.addRow(row);
            }

            rs.close();
            st.close();
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // Limpar painel antes de adicionar nova tabela
        Tela_principal_adm.getPaineldasListas().removeAll();

        // Adicionar tabela ao painel com JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);
        Tela_principal_adm.getPaineldasListas().add(scrollPane, BorderLayout.CENTER);

        // Atualizar o painel para exibir mudanças
        Tela_principal_adm.getPaineldasListas().revalidate();
        Tela_principal_adm.getPaineldasListas().repaint();
    }

    public static void getFilmes() {
        DefaultTableModel tableModel = new DefaultTableModel();
        JTable table = new JTable(tableModel);
        try {
            SqlConnection conection = new SqlConnection();
            Connection cn = conection.openDB();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM filme");

            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Adicionando colunas ao modelo de tabela
            for (int column = 1; column <= columnCount; column++) {
                tableModel.addColumn(metaData.getColumnName(column));
            }

            // Adicionando linhas ao modelo de tabela
            while (rs.next()) {
                Object[] row = new Object[columnCount];
                for (int column = 1; column <= columnCount; column++) {
                    row[column - 1] = rs.getObject(column);
                }
                tableModel.addRow(row);
            }

            rs.close();
            st.close();
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // Limpar painel antes de adicionar nova tabela
        Tela_principal_adm.getPaineldasListas().removeAll();

        // Adicionar tabela ao painel com JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);
        Tela_principal_adm.getPaineldasListas().add(scrollPane, BorderLayout.CENTER);

        // Atualizar o painel para exibir mudanças
        Tela_principal_adm.getPaineldasListas().revalidate();
        Tela_principal_adm.getPaineldasListas().repaint();
    }

    public static void getSessao() {
        DefaultTableModel tableModel = new DefaultTableModel();
        JTable table = new JTable(tableModel);
        try {
            SqlConnection conection = new SqlConnection();
            Connection cn = conection.openDB();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM sessao");

            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Adicionando colunas ao modelo de tabela
            for (int column = 1; column <= columnCount; column++) {
                tableModel.addColumn(metaData.getColumnName(column));
            }

            // Adicionando linhas ao modelo de tabela
            while (rs.next()) {
                Object[] row = new Object[columnCount];
                for (int column = 1; column <= columnCount; column++) {
                    row[column - 1] = rs.getObject(column);
                }
                tableModel.addRow(row);
            }

            rs.close();
            st.close();
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // Limpar painel antes de adicionar nova tabela
        Tela_principal_adm.getPaineldasListas().removeAll();

        // Adicionar tabela ao painel com JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);
        Tela_principal_adm.getPaineldasListas().add(scrollPane, BorderLayout.CENTER);

        // Atualizar o painel para exibir mudanças
        Tela_principal_adm.getPaineldasListas().revalidate();
        Tela_principal_adm.getPaineldasListas().repaint();
    }

    public static void getUsuario() {
        DefaultTableModel tableModel = new DefaultTableModel();
        JTable table = new JTable(tableModel);
        try {
            SqlConnection conection = new SqlConnection();
            Connection cn = conection.openDB();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM usuario");

            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Adicionando colunas ao modelo de tabela
            for (int column = 1; column <= columnCount; column++) {
                tableModel.addColumn(metaData.getColumnName(column));
            }

            // Adicionando linhas ao modelo de tabela
            while (rs.next()) {
                Object[] row = new Object[columnCount];
                for (int column = 1; column <= columnCount; column++) {
                    row[column - 1] = rs.getObject(column);
                }
                tableModel.addRow(row);
            }

            rs.close();
            st.close();
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // Limpar painel antes de adicionar nova tabela
        Tela_principal_adm.getPaineldasListas().removeAll();

        // Adicionar tabela ao painel com JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);
        Tela_principal_adm.getPaineldasListas().add(scrollPane, BorderLayout.CENTER);

        // Atualizar o painel para exibir mudanças
        Tela_principal_adm.getPaineldasListas().revalidate();
        Tela_principal_adm.getPaineldasListas().repaint();
    }
}
