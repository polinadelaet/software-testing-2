package function;

public class Log {
    public final Ln ln;

    public Log(Ln ln) {
        this.ln = ln;
    }

    public double log(double x, double a, double esp) { // (большое число, на мелкое (на основание)) x - x, a - основание

        if (a == 1 || a <= 0 || a == Double.NEGATIVE_INFINITY || x == 0) {
            return Double.NaN;
        }
        if (x == 1) {
            return 0;
        }
        return ln.ln(x, esp) / ln.ln(a, esp);
    }
}
