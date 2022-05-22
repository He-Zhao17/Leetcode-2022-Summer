import java.io.CharArrayReader;
import java.util.Stack;

public class E20_ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> sta = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                sta.push(ch);
            } else {
                if ((!sta.empty()) && ch == ')' && sta.peek() == '('){
                    sta.pop();
                } else if ((!sta.empty()) && ch == ']' && sta.peek() == '['){
                    sta.pop();
                } else if ((!sta.empty()) && ch == '}' && sta.peek() == '{'){
                    sta.pop();
                } else {
                    sta.push(ch);
                }
            }
        }
        if (sta.empty()) {
            return true;
        } else {
            return false;
        }

    }
}
