import java.util.Arrays;
import java.util.Iterator;

public class Kata {
    public static String findNeedle(Object[] haystack) {
        // Your code here
        int index = 0;
        for (Object obj : haystack) {
            if (obj instanceof String && obj.equals("needle")) {
                return "found the needle at position " + index;
            }
            index++;
        }
        return null;
    }

    public static double getChance(int n, int x, int a) {
        //your code here
        return 0d;
    }
}