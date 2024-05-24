package run_main;

import Entities.*;
import sql_actions.*;
import ui_swing.*;
import validations.Verifica_docs;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;

public class Main extends Component {

    private int id;
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

    public String getUser() {
        return user;
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
        telaInicio = new Tela_de_inicio(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == telaInicio.getLoginButton()) {
                    cardLayout.show(cards, "login");
                } else if (e.getSource() == telaInicio.getCadastroButton()) {
                    cardLayout.show(cards, "cadastro");
                }
            }
        });
        telaLogin = new Tela_login(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == Tela_login.getEntrarButton()) {
                    if(Tela_login.getUserText().getText().isEmpty()){
                        JOptionPane.showMessageDialog(null, "Campo usuário obrigatório!");
                        Tela_login.getUserText().requestFocus();
                    } else if (Tela_login.getSenhaText().getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Campo senha obrigatório!");
                        Tela_login.getSenhaText().requestFocus();
                    } else {
                        try {
                            id = Id_casoLogin.getUserId(Tela_login.getUserText().getText(), Tela_login.getSenhaText().getText());
                            if (id != -1) {
                                user = Busca_usuario.getNome(id);
                                assert user != null;
//                                Tela_principal.getNomeUser().setText("Olá " + user.split(" ")[0]);
                                JOptionPane.showMessageDialog(null, "Bem-vindo " + user + "!");
                                Busca_filme.getFilmeCartaz();
                                cardLayout.show(cards, "menu_principal");
                            } else {
                                JOptionPane.showMessageDialog(null, "Usuário não encontrado!");
                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                } else if (e.getSource() == Tela_login.getVoltarButton()) {
                    cardLayout.show(cards, "inicio");
                }
            }
        });
        telaCadastro = new Tela_cadastro_usuario(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == Tela_cadastro_usuario.getCadastrarButton()) {
                    String cpfSemPontuacao = Tela_cadastro_usuario.getCpfText().getText().replaceAll("\\D", "");
                    String rgSemPontuacao = Tela_cadastro_usuario.getRgText().getText().replaceAll("\\D", "");
                    if(Tela_cadastro_usuario.getCpfText().getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Campo CPF obrigatório!");
                        Tela_cadastro_usuario.getCpfText().requestFocus();
                    } else if (!Verifica_docs.validarCPF(cpfSemPontuacao)) {
                        JOptionPane.showMessageDialog(null, "CPF inválido!");
                        Tela_cadastro_usuario.getCpfText().setText("");
                        Tela_cadastro_usuario.getCpfText().requestFocus();
                    } else if (Tela_cadastro_usuario.getRgText().getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Campo RG obrigatório!");
                        Tela_cadastro_usuario.getRgText().requestFocus();
                    } else if (!Verifica_docs.validarRG(rgSemPontuacao)) {
                        JOptionPane.showMessageDialog(null, "RG inválido!");
                        Tela_cadastro_usuario.getRgText().setText("");
                        Tela_cadastro_usuario.getRgText().requestFocus();
                    }

                    Usuario u = new Usuario(Tela_cadastro_usuario.getNomeText().getText(), cpfSemPontuacao, rgSemPontuacao, Tela_cadastro_usuario.getTelefoneText().getText(), Tela_cadastro_usuario.getEmailText().getText(), Tela_cadastro_usuario.getSenhaText().getText());
                    u.setData_de_nascimento(u.transformaDataSQL(Tela_cadastro_usuario.getDataText().getText()));
                    try {
                        Cad_usuario.Cad_user(u);
                        cardLayout.show(cards, "login");
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (e.getSource() == Tela_cadastro_usuario.getVoltarButton()) {
                    cardLayout.show(cards, "inicio");
                }
            }
        });
        telaPrincipal = new Tela_principal();
        telaCadFilme = new Tela_cadastro_filme();
        telaCadSessoes = new Tela_cad_sessoes();
        telaFilmeEscolhido = new Tela_filme_escolhido();
        telaSelecaoLugar = new Tela_selecao_lugar();

        // Adicionando as telas ao CardLayout
        cards.add(telaInicio, "inicio");
        cards.add(telaLogin, "login");
        cards.add(telaCadastro, "cadastro");
        cards.add(telaPrincipal, "menu_principal");
        cards.add(telaCadFilme, "cad_filme");
        cards.add(telaCadSessoes, "cad_sessao");
        cards.add(telaFilmeEscolhido, "filme_escolhido");
        cards.add(telaSelecaoLugar, "selecao_lugar");
        frame.add(cards);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}
