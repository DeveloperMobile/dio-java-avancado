package aula1.recursividade;

public class FatorialRecursivo {
    public static void main(String[] args) {
        System.out.println(fatorial(5));
    }

    // função de recursividade no else
    public static int fatorial(int value) {
        if (value == 1) {
            return value;
        }
        return value * fatorial(value - 1);
    }
}
