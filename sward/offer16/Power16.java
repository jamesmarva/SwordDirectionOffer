package sward.offer16;

/**
 * @program: myleetcode
 * @description:
 * @author: James
 * @create: 2019-08-22 06:50
 **/
public class Power16 {

    public double power(double base, int exponent) {
        if (base == 0.0 && exponent <= 0.0) {
            return 0.0;
        }
        double result = 1;
        for (int i = 1; i <= Math.abs(exponent); ++i) {
            result *= base;
        }
        if (exponent < 0) {
            result = 1 / result;
        }
        return result;
    }


    public double powerBetter(double base, double exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        int tempExponent = ((int) exponent) >> 1;
        double result = powerBetter(base, tempExponent);
        result *= result;

        if (((int) exponent & 1) == 1) {
            result *= base;
        }
        return result;
    }
}
