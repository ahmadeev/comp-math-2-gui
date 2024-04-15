package math.equations;

public class EquationTwo extends Equations {
    public static final String EQUATION = "x^4 + 5 * x^3 + 10 * (x + 5)^2 - x = 0";
    public static final String ROOTS = "[-4,959], [-2,84]";

    public EquationTwo() {
    }

    @Override
    public double getDerivative(double x) {
        return 4 * Math.pow(x, 3) + 5 * 3 * Math.pow(x, 2) + 10 * 2 * (x + 5) - 1;
    }

    @Override
    public double getSecondDerivative(double x) {
        return 4 * 3 * Math.pow(x, 2) + 5 * 3 * 2 * x + 10 * 2;
    }

    @Override
    public double getEquationValue(double x) {
        return (Math.pow(x, 4) + 5 * Math.pow(x, 3) + 10 * Math.pow((x+5), 2) - x);
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
