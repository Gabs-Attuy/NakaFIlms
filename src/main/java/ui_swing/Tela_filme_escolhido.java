package ui_swing;

import Entities.SessaoItem;
import run_main.Main;
import sql_actions.Read;
import validations.Verifica_idade;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Blob;
import java.sql.SQLException;

public class Tela_filme_escolhido extends javax.swing.JPanel {


    public Tela_filme_escolhido() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header = new javax.swing.JPanel();
        id_filme = -1;
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
        footer = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        botaoConfirmar = new javax.swing.JButton();
        Secao = new javax.swing.JLabel();
        comboSecoes = new javax.swing.JComboBox<>();

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
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(15, 15, 15)
                                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(25, 25, 25)
                                                .addComponent(diretor, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(41, 41, 41)
                                                .addComponent(nomeDiretor, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(38, 38, 38)
                                                .addComponent(classificacao, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(60, 60, 60)
                                                .addComponent(nomeClassificacao, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(25, 25, 25)
                                                .addComponent(elenco, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(41, 41, 41)
                                                .addComponent(nomeElenco, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(38, 38, 38)
                                                .addComponent(distribuicao)
                                                .addGap(63, 63, 63)
                                                .addComponent(nomeDistribuicao, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(25, 25, 25)
                                                .addComponent(genero, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(31, 31, 31)
                                                .addComponent(nomeGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(38, 38, 38)
                                                .addComponent(duracao, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(63, 63, 63)
                                                .addComponent(tempoDuracao, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(diretor)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(classificacao)
                                                .addComponent(nomeClassificacao))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(3, 3, 3)
                                                .addComponent(nomeDiretor)))
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(elenco)
                                        .addComponent(distribuicao)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(3, 3, 3)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(nomeElenco)
                                                        .addComponent(nomeDistribuicao))))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(genero)
                                        .addComponent(duracao)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(3, 3, 3)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(nomeGenero)
                                                        .addComponent(tempoDuracao)))))
        );
        add(jPanel1);
        jPanel1.setBounds(430, 110, 900, 570);

        footer = Metodos_swing.footer();
        add(footer);
        footer.setBounds(0, 700, 1366, 50);

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
                    Blob foto = selectedItem.getFoto();
                    String nome = selectedItem.getNome_filme();
                    try {
                        if(!Verifica_idade.verifica(Main.getId(), id_filme)){
                            JOptionPane.showMessageDialog(null, "Usuário não tem idade suficiente para prosseguir.");
                            setId_filme(-1);
                            Main.getCardLayout().show(Main.getCards(), "menu_principal");
                            return;
                        }
                        try {
                            Tela_selecao_lugar.getjLabel2().setIcon(Metodos_swing.recuperaFoto(foto));
                            Tela_selecao_lugar.getjLabel10().setText(nome);
//                            Tela_selecao_lugar.setValorIngresso(Read.);
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    Read.Busca_assento(idSessao);
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
        Secao.setBounds(40, 460, 120, 32);

        add(comboSecoes);
        comboSecoes.setBounds(40, 510, 180, 30);
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
    private javax.swing.JPanel footer;

    private static javax.swing.JLabel nomeClassificacao;
    private static javax.swing.JLabel nomeDiretor;
    private static javax.swing.JLabel nomeDistribuicao;
    private static javax.swing.JLabel nomeElenco;
    private static javax.swing.JLabel nomeGenero;
    private static javax.swing.JLabel sinopse;
    private static javax.swing.JLabel tempoDuracao;

    private static int id_filme;
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

    public static void setId_filme(int id_filme) {
        Tela_filme_escolhido.id_filme = id_filme;
    }

    public static int getId_filme() {
        return id_filme;
    }
}