package digital.innovation.one.utils.interna;

import digital.innovation.one.utils.operador.Operacao;

public class SumHelper implements Operacao<Integer> {
    @Override
    public Integer execute(Integer a, Integer b) {
        return a + b;
    }
}
