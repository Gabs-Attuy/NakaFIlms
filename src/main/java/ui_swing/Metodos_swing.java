package ui_swing;

import javax.imageio.IIOImage;
import javax.swing.*;
import java.awt.*;

public class Metodos_swing {
    public static Dimension getScreensize(){
        return Toolkit.getDefaultToolkit().getScreenSize();
    }

    public static JButton cria_botao(String texto){
        JButton botao = new JButton(texto);
        botao.setBackground(Color.decode("#F2F0C9"));
        botao.setForeground(Color.decode("#F21B7F"));
        botao.setPreferredSize(new Dimension(250, 50));
        return botao;
    }

    public static JButton cria_botao_header(String texto){
        JButton botao = new JButton(texto);
        botao.setBackground(Color.decode("#0D1E40"));
        botao.setForeground(Color.decode("#F21B7F"));
        botao.setPreferredSize(new Dimension(295, 56));
        return botao;
    }

    public static JPanel cria_cartaz(String img, int image, int id){
        JPanel cartaz = new JPanel(new GridLayout(2, 1, 0, 10));
        cartaz.setPreferredSize(new Dimension(400, 800));
        cartaz.setOpaque(false);
        ImageIcon imgCartaz = new ImageIcon("src/main/resources/" + img);
        JLabel imgCartazLabel = new JLabel(imgCartaz);
        cartaz.add(imgCartazLabel);
        JButton botao = new JButton();

        return cartaz;
    }
}
//labelUsuario = new JLabel("Usuário:");
//labelSenha = new JLabel("Senha:");
//campoUsuario = new JTextField(20);
//campoSenha = new JPasswordField(20);
//botaoLogin = new JButton("Login");
//
//// Adicionando listener ao botão de login
//        botaoLogin.addActionListener(this);
//
//// Criando um painel para organizar os componentes
//JPanel painel = new JPanel();
//        painel.setLayout(new GridLayout(3, 2));
//        painel.add(labelUsuario);
//        painel.add(campoUsuario);
//        painel.add(labelSenha);
//        painel.add(campoSenha);
//        painel.add(new JLabel()); // Espaço em branco
//        painel.add(botaoLogin);