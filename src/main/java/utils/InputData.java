package utils;

public class InputData {
    int programmeMode;
    int objectCode;
    int methodNumber;
    double lowerBoundary;
    double higherBoundary;
    double precision;

    public InputData() {}

    public int getProgrammeMode() {
        return programmeMode;
    }

    public void setProgrammeMode(int programmeMode) {
        this.programmeMode = programmeMode;
    }

    public int getObjectCode() {
        return objectCode;
    }

    public void setObjectCode(int objectCode) {
        this.objectCode = objectCode;
    }

    public int getMethodNumber() {
        return methodNumber;
    }

    public void setMethodNumber(int methodNumber) {
        this.methodNumber = methodNumber;
    }

    public double getLowerBoundary() {
        return lowerBoundary;
    }

    public void setLowerBoundary(double lowerBoundary) {
        this.lowerBoundary = lowerBoundary;
    }

    public double getHigherBoundary() {
        return higherBoundary;
    }

    public void setHigherBoundary(double higherBoundary) {
        this.higherBoundary = higherBoundary;
    }

    public double getPrecision() {
        return precision;
    }

    public void setPrecision(double precision) {
        this.precision = precision;
    }
}
