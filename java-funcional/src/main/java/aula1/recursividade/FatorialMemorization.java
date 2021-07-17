package aula1.recursividade;

import java.util.HashMap;
import java.util.Map;

public class FatorialMemorization {
    static Map<Integer, Integer> MAPA_FATORIAL = new HashMap<>();

    public static void main(String[] args) {
        long I = System.nanoTime();
        System.out.println(fatorialMamorization(15));
        long F = System.nanoTime();
        System.out.println("FATorial 1 : " + (F - I));

        I = System.nanoTime();
        System.out.println(fatorialMamorization(15));
        F = System.nanoTime();
        System.out.println("FAtorial 2 : " + (F - I));

    }

    public static Integer fatorialMamorization(Integer value) {
        if (value == 1) {
            return value;
        } else {
            if (MAPA_FATORIAL.containsKey(value)) {
                return MAPA_FATORIAL.get(value);
            } else {
                Integer resultado = value * fatorialMamorization(value - 1);
                MAPA_FATORIAL.put(value, resultado);
                return resultado;
            }
        }
    }
}
