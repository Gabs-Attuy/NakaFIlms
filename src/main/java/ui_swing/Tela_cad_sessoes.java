package ui_swing;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.*;

public class Tela_cad_sessoes extends JPanel implements ActionListener {
    private static JComboBox<String> idiomaText;
    private static JFormattedTextField dataText;
    private static JComboBox<String> horaText;
    private static JFormattedTextField valorText;
    private static JFormattedTextField salaText;
    private static JButton cadastrarButton, voltarButton;

    public static JComboBox<String> getIdiomaText() {
        return idiomaText;
    }

    public static JFormattedTextField getDataText() {
        return dataText;
    }

    public static JComboBox<String> getHoraText() {
        return horaText;
    }

    public static JFormattedTextField getValorText() {
        return valorText;
    }

    public static JButton getCadastrarButton() {
        return cadastrarButton;
    }

    public static JButton getVoltarButton() {
        return voltarButton;
    }

    public static JFormattedTextField getSalaText() {
        return salaText;
    }

    public Tela_cad_sessoes(ActionListener listener) {
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
        JPanel inputPanel = new JPanel(new GridLayout(6, 2, 10, 30));
        inputPanel.setOpaque(false);
        JLabel idioma = new JLabel("Idioma:");
        idioma.setForeground(Color.decode("#F21B7F"));
        inputPanel.add(idioma);
        idiomaText = new JComboBox<>(new String[]{"DUB", "LEG"});
        inputPanel.add(idiomaText);
        JLabel data = new JLabel("Data:");
        data.setForeground(Color.decode("#F21B7F"));
        inputPanel.add(data);
        dataText = criarCaixaTextoFormatada("##-##");
        inputPanel.add(dataText);
        JLabel hora = new JLabel("Horário:");
        hora.setForeground(Color.decode("#F21B7F"));
        inputPanel.add(hora);
        horaText = new JComboBox<>(new String[]{"10:00", "12:00", "14:00", "16:00", "18:00", "20:00", "22:00"});
        inputPanel.add(horaText);
        JLabel valor = new JLabel("Valor:");
        valor.setForeground(Color.decode("#F21B7F"));
        inputPanel.add(valor);
        valorText = criarCaixaTextoFormatada("R$##,00");
        inputPanel.add(valorText);
        JLabel sala = new JLabel("Sala:");
        sala.setForeground(Color.decode("#F21B7F"));
        inputPanel.add(sala);
        salaText = criarCaixaTextoFormatada("#");
        inputPanel.add(salaText);
        cadastrarButton = Metodos_swing.cria_botao("Cadastrar");
        cadastrarButton.addActionListener(listener);
        inputPanel.add(cadastrarButton);
        voltarButton = Metodos_swing.cria_botao("Voltar");
        voltarButton.addActionListener(listener);
        inputPanel.add(voltarButton);
        add(inputPanel, gbc);
    }

    private MaskFormatter setMascara(String mascara){
        MaskFormatter mask = null;
        try{
            mask = new MaskFormatter(mascara);
        }catch(java.text.ParseException ex){}
        return mask;
    }
    private JFormattedTextField criarCaixaTextoFormatada(String mascara) {
        JFormattedTextField texto = new JFormattedTextField(setMascara(mascara));
        texto.addActionListener(this);
        return texto;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
