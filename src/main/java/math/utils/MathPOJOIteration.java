package math.utils;

public class MathPOJOIteration {
    private int counter;
    private double prevX;
    private double x;
    private double xPhi;
    private double xValue;
    private double step;

    public MathPOJOIteration(int counter, double prevX, double x, double xPhi, double xValue, double step) {
        this.counter = counter;
        this.prevX = prevX;
        this.x = x;
        this.xPhi = xPhi;
        this.xValue = xValue;
        this.step = step;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public double getPrevX() {
        return prevX;
    }

    public void setPrevX(double prevX) {
        this.prevX = prevX;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getXPhi() {
        return xPhi;
    }

    public void setXPhi(double xPhi) {
        this.xPhi = xPhi;
    }

    public double getXValue() {
        return xValue;
    }

    public void setXValue(double xValue) {
        this.xValue = xValue;
    }

    public double getStep() {
        return step;
    }

    public void setStep(double step) {
        this.step = step;
    }
}
