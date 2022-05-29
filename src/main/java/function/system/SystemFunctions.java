package function.system;

public class SystemFunctions implements IFunction {

    private final TrigonometricFunction trigonometricFunction;
    private final LogFunction logFunction;

    public SystemFunctions(TrigonometricFunction trigonometricFunction, LogFunction logFunction) {
        this.trigonometricFunction = trigonometricFunction;
        this.logFunction = logFunction;
    }

    @Override
    public double calculate(double x, double esp) {
        if (x <= 0) {
            return trigonometricFunction.calculate(x, esp);
        } else {
            return logFunction.calculate(x, esp);
        }
    }
}
