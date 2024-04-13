package math.utils;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import math.equations.Equations;

import static java.lang.Math.abs;
import static java.lang.Math.log;
import static java.util.Objects.isNull;
import static math.utils.Utils.exit;

public class Methods {

    public static class Halving {
        public static ObservableList<MathPOJOHalving> halvingData = FXCollections.observableArrayList();
        public static void getRoot(double a, double b, double precision, Equations equation) {
            if (isNull(equation) || precision == 0) exit("Неверные входные данные!", 1);

            double lowerBoundary = a;
            double higherBoundary = b;
            double lowerBoundaryValue = equation.getEquationValue(lowerBoundary);
            double higherBoundaryValue = equation.getEquationValue(higherBoundary);
            double center;
            double centerValue;

            int reps = (int) Math.floor(log(abs(a - b) / precision) / log(2)) + 1 ;
            int counter = 0;
            while (counter < reps) {
                center = lowerBoundary + (higherBoundary - lowerBoundary) / 2;
                centerValue = equation.getEquationValue(center);

                if ((lowerBoundaryValue < 0 && centerValue >= 0) || (lowerBoundaryValue >= 0 && centerValue < 0)) {
                    higherBoundary = center;
                    higherBoundaryValue = equation.getEquationValue(higherBoundary);
                } else if ((centerValue >= 0 && higherBoundaryValue < 0) || (centerValue < 0 && higherBoundaryValue >= 0)) {
                    lowerBoundary = center;
                    lowerBoundaryValue = equation.getEquationValue(lowerBoundary);
                } else {
                    exit("Что-то пошло не так при решении уравнения!", 1);
                }

                counter++;
                printStepResult(counter, lowerBoundary, higherBoundary, lowerBoundaryValue, higherBoundaryValue);
                halvingData.add(new MathPOJOHalving(counter, lowerBoundary, higherBoundary,
                        lowerBoundary + (higherBoundary - lowerBoundary) / 2,
                        lowerBoundaryValue, higherBoundaryValue, abs(lowerBoundary - higherBoundary)));
            }
            System.out.println();
            System.out.printf("После %d итераций корень уравнения равен %f с точностью %f.\n",
                    reps, lowerBoundary + (higherBoundary - lowerBoundary) / 2, precision);
            System.out.printf("Уравнение имеет корни: %s\n", equation.getExpectedRoots());
        }

        public static void printStepResult(int counter, double lowerBoundary, double higherBoundary, double lowerBoundaryValue, double higherBoundaryValue) {
            System.out.printf("%d.   a = %5.2f   b = %5.2f   x = %5.2f   f(a) = %5.2f   f(b) = %5.2f   |a - b| = %5.2f\n",
                    counter, lowerBoundary, higherBoundary,
                    lowerBoundary + (higherBoundary - lowerBoundary) / 2,
                    lowerBoundaryValue, higherBoundaryValue, abs(lowerBoundary - higherBoundary));
        }
    }

    public static class Newton {
        public static ObservableList<MathPOJONewton> newtonData = FXCollections.observableArrayList();
        public static void getRoot(double a, double b, double precision, Equations equation) {
            if (isNull(equation) || precision == 0) exit("Неверные входные данные!", 1);
            if (getNumberOfRoots(equation, a, b) != 1) exit("Уравнение имеет больше одного корня на отрезке или не имеет корней совсем!", 1);

            int counter = 0;
            double previousX = b;

            if (equation.getEquationValue(a) * getSecondDerivative(equation, a) > 0
                    && equation.getEquationValue(b) * getSecondDerivative(equation, b) < 0) previousX = a;

            double previousXValue = equation.getEquationValue(previousX);
            double previousXDerivativeValue = getDerivative(equation, previousX);
            double x = previousX - previousXValue / previousXDerivativeValue;
            printStepResult(counter, previousX, previousXValue, previousXDerivativeValue, x);
            newtonData.add(new MathPOJONewton(counter,
                    previousX,
                    previousXValue,
                    previousXDerivativeValue,
                    x,
                    abs(x - previousX)));
            counter++;

            while (abs(previousX - x) > precision && abs(previousXValue) > precision) {
                previousX = x;
                previousXValue = equation.getEquationValue(previousX);
                previousXDerivativeValue = getDerivative(equation, previousX);
                x = previousX - previousXValue / previousXDerivativeValue;
                printStepResult(counter, previousX, previousXValue, previousXDerivativeValue, x);
                newtonData.add(new MathPOJONewton(counter,
                        previousX,
                        previousXValue,
                        previousXDerivativeValue,
                        x,
                        abs(x - previousX)));
                counter++;
            }

            System.out.println();
            System.out.printf("После %d итераций корень уравнения равен %f с точностью %f.\n",
                    counter, x, precision);
            System.out.printf("Уравнение имеет корни: %s\n", equation.getExpectedRoots());
        }

