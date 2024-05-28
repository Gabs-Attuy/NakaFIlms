package ui_swing;

import Entities.Usuario;
import run_main.Main;
import sql_actions.Create;
import validations.Verifica_docs;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.*;

public class Tela_cadastro_usuario extends JPanel implements ActionListener {
    private static JTextField nomeText, emailText;
    private static JPasswordField senhaText, confirmaSenhaText;
    private static JFormattedTextField cpfText, rgText, telefoneText, dataText;

    public static JTextField getNomeText() {
        return nomeText;
    }

    public static JTextField getEmailText() {
        return emailText;
    }

    public static JPasswordField getSenhaText() {
        return senhaText;
    }

    public static JPasswordField getConfirmaSenhaText() {
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

    public Tela_cadastro_usuario() {
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
        JPanel inputPanel = new JPanel(new GridLayout(9, 2, 10, 30));
        inputPanel.setOpaque(false);
        JLabel nome = new JLabel("Nome:");
        nome.setForeground(Color.decode("#F21B7F"));
        inputPanel.add(nome);
        nomeText = new JTextField(20);
        inputPanel.add(nomeText);
        JLabel data_nascimento = new JLabel("Data de Nascimento (Ano-Mês-Dia):");
        data_nascimento.setForeground(Color.decode("#F21B7F"));
        inputPanel.add(data_nascimento);
        dataText = Metodos_swing.criarCaixaTextoFormatada("####-##-##");
        inputPanel.add(dataText);
        JLabel cpf = new JLabel("CPF:");
        cpf.setForeground(Color.decode("#F21B7F"));
        inputPanel.add(cpf);
        cpfText = Metodos_swing.criarCaixaTextoFormatada("###.###.###-##");
        inputPanel.add(cpfText);
        JLabel rg = new JLabel("RG:");
        rg.setForeground(Color.decode("#F21B7F"));
        inputPanel.add(rg);
        rgText = Metodos_swing.criarCaixaTextoFormatada("##.###.###-A");
        inputPanel.add(rgText);
        JLabel telefone = new JLabel("Telefone:");
        telefone.setForeground(Color.decode("#F21B7F"));
        inputPanel.add(telefone);
        telefoneText = Metodos_swing.criarCaixaTextoFormatada("(##)#####-####");
        inputPanel.add(telefoneText);
        JLabel email = new JLabel("E-mail:");
        email.setForeground(Color.decode("#F21B7F"));
        inputPanel.add(email);
        emailText = new JTextField(20);
        inputPanel.add(emailText);
        JLabel senha = new JLabel("Senha:");
        senha.setForeground(Color.decode("#F21B7F"));
        inputPanel.add(senha);
        senhaText = new JPasswordField(20);
        inputPanel.add(senhaText);
        JLabel confirmaSenha = new JLabel("Confirma Senha:");
        confirmaSenha.setForeground(Color.decode("#F21B7F"));
        inputPanel.add(confirmaSenha);
        confirmaSenhaText = new JPasswordField(20);
        inputPanel.add(confirmaSenhaText);
        JButton cadastrarButton = Metodos_swing.cria_botao("Cadastrar");
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cpfSemPontuacao = getCpfText().getText().replaceAll("\\D", "");
                String rgSemPontuacao = getRgText().getText().replaceAll("\\D", "");
                if(getCpfText().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Campo CPF obrigatório!");
                    getCpfText().requestFocus();
                    return;
                } else if (!Verifica_docs.validarCPF(cpfSemPontuacao)) {
                    JOptionPane.showMessageDialog(null, "CPF inválido!");
                    getCpfText().setText("");
                    getCpfText().requestFocus();
                    return;
                } else if (getRgText().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Campo RG obrigatório!");
                    getRgText().requestFocus();
                    return;
                } /*else if (!Verifica_docs.validarRG(rgSemPontuacao)) {
                    JOptionPane.showMessageDialog(null, "RG inválido!");
                    getRgText().setText("");
                    getRgText().requestFocus();
                    return;
                }*/ else if (getNomeText().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Campo Nome obrigatório!");
                    getNomeText().requestFocus();
                    return;
                } else if (getDataText().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Campo Data de Nascimento obrigatório");
                    getDataText().requestFocus();
                    return;
                } else if (getTelefoneText().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Campo Telefone obrigatório!");
                    getTelefoneText().requestFocus();
                    return;
                } else if (getEmailText().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Campo E-mail obrigatório!");
                    getEmailText().requestFocus();
                    return;
                } else if (getSenhaText().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Campo Senha obrigatório!");
                    getSenhaText().requestFocus();
                    return;
                } else if (getConfirmaSenhaText().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Campo Confirma Senha obrigatório!");
                    getConfirmaSenhaText().requestFocus();
                    return;
                } else if(!getSenhaText().getText().equals(getConfirmaSenhaText().getText())) {
                    JOptionPane.showMessageDialog(null, "Confirmação de senha inválida!");
                    getSenhaText().setText(null);
                    getConfirmaSenhaText().setText(null);
                    getSenhaText().requestFocus();
                    return;
                }
                    Usuario u = new Usuario(getNomeText().getText(), cpfSemPontuacao, rgSemPontuacao, getTelefoneText().getText(), getEmailText().getText(), getSenhaText().getText());
                    u.setData_de_nascimento(u.transformaDataSQL(getDataText().getText()));
                    try {
                        Create.Cad_user(u);
                        clearFields();
                        Main.getCardLayout().show(Main.getCards(), "login");
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Erro ao cadastrar usuário: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                        clearFields();
                        getNomeText().requestFocus();
                    }
            }
        });
        inputPanel.add(cadastrarButton);
        JButton voltarButton = Metodos_swing.cria_botao("Voltar");
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
                Main.getCardLayout().show(Main.getCards(), "inicio");
            }
        });
        inputPanel.add(voltarButton);
        add(inputPanel, gbc);
    }

    private static void clearFields() {
        getNomeText().setText(null);
        getDataText().setText(null);
        getCpfText().setText(null);
        getRgText().setText(null);
        getTelefoneText().setText(null);
        getEmailText().setText(null);
        getSenhaText().setText(null);
        getConfirmaSenhaText().setText(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
