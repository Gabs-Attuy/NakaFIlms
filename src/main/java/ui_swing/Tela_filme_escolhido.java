package ui_swing;
//
//import javax.swing.*;
//import java.awt.event.ActionListener;
//
//public class Tela_filme_escolhido extends JPanel {
//    private static int id_filme;
//
//    public static int getId_filme() {
//        return id_filme;
//    }
//
//    public static void setId_filme(int id_filme) {
//        Tela_filme_escolhido.id_filme = id_filme;
//    }
//
//    public Tela_filme_escolhido(ActionListener listener) {
//        initComponents(listener);
//    }
//
//
//    @SuppressWarnings("unchecked")
//    private void initComponents(ActionListener listener) {
//
//        header = new JPanel();
//        nakabankButton = new JButton();
//        homeButton = new JButton();
//        logo = new JLabel();
//        lblCartaz = new JLabel();
//        jPanel1 = new JPanel();
//        jPanel2 = new JPanel();
//        lblSinopse = new JLabel();
//        jLabel10 = new JLabel();
//        jLabel11 = new JLabel();
//        jLabel12 = new JLabel();
//        jLabel13 = new JLabel();
//        jLabel14 = new JLabel();
//        jLabel15 = new JLabel();
//        textDiretor = new JLabel();
//        textElenco = new JLabel();
//        textGenero = new JLabel();
//        textClassificacao = new JLabel();
//        textDistribuidora = new JLabel();
//        textDuracao = new JLabel();
//        jComboBox2 = new JComboBox<>();
//        jLabel3 = new JLabel();
//        jLabel4 = new JLabel();
//        jLabel5 = new JLabel();
//        jLabel6 = new JLabel();
//        jLabel7 = new JLabel();
//        jLabel8 = new JLabel();
//        jComboBox7 = new JComboBox<>();
//        jComboBox8 = new JComboBox<>();
//        jComboBox9 = new JComboBox<>();
//        jComboBox10 = new JComboBox<>();
//        jComboBox11 = new JComboBox<>();
//        jPanel3 = new JPanel();
//        jLabel22 = new JLabel();
//
//        setBackground(new java.awt.Color(13, 30, 64));
//        setMinimumSize(new java.awt.Dimension(1366, 768));
//        setName("Filme"); // NOI18N
//        setPreferredSize(new java.awt.Dimension(1366, 768));
//        setLayout(null);
//
//        header = Metodos_swing.header();
//        add(header);
//        header.setBounds(0, 0, 1520, 80);
//
//        lblCartaz.setSize(217, 297);
//        add(lblCartaz);
//        lblCartaz.setBounds(170, 110, 183, 275);
//
//        jPanel1.setBackground(new java.awt.Color(242, 240, 201));
//
//        jPanel2.setBackground(new java.awt.Color(234, 216, 152));
//
//        lblSinopse.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
//
//        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
//        jPanel2.setLayout(jPanel2Layout);
//        jPanel2Layout.setHorizontalGroup(
//                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                        .addGroup(jPanel2Layout.createSequentialGroup()
//                                .addGap(16, 16, 16)
//                                .addComponent(lblSinopse, javax.swing.GroupLayout.PREFERRED_SIZE, 654, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                .addContainerGap(28, Short.MAX_VALUE))
//        );
//        jPanel2Layout.setVerticalGroup(
//                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                        .addGroup(jPanel2Layout.createSequentialGroup()
//                                .addContainerGap()
//                                .addComponent(lblSinopse, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                .addContainerGap(178, Short.MAX_VALUE))
//        );
//
//        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
//        jLabel10.setText("Diretor:");
//
//        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
//        jLabel11.setText("Genero:");
//
//        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
//        jLabel12.setText("Elenco:");
//
//        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
//        jLabel13.setText("Classificação:");
//
//        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
//        jLabel14.setText("Distribuidora:");
//
//        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
//        jLabel15.setText("Duração:");
//
//        textDiretor.setText("Nome do diretor");
//
//        textElenco.setText("elenco do filme");
//
//        textGenero.setText("genero do filme");
//
//        textClassificacao.setText("Classificação");
//
//        textDistribuidora.setText("Distribuidora");
//
//        textDuracao.setText("Duração");
//
//        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
//        jPanel1.setLayout(jPanel1Layout);
//        jPanel1Layout.setHorizontalGroup(
//                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                        .addGroup(jPanel1Layout.createSequentialGroup()
//                                .addGap(15, 15, 15)
//                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                .addContainerGap(37, Short.MAX_VALUE))
//                        .addGroup(jPanel1Layout.createSequentialGroup()
//                                .addGap(25, 25, 25)
//                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                                        .addGroup(jPanel1Layout.createSequentialGroup()
//                                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                                                .addComponent(textDiretor))
//                                        .addGroup(jPanel1Layout.createSequentialGroup()
//                                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                                                .addComponent(textElenco))
//                                        .addGroup(jPanel1Layout.createSequentialGroup()
//                                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                                                .addComponent(textGenero)))
//                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                                        .addGroup(jPanel1Layout.createSequentialGroup()
//                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
//                                                        .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                                                        .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING))
//                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
//                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                                                        .addComponent(textDistribuidora)
//                                                        .addComponent(textDuracao)))
//                                        .addGroup(jPanel1Layout.createSequentialGroup()
//                                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                                                .addComponent(textClassificacao)))
//                                .addGap(179, 179, 179))
//        );
//        jPanel1Layout.setVerticalGroup(
//                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                        .addGroup(jPanel1Layout.createSequentialGroup()
//                                .addGap(14, 14, 14)
//                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                .addGap(18, 18, 18)
//                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                                        .addComponent(jLabel10)
//                                        .addComponent(jLabel13)
//                                        .addComponent(textDiretor)
//                                        .addComponent(textClassificacao))
//                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
//                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                                        .addComponent(jLabel12)
//                                        .addComponent(jLabel14)
//                                        .addComponent(textElenco)
//                                        .addComponent(textDistribuidora))
//                                .addGap(18, 18, 18)
//                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                                        .addComponent(jLabel11)
//                                        .addComponent(jLabel15)
//                                        .addComponent(textGenero)
//                                        .addComponent(textDuracao))
//                                .addGap(24, 24, 24))
//        );
//
//        add(jPanel1);
//        jPanel1.setBounds(580, 110, 750, 430);
//
//        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Horario", "Horario", "Horario", "Horario" }));
//
//        add(jComboBox2);
//        jComboBox2.setBounds(1160, 590, 170, 30);
//
//        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
//        jLabel3.setForeground(new java.awt.Color(242, 27, 127));
//        jLabel3.setText("Sabado");
//        add(jLabel3);
//        jLabel3.setBounds(1160, 550, 120, 32);
//
//        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
//        jLabel4.setForeground(new java.awt.Color(242, 27, 127));
//        jLabel4.setText("Segunda");
//        add(jLabel4);
//        jLabel4.setBounds(50, 550, 120, 32);
//
//        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
//        jLabel5.setForeground(new java.awt.Color(242, 27, 127));
//        jLabel5.setText("Terça");
//        add(jLabel5);
//        jLabel5.setBounds(270, 550, 120, 32);
//
//        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
//        jLabel6.setForeground(new java.awt.Color(242, 27, 127));
//        jLabel6.setText("Quarta");
//        add(jLabel6);
//        jLabel6.setBounds(500, 550, 120, 32);
//
//        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
//        jLabel7.setForeground(new java.awt.Color(242, 27, 127));
//        jLabel7.setText("Quinta");
//        add(jLabel7);
//        jLabel7.setBounds(720, 550, 120, 32);
//
//        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
//        jLabel8.setForeground(new java.awt.Color(242, 27, 127));
//        jLabel8.setText("Sexta");
//        add(jLabel8);
//        jLabel8.setBounds(940, 550, 120, 32);
//
//        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Horario", "Horario", "Horario", "Horario" }));
//
//        add(jComboBox7);
//        jComboBox7.setBounds(40, 590, 170, 30);
//
//        jComboBox8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Horario", "Horario", "Horario", "Horario" }));
//
//        add(jComboBox8);
//        jComboBox8.setBounds(270, 590, 170, 30);
//
//        jComboBox9.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Horario", "Horario", "Horario", "Horario" }));
//
//        add(jComboBox9);
//        jComboBox9.setBounds(500, 590, 170, 30);
//
//        jComboBox10.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Horario", "Horario", "Horario", "Horario" }));
//
//        add(jComboBox10);
//        jComboBox10.setBounds(720, 590, 170, 30);
//
//        jComboBox11.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Horario", "Horario", "Horario", "Horario" }));
//
//        add(jComboBox11);
//        jComboBox11.setBounds(940, 590, 170, 30);
//
//        jLabel22.setText("jLabel2");
//
//        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
//        jPanel3.setLayout(jPanel3Layout);
//        jPanel3Layout.setHorizontalGroup(
//                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                        .addGroup(jPanel3Layout.createSequentialGroup()
//                                .addGap(607, 607, 607)
//                                .addComponent(jLabel22)
//                                .addContainerGap(736, Short.MAX_VALUE))
//        );
//        jPanel3Layout.setVerticalGroup(
//                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                        .addGroup(jPanel3Layout.createSequentialGroup()
//                                .addComponent(jLabel22)
//                                .addGap(0, 14, Short.MAX_VALUE))
//        );
//
//        add(jPanel3);
//        jPanel3.setBounds(0, 720, 1380, 30);
//    }// </editor-fold>//GEN-END:initComponents
//
//
//    // Variables declaration - do not modify//GEN-BEGIN:variables
//    private JPanel header;
//    private static JButton homeButton;
//    private static JButton nakabankButton;
//    private JComboBox<String> jComboBox10;
//    private JComboBox<String> jComboBox11;
//    private JComboBox<String> jComboBox2;
//    private JComboBox<String> jComboBox7;
//    private JComboBox<String> jComboBox8;
//    private JComboBox<String> jComboBox9;
//    private JLabel logo;
//    private JLabel jLabel10;
//    private JLabel jLabel11;
//    private JLabel jLabel12;
//    private JLabel jLabel13;
//    private JLabel jLabel14;
//    private JLabel jLabel15;
//    private static JLabel textDiretor;
//    private static JLabel textElenco;
//    private static JLabel textGenero;
//    private static JLabel textClassificacao;
//    private static JLabel lblCartaz;
//    private static JLabel textDistribuidora;
//    private static JLabel textDuracao;
//    private JLabel jLabel22;
//    private JLabel jLabel3;
//    private JLabel jLabel4;
//    private JLabel jLabel5;
//    private JLabel jLabel6;
//    private JLabel jLabel7;
//    private JLabel jLabel8;
//    private static JLabel lblSinopse;
//
//    public static JLabel getLblSinopse() {
//        return lblSinopse;
//    }
//
//    private JPanel jPanel1;
//    private JPanel jPanel2;
//    private JPanel jPanel3;
//    // End of variables declaration//GEN-END:variables
//
//
//    public static JLabel getTextDiretor() {
//        return textDiretor;
//    }
//
//    public static JLabel getTextElenco() {
//        return textElenco;
//    }
//
//    public static JLabel getTextGenero() {
//        return textGenero;
//    }
//
//    public static JLabel getTextClassificacao() {
//        return textClassificacao;
//    }
//
//    public static JLabel getLblCartaz() {
//        return lblCartaz;
//    }
//
//    public static JLabel getTextDistribuidora() {
//        return textDistribuidora;
//    }
//
//    public static JLabel getTextDuracao() {
//        return textDuracao;
//    }
//
//    public static JButton getHomeButton() {
//        return homeButton;
//    }
//
//    public static JButton getNakabankButton() {
//        return nakabankButton;
//    }
//}


