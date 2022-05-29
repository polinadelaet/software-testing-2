package function;

public class Sin {
    public double sin(double x, double esp) {
        if (Double.POSITIVE_INFINITY == x || Double.NEGATIVE_INFINITY == x) { // +бесконеч и -бесконеч
            return Double.NaN;
        }
        double fact = 1, result_l = 1, result = 0, xx, pow;
        int sign = 1, cnt = 1;
        if (x >= 0) {
            while (x > Math.PI * 2) {
                x -= Math.PI * 2;
            }
        } else if (x < 0) {
            while (x < Math.PI * 2) {
                x += Math.PI * 2;
            }
        }
        xx = x * x;
        pow = x;
        while (Math.abs(result_l - result) > esp) {
            fact /= cnt;
            result_l = result;
            result += sign * pow * fact;
            sign = -sign;
            fact /= (cnt + 1);
            pow *= xx;
            cnt += 2;
        }
        return result;
    }
}
