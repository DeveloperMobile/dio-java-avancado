package one.innovation.digital.utils.interna;


import one.innovation.digital.utils.operador.Operacao;

public class SubtHelper implements Operacao<Integer> {
    @Override
    public Integer execute(Integer a, Integer b) {
        return a - b;
    }
}
