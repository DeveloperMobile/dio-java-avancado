package aula2;

import java.util.function.Consumer;

public class Consumidores {
    public static void main(String[] args) {
        /* Method Reference
        * Apenas utilizar o paremetro da forma
        * que ele foi recebido
        */
        Consumer<String> imprimirUmaFrase = System.out::println;

        /* Lambda */
        Consumer<String> imprimirUmaFrase2 = frase -> System.out.println(frase);

        imprimirUmaFrase.accept("Hello World!");
        imprimirUmaFrase2.accept("Hello World!!");
    }
}
