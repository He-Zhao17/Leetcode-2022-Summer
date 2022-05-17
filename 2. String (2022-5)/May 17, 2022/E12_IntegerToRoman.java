import javax.print.DocFlavor;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class E12_IntegerToRoman {
    Map<Integer, Character> map = new HashMap<Integer, Character>() {{
        put(1, 'I');
        put(5, 'V');
        put(10, 'X');
        put(50, 'L');
        put(100, 'C');
        put(500, 'D');
        put(1000, 'M');
    }};
    //答案 模拟法（没比我快很多）
    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    public String intToRoman2(int num) {
        StringBuffer roman = new StringBuffer();
        for (int i = 0; i < values.length; ++i) {
            int value = values[i];
            String symbol = symbols[i];
            while (num >= value) {
                num -= value;
                roman.append(symbol);
            }
            if (num == 0) {
                break;
            }
        }
        return roman.toString();
    }




    //我的 通用解法 我真nb
    public String intToRoman(int num) {

        Stack<String> sta = new Stack<>();
        int i = 1;
        while (num >= 1) {
            int pow = (int) Math.pow(10, i);
            int temp = num % pow;
            temp /= (int) Math.pow(10, i - 1);
            if (temp == 0) {
                i++;
                continue;
            }
            StringBuffer sb = new StringBuffer();
            char ch = map.get((int) Math.pow(10, i - 1));
            char ch5, ch10;
            if (i < 4) {
                ch5 = map.get(5 * ((int) Math.pow(10, i - 1)));
                ch10 = map.get(10 * ((int) Math.pow(10, i - 1)));
            } else {
                ch5 = 'a';
                ch10 = 'b';
            }

            if (temp >= 1 && temp <= 3) {
                for (int k = 0; k < temp; k++) {
                    sb.append(ch);
                }
            } else if (temp == 4) {
                sb.append(ch);
                sb.append(ch5);
            } else if (temp >= 5 && temp <= 8) {
                sb.append(ch5);
                for (int k = 6; k <= temp; k++) {
                    sb.append(ch);
                }
            } else {
                sb.append(ch);
                sb.append(ch10);
            }
            sta.push(sb.toString());
            num -= temp * ((int) Math.pow(10, i - 1));
            i++;
        }
        StringBuffer sb = new StringBuffer();
        while (!sta.empty()) {
            sb.append(sta.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        E12_IntegerToRoman temp = new E12_IntegerToRoman();
        temp.intToRoman(58);
    }
}
