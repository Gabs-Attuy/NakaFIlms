package validations;

import sql_actions.Busca_filme;
import sql_actions.Busca_usuario;
import java.util.Date;
import java.util.regex.*;
public class Verifica_idade {
    public static boolean verifica(int id) throws Exception {
        Date data = data(id);
        int idade = calcularIdade(data);
        int classificacao = classificacao();
        if(classificacao == -1)
            return true;
        else {
            return idade >= classificacao;
        }
    }
    public static int classificacao() throws Exception {
        String idadeString = Busca_filme.getClassificacao(2);

        // Use uma expressão regular para encontrar o número na string
        String numeroRegex = "\\d+";
        Pattern pattern = Pattern.compile(numeroRegex);
        Matcher matcher = pattern.matcher(idadeString);

        // Verifique se um número foi encontrado
        if (matcher.find()) {
            // Extrai o número da string e converte para inteiro
            int classificacao = Integer.parseInt(matcher.group());
            System.out.println("Classificação: " + classificacao);
            return classificacao;
        } else {
            System.out.println("Nenhum número encontrado na string.");
            return -1;
        }
    }

    public static Date data(int id){
        Date datanasc;
        try {
            datanasc = Busca_usuario.getDatadeNasc(id);
            return datanasc;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public static int calcularIdade(Date dataDeNascimento) {
        // Converte para milissegundos
        Date dataAtual = new Date();
        long tempoDeNascimento = dataDeNascimento.getTime();
        long tempoAtual = dataAtual.getTime();

        // Calcula a diferença em milissegundos
        long diferenca = tempoAtual - tempoDeNascimento;

        // Converte a diferença de milissegundos para anos
        int idade = (int) (diferenca / (1000L * 60 * 60 * 24 * 365));
        return idade;
    }
}
