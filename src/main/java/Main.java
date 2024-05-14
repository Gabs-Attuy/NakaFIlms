import Entities.*;
import sql_actions.*;
import ui_swing.*;
import validations.Verifica_docs;
import validations.Verifica_idade;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;

public class Main extends Component {

    private int id;
    private final JFrame frame;
    private final JPanel cards;
    private static CardLayout cardLayout;

    private final Tela_de_inicio telaInicio;
    private Tela_login telaLogin;
    private Tela_cadastro_usuario telaCadastro;
    private Tela_principal telaPrincipal;
    private Tela_cadastro_filme telaCadFilme;

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
                                JOptionPane.showMessageDialog(null, "Bem-vindo!");
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
        telaPrincipal = new Tela_principal(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == Tela_principal.getHome()){
                    cardLayout.show(cards, "cad_filme");
                } else if (e.getSource() == Tela_principal.getNakabank()) {
                    try {
                        System.out.println(Verifica_idade.verifica(id));
                    } catch (Exception err) {
                        System.out.println(err);
                    }
                }
            }
        });
        telaCadFilme = new Tela_cadastro_filme(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == Tela_cadastro_filme.getProcuraFoto()) {
                    carregarFoto();
                } else if (e.getSource() == Tela_cadastro_filme.getCadastrarButton()) {
                    Filme f = new Filme(Tela_cadastro_filme.getNomeText().getText(),
                            Tela_cadastro_filme.getDuracaoText().getText(),
                            Tela_cadastro_filme.getElencoText().getText(),
                            Tela_cadastro_filme.getDiretorText().getText(),
                            Tela_cadastro_filme.getGeneroText().getText(),
                            Tela_cadastro_filme.getDistribuidoraText().getText(),
                            Tela_cadastro_filme.getClassificacaoText().getText(),
                            Tela_cadastro_filme.getSinopseText().getText(),
                            Tela_cadastro_filme.getFis(),
                            Tela_cadastro_filme.getTamanho());
                    try {
                        Cad_filme.Cad_filmes(f);
                        cardLayout.show(cards, "menu_principal");
                    } catch (Exception er){
                        er.printStackTrace();
                    }
                }
            }
        });
        // Adicionando as telas ao CardLayout
        cards.add(telaInicio, "inicio");
        cards.add(telaLogin, "login");
        cards.add(telaCadastro, "cadastro");
        cards.add(telaPrincipal, "menu_principal");
        cards.add(telaCadFilme, "cad_filme");
        frame.add(cards);
        frame.setVisible(true);
    }

    public void carregarFoto(){
        JFileChooser jfc = new JFileChooser();
        jfc.setDialogTitle("Selecionar Imagem do Cartaz");
        jfc.setFileFilter(new FileNameExtensionFilter("Arquivo de imagens (*.PNG, *.JPG, *.JPEG)", "png", "jpg", "jpeg"));
        int resultado = jfc.showSaveDialog(this);
        if(resultado == JFileChooser.APPROVE_OPTION){
            try{
                Tela_cadastro_filme.fis = new FileInputStream(jfc.getSelectedFile());
                Tela_cadastro_filme.tamanho = (int) jfc.getSelectedFile().length();
                Image foto = ImageIO.read(jfc.getSelectedFile()).getScaledInstance(Tela_cadastro_filme.getLblCartaz().getWidth(), Tela_cadastro_filme.getLblCartaz().getHeight(), Image.SCALE_SMOOTH);
                Tela_cadastro_filme.getLblCartaz().setIcon(new ImageIcon(foto));
                Tela_cadastro_filme.getLblCartaz().updateUI();
            } catch (Exception e){
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}
