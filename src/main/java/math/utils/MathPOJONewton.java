package math.utils;

public class MathPOJONewton {
    private int counter;
    private double prevX;
    private double prevXValue;
    private double prevXDerValue;
    private double x;
    private double step;

    public MathPOJONewton(int counter, double prevX, double prevXValue, double prevXDerValue, double x, double step) {
        this.counter = counter;
        this.prevX = prevX;
        this.prevXValue = prevXValue;
        this.prevXDerValue = prevXDerValue;
        this.x = x;
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

    public double getPrevXValue() {
        return prevXValue;
    }

    public void setPrevXValue(double prevXValue) {
        this.prevXValue = prevXValue;
    }

    public double getPrevXDerValue() {
        return prevXDerValue;
    }

    public void setPrevXDerValue(double prevXDerValue) {
        this.prevXDerValue = prevXDerValue;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getStep() {
        return step;
    }

    public void setStep(double step) {
        this.step = step;
    }
}
