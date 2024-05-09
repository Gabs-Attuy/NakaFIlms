import Entities.Usuario;
import sql_actions.Cad_usuario;
import ui_swing.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {
    private JFrame frame;
    private JPanel cards;
    private static CardLayout cardLayout;

    private Tela_de_inicio telaInicio;
    private Tela_login telaLogin;
    private Tela_cadastro_usuario telaCadastro;

    public static CardLayout getCardLayout() {
        return cardLayout;
    }

    public Main() {
        frame = new JFrame("NakaFilms");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension tela = Metodos_swing.getScreensize();
        frame.setSize(tela.width, tela.height);
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

                    try {
                        Cad_usuario.Cad_user(u);
                        cardLayout.show(cards, "login");
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        telaCadastro = new Tela_cadastro_usuario(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == Tela_cadastro_usuario.getCadastrarButton()) {
                    String cpfSemPontuacao = Tela_cadastro_usuario.getCpfText().getText().replaceAll("\\D", "");
                    String rgSemPontuacao = Tela_cadastro_usuario.getRgText().getText().replaceAll("\\D", "");
                    Usuario u = new Usuario(Tela_cadastro_usuario.getNomeText().getText(), cpfSemPontuacao, rgSemPontuacao, Tela_cadastro_usuario.getTelefoneText().getText(), Tela_cadastro_usuario.getEmailText().getText(), Tela_cadastro_usuario.getSenhaText().getText());
                    u.setData_de_nascimento(u.transformaDataSQL(Tela_cadastro_usuario.getDataText().getText()));
                    try {
                        Cad_usuario.Cad_user(u);
                        cardLayout.show(cards, "login");
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        // Adicionando as telas ao CardLayout
        cards.add(telaInicio, "inicio");
        cards.add(telaLogin, "login");
        cards.add(telaCadastro, "cadastro");

        frame.add(cards);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}
