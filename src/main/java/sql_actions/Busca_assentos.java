package sql_actions;

import run_main.Main;
import ui_swing.Metodos_swing;
import ui_swing.Tela_filme_escolhido;
import ui_swing.Tela_selecao_lugar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

public class Busca_assentos {
    public static void Busca_assento(int sessao_id){
        HashMap<JCheckBox, Integer> assentoMap = new HashMap<>();

        try {
            SqlConnection conection = new SqlConnection();
            Connection cn = conection.openDB();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(
                    "SELECT * FROM assento WHERE FK_sessao_id = '" + sessao_id + "'"
            );
            if(rs != null) {
                Tela_selecao_lugar.getPainelCheckBox().removeAll();
                while(rs.next()) {
                    int id = rs.getInt("id");
                    boolean ocupado = rs.getBoolean(4);
                    // Criar JCheckBox para o assento
                    JCheckBox checkBox = new JCheckBox();

                    if(ocupado) {
                        checkBox.setSelected(true);
                        checkBox.setEnabled(false);
                    }

                    checkBox.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                        }
                    });
                    // Adicionar JCheckBox ao painel
                    Tela_selecao_lugar.getPainelCheckBox().add(checkBox);

                    // Mapear JCheckBox para o ID do assento
                    assentoMap.put(checkBox, id);
                }
            }
            // Percorrer os resultados da consulta e criar JCheckBox para cada assento
            // Fechar recursos
            assert rs != null;
            rs.close();
            st.close();
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Main.getCardLayout().show(Main.getCards(), "selecao_lugar");
    }
}
