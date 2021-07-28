package aula6;

public class StringRepeat {
    public static void main(String[] args) {
        String nome = "Tiago ";
        String aux = "";

        // Forma antiga
        for (int i = 0; i < 10; i++) {
            aux+=", " + nome;
        }

        System.out.println(aux);

        System.out.println("-------- Atual Java 11 ------------------");

        System.out.println(nome.repeat(10));
    }
}
