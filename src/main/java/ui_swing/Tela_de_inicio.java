package ui_swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Tela_de_inicio extends JPanel{
    private JButton loginButton;
    private JButton cadastroButton;

    public JButton getLoginButton() {
        return loginButton;
    }

    public JButton getCadastroButton() {
        return cadastroButton;
    }

    public Tela_de_inicio(ActionListener listener) {
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
        loginButton = Metodos_swing.cria_botao("Login");
        loginButton.addActionListener(listener);
        add(loginButton, gbc);

        gbc.gridy = 2;
        cadastroButton = Metodos_swing.cria_botao("Cadastre-se");
        cadastroButton.addActionListener(listener);
        add(cadastroButton, gbc);
    }
}
