package jianzhi;

public class Jz12 {
    public double Power(double base, int exponent) {
        if (exponent == 0) return 1;
        if (exponent < 0) {
            base = 1 / base;
            exponent = -exponent;
        }

        return ((exponent & 1) == 1) ? base * Power(base * base, exponent / 2) : Power(base * base, exponent / 2);
    }
}
