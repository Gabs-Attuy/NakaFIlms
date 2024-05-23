package ui_swing;

import javax.swing.*;
import java.awt.event.ActionListener;

public class Tela_filme_escolhido extends JPanel {


    public Tela_filme_escolhido(ActionListener listener) {
        initComponents(listener);
    }


    @SuppressWarnings("unchecked")
    private void initComponents(ActionListener listener) {

        header = new JPanel();
        nakabankButton = new JButton();
        homeButton = new JButton();
        logo = new JLabel();
        jLabel2 = new JLabel();
        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jLabel9 = new JLabel();
        jLabel10 = new JLabel();
        jLabel11 = new JLabel();
        jLabel12 = new JLabel();
        jLabel13 = new JLabel();
        jLabel14 = new JLabel();
        jLabel15 = new JLabel();
        jLabel16 = new JLabel();
        jLabel17 = new JLabel();
        jLabel18 = new JLabel();
        jLabel19 = new JLabel();
        jLabel20 = new JLabel();
        jLabel21 = new JLabel();
        jComboBox2 = new JComboBox<>();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        jComboBox7 = new JComboBox<>();
        jComboBox8 = new JComboBox<>();
        jComboBox9 = new JComboBox<>();
        jComboBox10 = new JComboBox<>();
        jComboBox11 = new JComboBox<>();
        jPanel3 = new JPanel();
        jLabel22 = new JLabel();

        setBackground(new java.awt.Color(13, 30, 64));
        setMinimumSize(new java.awt.Dimension(1366, 768));
        setName("Filme"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1366, 768));
        setLayout(null);

        header = Metodos_swing.header(header, homeButton, nakabankButton, logo);
        add(header);
        header.setBounds(0, 0, 1520, 80);
        homeButton.addActionListener(listener);
        nakabankButton.addActionListener(listener);
        jLabel2.setIcon(new javax.swing.ImageIcon("src/main/resources/images 1.png")); // NOI18N
        add(jLabel2);
        jLabel2.setBounds(170, 110, 183, 275);

        jPanel1.setBackground(new java.awt.Color(242, 240, 201));

        jPanel2.setBackground(new java.awt.Color(234, 216, 152));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setText("<HTML>Otávio é um militante sindical que organiza um movimento grevista para resistir às práticas exploradoras de uma metalúrgica,<br>\n na qual seu filho Tião também trabalha. Mas, com a namorada grávida, o jovem resiste à greve para não perder o emprego.</HTML>");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 654, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(178, Short.MAX_VALUE))
        );

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Diretor:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Genero:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Elenco:");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Classificação:");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Distribuidora:");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("Duração:");

        jLabel16.setText("Nome do diretor");

        jLabel17.setText("elenco do filme");

        jLabel18.setText("genero do filme");

        jLabel19.setText("Classificação");

        jLabel20.setText("Distribuidora");

        jLabel21.setText("Duração");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(37, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel16))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel17))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel18)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel20)
                                                        .addComponent(jLabel21)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel19)))
                                .addGap(179, 179, 179))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel10)
                                        .addComponent(jLabel13)
                                        .addComponent(jLabel16)
                                        .addComponent(jLabel19))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel12)
                                        .addComponent(jLabel14)
                                        .addComponent(jLabel17)
                                        .addComponent(jLabel20))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel11)
                                        .addComponent(jLabel15)
                                        .addComponent(jLabel18)
                                        .addComponent(jLabel21))
                                .addGap(24, 24, 24))
        );

        add(jPanel1);
        jPanel1.setBounds(580, 110, 750, 430);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Horario", "Horario", "Horario", "Horario" }));

        add(jComboBox2);
        jComboBox2.setBounds(1160, 590, 170, 30);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(242, 27, 127));
        jLabel3.setText("Sabado");
        add(jLabel3);
        jLabel3.setBounds(1160, 550, 120, 32);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(242, 27, 127));
        jLabel4.setText("Segunda");
        add(jLabel4);
        jLabel4.setBounds(50, 550, 120, 32);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(242, 27, 127));
        jLabel5.setText("Terça");
        add(jLabel5);
        jLabel5.setBounds(270, 550, 120, 32);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(242, 27, 127));
        jLabel6.setText("Quarta");
        add(jLabel6);
        jLabel6.setBounds(500, 550, 120, 32);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(242, 27, 127));
        jLabel7.setText("Quinta");
        add(jLabel7);
        jLabel7.setBounds(720, 550, 120, 32);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(242, 27, 127));
        jLabel8.setText("Sexta");
        add(jLabel8);
        jLabel8.setBounds(940, 550, 120, 32);

        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Horario", "Horario", "Horario", "Horario" }));

        add(jComboBox7);
        jComboBox7.setBounds(40, 590, 170, 30);

        jComboBox8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Horario", "Horario", "Horario", "Horario" }));

        add(jComboBox8);
        jComboBox8.setBounds(270, 590, 170, 30);

        jComboBox9.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Horario", "Horario", "Horario", "Horario" }));

        add(jComboBox9);
        jComboBox9.setBounds(500, 590, 170, 30);

        jComboBox10.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Horario", "Horario", "Horario", "Horario" }));

        add(jComboBox10);
        jComboBox10.setBounds(720, 590, 170, 30);

        jComboBox11.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Horario", "Horario", "Horario", "Horario" }));

        add(jComboBox11);
        jComboBox11.setBounds(940, 590, 170, 30);

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
                                .addGap(0, 14, Short.MAX_VALUE))
        );

        add(jPanel3);
        jPanel3.setBounds(0, 720, 1380, 30);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JPanel header;
    private static JButton homeButton;
    private static JButton nakabankButton;
    private JComboBox<String> jComboBox10;
    private JComboBox<String> jComboBox11;
    private JComboBox<String> jComboBox2;
    private JComboBox<String> jComboBox7;
    private JComboBox<String> jComboBox8;
    private JComboBox<String> jComboBox9;
    private JLabel logo;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel14;
    private JLabel jLabel15;
    private JLabel jLabel16;
    private JLabel jLabel17;
    private JLabel jLabel18;
    private JLabel jLabel19;
    private JLabel jLabel2;
    private JLabel jLabel20;
    private JLabel jLabel21;
    private JLabel jLabel22;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    // End of variables declaration//GEN-END:variables


    public static JButton getHomeButton() {
        return homeButton;
    }

    public static JButton getNakabankButton() {
        return nakabankButton;
    }
}