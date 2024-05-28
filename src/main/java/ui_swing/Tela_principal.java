package ui_swing;

import javax.swing.*;

public class Tela_principal extends JPanel {

    public Tela_principal() {
            header = new JPanel();

            jLabel10 = new JLabel();
            jPanel20 = new JPanel();
            jPanel20.setLayout(new BoxLayout(jPanel20, BoxLayout.X_AXIS));

            setBackground(new java.awt.Color(13, 30, 64));
            setMinimumSize(new java.awt.Dimension(1366, 768));
            setPreferredSize(new java.awt.Dimension(1366, 768));
            setLayout(null);

            header = Metodos_swing.header();
            add(header);
            header.setBounds(0, 0, 1520, 80);

            footer = Metodos_swing.footer();
            add(footer);
            footer.setBounds(0, 700, 1366, 50);

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
    private JLabel jLabel10;
    private JPanel footer;

    private static JPanel jPanel20;
    private JScrollPane jScrollPane5;
    // End of variables declaration//GEN-END:variables

    public static JPanel getjPanel20() {
        return jPanel20;
    }
}