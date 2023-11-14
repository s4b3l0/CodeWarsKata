import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> strings = new ArrayList<>();
        strings.add("hello");
        strings.add("hello2");
        strings.add("hello5");

        Iterator iterator = strings.listIterator();

        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
    }

    static char[] chs = new char[]{'0', '1', '2','3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    /**
     * Converts numbers color values rgb to hex
     * @param r
     * @param g
     * @param b
     * @return hex value of colors
     */
    public static String rgb(int r, int g, int b) {
        StringBuilder sb = new StringBuilder("");
        int[] num = new int[]{r, g, b};
        int idx = 0;
        while (idx <= 2) {
            if (!isValid(num[idx])) {
                if (num[idx] > 255) {
                    num[idx] = 255;
                } else {
                    num[idx] = 0;
                }
            }
            int val = num[idx] / 16;
            int rem = num[idx] - (val * 16);
            sb.append(chs[val]);
            sb.append(chs[rem]);
            idx++;
        }
        return sb.toString();
    }

    private static boolean isValid(int num) {
        return num >= 0 && num <= 255;
    }
}

