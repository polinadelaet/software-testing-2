package function.system;

import function.Cos;

public class TrigonometricFunction implements IFunction {

    private final Cos cos;

    public TrigonometricFunction(Cos cos) {
        this.cos = cos;
    }

    @Override
    public double calculate(double x, double esp) {
        return cos.cos(x, esp);
    }
}
