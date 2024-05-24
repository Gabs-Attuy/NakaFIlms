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
//    public static void mostrarData(JLabel lbldata){
//        Date data = new Date();
//        DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
//        lbldata.setText(formatador.format(data));
//    }

package ui_swing;

import javax.swing.*;
import java.awt.event.ActionListener;

public class Tela_principal extends JPanel {

    public Tela_principal() {
            header = new JPanel();
            nakabankButton = new JButton();
            homeButton = new JButton();
            jLabel10 = new JLabel();
            jPanel20 = new JPanel();
            jPanel20.setLayout(new BoxLayout(jPanel20, BoxLayout.X_AXIS));

            jButton18 = new JButton();

            setBackground(new java.awt.Color(13, 30, 64));
            setMinimumSize(new java.awt.Dimension(1366, 768));
            setPreferredSize(new java.awt.Dimension(1366, 768));
            setLayout(null);

            header = Metodos_swing.header();
            add(header);
            header.setBounds(0, 0, 1520, 80);

            jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
            jLabel10.setForeground(new java.awt.Color(242, 27, 127));
            jLabel10.setText("Em cartaz:");
            add(jLabel10);
            jLabel10.setBounds(20, 100, 240, 48);

            jPanel20.setBackground(new java.awt.Color(13, 30, 64));

        jScrollPane5 = new JScrollPane(jPanel20);
        jScrollPane5.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane5.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            add(jScrollPane5);
            jScrollPane5.setBounds(20, 150, 1290, 410);
    }

    private JPanel header;
    private static JButton homeButton;

    private static JButton jButton18;
    private static JButton nakabankButton;
    private JLabel jLabel10;

    private static JPanel jPanel20;
    private JScrollPane jScrollPane5;
    // End of variables declaration//GEN-END:variables


    public static JPanel getjPanel20() {
        return jPanel20;
    }

    public static JButton getHomeButton() {
        return homeButton;
    }

    public static JButton getNakabankButton() {
        return nakabankButton;
    }

    public static JButton getjButton18() {
        return jButton18;
    }
}