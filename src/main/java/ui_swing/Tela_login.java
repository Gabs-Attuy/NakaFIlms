//package ui_swing;
//
//import javax.swing.*;
//import java.awt.*;
//
//public class Tela_login extends JFrame {
//    public Tela_login(){
//        setTitle("Login");
//        Dimension tela = Metodos_swing.getScreensize();
//        setSize(tela.width, tela.height);
//        getContentPane().setBackground(Color.decode("#0D1E40"));
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);
//        setLayout(new GridBagLayout());
//        GridBagConstraints gbc = new GridBagConstraints();
//        gbc.insets = new Insets(10, 10, 10, 10); // Define o espaçamento interno do painel
//        gbc.weightx = 1; // Expande o componente horizontalmente
//
//        // Adicionando a imagem no painel
//        ImageIcon imageIcon = new ImageIcon("src/main/resources/Logo.png");
//        JLabel imageLabel = new JLabel(imageIcon);
//        gbc.gridx = 0;
//        gbc.gridy = 0;
//        add(imageLabel, gbc);
//
//        // Adicionando os campos de texto e botão
//        JPanel inputPanel = new JPanel();
//        inputPanel.setOpaque(false);
//        inputPanel.setLayout(new GridLayout(2, 2, 0, 30));
//        // GridLayout com três linhas e duas colunas
//
//        JPanel bc = new JPanel();
//        bc.setOpaque(false);
//        bc.setLayout(new FlowLayout());
//
//        // Centralizando o painel de botões
//        gbc.gridx = 0;
//        gbc.gridy = 1;
//        gbc.anchor = GridBagConstraints.CENTER;
//        add(inputPanel, gbc);
//        add(bc, gbc);
//
//
//        JLabel user = new JLabel("User:");
//        user.setForeground(Color.decode("#F21B7F"));
//        inputPanel.add(user);
//        JTextField userText = new JTextField(20);
//        inputPanel.add(userText);
//        JLabel senha = new JLabel("Senha:");
//        senha.setForeground(Color.decode("#F21B7F"));
//        inputPanel.add(senha);
//        JTextField senhaText = new JTextField(20);
//        inputPanel.add(senhaText);
//        JButton entrar = Metodos_swing.cria_botao("Entrar");
//        bc.add(entrar);
//        setVisible(true);
//    }
//}
package ui_swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Tela_login extends JPanel /*implements ActionListener*/{
    private static JTextField userText;
    private static JTextField senhaText;
    private static JButton entrarButton;

    public static JButton getEntrarButton() {
        return entrarButton;
    }

    public static JTextField getUserText() {
        return userText;
    }

    public static JTextField getSenhaText() {
        return senhaText;
    }

    public Tela_login(ActionListener listener) {
        setBackground(Color.decode("#0D1E40"));
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;

        // Adicionando a imagem no painel
        ImageIcon imageIcon = new ImageIcon("src/main/resources/Logo.png");
        JLabel imageLabel = new JLabel(imageIcon);
        add(imageLabel, gbc);

        // Adicionando os campos de texto
        gbc.gridy = 1;
        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 0, 30));
        inputPanel.setOpaque(false);
        JLabel user = new JLabel("User:");
        user.setForeground(Color.decode("#F21B7F"));
        inputPanel.add(user);
        userText = new JTextField(20);
        inputPanel.add(userText);
        JLabel senha = new JLabel("Senha:");
        senha.setForeground(Color.decode("#F21B7F"));
        inputPanel.add(senha);
        senhaText = new JTextField(20);
        inputPanel.add(senhaText);
        add(inputPanel, gbc);

        // Adicionando o botão
        gbc.gridy = 2;
        entrarButton = Metodos_swing.cria_botao("Entrar");
        add(entrarButton, gbc);
    }
}

