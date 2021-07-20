package one.innovation.digital.utils;


import one.innovation.digital.utils.interna.DivHelper;
import one.innovation.digital.utils.interna.MultHelper;
import one.innovation.digital.utils.interna.SubtHelper;
import one.innovation.digital.utils.interna.SumHelper;

public class Calculadora {
    private SumHelper sumHelper;
    private SubtHelper subtHelper;
    private MultHelper multHelper;
    private DivHelper divHelper;

    public Calculadora() {
        this.sumHelper = new SumHelper();
        this.subtHelper = new SubtHelper();
        this.multHelper = new MultHelper();
        this.divHelper = new DivHelper();
    }

    public int sum(int a, int b) {
        return this.sumHelper.execute(a, b);
    }

    public int sub(int a, int b) {
        return this.subtHelper.execute(a, b);
    }

    public int mul(int a, int b) {
        return this.multHelper.execute(a, b);
    }

    public int div(int a, int b) {
        return this.divHelper.execute(a, b);
    }
}
