package ui_swing;

import Entities.Nakabank;
import run_main.Main;
import sql_actions.Create;
import sql_actions.Read;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Random;

public class Metodos_swing {
    public static JButton cria_botao(String texto){
        JButton botao = new JButton(texto);
        botao.setBackground(Color.decode("#F2F0C9"));
        botao.setForeground(Color.decode("#F21B7F"));
        botao.setPreferredSize(new Dimension(250, 50));
        return botao;
    }

    public static JPanel header(){
        JPanel header = new JPanel();
        JLabel logo = new JLabel();
        JButton nakabank = new JButton();
        JButton home = new JButton();
        JButton sair = new JButton();
        JButton perfil = new JButton();

        header.setBackground(new java.awt.Color(242, 240, 201));
        logo.setIcon(new ImageIcon("src/main/resources/Logo_header.png"));
        nakabank.setBackground(new java.awt.Color(13, 30, 64));
        nakabank.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        nakabank.setForeground(new java.awt.Color(242, 27, 127));
        nakabank.setText("NakaBank");
        nakabank.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id_naka = Read.getNakabank(Main.getId());
                    if(id_naka == -1) {
                        int result = JOptionPane.showConfirmDialog(
                                null,
                                "Você não possuí uma conta NakaBank.\nDeseja criar uma conta NakaBank?",
                                "Criar conta NakaBank",
                                JOptionPane.YES_NO_OPTION
                        );
                        if(result == JOptionPane.YES_OPTION){
                            int senha = Integer.parseInt(JOptionPane.showInputDialog("Insira a sua senha NakaBank:"));
                            Random rm = new Random();
                            Nakabank n = new Nakabank(rm.nextInt(1,1000), senha, 50);
                            Create.Cad_conta_nakabank(n, Main.getId());
                        } else {
                            JOptionPane.showMessageDialog(null, "Cadastro cancelado.");
                        }
                    } else {
                        Read.getNakabankInforms(id_naka);
                        Main.getCardLayout().show(Main.getCards(), "nakabank");
                    }
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        home.setBackground(new java.awt.Color(13, 30, 64));
        home.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        home.setForeground(new java.awt.Color(242, 27, 127));
        home.setText("Home");
        home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.getCardLayout().show(Main.getCards(), "menu_principal");
            }
        });

        sair.setBackground(new java.awt.Color(13, 30, 64));
        sair.setFont(new java.awt.Font("Segoe UI", 0, 24));
        sair.setForeground(new java.awt.Color(242, 27, 127));
        sair.setText("Sair");
        sair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int sair = JOptionPane.showConfirmDialog(null, "Deseja mesmo sair?");
                if (sair == JOptionPane.YES_OPTION){
                    Main.setId(-1);
                    Tela_principal.getjPanel20().removeAll();
                    Main.getCardLayout().show(Main.getCards(), "inicio");
                }
            }
        });

        perfil.setBackground(new java.awt.Color(13, 30, 64));
        perfil.setFont(new java.awt.Font("Segoe UI", 0, 24));
        perfil.setForeground(new java.awt.Color(242, 27, 127));
        perfil.setText("Atualizar Perfil");
        perfil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Read.getUser();
                Main.getCardLayout().show(Main.getCards(), "atualiza_user");
            }
        });

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
                headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(logo)
                                .addGap(57, 57, 57)
                                .addComponent(nakabank, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(perfil, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(sair, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(170, Short.MAX_VALUE))
        );
        headerLayout.setVerticalGroup(
                headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(headerLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(nakabank, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(perfil, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(sair, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(15, Short.MAX_VALUE))
        );
        return header;
    }

    public static JPanel footer() {
        JPanel footer = new JPanel();
        JLabel data = new JLabel();
        footer.setBackground(new java.awt.Color(242, 240, 201));
        Metodos_swing.mostrarData(data);
        javax.swing.GroupLayout footerLayout = new javax.swing.GroupLayout(footer);
        footer.setLayout(footerLayout);
        footerLayout.setHorizontalGroup(
                footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(footerLayout.createSequentialGroup()
                                .addGap(683, 683, 683)
                                .addComponent(data)
                                .addContainerGap(683, Short.MAX_VALUE))
        );
        footerLayout.setVerticalGroup(
                footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(footerLayout.createSequentialGroup()
                                .addComponent(data)
                                .addGap(0, 25, Short.MAX_VALUE))
        );
        return footer;
    }

    public static Icon recuperaFoto(Blob foto) throws SQLException {
        byte[] img = foto.getBytes(1, (int) foto.length());
        BufferedImage imagem = null;
        try {
            imagem = ImageIO.read(new ByteArrayInputStream(img));
        } catch (Exception e) {
            System.out.println(e);
        }
        assert imagem != null;
        ImageIcon icone = new ImageIcon(imagem);
        Icon cartaz = new ImageIcon(icone.getImage().getScaledInstance(217, 297, Image.SCALE_SMOOTH));
        return cartaz;
    }

    public static void cartaz(int id, Blob foto) throws SQLException {
        JPanel panel = new JPanel();
        JLabel label = new JLabel();
        JButton botao = new JButton();
        label.setSize(217, 297);

        panel.setBackground(new java.awt.Color(13, 30, 64));
        panel.setPreferredSize(new java.awt.Dimension(217, 297));

        botao.setText("Agendar");
        botao.setActionCommand(String.valueOf(id));
        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String actionCommand = e.getActionCommand();
                int id_filme = Integer.parseInt(actionCommand);
                try {
                    Read.getFilme(id_filme);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                Tela_filme_escolhido.setId_filme(id_filme);
                Main.getCardLayout().show(Main.getCards(), "filme_escolhido");
            }
        });
        label.setIcon(recuperaFoto(foto));
        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
                panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelLayout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(label, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(botao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(40, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
                panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(label, GroupLayout.PREFERRED_SIZE, 297, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                                .addComponent(botao)
                                .addGap(15, 15, 15))
        );
        Tela_principal.getjPanel20().add(panel);
    }

    public static void mostrarData(JLabel lbldata){
        Date data = new Date();
        DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
        lbldata.setText(formatador.format(data));
    }

    private static MaskFormatter setMascara(String mascara){
        MaskFormatter mask = null;
        try{
            mask = new MaskFormatter(mascara);
        }catch(java.text.ParseException ex){}
        return mask;
    }
    public static JFormattedTextField criarCaixaTextoFormatada(String mascara) {
        JFormattedTextField texto = new JFormattedTextField(setMascara(mascara));
        texto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        return texto;
    }
}