package function;

public class Ln {

    public static double constant;

    public double ln(double x, double esp) {
        if (Double.isNaN(x) || x <= 0.0 || x == Double.NEGATIVE_INFINITY) {
            return Double.NaN;
        } else if (x == Double.POSITIVE_INFINITY) {
            return Double.POSITIVE_INFINITY;
        }

        constant = ((x - 1) * (x - 1)) / ((x + 1) * (x + 1));

        double sum = 0;
        double currentValue = (x - 1) / (x + 1);
        int step = 1;
        while (Math.abs(currentValue) > esp/2) {
            sum += currentValue;
            currentValue = getNextValue(currentValue, step);
            step++;
        }
        sum *= 2;
        return sum;
    }

    public double getNextValue(double current, int step) {
        return (2 * step - 1) * current * constant / (2 * step + 1);
    }
}