        public static void printStepResult(int counter, double previousX, double previousXValue, double previousXDerivativeValue, double x) {
            System.out.printf("%d.   x_i = %5.2f   f(x_i) = %5.2f   f'(x_i) = %5.2f   x_i+1 = %5.2f   | x_i+1 - x_i | = %5.2f\n",
                    counter,
                    previousX,
                    previousXValue,
                    previousXDerivativeValue,
                    x,
                    abs(x - previousX));
        }
    }

    public static class Iteration {
        public static double lambda;
        public static ObservableList<MathPOJOIteration> iterationData = FXCollections.observableArrayList();
        public static void getRoot(double a, double b, double precision, Equations equation) {
            if (isNull(equation) || precision == 0) exit("Неверные входные данные!", 1);
            if (getNumberOfRoots(equation, a, b) != 1) exit("Уравнение имеет больше одного корня на отрезке или не имеет корней совсем!", 1);
            double previousX;
            if (getDerivative(equation, a) > getDerivative(equation, b)) { previousX = a; } else { previousX = b; }
            lambda = getLambda(equation, previousX, a, b);
            double x = getPhi(equation, previousX, lambda);
            int counter = 0;
            printStepResult(counter, previousX, x, equation);
            iterationData.add(new MathPOJOIteration(
                    counter,
                    previousX,
                    x,
                    getPhi(equation, x, lambda),
                    equation.getEquationValue(x),
                    abs(x - previousX)));
            counter++;

            while (abs(x - previousX) > precision) {
                previousX = x;
                x = getPhi(equation, previousX, lambda);

                printStepResult(counter, previousX, x, equation);
                iterationData.add(new MathPOJOIteration(
                        counter,
                        previousX,
                        x,
                        getPhi(equation, x, lambda),
                        equation.getEquationValue(x),
                        abs(x - previousX)));
                counter++;
            }
            System.out.println();
            System.out.printf("После %d итераций корень уравнения равен %f с точностью %f.\n",
                    counter, x, precision);
            System.out.printf("Уравнение имеет корни: %s\n", equation.getExpectedRoots());
        }

        public static double getLambda(Equations equation, double x, double a, double b) {
            double maxDerivative = Math.max(abs(getDerivative(equation, a)), abs(getDerivative(equation, b)));
            double sign = (getDerivative(equation, a) > 0 && getDerivative(equation, b) > 0) ? -1 : 1;
            return sign / maxDerivative;
        }

        public static double getPhi(Equations equation, double x, double lambda) {
            return (x + lambda * equation.getEquationValue(x));
        }

        public static void printStepResult(int counter, double previousX, double x, Equations equation) {
            System.out.printf("%d.   x_i = %5.2f   x_i+1 = %5.2f   phi(x_i+1) = %5.2f   f(x_i+1) = %5.2f   | x_i+1 - x_i | = %5.2f\n",
                    counter,
                    previousX,
                    x,
                    getPhi(equation, x, lambda),
                    equation.getEquationValue(x),
                    abs(x - previousX));
        }
    }

    public static double getDerivative(Equations equation, double x) {
        if (isNull(equation)) exit("", 1);
        double deltaX = 1.0e-3;
        return ((equation.getEquationValue(x + deltaX) - equation.getEquationValue(x)) / deltaX);
    }

    public static double getSecondDerivative(Equations equation, double x) {
        if (isNull(equation)) exit("", 1);
        double deltaX = 1.0e-3;
        return (equation.getEquationValue(x + deltaX) - 2 * equation.getEquationValue(x) + equation.getEquationValue(x - deltaX))
                / (deltaX * deltaX);
    }

    public static int getNumberOfRoots(Equations equation, double a, double b) {
        int counter = 0;
        double step = 0.001;

        double lowerBoundaryValue = equation.getEquationValue(a);
        a += step;
        double higherBoundaryValue = equation.getEquationValue(a);
        if ((lowerBoundaryValue < 0 && higherBoundaryValue >= 0) || (lowerBoundaryValue >= 0 && higherBoundaryValue < 0))
            counter++;

        while (a <= b) {
            lowerBoundaryValue = higherBoundaryValue;
            higherBoundaryValue = equation.getEquationValue(a);
            if ((lowerBoundaryValue < 0 && higherBoundaryValue >= 0) || (lowerBoundaryValue >= 0 && higherBoundaryValue < 0))
                counter++;

            a += step;
        }

        return counter;
    }
}