package ui_swing;

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