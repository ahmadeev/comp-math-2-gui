package math.equations;

public class EquationFour extends Equations {
    public static final String EQUATION = "sin(x) = 0";
    public static final String ROOTS = "[...], [-6,2832], [-3,1415], [0], [3,1415], [6,2832], [...]";

    public EquationFour() {}

    @Override
    public double getEquationValue(double x) {
        return (Math.sin(x));
    }

    @Override
    public String getExpectedRoots() {
        return ROOTS;
    }
}