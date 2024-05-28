package run_main;

import sql_actions.*;
import ui_swing.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends Component {

    private static int id;
    private static boolean isAdin;
    private String user;
    private final JFrame frame;
    private static JPanel cards;
    private static CardLayout cardLayout;

    private final Tela_de_inicio telaInicio;
    private Tela_login telaLogin;
    private Tela_cadastro_usuario telaCadastro;
    private Tela_principal telaPrincipal;
    private Tela_cadastro_filme telaCadFilme;
    private Tela_cad_sessoes telaCadSessoes;
    private Tela_filme_escolhido telaFilmeEscolhido;
    private Tela_selecao_lugar telaSelecaoLugar;
    private Tela_nakabank telaNakabank;
    private Tela_apagar_filmes telaApagarFilmes;
    private Tela_atualiza_usuario telaAtualizaUsuario;
    private Tela_principal_adm telaPrincipalAdm;

    public static void setIsAdin(boolean isAdin) {
        Main.isAdin = isAdin;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Main.id = id;
    }

    public static CardLayout getCardLayout() {
        return cardLayout;
    }

    public static JPanel getCards() {
        return cards;
    }

    public Main() {
        frame = new JFrame("NakaFilms");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1366, 768);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);

        // Inicialização das telas
        telaInicio = new Tela_de_inicio();
        telaLogin = new Tela_login(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == Tela_login.getEntrarButton()) {
                    if (Tela_login.getUserText().getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Campo usuário obrigatório!");
                        Tela_login.getUserText().requestFocus();
                    } else if (Tela_login.getSenhaText().getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Campo senha obrigatório!");
                        Tela_login.getSenhaText().requestFocus();
                    } else {
                        try {
                            Read.getUserId(Tela_login.getUserText().getText(), Tela_login.getSenhaText().getText());
                            int id = Main.getId(); // Recupera o ID do usuário
                            if (id != -1) {
                                String user = Read.getNome(id);
                                assert user != null;
                                JOptionPane.showMessageDialog(null, "Bem-vindo " + user + "!");
                                if (isAdin) {
                                    clearFields();
                                    cardLayout.show(cards, "adm");
                                } else {
                                    Read.getFilmeCartaz();
                                    clearFields();
                                    cardLayout.show(cards, "menu_principal");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Usuário não encontrado!");
                                clearFields();
                                Tela_login.getUserText().requestFocus();
                            }
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "Erro ao efetuar login: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                            clearFields();
                        }
                    }
                }
            }
        });
        telaCadastro = new Tela_cadastro_usuario();
        telaPrincipal = new Tela_principal();
        telaCadFilme = new Tela_cadastro_filme();
        telaCadSessoes = new Tela_cad_sessoes();
        telaFilmeEscolhido = new Tela_filme_escolhido();
        telaSelecaoLugar = new Tela_selecao_lugar();
        telaNakabank = new Tela_nakabank();
        telaApagarFilmes = new Tela_apagar_filmes();
        telaAtualizaUsuario = new Tela_atualiza_usuario();
        telaPrincipalAdm = new Tela_principal_adm();

        // Adicionando as telas ao CardLayout
        cards.add(telaInicio, "inicio");
        cards.add(telaLogin, "login");
        cards.add(telaCadastro, "cadastro");
        cards.add(telaPrincipal, "menu_principal");
        cards.add(telaCadFilme, "cad_filme");
        cards.add(telaCadSessoes, "cad_sessao");
        cards.add(telaFilmeEscolhido, "filme_escolhido");
        cards.add(telaSelecaoLugar, "selecao_lugar");
        cards.add(telaNakabank, "nakabank");
        cards.add(telaApagarFilmes, "pagamento");
        cards.add(telaAtualizaUsuario, "atualiza_user");
        cards.add(telaPrincipalAdm, "adm");
        frame.add(cards);
        frame.setVisible(true);
    }

    private static void clearFields(){
        Tela_login.getUserText().setText(null);
        Tela_login.getSenhaText().setText(null);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}
