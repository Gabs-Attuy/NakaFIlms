package ui_swing;
import run_main.Main;
import sql_actions.Create;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class Tela_selecao_lugar extends JPanel {
    private static HashMap<JCheckBox, Integer> assentoMap = new HashMap<>();

    public static HashMap<JCheckBox, Integer> getAssentoMap() {
        return assentoMap;
    }

    private static double valorPedido = 0;
    private static int quantidadeingressos = 0;

    public static double getValorPedido() {
        return valorPedido;
    }

    public static void incrementarValorPedido(double valor_assento) {
        valorPedido += valor_assento;
        atualizarValorPedidoLabel();
    }

    public static void decrementarValorPedido(double valor_assento) {
        valorPedido -= valor_assento;
        atualizarValorPedidoLabel();
    }

    public static int getQuantidadeingressos() {
        return quantidadeingressos;
    }

    public static void incrementarQtdd() {
        quantidadeingressos++;
        atualizarQuantidadeIngressosLabel();
    }

    public static void decrementarQtdd() {
        quantidadeingressos--;
        atualizarQuantidadeIngressosLabel();
    }

    public Tela_selecao_lugar() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    private void initComponents() {

        header = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        TextoSelecioneOsLugares = new javax.swing.JLabel();
        textoPagamento = new javax.swing.JLabel();
        textoQtdIngressos = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        textoValor = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        botaoComprar = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        PainelCheckBox = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(13, 30, 64));
        setMinimumSize(new java.awt.Dimension(1366, 768));
        setPreferredSize(new java.awt.Dimension(1366, 768));
        setLayout(null);

        header = Metodos_swing.header();
        add(header);
        header.setBounds(0, 0, 1520, 80);

        add(jLabel2);
        jLabel2.setBounds(170, 110, 183, 275);

        jPanel1.setBackground(new java.awt.Color(242, 240, 201));
        jPanel1.setLayout(null);

        TextoSelecioneOsLugares.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TextoSelecioneOsLugares.setText("Selecione os Lugares:");
        jPanel1.add(TextoSelecioneOsLugares);
        TextoSelecioneOsLugares.setBounds(35, 24, 260, 25);

        textoPagamento.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textoPagamento.setText("Pagamento:");
        jPanel1.add(textoPagamento);
        textoPagamento.setBounds(35, 211, 170, 25);

        textoQtdIngressos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textoQtdIngressos.setText("Quantidade de ingressos:");
        jPanel1.add(textoQtdIngressos);
        textoQtdIngressos.setBounds(50, 270, 230, 25);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText(String.valueOf(getQuantidadeingressos()));
        jPanel1.add(jLabel8);
        jLabel8.setBounds(300, 270, 120, 25);

        textoValor.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textoValor.setText("Valor: N$");
        jPanel1.add(textoValor);
        textoValor.setBounds(220, 340, 120, 25);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setText(String.valueOf(getValorPedido()));
        jPanel1.add(jLabel11);
        jLabel11.setBounds(340, 340, 100, 25);

        botaoComprar.setBackground(new java.awt.Color(13, 30, 64));
        botaoComprar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        botaoComprar.setForeground(new java.awt.Color(242, 27, 127));
        botaoComprar.setText("Gerar pedido");

        botaoComprar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Create.criarPedido();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Erro ao gerar pedido: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        jPanel1.add(botaoComprar);
        botaoComprar.setBounds(60, 420, 261, 41);

        botaoCancelar.setBackground(new java.awt.Color(13, 30, 64));
        botaoCancelar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        botaoCancelar.setForeground(new java.awt.Color(242, 27, 127));
        botaoCancelar.setText("Cancelar");
        botaoCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.getCardLayout().show(Main.getCards(), "filme_escolhido");
            }
        });
        jPanel1.add(botaoCancelar);
        botaoCancelar.setBounds(390, 420, 261, 41);

        PainelCheckBox.setBackground(new java.awt.Color(211, 206, 111));
        PainelCheckBox.setLayout(new java.awt.GridLayout(5, 5));
        jPanel1.add(PainelCheckBox);
        PainelCheckBox.setBounds(220, 50, 490, 130);

        add(jPanel1);
        jPanel1.setBounds(580, 110, 750, 490);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(242, 27, 127));
        add(jLabel10);
        jLabel10.setBounds(100, 400, 250, 30);

        footer = Metodos_swing.footer();
        add(footer);
        footer.setBounds(0, 700, 1366, 50);
    }

    private static javax.swing.JPanel PainelCheckBox;
    private javax.swing.JLabel TextoSelecioneOsLugares;
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoComprar;
    private javax.swing.JPanel header;

    private static javax.swing.JLabel jLabel10;
    private static javax.swing.JLabel jLabel11;
    private static javax.swing.JLabel jLabel2;
    private static javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel footer;
    private javax.swing.JLabel textoPagamento;
    private javax.swing.JLabel textoQtdIngressos;
    private javax.swing.JLabel textoValor;
    // End of variables declaration//GEN-END:variables


    public static JLabel getjLabel2() {
        return jLabel2;
    }

    public static JLabel getjLabel10() {
        return jLabel10;
    }

    // Métodos estáticos para atualizar os rótulos
    public static void atualizarValorPedidoLabel() {
        jLabel11.setText(String.valueOf(getValorPedido()));
        jLabel11.revalidate();
        jLabel11.repaint();
    }

    public static void atualizarQuantidadeIngressosLabel() {
        jLabel8.setText(String.valueOf(getQuantidadeingressos()));
        jLabel8.revalidate();
        jLabel8.repaint();
    }

    public static JPanel getPainelCheckBox() {
        return PainelCheckBox;
    }
}