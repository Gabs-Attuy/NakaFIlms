//package ui_swing;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
//import java.text.DateFormat;
//import java.util.Date;
//
//public class Tela_principal extends JPanel implements ActionListener {
//    private static JButton nakabank, home;
//    private static JLabel lbldata, nomeUser;
//    public static JButton getNakabank() {
//        return nakabank;
//    }
//
//    public static JLabel getNomeUser() {
//        return nomeUser;
//    }
//
//    public static JButton getHome() {
//        return home;
//    }
//
//    public Tela_principal(ActionListener listener) {
//            setBackground(Color.decode("#0D1E40"));
//            setLayout(new BorderLayout()); // Usar BorderLayout para colocar o painel no topo
//
//            JPanel header = new JPanel(new FlowLayout());
//            header.setOpaque(true);
//            header.setBackground(Color.decode("#F2F0C9"));
//            ImageIcon imageIcon = new ImageIcon("src/main/resources/Logo_header.png");
//            JLabel imageLabel = new JLabel(imageIcon);
//            header.add(imageLabel);
//            JLabel fantasma1 = new JLabel();
//            fantasma1.setPreferredSize(new Dimension(295, 56));
//            header.add(fantasma1);
//            JLabel fantasma2 = new JLabel();
//            fantasma2.setPreferredSize(new Dimension(295, 56));
//            header.add(fantasma2);
//            nakabank = Metodos_swing.cria_botao_header("NakaBank");
//            nakabank.addActionListener(listener);
//            header.add(nakabank);
//            JLabel fantasma3 = new JLabel();
//            fantasma3.setPreferredSize(new Dimension(148, 56));
//            header.add(fantasma3);
//            home = Metodos_swing.cria_botao_header("Home");
//            home.addActionListener(listener);
//            header.add(home);
//            nomeUser = new JLabel();
//            nomeUser.setPreferredSize(new Dimension(148, 56));
//            header.add(nomeUser);
//            ImageIcon usuario = new ImageIcon("src/main/resources/Usuario.png");
//            JLabel imageUsuario = new JLabel(usuario);
//            header.add(imageUsuario);
//            // Adiciona o painel de cabeçalho ao BorderLayout na parte superior
//            add(header, BorderLayout.NORTH);
//
//            JPanel footer = new JPanel(new FlowLayout());
//            footer.setOpaque(true);
//            footer.setBackground(Color.decode("#F2F0C9"));
//            lbldata = new JLabel();
//            mostrarData(lbldata);
//            lbldata.setForeground(Color.decode("#F21B7F"));
//            footer.add(lbldata);
//
//            // Adiciona o painel de rodapé ao BorderLayout na parte inferior
//            add(footer, BorderLayout.SOUTH);
//    }
//
//    public static void mostrarData(JLabel lbldata){
//        Date data = new Date();
//        DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
//        lbldata.setText(formatador.format(data));
//    }
//    @Override
//    public void actionPerformed(ActionEvent e) {
//
//    }
//}



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui_swing;

import javax.swing.*;
import java.awt.event.ActionListener;

public class Tela_principal extends JPanel {

    public Tela_principal(ActionListener listener) {
            header = new JPanel();
            nakabankButton = new JButton();
            homeButton = new JButton();
            logo = new JLabel();
            jLabel10 = new JLabel();
            jPanel20 = new JPanel();
            jPanel20.setLayout(new BoxLayout(jPanel20, BoxLayout.X_AXIS));
            jPanel19 = new JPanel();
            jLabel18 = new JLabel();
            jButton18 = new JButton();
            jPanel12 = new JPanel();
            jLabel12 = new JLabel();
            jButton12 = new JButton();
            jPanel13 = new JPanel();
            jLabel13 = new JLabel();
            jButton13 = new JButton();
            jPanel14 = new JPanel();
            jLabel14 = new JLabel();
            jButton14 = new JButton();
            jPanel15 = new JPanel();
            jLabel15 = new JLabel();
            jButton15 = new JButton();
            jPanel16 = new JPanel();
            jLabel16 = new JLabel();
            jButton16 = new JButton();

            setBackground(new java.awt.Color(13, 30, 64));
            setMinimumSize(new java.awt.Dimension(1366, 768));
            setPreferredSize(new java.awt.Dimension(1366, 768));
            setLayout(null);

            header = Metodos_swing.header(header, homeButton, nakabankButton, logo);
            add(header);
            homeButton.addActionListener(listener);
            nakabankButton.addActionListener(listener);
            header.setBounds(0, 0, 1520, 80);

            jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
            jLabel10.setForeground(new java.awt.Color(242, 27, 127));
            jLabel10.setText("Em cartaz:");
            add(jLabel10);
            jLabel10.setBounds(20, 100, 240, 48);

            jPanel20.setBackground(new java.awt.Color(13, 30, 64));

            jPanel19.setBackground(new java.awt.Color(13, 30, 64));
            jPanel19.setPreferredSize(new java.awt.Dimension(217, 297));

            jButton18.setText("Agendar");
            jButton18.addActionListener(listener);
            jLabel18.setIcon(new ImageIcon("src/main/resources/images 1.png"));
            javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
            jPanel19.setLayout(jPanel19Layout);
            jPanel19Layout.setHorizontalGroup(
                    jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                    .addGap(38, 38, 38)
                                    .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel18, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addContainerGap(40, Short.MAX_VALUE))
            );
            jPanel19Layout.setVerticalGroup(
                    jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                    .addGap(23, 23, 23)
                                    .addComponent(jLabel18, GroupLayout.PREFERRED_SIZE, 297, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                                    .addComponent(jButton18)
                                    .addGap(15, 15, 15))
            );

