import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BalancedParens {

    private static int BUFFER = 100;
    private static boolean isBalanced(String str) {
        if (str.isBlank() || str.isEmpty()) return true;
        if (str.length() % 2 > 0) return false;

        while (str.contains("()")) {
            str = str.replace("()", "");
        }
        if (str.isEmpty()) return true;

        return false;
    }

    public static List<String> balancedParens (int n) {
        // your code here
        //build balanced
        //List<String> counter = new ArrayList<>();
        String[] countBuffer = new String[BUFFER];

        if (n == 0) {
            var lst = new ArrayList<String>();
            lst.add("");
            return lst;
        }
        List<String> balanced = new ArrayList<>();

        //counter.add(String.format("%-"+ n * 2 + "s", "").replace(" ", "1"));
        countBuffer[0] = String.format("%-"+ n * 2 + "s", "").replace(" ", "1");
        String track = countBuffer[0];
        int idx = 0;
        while (track.charAt(0) != '2') {
            //add
            track = countBuffer[idx];

            char[] arr = track.toCharArray();
            arr = generateNextCombination(arr);
            idx ++;
            countBuffer[idx] = String.valueOf(arr);
            track = countBuffer[idx];;

            //cleanup and continue
            if (idx == BUFFER - 1) {
                arr = generateNextCombination(arr);
                track = String.valueOf(arr);
                validate(countBuffer, balanced);
                countBuffer = new String[BUFFER];
                idx = 0;
                countBuffer[idx] = track;
            }

        }

        validate(countBuffer, balanced);

        return balanced;
    }

    private static void validate(String[] counter, List<String> balanced) {
        final Predicate<String> predicate = (String v) -> {
            return !Objects.isNull(v) && v.endsWith("2") && v.startsWith("1") && (v.length() / 2) == v.replace("1", "").length();
        };
        for ( String val: Arrays.asList(counter).stream().filter(predicate).collect(Collectors.toList())) {
            String v = val.replace('1', '(');
            v = v.replace('2', ')');
            if (isBalanced(v)) {
                balanced.add(v);
            }
        }
    }

    private static char[] generateNextCombination(char[] arr) {
        int idx = arr.length - 1;
        char carry = 0;
        while (idx >= 0 ) {
            if (arr[idx] == '2') {
                arr[idx] = '1';
                carry = '1';
            }
            if (arr[idx] == '1' && carry == 0) {
                arr[idx] ++ ;
                if (idx + 1 != arr.length)
                 Arrays.fill(arr, idx+1,arr.length , '1' );
                break;
            }
            if (arr[idx] == '1' && carry == '1') {
                arr[idx] ++;
                carry = 0;
            }
            idx --;
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(balancedParens(3).toString());
        //System.out.println(String.format("%-10s", "").replace(" ", "1"));
    }

}
