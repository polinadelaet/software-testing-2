package function;

public class Cos {
    private final Sin sin;

    public Cos(Sin sin) {
        this.sin = sin;
    }

    public double cos(double x, double esp) {
        if (Double.POSITIVE_INFINITY == x || Double.NEGATIVE_INFINITY == x || Double.isNaN(x)) {
            return Double.NaN;
        }
        double s_x = x;
        if (x < -Math.PI) {
            while (x < -Math.PI) x += 2 * Math.PI;
        }
        if (x > Math.PI) {
            while (x > Math.PI) x -= 2 * Math.PI;
        }

        if (x > Math.PI / 2 || x < - Math.PI / 2) {
            return -1 * Math.sqrt(1 - sin.sin(s_x, esp) * sin.sin(s_x, esp));
        }

        return Math.sqrt(1 - sin.sin(s_x, esp) * sin.sin(s_x, esp));
    }
}
