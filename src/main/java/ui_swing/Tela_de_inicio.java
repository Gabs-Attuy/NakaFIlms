package ui_swing;

import run_main.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Tela_de_inicio extends JPanel{

    public Tela_de_inicio() {
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

        // Adicionando os botões
        gbc.gridy = 1;
        JButton loginButton = Metodos_swing.cria_botao("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.getCardLayout().show(Main.getCards(), "login");
                Tela_login.getUserText().requestFocus();
            }
        });
        add(loginButton, gbc);

        gbc.gridy = 2;
        JButton cadastroButton = Metodos_swing.cria_botao("Cadastre-se");
        cadastroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.getCardLayout().show(Main.getCards(), "cadastro");
                Tela_cadastro_usuario.getNomeText().requestFocus();
            }
        });
        add(cadastroButton, gbc);
    }
}
