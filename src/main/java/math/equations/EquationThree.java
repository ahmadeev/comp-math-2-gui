package math.equations;

public class EquationThree extends Equations {
    public static final String EQUATION = "10 * x^5 + x^2 - x + 2 * e^x = 0";
    public static final String ROOTS = "[-0,742]";

    public EquationThree() {}

    @Override
    public double getDerivative(double x) {
        return (50 * Math.pow(x, 4) + 2 * x - 1 + 2 * Math.exp(x));
    }

    @Override
    public double getSecondDerivative(double x) {
        return 50 * 4 * Math.pow(x, 3) + 2 + 2 * Math.exp(x);
    }

    @Override
    public double getEquationValue(double x) {
        return (10 * Math.pow(x, 5) + Math.pow(x, 2) - x + 2 * Math.exp(x));
    }

    @Override
    public String getRoots() {
        return ROOTS;
    }

    @Override
    public String toString() {
        return EQUATION;
    }
}
