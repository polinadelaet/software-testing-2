package function.system;

import function.Ln;
import function.Log;

public class LogFunction implements IFunction {

    private final Ln ln;
    private final Log log;

    public LogFunction(Ln ln, Log log) {
        this.ln = ln;
        this.log = log;
    }

    @Override
    public double calculate(double x, double esp) {
        return (((((ln.ln(x, esp) * ln.ln(x, esp)) * log.log(x, 2, esp)) + (log.log(x, 5, esp) * log.log(x, 10, esp))) * (((ln.ln(x, esp) * ln.ln(x, esp)) * log.log(x, 2, esp)) + (log.log(x, 5, esp) * log.log(x, 10, esp)))) * log.log(x, 2, esp));
    }
}