            jPanel20.add(jPanel19);
            jPanel19.setBounds(6, 0, 261, 371);

            jPanel12.setBackground(new java.awt.Color(13, 30, 64));
            jPanel12.setPreferredSize(new java.awt.Dimension(259, 302));

            jButton12.setText("Agendar");
            jLabel12.setIcon(new ImageIcon("src/main/resources/images 1.png"));
            javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
            jPanel12.setLayout(jPanel12Layout);
            jPanel12Layout.setHorizontalGroup(
                    jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                    .addGap(38, 38, 38)
                                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addContainerGap(40, Short.MAX_VALUE))
            );
            jPanel12Layout.setVerticalGroup(
                    jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                    .addGap(23, 23, 23)
                                    .addComponent(jLabel12)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                                    .addComponent(jButton12)
                                    .addGap(15, 15, 15))
            );

            jPanel20.add(jPanel12);
//            jPanel12.setBounds(279, 0, 261, 371);

            jPanel13.setBackground(new java.awt.Color(13, 30, 64));
            jPanel13.setPreferredSize(new java.awt.Dimension(259, 302));

            jButton13.setText("Agendar");

            javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
            jPanel13.setLayout(jPanel13Layout);
            jPanel13Layout.setHorizontalGroup(
                    jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                    .addGap(38, 38, 38)
                                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addContainerGap(40, Short.MAX_VALUE))
            );
            jPanel13Layout.setVerticalGroup(
                    jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                    .addGap(23, 23, 23)
                                    .addComponent(jLabel13)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                                    .addComponent(jButton13)
                                    .addGap(15, 15, 15))
            );

            jPanel20.add(jPanel13);
//            jPanel13.setBounds(558, 0, 261, 371);

            jPanel14.setBackground(new java.awt.Color(13, 30, 64));
            jPanel14.setPreferredSize(new java.awt.Dimension(259, 302));

            jButton14.setText("Agendar");

            javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
            jPanel14.setLayout(jPanel14Layout);
            jPanel14Layout.setHorizontalGroup(
                    jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                    .addGap(38, 38, 38)
                                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButton14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addContainerGap(40, Short.MAX_VALUE))
            );
            jPanel14Layout.setVerticalGroup(
                    jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                    .addGap(23, 23, 23)
                                    .addComponent(jLabel14)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                                    .addComponent(jButton14)
                                    .addGap(15, 15, 15))
            );

            jPanel20.add(jPanel14);
//            jPanel14.setBounds(825, 0, 261, 371);

            jPanel15.setBackground(new java.awt.Color(13, 30, 64));
            jPanel15.setPreferredSize(new java.awt.Dimension(259, 302));

            jButton15.setText("Agendar");

            javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
            jPanel15.setLayout(jPanel15Layout);
            jPanel15Layout.setHorizontalGroup(
                    jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                    .addGap(38, 38, 38)
                                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addContainerGap(40, Short.MAX_VALUE))
            );
            jPanel15Layout.setVerticalGroup(
                    jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                    .addGap(23, 23, 23)
                                    .addComponent(jLabel15)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                                    .addComponent(jButton15)
                                    .addGap(15, 15, 15))
            );

            jPanel20.add(jPanel15);
//            jPanel15.setBounds(1092, 0, 261, 371);

            jPanel16.setBackground(new java.awt.Color(13, 30, 64));
            jPanel16.setPreferredSize(new java.awt.Dimension(259, 302));

            jButton16.setText("jButton1");

            javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
            jPanel16.setLayout(jPanel16Layout);
            jPanel16Layout.setHorizontalGroup(
                    jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                    .addGap(38, 38, 38)
                                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButton16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addContainerGap(40, Short.MAX_VALUE))
            );
            jPanel16Layout.setVerticalGroup(
                    jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                    .addGap(23, 23, 23)
                                    .addComponent(jLabel16)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                                    .addComponent(jButton16)
                                    .addGap(15, 15, 15))
            );

            jPanel20.add(jPanel16);
//            jPanel16.setBounds(1359, 0, 261, 371);

        jScrollPane5 = new JScrollPane(jPanel20);
        jScrollPane5.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane5.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            add(jScrollPane5);
            jScrollPane5.setBounds(20, 150, 1290, 410);
    }

    private JPanel header;
    private JButton homeButton;
    private JButton jButton12;
    private JButton jButton13;
    private JButton jButton14;
    private JButton jButton15;
    private JButton jButton16;
    private static JButton jButton18;
    private JButton nakabankButton;
    private JLabel logo;
    private JLabel jLabel10;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel14;
    private JLabel jLabel15;
    private JLabel jLabel16;
    private JLabel jLabel18;
    private JPanel jPanel12;
    private JPanel jPanel13;
    private JPanel jPanel14;
    private JPanel jPanel15;
    private JPanel jPanel16;
    private JPanel jPanel19;
    private JPanel jPanel20;
    private JScrollPane jScrollPane5;
    // End of variables declaration//GEN-END:variables


    public static JButton getjButton18() {
        return jButton18;
    }
}