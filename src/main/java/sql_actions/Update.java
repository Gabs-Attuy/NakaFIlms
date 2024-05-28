package sql_actions;

import run_main.Main;
import ui_swing.Tela_nakabank;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Update {
    public static void setSenhaNakabank(int senhaAtual, int senhaNova) throws Exception {
        try {
            SqlConnection conection = new SqlConnection();
            Connection cn = conection.openDB();
            // Usando PreparedStatement para evitar injeção de SQL e problemas de sintaxe
            int id_naka = Read.getNakabank(Main.getId());
            int atualSenha = Read.getSenhaNakabank(id_naka);
            if(senhaAtual == atualSenha){
                PreparedStatement ps = cn.prepareStatement("UPDATE nakabank SET codigo_seguranca = ? WHERE id = ?");
                ps.setInt(1, senhaNova);
                ps.setInt(2, id_naka);

                int linhasAfetadas = ps.executeUpdate();
                if (linhasAfetadas > 0) {
                    JOptionPane.showMessageDialog(null, "Senha alterada com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Falha ao alterar senha.");
                }
                ps.close();
            }
            cn.close();
        } catch (SQLException e) {
            throw new Exception("Falha ao acessar base de dados.\n" + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void Depositar(int id, double valor) throws Exception {
        try {
            SqlConnection conection = new SqlConnection();
            Connection cn = conection.openDB();
            // Usando PreparedStatement para evitar injeção de SQL e problemas de sintaxe
            PreparedStatement ps = cn.prepareStatement("UPDATE nakabank SET saldo = saldo + ? WHERE id = ?");
            ps.setDouble(1, valor);
            ps.setInt(2, id);

            int linhasAfetadas = ps.executeUpdate();
            if (linhasAfetadas > 0) {
                JOptionPane.showMessageDialog(null, "Depósito concluído!");
                Tela_nakabank.getCampoParaValorDepositar().setText(null);
                Tela_nakabank.atualizarValorSaldo();
            }

            ps.close();
            cn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao efetuar depósito: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            Tela_nakabank.getCampoParaValorDepositar().setText(null);
        }
    }

    public static void Transferir(int id_origem, int cod_seguranca, int n_conta, double valor) {
        String sqlSubtrair = "UPDATE nakabank SET saldo = saldo - ? WHERE id = ? AND codigo_seguranca = ?";
        String sqlAdicionar = "UPDATE nakabank SET saldo = saldo + ? WHERE n_conta = ?";
        String sqlVerificarSaldo = "SELECT saldo FROM nakabank WHERE id = ? AND codigo_seguranca = ?";
        String sqlVerificarConta = "SELECT COUNT(*) FROM nakabank WHERE n_conta = ?";

        PreparedStatement pstmtSubtrair = null;
        PreparedStatement pstmtAdicionar = null;
        PreparedStatement pstmtVerificarSaldo = null;
        PreparedStatement pstmtVerificarConta = null;
        Connection cn = null;

        try {
            SqlConnection connection = new SqlConnection();
            cn = connection.openDB();
            cn.setAutoCommit(false);  // Iniciar transação

            // Verificar saldo da conta de origem
            pstmtVerificarSaldo = cn.prepareStatement(sqlVerificarSaldo);
            pstmtVerificarSaldo.setInt(1, id_origem);
            pstmtVerificarSaldo.setInt(2, cod_seguranca);
            ResultSet rsSaldo = pstmtVerificarSaldo.executeQuery();
            if (!rsSaldo.next()) {
                JOptionPane.showMessageDialog(null, "Conta de origem não encontrada ou código de segurança inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
                Tela_nakabank.clearFields();
                return;
            }

            double saldoAtual = rsSaldo.getDouble("saldo");
            if (saldoAtual < valor) {
                JOptionPane.showMessageDialog(null, "Saldo insuficiente.", "Erro", JOptionPane.ERROR_MESSAGE);
                Tela_nakabank.clearFields();
                return;
            }

            // Verificar existência da conta de destino
            pstmtVerificarConta = cn.prepareStatement(sqlVerificarConta);
            pstmtVerificarConta.setInt(1, n_conta);
            ResultSet rsConta = pstmtVerificarConta.executeQuery();
            rsConta.next();
            if (rsConta.getInt(1) == 0) {
                JOptionPane.showMessageDialog(null, "Conta de destino inválida.", "Erro", JOptionPane.ERROR_MESSAGE);
                Tela_nakabank.clearFields();
                return;
            }

            // Preparar instruções SQL
            pstmtSubtrair = cn.prepareStatement(sqlSubtrair);
            pstmtAdicionar = cn.prepareStatement(sqlAdicionar);

            // Definir parâmetros para subtrair saldo da conta de origem
            pstmtSubtrair.setDouble(1, valor);
            pstmtSubtrair.setInt(2, id_origem);
            pstmtSubtrair.setInt(3, cod_seguranca);
            pstmtSubtrair.executeUpdate();

            // Definir parâmetros para adicionar saldo à conta de destino
            pstmtAdicionar.setDouble(1, valor);
            pstmtAdicionar.setInt(2, n_conta);
            pstmtAdicionar.executeUpdate();

            // Confirmar transação
            cn.commit();
            JOptionPane.showMessageDialog(null, "Transferência realizada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            Tela_nakabank.atualizarValorSaldo();
            Tela_nakabank.clearFields();
        } catch (SQLException e) {
            if (cn != null) {
                try {
                    cn.rollback();  // Reverter transação em caso de erro
                    JOptionPane.showMessageDialog(null, "Transação revertida devido a erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (pstmtSubtrair != null) pstmtSubtrair.close();
                if (pstmtAdicionar != null) pstmtAdicionar.close();
                if (pstmtVerificarSaldo != null) pstmtVerificarSaldo.close();
                if (pstmtVerificarConta != null) pstmtVerificarConta.close();
                if (cn != null) cn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void efetuarPagamento(int pedidoId, int usuarioId) throws Exception {
        Connection cn = null;
        PreparedStatement psUpdateSaldo = null;
        PreparedStatement psUpdatePedido = null;
        ResultSet rs = null;

        try {
            SqlConnection conection = new SqlConnection();
            cn = conection.openDB();

            // Iniciar transação
            cn.setAutoCommit(false);

            // Verificar o saldo do usuário
            String querySaldo = "SELECT saldo FROM nakabank WHERE id = (SELECT FK_nakabank_id FROM usuario WHERE id = ?)";
            psUpdateSaldo = cn.prepareStatement(querySaldo);
            psUpdateSaldo.setInt(1, usuarioId);
            rs = psUpdateSaldo.executeQuery();

            if (rs.next()) {
                double saldo = rs.getDouble("saldo");
                System.out.println("Saldo atual: " + saldo);

                // Obter o valor do pedido
                String queryPedido = "SELECT valor FROM pedido_novo WHERE id = ?";
                psUpdatePedido = cn.prepareStatement(queryPedido);
                psUpdatePedido.setInt(1, pedidoId);
                ResultSet rsPedido = psUpdatePedido.executeQuery();

                if (rsPedido.next()) {
                    double valorPedido = rsPedido.getDouble("valor");
                    System.out.println("Valor do pedido: " + valorPedido);

                    // Verificar se o saldo é suficiente
                    if (saldo >= valorPedido) {
                        // Atualizar o saldo do usuário
                        String updateSaldo = "UPDATE nakabank SET saldo = saldo - ? WHERE id = (SELECT FK_nakabank_id FROM usuario WHERE id = ?)";
                        psUpdateSaldo = cn.prepareStatement(updateSaldo);
                        psUpdateSaldo.setDouble(1, valorPedido);
                        psUpdateSaldo.setInt(2, usuarioId);
                        int update = psUpdateSaldo.executeUpdate();
                        if(update > 0){
                            System.out.println("Saldo atualizado.");
                        }
                        // Atualizar o status do pedido
                        String updatePedido = "UPDATE pedido_novo SET pago = ? WHERE id = ?";
                        psUpdatePedido = cn.prepareStatement(updatePedido);
                        psUpdatePedido.setBoolean(1, true);
                        psUpdatePedido.setInt(2, pedidoId);
                        int update2 = psUpdatePedido.executeUpdate();
                        if(update2 > 0){
                            System.out.println("Status do pedido atualizado.");
                        }

                        // Confirmar a transação
                        cn.commit();

                        JOptionPane.showMessageDialog(null, "Pagamento efetuado com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Saldo insuficiente.");
                    }
                } else {
                    throw new Exception("Pedido não encontrado.");
                }
            } else {
                throw new Exception("Conta Nakabank não encontrada para o usuário.");
            }
        } catch (SQLException e) {
            if (cn != null) {
                try {
                    // Reverter transação em caso de erro
                    cn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
            throw new Exception("Falha ao processar pagamento.\n" + e.getMessage());
        } finally {
            // Fechar recursos
            if (rs != null) rs.close();
            if (psUpdateSaldo != null) psUpdateSaldo.close();
            if (psUpdatePedido != null) psUpdatePedido.close();
            if (cn != null) cn.close();
        }
    }

    public static void telefone(String telefone) throws Exception {
        try {
            SqlConnection conection = new SqlConnection();
            Connection cn = conection.openDB();
            // Usando PreparedStatement para evitar injeção de SQL e problemas de sintaxe
            PreparedStatement ps = cn.prepareStatement("UPDATE usuario SET telefone = ? WHERE id = ?");
            ps.setString(1, telefone);
            ps.setInt(2, Main.getId());

            int linhasAfetadas = ps.executeUpdate();
            if (linhasAfetadas > 0) {
                JOptionPane.showMessageDialog(null, "Número de telefone alterado!");
            } else {
                JOptionPane.showMessageDialog(null, "Falha ao alterar o número do telefone.");
            }

            ps.close();
            cn.close();
        } catch (SQLException e) {
            throw new Exception("Falha ao acessar base de dados.\n" + e.getMessage());
        }
    }

    public static void senha(String senha) throws Exception {
        try {
            SqlConnection conection = new SqlConnection();
            Connection cn = conection.openDB();
            // Usando PreparedStatement para evitar injeção de SQL e problemas de sintaxe
            PreparedStatement ps = cn.prepareStatement("UPDATE usuario SET senha = ? WHERE id = ?");
            ps.setString(1, senha);
            ps.setInt(2, Main.getId());

            int linhasAfetadas = ps.executeUpdate();
            if (linhasAfetadas > 0) {
                JOptionPane.showMessageDialog(null, "Senha alterada com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Falha ao alterar a senha.");
            }

            ps.close();
            cn.close();
        } catch (SQLException e) {
            throw new Exception("Falha ao acessar base de dados.\n" + e.getMessage());
        }
    }

    public static void email(String email) throws Exception {
        try {
            SqlConnection conection = new SqlConnection();
            Connection cn = conection.openDB();
            // Usando PreparedStatement para evitar injeção de SQL e problemas de sintaxe
            PreparedStatement ps = cn.prepareStatement("UPDATE usuario SET e_mail = ? WHERE id = ?");
            ps.setString(1, email);
            ps.setInt(2, Main.getId());

            int linhasAfetadas = ps.executeUpdate();
            if (linhasAfetadas > 0) {
                JOptionPane.showMessageDialog(null, "E-mail alterado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Falha ao alterar o e-mail.");
            }

            ps.close();
            cn.close();
        } catch (SQLException e) {
            throw new Exception("Falha ao acessar base de dados.\n" + e.getMessage());
        }
    }
}
