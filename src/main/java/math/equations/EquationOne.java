package math.equations;

public class EquationOne extends Equations {
    public static final String EQUATION = "x^3 - x + 4 = 0";
    public static final String ROOTS = "[-1,796]";

    public EquationOne() {
    }

    @Override
    public double getEquationValue(double x) {
        return (Math.pow(x, 3) - x + 4);
    }

    @Override
    public String getExpectedRoots() {
        return ROOTS;
    }
}
