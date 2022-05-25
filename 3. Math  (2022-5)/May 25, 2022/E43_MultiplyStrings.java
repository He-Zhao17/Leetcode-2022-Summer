import java.util.ArrayList;

public class E43_MultiplyStrings {
    public String multiply(String num1, String num2) {
        //注意corner case 会返回000000 而不是0
        if ((num1.length() == 1 && num1.equals("0")) || (num2.length() == 1 && num2.equals("0"))) {
            return "0";
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < num2.length(); i++) {
            int ch2 = num2.charAt(num2.length() - 1 - i) - '0';
            int overFlow = 0;
            int carry = 0;
            for (int j = 0; j < num1.length(); j++) {
                int ch1 = num1.charAt(num1.length() - 1 - j) - '0';
                int mul = ch1 * ch2 + overFlow;
                if (mul > 9) {
                    overFlow = mul / 10;
                } else {
                    overFlow = 0;
                }
                mul = mul % 10;
                if (j + i >= res.size()) {
                    int add = mul + carry;
                    if (add > 9) {
                        carry = 1;
                    } else {
                        carry = 0;
                    }
                    add = add % 10;
                    res.add(add);
                } else {
                    int add = mul + res.get(j + i) + carry;
                    if (add > 9) {
                        carry = 1;
                    } else {
                        carry = 0;
                    }
                    add = add % 10;
                    res.set(j + i, add);
                }
            }
            int curr = num1.length() + i;
            while (carry != 0 || overFlow != 0){
                if (curr < res.size()) {
                    for (int j = num1.length() + 1; j < res.size(); ++j ){
                        if (carry == 0 && overFlow == 0) {
                            break;
                        }
                        int add = overFlow + carry + res.get(j);
                        overFlow = 0;
                        if (add > 9) {
                            carry = 1;
                        } else {
                            carry = 0;
                        }
                        add = add % 10;
                        res.set(j, add);
                    }
                    curr = res.size();
                } else {
                    res.add(carry + overFlow);
                    carry = 0;
                    overFlow = 0;
                    curr++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = res.size() - 1; i >= 0; --i) {
            sb.append(res.get(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str1 = "23";
        String str2 = "3566";
        E43_MultiplyStrings temp = new E43_MultiplyStrings();
        String res = temp.multiply(str1, str2);
        System.out.println(res);
    }
}
