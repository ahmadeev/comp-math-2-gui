package math.groups;

import static java.lang.Math.abs;
import static math.utils.MatrixOperations.*;

public class GroupTwo {
    private static final int numberOfEquations = 2;
    private static final String ROOTS = "[(-2,236; -11,18), (2,236; 11,18)]";
    private Equations[] equations = {
            new EquationOne(),
            new EquationTwo()
    };

    public GroupTwo() {

    }

    public class EquationOne implements Equations {
        private static final String equationOne = "y = 5 * x";

        public EquationOne() {
        }

        public double getEquationValue(double x, double y) {
            return y - 5 * x;
        }

        //  partial derivative with respect to x variable
        public double getEquationDerivativeToX(double x, double y) {
            return -5;
        }

        public double getEquationDerivativeToY(double x, double y) {
            return 1;
        }
    }

    public class EquationTwo implements Equations {
        private static final String equationTwo = "y = x^3";

        public EquationTwo() {
        }

        public double getEquationValue(double x, double y) {
            return y - Math.pow(x, 3);
        }

        //  частная производная по x
        public double getEquationDerivativeToX(double x, double y) {
            return -3 * Math.pow(x, 2);
        }

        public double getEquationDerivativeToY(double x, double y) {
            return 1;
        }
    }

    public double[][] getExtendedMatrix(double a, double b) {
        return new double[][]{
                new double[] {
                        equations[0].getEquationDerivativeToX(a, b),
                        equations[0].getEquationDerivativeToY(a, b),
                        -equations[0].getEquationValue(a, b)
                },
                new double[] {
                        equations[1].getEquationDerivativeToX(a, b),
                        equations[1].getEquationDerivativeToY(a, b),
                        -equations[1].getEquationValue(a, b)
                },
        };
    }

    public double[] solveSystem(double[][] extendedMatrix) {
        double[][] solution = matrixToTriangle(extendedMatrix);
        getAnswer(solution);
        return getXFromExtendedMatrix(solution);
    }

    public GroupOutput solveSystem(GroupTwo groupTwo, double a, double b) {
        double[][] extendedMatrix;
        double[] dx;
        double precision = 0.01;

        int counter = 0;
        while(true) {

            extendedMatrix = groupTwo.getExtendedMatrix(a, b);
            dx = groupTwo.solveSystem(extendedMatrix);
            a += dx[0];
            b += dx[1];
            if (abs(dx[0]) <= precision && abs(dx[1]) <= precision) {
                break;
            }
            counter++;
        }
        System.out.println(counter + " : " + a + " : " + b);
        return new GroupOutput(new double[] {a, b}, dx, counter + 1);
    }

    public String getRoots() {
        return ROOTS;
    }

    @Override
    public String toString() {
        return (EquationOne.equationOne + "\n"
                + EquationTwo.equationTwo);
    }
}
