import java.util.Calendar;
import java.util.Stack;

public class E125_ValidPalindrome {
    //双指针 更好 但无伤大雅
    public boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }
        char[] arr = s.toCharArray();
        Stack<Character> sta1 = new Stack<>();
        Stack<Character> sta2 = new Stack<>();
        for (int i = 0; i < arr.length; ++i) {
            if (Character.isLetterOrDigit(arr[i])) {
                char ch = arr[i];
                if (Character.isUpperCase(arr[i])) {
                    ch = Character.toLowerCase(arr[i]);
                }
                sta1.push(ch);
            }
        }
        int mid = sta1.size()/2;
        for (int i = 0; i < mid; ++i) {
            sta2.push(sta1.pop());
        }
        if (sta1.size() > sta2.size()) {
            sta1.pop();
        }

        for (int i = 0; i < mid; ++i) {
            if (sta1.pop() != sta2.pop()) {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        String test = ",; W;:GlG:;l ;,";
        E125_ValidPalindrome temp = new E125_ValidPalindrome();
        boolean res = temp.isPalindrome(test);

    }
}
