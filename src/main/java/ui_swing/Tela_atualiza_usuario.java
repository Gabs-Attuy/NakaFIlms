package ui_swing;

import sql_actions.Delete;
import sql_actions.Update;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tela_atualiza_usuario extends JPanel {
    public Tela_atualiza_usuario(){
        initComponents();
    }
    private void initComponents() {

        footer = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        PainelMeio = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        dataNascimentoaqui = new javax.swing.JLabel();
        TextoNome = new javax.swing.JLabel();
        textoData = new javax.swing.JLabel();
        TextoCPF = new javax.swing.JLabel();
        NomeAqui = new javax.swing.JLabel();
        CPFaqui = new javax.swing.JLabel();
        textoRG = new javax.swing.JLabel();
        RGaqui = new javax.swing.JLabel();
        EmailAqui = new javax.swing.JTextField();
        textoTelefone = new javax.swing.JLabel();
        NumeroTelefone1 = Metodos_swing.criarCaixaTextoFormatada("(##)#####-####");
        textoEmail = new javax.swing.JLabel();
        Senha = new javax.swing.JPasswordField();
        textoSenha = new javax.swing.JLabel();
        botaoAlterarSenha = new javax.swing.JButton();
        botaoAlterarNumero = new javax.swing.JButton();
        botaoAlterarEmail = new javax.swing.JButton();
        botaoExcluirUsuario = new JButton();

        botaoExcluirUsuario.setBackground(new java.awt.Color(255, 0, 0));
        botaoExcluirUsuario.setText("Excluir Perfil");
        botaoExcluirUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirmaexclusao = JOptionPane.showConfirmDialog(null, "Deseja mesmo excluir sua conta NakaFilms?");
                if (confirmaexclusao == JOptionPane.YES_OPTION) {
                    try {
                        Delete.usuario();
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
        PainelMeio.add(botaoExcluirUsuario);
        botaoExcluirUsuario.setBounds(270, 390, 240, 23);

        setBackground(new java.awt.Color(13, 30, 64));
        setMinimumSize(new java.awt.Dimension(1366, 768));

        header = Metodos_swing.header();
        add(header);
        header.setBounds(0, 0, 1520, 80);

        footer = Metodos_swing.footer();
        add(footer);
        footer.setBounds(0, 700, 1366, 50);

        PainelMeio.setBackground(new java.awt.Color(242, 240, 201));
        PainelMeio.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(242, 27, 127));
        jLabel1.setText("Perfil");
        PainelMeio.add(jLabel1);
        jLabel1.setBounds(330, 20, 213, 45);

        dataNascimentoaqui.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        PainelMeio.add(dataNascimentoaqui);
        dataNascimentoaqui.setBounds(450, 130, 280, 40);

        TextoNome.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TextoNome.setForeground(new java.awt.Color(242, 27, 127));
        TextoNome.setText("Nome:");
        PainelMeio.add(TextoNome);
        TextoNome.setBounds(90, 90, 90, 40);

        textoData.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textoData.setForeground(new java.awt.Color(242, 27, 127));
        textoData.setText("Data de nascimento:");
        PainelMeio.add(textoData);
        textoData.setBounds(450, 90, 270, 40);

        TextoCPF.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TextoCPF.setForeground(new java.awt.Color(242, 27, 127));
        TextoCPF.setText("CPF:");
        PainelMeio.add(TextoCPF);
        TextoCPF.setBounds(90, 140, 80, 40);

        NomeAqui.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        PainelMeio.add(NomeAqui);
        NomeAqui.setBounds(180, 90, 250, 40);

        CPFaqui.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        PainelMeio.add(CPFaqui);
        CPFaqui.setBounds(180, 140, 250, 40);

        textoRG.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textoRG.setForeground(new java.awt.Color(242, 27, 127));
        textoRG.setText("RG:");
        PainelMeio.add(textoRG);
        textoRG.setBounds(90, 180, 90, 40);

        RGaqui.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        PainelMeio.add(RGaqui);
        RGaqui.setBounds(180, 180, 250, 40);
        PainelMeio.add(EmailAqui);
        EmailAqui.setBounds(190, 280, 200, 22);

        textoTelefone.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textoTelefone.setForeground(new java.awt.Color(242, 27, 127));
        textoTelefone.setText("Telefone:");
        PainelMeio.add(textoTelefone);
        textoTelefone.setBounds(90, 220, 110, 40);
        PainelMeio.add(NumeroTelefone1);
        NumeroTelefone1.setBounds(190, 230, 200, 22);

        textoEmail.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textoEmail.setForeground(new java.awt.Color(242, 27, 127));
        textoEmail.setText("E-mail:");
        PainelMeio.add(textoEmail);
        textoEmail.setBounds(90, 270, 110, 40);
        PainelMeio.add(Senha);
        Senha.setBounds(190, 330, 200, 22);

        textoSenha.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textoSenha.setForeground(new java.awt.Color(242, 27, 127));
        textoSenha.setText("Senha:");
        PainelMeio.add(textoSenha);
        textoSenha.setBounds(90, 320, 110, 40);

        botaoAlterarSenha.setText("Alterar Senha");
        botaoAlterarSenha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Update.senha(getSenha().getText());
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        PainelMeio.add(botaoAlterarSenha);
        botaoAlterarSenha.setBounds(410, 330, 250, 23);

        botaoAlterarNumero.setText("Alterar numero de telefone");
        botaoAlterarNumero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Update.telefone(getNumeroTelefone1().getText());
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        PainelMeio.add(botaoAlterarNumero);
        botaoAlterarNumero.setBounds(410, 230, 250, 23);

        botaoAlterarEmail.setText("Alterar E-mail");
        botaoAlterarEmail.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Update.email(getEmailAqui().getText());
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        PainelMeio.add(botaoAlterarEmail);
        botaoAlterarEmail.setBounds(410, 280, 250, 23);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(300, 300, 300)
                                .addComponent(PainelMeio, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(130, 130, 130)
                                .addComponent(PainelMeio, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(130, 130, 130))
        );
    }// </editor-fold>


    // Variables declaration - do not modify
    private static javax.swing.JLabel CPFaqui;
    private static javax.swing.JTextField EmailAqui;
    private static javax.swing.JLabel NomeAqui;
    private static javax.swing.JFormattedTextField NumeroTelefone1;
    private javax.swing.JPanel PainelMeio;
    private static javax.swing.JLabel RGaqui;
    private static javax.swing.JPasswordField Senha;
    private javax.swing.JLabel TextoCPF;
    private javax.swing.JLabel TextoNome;
    private javax.swing.JButton botaoAlterarEmail;
    private javax.swing.JButton botaoAlterarNumero;
    private javax.swing.JButton botaoAlterarSenha;
    private static javax.swing.JLabel dataNascimentoaqui;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel footer;
    private javax.swing.JPanel header;
    private javax.swing.JLabel textoData;
    private javax.swing.JLabel textoEmail;
    private javax.swing.JLabel textoRG;
    private javax.swing.JLabel textoSenha;
    private javax.swing.JLabel textoTelefone;
    private javax.swing.JButton botaoExcluirUsuario;
    // End of variables declaration


    public static JTextField getEmailAqui() {
        return EmailAqui;
    }

    public static JFormattedTextField getNumeroTelefone1() {
        return NumeroTelefone1;
    }

    public static JPasswordField getSenha() {
        return Senha;
    }

    public static JLabel getCPFaqui() {
        return CPFaqui;
    }

    public static JLabel getNomeAqui() {
        return NomeAqui;
    }

    public static JLabel getRGaqui() {
        return RGaqui;
    }

    public static JLabel getDataNascimentoaqui() {
        return dataNascimentoaqui;
    }
}
