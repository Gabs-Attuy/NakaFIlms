package ui_swing;

import run_main.Main;
import sql_actions.Read;
import sql_actions.Update;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tela_nakabank extends JPanel {

    public Tela_nakabank() {
        initComponents();
    }


    @SuppressWarnings("unchecked")

    private void initComponents() {

        header = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        textoSaldo = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        textoUsuarioaReceber = new javax.swing.JLabel();
        textoNumerodaContaRecebedora = new javax.swing.JLabel();
        textoValorDepositar = new javax.swing.JLabel();
        TransferirValor = new javax.swing.JButton();
        DepositarValor = new javax.swing.JButton();
        textoValorTransferir = new javax.swing.JLabel();
        campoParaValorDepositar = new javax.swing.JTextField();
        campoUsuarioaReceber = new javax.swing.JTextField();
        campoContaaReceber = new javax.swing.JTextField();
        footer = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        textoDepositar = new javax.swing.JLabel();
        textoConta1 = new javax.swing.JLabel();
        campovaloratransferir = new javax.swing.JPasswordField();
        textoTransferir1 = new javax.swing.JLabel();
        numerodaContaAQUI = new javax.swing.JLabel();
        valorSaldo = new javax.swing.JLabel();

        setBackground(new java.awt.Color(13, 30, 64));
        setMinimumSize(new java.awt.Dimension(1366, 768));
        setPreferredSize(new java.awt.Dimension(1366, 768));
        setLayout(null);

        header = Metodos_swing.header();
        add(header);
        header.setBounds(0, 0, 1520, 80);

        jLabel2.setFont(new java.awt.Font("SimSun-ExtB", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(242, 27, 127));
        jLabel2.setText("Bem vindo ao NakaBank");
        add(jLabel2);
        jLabel2.setBounds(390, 100, 880, 80);

        textoSaldo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        textoSaldo.setForeground(new java.awt.Color(242, 27, 127));
        textoSaldo.setText("Saldo: N$");
        add(textoSaldo);
        textoSaldo.setBounds(890, 250, 110, 50);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(242, 27, 127));
        jLabel7.setText("Dados do usuario");
        add(jLabel7);
        jLabel7.setBounds(80, 190, 230, 30);

        textoUsuarioaReceber.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textoUsuarioaReceber.setForeground(new java.awt.Color(255, 255, 255));
        textoUsuarioaReceber.setText("Conta:");
        add(textoUsuarioaReceber);
        textoUsuarioaReceber.setBounds(790, 450, 180, 30);

        textoNumerodaContaRecebedora.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textoNumerodaContaRecebedora.setForeground(new java.awt.Color(255, 255, 255));
        textoNumerodaContaRecebedora.setText("Valor:");
        add(textoNumerodaContaRecebedora);
        textoNumerodaContaRecebedora.setBounds(780, 510, 190, 30);

        textoValorDepositar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textoValorDepositar.setForeground(new java.awt.Color(242, 27, 127));
        textoValorDepositar.setText("Valor:");
        add(textoValorDepositar);
        textoValorDepositar.setBounds(100, 550, 60, 30);

        TransferirValor.setText("Transferir valor");
        TransferirValor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numeroconta = Integer.parseInt(getCampoUsuarioaReceber().getText());
                double valor = Double.parseDouble(getCampoContaaReceber().getText());
                int senha = Integer.parseInt(getCampovaloratransferir().getText());
                try {
                    Update.Transferir(Read.getNakabank(Main.getId()), senha, numeroconta, valor);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        add(TransferirValor);
        TransferirValor.setBounds(860, 630, 280, 23);

        DepositarValor.setText("Depositar valor");
        DepositarValor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double valor = Double.parseDouble(getCampoParaValorDepositar().getText());
                    Update.Depositar(Read.getNakabank(Main.getId()), valor);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao efetuar depósito: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                    getCampoParaValorDepositar().setText(null);
                }
            }
        });
        add(DepositarValor);
        DepositarValor.setBounds(170, 610, 230, 23);

        textoValorTransferir.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textoValorTransferir.setForeground(new java.awt.Color(255, 255, 255));
        textoValorTransferir.setText("Senha:");
        add(textoValorTransferir);
        textoValorTransferir.setBounds(870, 560, 100, 30);
        add(campoParaValorDepositar);
        campoParaValorDepositar.setBounds(170, 560, 230, 22);
        add(campoUsuarioaReceber);
        campoUsuarioaReceber.setBounds(970, 460, 200, 22);
        add(campoContaaReceber);
        campoContaaReceber.setBounds(970, 520, 200, 22);

        footer = Metodos_swing.footer();
        add(footer);
        footer.setBounds(0, 700, 1366, 50);

        textoDepositar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        textoDepositar.setForeground(new java.awt.Color(242, 27, 127));
        textoDepositar.setText("Depositar NakaCoins");
        add(textoDepositar);
        textoDepositar.setBounds(90, 460, 340, 60);

        textoConta1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textoConta1.setForeground(new java.awt.Color(242, 27, 127));
        textoConta1.setText("Conta:");
        add(textoConta1);
        textoConta1.setBounds(190, 300, 80, 30);

        add(campovaloratransferir);
        campovaloratransferir.setBounds(970, 570, 200, 22);

        textoTransferir1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        textoTransferir1.setForeground(new java.awt.Color(242, 27, 127));
        textoTransferir1.setText("Transferir");
        add(textoTransferir1);
        textoTransferir1.setBounds(860, 370, 260, 50);

        numerodaContaAQUI.setBackground(new java.awt.Color(255, 255, 255));
        numerodaContaAQUI.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        numerodaContaAQUI.setForeground(new java.awt.Color(255, 255, 255));
        numerodaContaAQUI.setText("Numero da conta");
        add(numerodaContaAQUI);
        numerodaContaAQUI.setBounds(260, 300, 350, 30);

        valorSaldo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        valorSaldo.setForeground(new java.awt.Color(255, 255, 255));
        valorSaldo.setText("saldo");
        add(valorSaldo);
        valorSaldo.setBounds(1100, 250, 100, 50);
    }// </editor-fold>

    // Variables declaration - do not modify
    private javax.swing.JButton DepositarValor;
    private javax.swing.JButton TransferirValor;
    private static javax.swing.JTextField campoContaaReceber;
    private static javax.swing.JTextField campoParaValorDepositar;
    private static javax.swing.JTextField campoUsuarioaReceber;
    private static javax.swing.JPasswordField campovaloratransferir;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel footer;
    private static javax.swing.JLabel numerodaContaAQUI;
    private javax.swing.JLabel textoConta1;
    private javax.swing.JLabel textoDepositar;
    private javax.swing.JLabel textoNumerodaContaRecebedora;
    private javax.swing.JLabel textoSaldo;
    private javax.swing.JLabel textoTransferir1;
    private javax.swing.JLabel textoUsuarioaReceber;
    private javax.swing.JLabel textoValorDepositar;
    private javax.swing.JLabel textoValorTransferir;
    private static javax.swing.JLabel valorSaldo;
    // End of variables declaration

    public static JTextField getCampoUsuarioaReceber() {
        return campoUsuarioaReceber;
    }

    public static JPasswordField getCampovaloratransferir() {
        return campovaloratransferir;
    }

    public static JTextField getCampoContaaReceber() {
        return campoContaaReceber;
    }

    public static JTextField getCampoParaValorDepositar() {
        return campoParaValorDepositar;
    }

    public static JLabel getNumerodaContaAQUI() {
        return numerodaContaAQUI;
    }

    public static JLabel getValorSaldo() {
        return valorSaldo;
    }

    public static void clearFields() {
        getCampoContaaReceber().setText(null);
        getCampoUsuarioaReceber().setText(null);
        getCampovaloratransferir().setText(null);
    }

    public static void atualizarValorSaldo() throws Exception {
        Read.getNakabankInforms(Read.getNakabank(Main.getId()));
        valorSaldo.revalidate();
        valorSaldo.repaint();
    }
}