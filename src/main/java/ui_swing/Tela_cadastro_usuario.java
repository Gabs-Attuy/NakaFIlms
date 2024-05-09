package ui_swing;
import Entities.Usuario;
import sql_actions.Cad_usuario;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.*;

public class Tela_cadastro_usuario extends JPanel implements ActionListener {
    private static JTextField nomeText;
    private static JTextField emailText;
    private static JTextField senhaText;
    private JTextField confirmaSenhaText;
    private static JFormattedTextField cpfText;
    private static JFormattedTextField rgText;
    private static JFormattedTextField telefoneText;
    private static JFormattedTextField dataText;
    private static JButton cadastrarButton;

    public static JTextField getNomeText() {
        return nomeText;
    }

    public static JTextField getEmailText() {
        return emailText;
    }

    public static JTextField getSenhaText() {
        return senhaText;
    }

    public JTextField getConfirmaSenhaText() {
        return confirmaSenhaText;
    }

    public static JFormattedTextField getCpfText() {
        return cpfText;
    }

    public static JFormattedTextField getRgText() {
        return rgText;
    }

    public static JFormattedTextField getTelefoneText() {
        return telefoneText;
    }

    public static JFormattedTextField getDataText() {
        return dataText;
    }

    public static JButton getCadastrarButton() {
        return cadastrarButton;
    }

    public Tela_cadastro_usuario(ActionListener listener) {
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
        JPanel inputPanel = new JPanel(new GridLayout(8, 2, 0, 30));
        inputPanel.setOpaque(false);
        JLabel nome = new JLabel("Nome:");
        nome.setForeground(Color.decode("#F21B7F"));
        inputPanel.add(nome);
        nomeText = new JTextField(20);
        inputPanel.add(nomeText);
        JLabel data_nascimento = new JLabel("Data de Nascimento (Ano-Mês-Dia):");
        data_nascimento.setForeground(Color.decode("#F21B7F"));
        inputPanel.add(data_nascimento);
        dataText = criarCaixaTextoFormatada("####-##-##");
        inputPanel.add(dataText);
        JLabel cpf = new JLabel("CPF:");
        cpf.setForeground(Color.decode("#F21B7F"));
        inputPanel.add(cpf);
        cpfText = criarCaixaTextoFormatada("###.###.###-##");
        inputPanel.add(cpfText);
        JLabel rg = new JLabel("RG:");
        rg.setForeground(Color.decode("#F21B7F"));
        inputPanel.add(rg);
        rgText = criarCaixaTextoFormatada("##.###.###-A");
        inputPanel.add(rgText);
        JLabel telefone = new JLabel("Telefone:");
        telefone.setForeground(Color.decode("#F21B7F"));
        inputPanel.add(telefone);
        telefoneText = criarCaixaTextoFormatada("(##)#####-####");
        inputPanel.add(telefoneText);
        JLabel email = new JLabel("E-mail:");
        email.setForeground(Color.decode("#F21B7F"));
        inputPanel.add(email);
        emailText = new JTextField(20);
        inputPanel.add(emailText);
        JLabel senha = new JLabel("Senha:");
        senha.setForeground(Color.decode("#F21B7F"));
        inputPanel.add(senha);
        senhaText = new JTextField(20);
        inputPanel.add(senhaText);
        JLabel confirmaSenha = new JLabel("Confirma Senha:");
        confirmaSenha.setForeground(Color.decode("#F21B7F"));
        inputPanel.add(confirmaSenha);
        confirmaSenhaText = new JTextField(20);
        inputPanel.add(confirmaSenhaText);
        add(inputPanel, gbc);

        // Adicionando o botão
        gbc.gridy = 2;
        cadastrarButton = Metodos_swing.cria_botao("Cadastrar");
        cadastrarButton.addActionListener(listener);
        add(cadastrarButton, gbc);
    }

//    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == cadastrarButton) {
//            String cpfSemPontuacao = cpfText.getText().replaceAll("\\D", "");
//            String rgSemPontuacao = rgText.getText().replaceAll("\\D", "");
//            Usuario u = new Usuario(nomeText.getText(), cpfSemPontuacao, rgSemPontuacao, telefoneText.getText(), emailText.getText(), senhaText.getText());
//            u.setData_de_nascimento(u.transformaDataSQL(dataText.getText()));
//            try {
//                Cad_usuario.Cad_user(u);
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        }
//    }
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
