import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class E17_LetterCombinationsOfAPhoneNumber {
    List<String> ans = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<String>();
        }
        char[][] arr = new char[10][3];
        arr[2] = new char[]{'a', 'b', 'c', ' '};
        arr[3] = new char[]{'d', 'e', 'f', ' '};
        arr[4] = new char[]{'g', 'h', 'i', ' '};
        arr[5] = new char[]{'j', 'k', 'l', ' '};
        arr[6] = new char[]{'m', 'n', 'o', ' '};
        arr[7] = new char[]{'p', 'q', 'r', 's'};
        arr[8] = new char[]{'t', 'u', 'v', ' '};
        arr[9] = new char[]{'w', 'x', 'y', 'z'};

        int[] d = new int[digits.length()];
        for (int i = 0; i < digits.length(); ++i) {
            d[i] = Integer.valueOf(digits.charAt(i)) - '0';
        }
        help(arr, 0, d);
        return ans;
    }
    private void help (char[][] arr, int index, int[] d) {
        if (index == d.length) {
            ans.add(sb.toString());
            return;
        }
        int temp = d[index];
        int k = (temp == 7 || temp == 9) ? 4: 3;
        for (int j = 0; j < k; j++) {
            sb.append(arr[temp][j]);
            help(arr, index + 1, d);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        E17_LetterCombinationsOfAPhoneNumber temp = new E17_LetterCombinationsOfAPhoneNumber();
        temp.letterCombinations("7");
    }
}
