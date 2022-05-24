import java.nio.charset.StandardCharsets;
import java.util.Map;

public class E67_AddBinary {
    public String addBinary(String a, String b) {
        int first = Math.min(a.length(), b.length());
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < first; ++i) {
            int a1 = a.charAt(a.length() - 1 - i) - '0';
            int a2 = b.charAt(b.length() - 1 - i) - '0';
            int add = a1 + a2 + carry;
            if (add > 1) {
                sb.append(add % 2);
                carry = 1;
            } else {
                sb.append(add);
                carry = 0;
            }
        }
        String longstr = "";
        if (a.length() > b.length()) {
            longstr = first == 0 ? a : a.substring(0, a.length() - first);
        } else if (b.length() > a.length()) {
            longstr = first == 0 ? b : b.substring(0, b.length() - first);
        } else {
            longstr = "";
        }
        for (int i = 0; i < longstr.length(); ++i) {
            int a1 = longstr.charAt(longstr.length() - 1 - i) - '0';
            int add = a1 + carry;
            if (add > 1) {
                sb.append(add % 2);
                carry = 1;
            } else {
                sb.append(add);
                carry = 0;
            }
        }
        if (carry > 0) {
            sb.append(1);
        }
        return sb.reverse().toString();


    }
}
