package aula1;

import java.util.function.UnaryOperator;

public class Funcional {
    public static void main(String[] args) {
        UnaryOperator<Integer> calculaValorVezesTres = valor -> valor * 3; // Um conceito do Paradigma Funcional
        int valor = 10;
        System.err.println("O resultado " + calculaValorVezesTres.apply(valor));
    }
}
