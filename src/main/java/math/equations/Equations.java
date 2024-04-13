package math.equations;

public abstract class Equations {
    public static final String ROOTS = null;
    public Equations() {
    }
    public abstract double getEquationValue(double x);

    public abstract String getExpectedRoots();

    public double getDerivative(double x) {
        double deltaX = 1.0e-3;
        return ((this.getEquationValue(x + deltaX) - this.getEquationValue(x)) / deltaX);
    }

    public double getSecondDerivative(double x) {
        double deltaX = 1.0e-3;
        return (this.getEquationValue(x + deltaX) - 2 * this.getEquationValue(x) + this.getEquationValue(x - deltaX))
                / (deltaX * deltaX);
    }

    public int getNumberOfRoots(double a, double b) {
        int counter = 0;
        double step = 0.001;

        double lowerBoundaryValue = this.getEquationValue(a);
        a += step;
        double higherBoundaryValue = this.getEquationValue(a);
        if ((lowerBoundaryValue < 0 && higherBoundaryValue >= 0) || (lowerBoundaryValue >= 0 && higherBoundaryValue < 0))
            counter++;

        while (a <= b) {
            lowerBoundaryValue = higherBoundaryValue;
            higherBoundaryValue = this.getEquationValue(a);
            if ((lowerBoundaryValue < 0 && higherBoundaryValue >= 0) || (lowerBoundaryValue >= 0 && higherBoundaryValue < 0))
                counter++;

            a += step;
        }

        return counter;
    }
}
