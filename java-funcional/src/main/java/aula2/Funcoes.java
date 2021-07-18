package aula2;

import java.util.function.Function;

public class Funcoes {
    public static void main(String[] args) {
        Function<String, String> retornaNomeAoContrario = texto -> new StringBuffer(texto).reverse().toString();
        System.out.println(retornaNomeAoContrario.apply("Tiago"));
        // Retornando um inteiro
        Function<String, Integer> converterStringParaInteiroECalcularODobro =
                string -> Integer.parseInt(string) * 2;
        System.out.println(converterStringParaInteiroECalcularODobro.apply("20"));

    }
}
