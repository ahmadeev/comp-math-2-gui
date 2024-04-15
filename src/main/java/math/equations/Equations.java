package math.equations;

import java.math.BigDecimal;

public abstract class Equations {
    public static final String ROOTS = null;

    public Equations() {
    }
    public abstract double getEquationValue(double x);

    public abstract String getRoots();

    public double getDerivative(double x) {
        double deltaX = 1.0e-3;
        return ((this.getEquationValue(x + deltaX) - this.getEquationValue(x)) / deltaX);
    }

/*    public double getDerivative(double x) {
        BigDecimal deltaX = BigDecimal.valueOf(1.0e-10);

        BigDecimal meow = BigDecimal.valueOf(x).add(deltaX);
        BigDecimal woof = BigDecimal.valueOf(x);
        BigDecimal meowwoof = meow.subtract(woof).divide(deltaX);

        return meowwoof.doubleValue();
    }*/

    public double getSecondDerivative(double x) {
        double deltaX = 1.0e-3;
        return (this.getEquationValue(x + deltaX) - 2 * this.getEquationValue(x) + this.getEquationValue(x - deltaX))
                / (deltaX * deltaX);
    }

/*    public double getSecondDerivative(double x) {
        BigDecimal deltaX = BigDecimal.valueOf(1.0e-10);

        BigDecimal meow = BigDecimal.valueOf(x).add(deltaX);
        BigDecimal woof = BigDecimal.valueOf(x).multiply(BigDecimal.valueOf(2));
        BigDecimal moo = BigDecimal.valueOf(x).subtract(deltaX);
        BigDecimal meowwoofmoo = (meow.subtract(woof).add(moo)).divide(deltaX.pow(2));

        return meowwoofmoo.doubleValue();
    }*/

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
