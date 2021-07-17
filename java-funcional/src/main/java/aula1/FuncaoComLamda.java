package aula1;

public class FuncaoComLamda {
    public static void main(String[] args) {
        Funcao funcao = valor -> "Sr. " + valor;
        System.out.println(funcao.gerar("Tiago"));
    }
}
