package ui_swing;

import run_main.Main;
import sql_actions.Delete;
import sql_actions.Read;
import sql_actions.Update;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tela_apagar_filmes extends JPanel {

    public Tela_apagar_filmes() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        header = new javax.swing.JPanel();
        footerr = new javax.swing.JPanel();
        Painel_Opcoes = new javax.swing.JPanel();
        textoPagamento = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        gerarLista = new javax.swing.JButton();
        TextoIDpedido = new javax.swing.JLabel();
        idpedidoaqui = new javax.swing.JTextField();
        cancelarPagamento = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        EfetuarPagamento = new javax.swing.JButton();

        setBackground(new java.awt.Color(13, 30, 64));
        setMinimumSize(new java.awt.Dimension(1366, 768));
        setPreferredSize(new java.awt.Dimension(1366, 768));
        setLayout(null);

        header = Metodos_swing.header();
        add(header);
        header.setBounds(0, 0, 1520, 80);

        footerr = Metodos_swing.footer();
        add(footerr);
        footerr.setBounds(0, 700, 1366, 50);

        Painel_Opcoes.setBackground(new java.awt.Color(242, 240, 201));
        Painel_Opcoes.setLayout(null);

        textoPagamento.setFont(new java.awt.Font("Sitka Small", 0, 36)); // NOI18N
        textoPagamento.setForeground(new java.awt.Color(242, 27, 127));
        textoPagamento.setText("                    Pagamento");
        Painel_Opcoes.add(textoPagamento);
        textoPagamento.setBounds(210, 16, 600, 70);

        jPanel1.setLayout(new java.awt.BorderLayout());
        Painel_Opcoes.add(jPanel1);
        jPanel1.setBounds(210, 90, 610, 330);

        gerarLista.setText("Gerar Lista de Pedidos");
        gerarLista.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Read.getMeusPedidos();
            }
        });
        Painel_Opcoes.add(gerarLista);
        gerarLista.setBounds(60, 460, 210, 23);

        TextoIDpedido.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TextoIDpedido.setForeground(new java.awt.Color(242, 27, 127));
        TextoIDpedido.setText("ID pedido:");
        Painel_Opcoes.add(TextoIDpedido);
        TextoIDpedido.setBounds(310, 460, 130, 30);

        Painel_Opcoes.add(idpedidoaqui);
        idpedidoaqui.setBounds(410, 460, 150, 30);

        cancelarPagamento.setText("Cancelar Pagamento");
        cancelarPagamento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Delete.pedido(Integer.parseInt(getIdpedidoaqui().getText()));
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        Painel_Opcoes.add(cancelarPagamento);
        cancelarPagamento.setBounds(770, 460, 180, 23);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(242, 27, 127));
        jLabel1.setText("NakaCoins: ");
        Painel_Opcoes.add(jLabel1);
        jLabel1.setBounds(810, 20, 150, 30);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(242, 27, 127));
        jLabel2.setText("jLabel2");
        Painel_Opcoes.add(jLabel2);
        jLabel2.setBounds(940, 20, 160, 30);

        EfetuarPagamento.setText("Efetuar Pagamento");
        EfetuarPagamento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Update.efetuarPagamento(Integer.parseInt(getIdpedidoaqui().getText()), Main.getId());
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        Painel_Opcoes.add(EfetuarPagamento);
        EfetuarPagamento.setBounds(570, 460, 180, 23);

        add(Painel_Opcoes);
        Painel_Opcoes.setBounds(160, 140, 1040, 510);
    }

    // Variables declaration - do not modify
    private javax.swing.JButton EfetuarPagamento;
    private javax.swing.JPanel Painel_Opcoes;
    private javax.swing.JLabel TextoIDpedido;
    private javax.swing.JButton cancelarPagamento;
    private javax.swing.JPanel footerr;
    private javax.swing.JButton gerarLista;
    private javax.swing.JPanel header;
    private javax.swing.JTextField idpedidoaqui;
    private javax.swing.JLabel jLabel1;
    private static javax.swing.JLabel jLabel2;
    private static javax.swing.JPanel jPanel1;
    private javax.swing.JLabel textoPagamento;
    // End of variables declaration


    public static JLabel getjLabel2() {
        return jLabel2;
    }

    public static JPanel getjPanel1() {
        return jPanel1;
    }

    public JTextField getIdpedidoaqui() {
        return idpedidoaqui;
    }
}
