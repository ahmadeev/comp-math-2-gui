package math.equations;

public class EquationFour extends Equations {
    public static final String EQUATION = "sin(x) - 10 * cos(2x) = 0";
    public static final String ROOTS = "[...], [-2,32], [-0,822], [0,751], [2,39], [...]";

    public EquationFour() {}

    @Override
    public double getEquationValue(double x) {
        return (Math.sin(x) - 10 * Math.cos(2 * x));
    }

    @Override
    public String getExpectedRoots() {
        return ROOTS;
    }
}