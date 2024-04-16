package controllers.group;

import java.util.Arrays;

import static java.lang.Math.abs;
import static math.utils.MatrixOperations.*;

public class GroupOne {
    private static final int numberOfEquations = 2;
    private static final String ROOTS = "[]";
    private Equations[] equations = {
        new EquationOne(),
        new EquationTwo()
    };

    public GroupOne() {

    }

    public class EquationOne implements Equations {
        private static final String equationOne = "x^2 + y^2 = 4";

        public EquationOne() {
        }

        public double getEquationValue(double x, double y) {
            return Math.pow(x, 2) + Math.pow(y, 2) - 4;
        }

        //  partial derivative with respect to x variable
        public double getEquationDerivativeToX(double x, double y) {
            return 2 * x;
        }

        public double getEquationDerivativeToY(double x, double y) {
            return 2 * y;
        }
    }

    public class EquationTwo implements Equations {
        private static final String equationTwo = "y = 3 * x^2";

        public EquationTwo() {
        }

        public double getEquationValue(double x, double y) {
            return y - 3 * Math.pow(x, 2);
        }

        //  частная производная по x
        public double getEquationDerivativeToX(double x, double y) {
            return -6 * x;
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

    public double[] solveOneSystem(double[][] extendedMatrix) {
        double[][] solution = matrixToTriangle(extendedMatrix);
        getAnswer(solution);
        return getXFromExtendedMatrix(solution);
    }

    public double[] solveSystem(GroupOne groupOne) {
        double[][] extendedMatrix;
        double[] dx;
        double a = 1;
        double b = 2;
        double precision = 0.01;

        int counter = 0;
        while(counter < 10) {
            extendedMatrix = groupOne.getExtendedMatrix(a, b);
            dx = groupOne.solveOneSystem(extendedMatrix);
            if (abs(dx[0]) <= precision && abs(dx[1]) <= precision) {
                break;
            }
            a += dx[0];
            b += dx[1];
            counter++;
        }
        System.out.println(counter + " : " + a + " : " + b);
        return new double[] {a, b};
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
