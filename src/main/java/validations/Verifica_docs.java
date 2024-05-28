package validations;

public class Verifica_docs {
    public static boolean validarCPF(String cpf) {
        // Verifica se o CPF tem 11 dígitos
        if (cpf.length() != 11) {
            return false;
        }

        // Verifica se todos os dígitos do CPF são iguais
        boolean digitosIguais = true;
        for (int i = 1; i < cpf.length(); i++) {
            if (cpf.charAt(i) != cpf.charAt(0)) {
                digitosIguais = false;
                break;
            }
        }
        if (digitosIguais) {
            return false;
        }

        // Calcula o primeiro dígito verificador
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += (cpf.charAt(i) - '0') * (10 - i);
        }
        int primeiroDigito = 11 - (soma % 11);
        if (primeiroDigito > 9) {
            primeiroDigito = 0;
        }

        // Verifica se o primeiro dígito verificador calculado é igual ao fornecido
        if (cpf.charAt(9) - '0' != primeiroDigito) {
            return false;
        }

        // Calcula o segundo dígito verificador
        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += (cpf.charAt(i) - '0') * (11 - i);
        }
        int segundoDigito = 11 - (soma % 11);
        if (segundoDigito > 9) {
            segundoDigito = 0;
        }

        // Verifica se o segundo dígito verificador calculado é igual ao fornecido
        return cpf.charAt(10) - '0' == segundoDigito;
    }

//    public static boolean validarRG(String rg) {
//        // Remove caracteres não numéricos do RG
//        rg = rg.replaceAll("[^0-9X]", "");
//
//        // Verifica se o RG tem 9 dígitos
//        if (rg.length() != 9) {
//            return false;
//        }
//
//        // Calcula o dígito verificador
//        int soma = 0;
//        for (int i = 0; i < 8; i++) {
//            soma += (rg.charAt(i) - '0') * (9 - i);
//        }
//        int digito = 11 - (soma % 11);
//        if (digito == 10) {
//            digito = 0; // Se o dígito for 10, considera como 0
//        } else if (digito == 11) {
//            digito = 1; // Se o dígito for 11, considera como 1
//        }
//
//        // Verifica se o dígito verificador calculado é igual ao fornecido
//        char ultimoCaractere = rg.charAt(8);
//        int digitoVerificador;
//        if (ultimoCaractere == 'X') {
//            digitoVerificador = 10; // Se o último caractere for 'X', considera como 10
//        } else {
//            digitoVerificador = ultimoCaractere - '0';
//        }
//
//        return digitoVerificador == digito;
//    }
}
