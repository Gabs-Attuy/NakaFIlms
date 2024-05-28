package ui_swing;

import run_main.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Tela_login extends JPanel {
    private static JTextField userText;
    private static JPasswordField senhaText;
    private static JButton entrarButton, voltarButton;

    public static JButton getEntrarButton() {
        return entrarButton;
    }

    public static JTextField getUserText() {
        return userText;
    }

    public static JPasswordField getSenhaText() {
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
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 30));
        inputPanel.setOpaque(false);
        JLabel user = new JLabel("E-mail:");
        user.setForeground(Color.decode("#F21B7F"));
        inputPanel.add(user);
        userText = new JTextField(20);
        inputPanel.add(userText);
        JLabel senha = new JLabel("Senha:");
        senha.setForeground(Color.decode("#F21B7F"));
        inputPanel.add(senha);
        senhaText = new JPasswordField(20);
        inputPanel.add(senhaText);
        entrarButton = Metodos_swing.cria_botao("Entrar");
        entrarButton.addActionListener(listener);
        inputPanel.add(entrarButton);
        voltarButton = Metodos_swing.cria_botao("Voltar");
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getUserText().setText(null);
                getSenhaText().setText(null);
                Main.getCardLayout().show(Main.getCards(), "inicio");
            }
        });
        inputPanel.add(voltarButton);
        add(inputPanel, gbc);
    }
}

