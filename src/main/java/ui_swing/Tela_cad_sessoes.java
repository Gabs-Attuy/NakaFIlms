package ui_swing;

import Entities.Sessao;
import run_main.Main;
import sql_actions.Cad_sessoes;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.*;
import java.sql.Time;
import java.util.Date;

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

    public Tela_cad_sessoes() {
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
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idioma = (String) getIdiomaText().getSelectedItem();
                String hora = (String) getHoraText().getSelectedItem();
                int sala = Integer.parseInt(getSalaText().getText());
                Sessao s = new Sessao(idioma, sala);
                s.setData_Sessao(s.transformaDataSQL(Tela_cad_sessoes.getDataText().getText()));
                s.setHorario(s.converterStringParaTime(hora));
                try {
                    Cad_sessoes.Cad_sessao(s, converterStringParaDouble(getValorText().getText()));
                    limpaCampos();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        inputPanel.add(cadastrarButton);
        voltarButton = Metodos_swing.cria_botao("Voltar");
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cad_sessoes.setId_filme(-1);
                Main.getCardLayout().show(Main.getCards(), "cad_filme");
            }
        });
        inputPanel.add(voltarButton);
        add(inputPanel, gbc);
    }

    public static void limpaCampos(){
        getDataText().setText(null);
        getSalaText().setText(null);
        getValorText().setText(null);
    }
    public static double converterStringParaDouble(String valorText) {
        try {
            // Remover o prefixo "R$"
            String valorSemPrefixo = valorText.replace("R$", "").trim();

            // Substituir a vírgula por um ponto
            String valorFormatado = valorSemPrefixo.replace(",", ".");

            // Converter a string para double
            double valorDouble = Double.parseDouble(valorFormatado);

            return valorDouble;
        } catch (NumberFormatException e) {
            System.out.println("Formato de valor inválido: " + valorText);
            return 0.0; // Ou lance uma exceção, ou trate conforme necessário
        }
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
