package aula5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.stream.Collectors;

public class InferenciaExemplo {
    public static void main(String[] args) throws IOException {
        printarSoma(5,5,5);
    }

    private static void conncetAndPrintUrlJavaOlx() throws IOException {
        /* Utilizado no java 10, var não consegue ser utilizado a nivel de class */
        var url = new URL("https://www.oracle.com/br/downloads/");
        var urlConncetion = url.openConnection();

        try {
            var bufferedReader = new BufferedReader(new InputStreamReader(urlConncetion.getInputStream()));
            System.out.println(bufferedReader.lines().collect(Collectors.joining()).replaceAll(">", ">\n"));
        } catch (Exception e) { e.printStackTrace(); }
    }

    public static void testar(String nome, String sobrenome) {
        /* var não pode ser utilizado como parametro */
        var nomeCompleto = String.format("%s %s", nome, sobrenome);
        System.out.println(nomeCompleto);
    }

    public static void printarSoma(int... numeros) {
        int soma;

        if (numeros.length > 0) {
            soma = 0;
            for (var numero : numeros) {
                soma += numero;
            }

            for (var numero = 0; numero < numeros.length; numero++) {
                soma += numeros[numero];
            }

            System.out.println("A soma é :: " + soma);
        }
    }

    /**
     * Consegue
     *
     * Verificar local inicializadas
     * Verificar suporte de for
     * Verificar suporte no for interativo
     * Pode ter dentro do try
     *
     * Não consege
     *
     * var não pode ser utilizdo em nível de class
     * var não pode ser utilizado como variavel
     * não consegue iniciar em variavel local
     */
}

