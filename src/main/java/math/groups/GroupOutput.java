package math.groups;

public class GroupOutput {
    private double[] x;
    private double[] dx;
    private int counter;

    public double[] getX() {
        return x;
    }

    public int getCounter() {
        return counter;
    }

    public double[] getDx() {
        return dx;
    }

    public GroupOutput(double[] x, double[] dx, int counter) {
        this.x = x;
        this.dx = dx;
        this.counter = counter;
    }
}
