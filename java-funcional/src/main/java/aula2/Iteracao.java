package aula2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Iteracao {
    public static void main(String[] args) {
        String[] nomes = { "Tiago", "Gabriel", "Paulo", "Oliveira", "Santos", "Instrutor", "Java" };
        Integer[] numeros = { 1, 2, 3, 4, 5 };

        imprimirnomesFiltrados(nomes);
        imprimirTodosNomes(nomes);
        imprimirODobroDeCadaIteracao(numeros);

        List<String> listaDeProficao = new ArrayList<>();
        listaDeProficao.add("Desenvolvedor");
        listaDeProficao.add("Testador");
        listaDeProficao.add("Gerente de Projeto");
        listaDeProficao.add("Gerente de Calidade");

        listaDeProficao.stream()
                .filter(proficao -> proficao.startsWith("Gerente"))
                .forEach(System.out::println);
    }

    public static void imprimirnomesFiltrados(String... nomes) {
        // Forma 1
        String nomesParaImprimir = "";
        for (int i = 0; i < nomes.length; i++) {
            if (nomes[i].equals("Tiago")) {
                nomesParaImprimir += ""+nomes[i];
            }
        }

        System.out.println("Nomes do for: " + nomesParaImprimir);

        // Forma 2 - Stream
        String nomesParaImprimirStream = Stream.of(nomes)
                .filter(nome -> nome.equals("Tiago"))
                .collect(Collectors.joining());

        System.out.println("Nomes do Stream: " + nomesParaImprimirStream);
    }

    public static void imprimirTodosNomes(String... nomes) {
        for (String nome : nomes) {
            System.out.println("Imprimir pelo for: " + nome);
        }
        // Stream
        Stream.of(nomes)
                .forEach(nome -> System.out.println("Imrpimindo pelo Stream: " + nome));
    }

    public static void imprimirODobroDeCadaIteracao(Integer... numeros) {
        for (Integer numero : numeros) {
            System.out.println("Imprimindo pelo for: " + numero * 2);
        }
        // Stream
        Stream.of(numeros)
                .map(numero -> numero * 2)
                .forEach(System.out::println);
    }
}
