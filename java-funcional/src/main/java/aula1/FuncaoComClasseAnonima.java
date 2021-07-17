package aula1;

public class FuncaoComClasseAnonima {
    public static void main(String[] args) {
        Funcao funcao = new Funcao() {
            @Override
            public String gerar(String valor) {
                return "Sr. " + valor;
            }
        };

        System.out.println(funcao.gerar("Tiago"));
    }
}
