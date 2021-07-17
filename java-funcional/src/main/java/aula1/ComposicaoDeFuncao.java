package aula1;

import java.util.Arrays;

public class ComposicaoDeFuncao {
    public static void main(String[] args) {
        int[] valores = {1,2,3,4};

        // Funcional
        Arrays.stream(valores)
                .filter(numero -> numero % 2 == 0) // resto da divisão
                .map(numero -> numero * 2) // multiplica por 2
                .forEach(System.out::println);

        /*
         * A mesma coisa que a função a cima está fazendo
         * utilizando conceito de Funções e imutabilidade em Paradigma Funcional
         */

        // imperativo
        for (int i = 0; i < valores.length; i++) {
            int valor = 0;
            if (valores[i] % 2 == 0) {
                valor = valores[i] * 2;
            }

            if (valor != 0) {
                System.out.println(valor);
            }
        }
    }
}
