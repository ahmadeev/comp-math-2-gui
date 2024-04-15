package controllers.group;

public class GroupOne {
    public static final String equationOne = "x^2 + y^2 = 4";
    public static final String equationTwo = "y = 3 * x^2";
    public static final String ROOTS = "[]";


    @Override
    public String toString() {
        return (equationOne + "\n"
                + equationTwo);
    }
}
