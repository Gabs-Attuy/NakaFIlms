package ui_swing;

import run_main.Main;
import sql_actions.Read;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.Blob;
import java.sql.SQLException;

public class Metodos_swing {
    public static Dimension getScreensize(){
        return Toolkit.getDefaultToolkit().getScreenSize();
    }

    public static JButton cria_botao(String texto){
        JButton botao = new JButton(texto);
        botao.setBackground(Color.decode("#F2F0C9"));
        botao.setForeground(Color.decode("#F21B7F"));
        botao.setPreferredSize(new Dimension(250, 50));
        return botao;
    }

    public static JButton cria_botao_header(String texto){
        JButton botao = new JButton(texto);
        botao.setBackground(Color.decode("#0D1E40"));
        botao.setForeground(Color.decode("#F21B7F"));
        botao.setPreferredSize(new Dimension(295, 56));
        return botao;
    }

    public static JPanel cria_cartaz(String img, int image, int id){
        JPanel cartaz = new JPanel(new GridLayout(2, 1, 0, 10));
        cartaz.setPreferredSize(new Dimension(400, 800));
        cartaz.setOpaque(false);
        ImageIcon imgCartaz = new ImageIcon("src/main/resources/" + img);
        JLabel imgCartazLabel = new JLabel(imgCartaz);
        cartaz.add(imgCartazLabel);
        JButton botao = new JButton();

        return cartaz;
    }

    public static JPanel header(){
        JPanel header = new JPanel();
        JLabel logo = new JLabel();
        JButton nakabank = new JButton();
        JButton home = new JButton();
        header.setBackground(new java.awt.Color(242, 240, 201));
        logo.setIcon(new ImageIcon("src/main/resources/Logo_header.png"));
        nakabank.setBackground(new java.awt.Color(13, 30, 64));
        nakabank.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        nakabank.setForeground(new java.awt.Color(242, 27, 127));
        nakabank.setText("NakaBank");
        nakabank.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.getCardLayout().show(Main.getCards(), "cad_sessao");
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

        GroupLayout headerLayout = new GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
                headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(logo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 567, Short.MAX_VALUE)
                                .addComponent(nakabank, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(187, 187, 187))
        );
        headerLayout.setVerticalGroup(
                headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(headerLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(nakabank, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(15, Short.MAX_VALUE))
        );
        return header;
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
}
//labelUsuario = new JLabel("Usuário:");
//labelSenha = new JLabel("Senha:");
//campoUsuario = new JTextField(20);
//campoSenha = new JPasswordField(20);
//botaoLogin = new JButton("Login");
//
//// Adicionando listener ao botão de login
//        botaoLogin.addActionListener(this);
//
//// Criando um painel para organizar os componentes
//JPanel painel = new JPanel();
//        painel.setLayout(new GridLayout(3, 2));
//        painel.add(labelUsuario);
//        painel.add(campoUsuario);
//        painel.add(labelSenha);
//        painel.add(campoSenha);
//        painel.add(new JLabel()); // Espaço em branco
//        painel.add(botaoLogin);