import Entities.SessaoItem;
import sql_actions.Busca_assentos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tela_filme_escolhido extends javax.swing.JPanel {


    public Tela_filme_escolhido() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header = new javax.swing.JPanel();

        lblCartaz = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        sinopse = new javax.swing.JLabel();
        diretor = new javax.swing.JLabel();
        genero = new javax.swing.JLabel();
        elenco = new javax.swing.JLabel();
        classificacao = new javax.swing.JLabel();
        distribuicao = new javax.swing.JLabel();
        duracao = new javax.swing.JLabel();
        nomeDiretor = new javax.swing.JLabel();
        nomeElenco = new javax.swing.JLabel();
        nomeGenero = new javax.swing.JLabel();
        nomeClassificacao = new javax.swing.JLabel();
        nomeDistribuicao = new javax.swing.JLabel();
        tempoDuracao = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        botaoConfirmar = new javax.swing.JButton();
        Secao = new javax.swing.JLabel();
        comboSecoes = new javax.swing.JComboBox<>();

//        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
//        jPanel4.setLayout(jPanel4Layout);
//        jPanel4Layout.setHorizontalGroup(
//                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                        .addGap(0, 100, Short.MAX_VALUE)
//        );
//        jPanel4Layout.setVerticalGroup(
//                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                        .addGap(0, 100, Short.MAX_VALUE)
//        );

        setBackground(new java.awt.Color(13, 30, 64));
        setMinimumSize(new java.awt.Dimension(1366, 768));
        setName("Filme"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1366, 768));
        setLayout(null);

        header = Metodos_swing.header();
        add(header);
        header.setBounds(0, 0, 1520, 80);


        add(lblCartaz);
        lblCartaz.setBounds(70, 160, 183, 275);

        jPanel1.setBackground(new java.awt.Color(242, 240, 201));

        jPanel2.setBackground(new java.awt.Color(234, 216, 152));

        sinopse.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(sinopse, javax.swing.GroupLayout.DEFAULT_SIZE, 843, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(sinopse, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
                                .addContainerGap())
        );

        diretor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        diretor.setText("Diretor:");

        genero.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        genero.setText("Genero:");

        elenco.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        elenco.setText("Elenco:");

        classificacao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        classificacao.setText("Classificação:");

        distribuicao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        distribuicao.setText("Distribuidora:");

        duracao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        duracao.setText("Duração:");

        nomeDiretor.setText("nome do diretor aqui");

        nomeElenco.setText("elenco aqui");

        nomeGenero.setText("genero aqui");

        nomeClassificacao.setText("classificação aqui");

        nomeDistribuicao.setText("Distribuidora aqui");

        tempoDuracao.setText("duracao aqui");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(elenco, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(genero, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(nomeGenero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(nomeElenco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(diretor, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(nomeDiretor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(304, 304, 304)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(classificacao, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(nomeClassificacao, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(duracao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(distribuicao, javax.swing.GroupLayout.Alignment.LEADING))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(nomeDistribuicao, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                                                        .addComponent(tempoDuracao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(20, 20, 20))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(diretor)
                                        .addComponent(classificacao)
                                        .addComponent(nomeDiretor)
                                        .addComponent(nomeClassificacao))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(elenco)
                                        .addComponent(distribuicao)
                                        .addComponent(nomeElenco)
                                        .addComponent(nomeDistribuicao))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(genero)
                                        .addComponent(duracao)
                                        .addComponent(nomeGenero)
                                        .addComponent(tempoDuracao))
                                .addGap(24, 24, 24))
        );

        add(jPanel1);
        jPanel1.setBounds(430, 110, 900, 570);

        jLabel22.setText("jLabel2");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(607, 607, 607)
                                .addComponent(jLabel22)
                                .addContainerGap(736, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addGap(0, 34, Short.MAX_VALUE))
        );

        add(jPanel3);
        jPanel3.setBounds(0, 700, 1380, 50);

        botaoConfirmar.setBackground(new java.awt.Color(242, 240, 201));
        botaoConfirmar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        botaoConfirmar.setForeground(new java.awt.Color(242, 27, 127));
        botaoConfirmar.setText("Confirmar");
        botaoConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SessaoItem selectedItem = (SessaoItem) comboSecoes.getSelectedItem();
                if (selectedItem != null) {
                    int idSessao = selectedItem.getId();
                    Busca_assentos.Busca_assento(idSessao);
                } else {
                    System.out.println("Nenhuma sessão selecionada.");
                }
            }
        });
        add(botaoConfirmar);
        botaoConfirmar.setBounds(40, 630, 261, 41);

        Secao.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        Secao.setForeground(new java.awt.Color(242, 27, 127));
        Secao.setText("Sessões:");
        add(Secao);
        Secao.setBounds(30, 460, 90, 32);

