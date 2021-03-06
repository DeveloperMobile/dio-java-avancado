package aula3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ParallelStreamExemplo {
    public static void main(String[] args) {
        long inicio1 = System.currentTimeMillis();
        IntStream.range(1, 100000).forEach(num -> fatorial(num));
        long fim1 = System.currentTimeMillis();
        System.out.println("Tempo de execução :: " + (fim1 - inicio1));

        long inicio2 = System.currentTimeMillis();
        IntStream.range(1, 100000).parallel().forEach(num -> fatorial(num));
        long fim2 = System.currentTimeMillis();
        System.out.println("Tempo de execução parallel :: " + (fim2 - inicio2));

        List<String> nomes = Arrays.asList("Tiago", "Vieira", "Silva");
        nomes.parallelStream().forEach(System.out::println);
    }

    public static long fatorial(long num) {
        long fat = 1;

        for (long i = 2; i <= num; i++) {
            fat *= i;
        }

        return fat;
    }
}
