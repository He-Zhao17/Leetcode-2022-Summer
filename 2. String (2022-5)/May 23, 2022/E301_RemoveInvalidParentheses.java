import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class E301_RemoveInvalidParentheses {

    //答案 回溯+剪枝
    List<String> result = new ArrayList<>();
    public List<String> removeInvalidParentheses(String s) {
        int lRemove = 0;
        int rRemove = 0;
        for (int i = 0; i < s.length(); ++i) {
            char cur = s.charAt(i);
            if (cur == '(') {
                lRemove++;
            } else if (cur == ')') {
                if (lRemove == 0) {
                    rRemove++;
                } else {
                    lRemove--;
                }
            }
        }
        helper(s, 0, 0, 0, lRemove, rRemove);
        return result;
    }
    private void helper (String str, int index, int lCount, int rCount, int lRemove, int rRemove) {
        if (lRemove == rRemove && lCount == 0) {
            if (isValid(str)) {
                result.add(str);
            }
            return;
        }

        for (int i = index; i < str.length(); i++) {
            char cur = str.charAt(i);
            if (i == index || cur != str.charAt(i - 1)) {
                if (lRemove + rRemove > str.length() - i) {
                    return;
                }
                if (lRemove > 0 && cur == '(') {
                    helper(str.substring(0, i) + str.substring(i+1), i, lCount, rCount, lRemove - 1, rRemove);
                }

                if (rRemove > 0 && cur == ')') {
                    helper(str.substring(0, i) + str.substring(i+1), i, lCount, rCount, lRemove, rRemove - 1);
                }
            }

            if (cur == '(') {
                lCount++;
            } else if (cur == ')') {
                rCount++;
            }
            if (rCount > lCount) {
                break;
            }
        }
    }
    private boolean isValid(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); ++i) {
            char ch = str.charAt(i);
            if (ch == '(') {
                count++;
            } else if(ch == ')') {
                if (count == 0) {
                    return false;
                }
            }
        }
        return count == 0;
    }

}