//        comboSecoes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(comboSecoes);
        comboSecoes.setBounds(120, 470, 180, 30);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Secao;
    private javax.swing.JButton botaoConfirmar;
    private javax.swing.JLabel classificacao;
    private static javax.swing.JComboBox<SessaoItem> comboSecoes;
    private javax.swing.JLabel diretor;
    private javax.swing.JLabel distribuicao;
    private javax.swing.JLabel duracao;
    private javax.swing.JLabel elenco;
    private javax.swing.JLabel genero;
    private javax.swing.JPanel header;

    private static javax.swing.JLabel lblCartaz;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;

    private static javax.swing.JLabel nomeClassificacao;
    private static javax.swing.JLabel nomeDiretor;
    private static javax.swing.JLabel nomeDistribuicao;
    private static javax.swing.JLabel nomeElenco;
    private static javax.swing.JLabel nomeGenero;
    private static javax.swing.JLabel sinopse;
    private static javax.swing.JLabel tempoDuracao;
    // End of variables declaration//GEN-END:variables

    public static JLabel getLblCartaz() {
        return lblCartaz;
    }

    public static JLabel getNomeClassificacao() {
        return nomeClassificacao;
    }

    public static JLabel getNomeDiretor() {
        return nomeDiretor;
    }

    public static JLabel getNomeDistribuicao() {
        return nomeDistribuicao;
    }

    public static JLabel getNomeElenco() {
        return nomeElenco;
    }

    public static JLabel getNomeGenero() {
        return nomeGenero;
    }

    public static JLabel getSinopse() {
        return sinopse;
    }

    public static JLabel getTempoDuracao() {
        return tempoDuracao;
    }

    public static JComboBox<SessaoItem> getComboSecoes() {
        return comboSecoes;
    }
}