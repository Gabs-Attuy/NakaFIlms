package ui_swing;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Tela_selecao_lugar extends JPanel {

    public Tela_selecao_lugar() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    private void initComponents() {

        header = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        TextoSelecioneOsLugares = new javax.swing.JLabel();
        textoPagamento = new javax.swing.JLabel();
        textoNakacoins = new javax.swing.JLabel();
        textoQtdIngressos = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        textoValor = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        botaoComprar = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        PainelCheckBox = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();

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
        TextoSelecioneOsLugares.setBounds(35, 24, 168, 25);

        textoPagamento.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textoPagamento.setText("Pagamento:");
        jPanel1.add(textoPagamento);
        textoPagamento.setBounds(35, 211, 95, 25);

        textoNakacoins.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textoNakacoins.setText("NakaCoins:");
        jPanel1.add(textoNakacoins);
        textoNakacoins.setBounds(480, 220, 90, 25);

        textoQtdIngressos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textoQtdIngressos.setText("Quantidade de ingressos:");
        jPanel1.add(textoQtdIngressos);
        textoQtdIngressos.setBounds(62, 266, 202, 25);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("jLabel7");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(580, 220, 60, 25);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("jLabel8");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(270, 270, 70, 25);

        textoValor.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textoValor.setText("Valor:  R$");
        jPanel1.add(textoValor);
        textoValor.setBounds(250, 340, 80, 25);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setText("000");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(330, 340, 60, 25);

        botaoComprar.setBackground(new java.awt.Color(13, 30, 64));
        botaoComprar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        botaoComprar.setForeground(new java.awt.Color(242, 27, 127));
        botaoComprar.setText("Comprar");

        jPanel1.add(botaoComprar);
        botaoComprar.setBounds(60, 420, 261, 41);

        botaoCancelar.setBackground(new java.awt.Color(13, 30, 64));
        botaoCancelar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        botaoCancelar.setForeground(new java.awt.Color(242, 27, 127));
        botaoCancelar.setText("Cancelar");

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
        jLabel10.setText("NOME DO FILME");
        add(jLabel10);
        jLabel10.setBounds(100, 400, 250, 30);

        jLabel12.setText("jLabel2");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(607, 607, 607)
                                .addComponent(jLabel12)
                                .addContainerGap(736, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(0, 14, Short.MAX_VALUE))
        );

        add(jPanel2);
        jPanel2.setBounds(0, 720, 1380, 30);
    }

    private static javax.swing.JPanel PainelCheckBox;
    private javax.swing.JLabel TextoSelecioneOsLugares;
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoComprar;
    private javax.swing.JPanel header;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel textoNakacoins;
    private javax.swing.JLabel textoPagamento;
    private javax.swing.JLabel textoQtdIngressos;
    private javax.swing.JLabel textoValor;
    // End of variables declaration//GEN-END:variables


    public static JPanel getPainelCheckBox() {
        return PainelCheckBox;
    }
}