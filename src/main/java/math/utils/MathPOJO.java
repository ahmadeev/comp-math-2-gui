package math.utils;

public class MathPOJO {
    private int counter;
    private double a;
    private double b;
    private double x;
    private double aValue;
    private double bValue;
    private double step;

    public MathPOJO(int counter, double a, double b, double x, double aValue, double bValue, double step) {
        this.counter = counter;
        this.a = a;
        this.b = b;
        this.x = x;
        this.aValue = aValue;
        this.bValue = bValue;
        this.step = step;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getAValue() {
        return aValue;
    }

    public void setAValue(double aValue) {
        this.aValue = aValue;
    }

    public double getBValue() {
        return bValue;
    }

    public void setBValue(double bValue) {
        this.bValue = bValue;
    }

    public double getStep() {
        return step;
    }

    public void setStep(double step) {
        this.step = step;
    }
}
