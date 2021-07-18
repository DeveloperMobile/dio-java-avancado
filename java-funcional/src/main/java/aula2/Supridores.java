package aula2;

import java.util.function.Supplier;

public class Supridores {
    public static void main(String[] args) {
        Supplier<Pessoa> instanciaPessoa = Pessoa::new;
        System.out.println(instanciaPessoa.get());
    }
}

class Pessoa {
    private String nome;
    private Integer idade;

    public Pessoa() {
        this.nome = "Tiago";
        this.idade = 35;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s, Idade: %d", nome, idade);
    }
}
