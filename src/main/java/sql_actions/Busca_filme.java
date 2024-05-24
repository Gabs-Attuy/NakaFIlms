package sql_actions;

import Entities.SessaoItem;
import ui_swing.Metodos_swing;
import ui_swing.Tela_cadastro_filme;
import ui_swing.Tela_filme_escolhido;

import java.sql.*;

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

//    public static void getFilme(int id) throws Exception{
//        try {
//            SqlConnection conection = new SqlConnection();
//            Connection cn = conection.openDB();
//            Statement st = cn.createStatement();
//            ResultSet rs = st.executeQuery(
//                    "SELECT * FROM filme WHERE id = '" + id + "'"
//            );
//            if(rs != null) {
//                while(rs.next()) {
////                    int id_filme = rs.getInt(1);
////                    String nome = rs.getString(2);
//                    String duracao = rs.getString(3);
//                    String elenco = rs.getString(4);
//                    String diretor = rs.getString(5);
//                    String genero = rs.getString(6);
//                    String distribuidora = rs.getString(7);
//                    String classificacao = rs.getString(8);
//                    Blob foto = (Blob) rs.getBlob(9);
//                    String sinopse = rs.getString(10);
//                    Tela_filme_escolhido.getSinopse().setText(sinopse);
//                    Tela_filme_escolhido.getNomeDiretor().setText(diretor);
//                    Tela_filme_escolhido.getNomeClassificacao().setText(classificacao);
//                    Tela_filme_escolhido.getNomeDistribuicao().setText(distribuidora);
//                    Tela_filme_escolhido.getNomeGenero().setText(genero);
//                    Tela_filme_escolhido.getNomeElenco().setText(elenco);
//                    Tela_filme_escolhido.getTempoDuracao().setText(duracao);
//                    Tela_filme_escolhido.getLblCartaz().setIcon(Metodos_swing.recuperaFoto(foto));
//                }
//            }
//
//            if (id != -1) {
//                PreparedStatement psComboBox = cn.prepareStatement("SELECT * FROM sessao WHERE FK_filme_id = ?");
//                psComboBox.setInt(1, id);
//                ResultSet rsComboBox = psComboBox.executeQuery();
//                if (rsComboBox != null) {
//                    while(rsComboBox.next()) {
//                        int idSessao = rs.getInt(1);
//                        String idioma = rsComboBox.getString(2);
//                        Date data = rsComboBox.getDate(3);
//                        Time horario = rsComboBox.getTime(4);
//                        int sala = rsComboBox.getInt(5);
//
//                        String informacoes = idioma + ", " + data + ", " + horario + ", sala " + sala;
//                        SessaoItem item = new SessaoItem(idSessao, informacoes);
//                        Tela_filme_escolhido.getComboSecoes().addItem(item);
//                    }
//                }
//                psComboBox.close();
//            }
//        } catch (SQLException e) {
//            throw new Exception("Falha ao acessar base de dados.\n" + e.getMessage());
//        }
//    }


    public static void getFilme(int id) throws Exception {
        SqlConnection conection = new SqlConnection();
        Connection cn = conection.openDB();
        Statement st = null;
        ResultSet rs = null;
        PreparedStatement psComboBox = null;
        ResultSet rsComboBox = null;

        try {
            st = cn.createStatement();
            rs = st.executeQuery(
                    "SELECT * FROM filme WHERE id = " + id
            );

            if (rs.next()) { // Usando if para checar a existência do resultado
                String duracao = rs.getString(3);
                String elenco = rs.getString(4);
                String diretor = rs.getString(5);
                String genero = rs.getString(6);
                String distribuidora = rs.getString(7);
                String classificacao = rs.getString(8);
                Blob foto = rs.getBlob(9);
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
                    Date data = rsComboBox.getDate(3);
                    Time horario = rsComboBox.getTime(4);
                    int sala = rsComboBox.getInt(5);

                    String informacoes = idioma + ", " + data + ", " + horario + ", sala " + sala;
                    SessaoItem item = new SessaoItem(idSessao, informacoes);
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
}
