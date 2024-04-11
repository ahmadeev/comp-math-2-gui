package math.utils;

public class Utils {

    public static void exit(String msg, int exitCode) {
        if (!(msg.trim().equals(""))) {
            System.out.println(msg);
        }
        System.exit(exitCode);
    }
}
