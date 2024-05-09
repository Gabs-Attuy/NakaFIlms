package ui_swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Tela_principal extends JPanel implements ActionListener {
    private static JButton nakabank, home;

    public static JButton getNakabank() {
        return nakabank;
    }

    public static JButton getHome() {
        return home;
    }

    public Tela_principal(ActionListener listener) {
        setBackground(Color.decode("#0D1E40"));
        setLayout(new BorderLayout()); // Usar BorderLayout para colocar o painel no topo

        JPanel header = new JPanel(new FlowLayout());
        header.setOpaque(true);
        header.setBackground(Color.decode("#F2F0C9"));
        ImageIcon imageIcon = new ImageIcon("src/main/resources/Logo_header.png");
        JLabel imageLabel = new JLabel(imageIcon);
        header.add(imageLabel);
        JLabel fantasma1 = new JLabel();
        fantasma1.setPreferredSize(new Dimension(295, 56));
        header.add(fantasma1);
        JLabel fantasma2 = new JLabel();
        fantasma2.setPreferredSize(new Dimension(295, 56));
        header.add(fantasma2);
        nakabank = Metodos_swing.cria_botao_header("NakaBank");
        nakabank.addActionListener(listener);
        header.add(nakabank);
        JLabel fantasma3 = new JLabel();
        fantasma3.setPreferredSize(new Dimension(148, 56));
        header.add(fantasma3);
        home = Metodos_swing.cria_botao_header("Home");
        home.addActionListener(listener);
        header.add(home);
        JLabel fantasma4 = new JLabel();
        fantasma4.setPreferredSize(new Dimension(148, 56));
        header.add(fantasma4);
        ImageIcon usuario = new ImageIcon("src/main/resources/Usuario.png");
        JLabel imageUsuario = new JLabel(usuario);
        header.add(imageUsuario);

        // Adicionar o painel de cabeçalho ao BorderLayout na parte superior
        add(header, BorderLayout.NORTH);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
