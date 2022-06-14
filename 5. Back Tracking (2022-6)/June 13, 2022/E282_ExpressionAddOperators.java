import java.util.*;

public class E282_ExpressionAddOperators {
    /*StringBuilder sb = new StringBuilder();
    List<String> ans = new ArrayList<>();
    public List<String> addOperators(String num, int target) {
        if (num.length() == 0) {
            return ans;
        }
        if (num.length() == 1) {
            if (Integer.parseInt(num) == target) {
                ans.add(num);
                return ans;
            } else {
                return ans;
            }
        }
        int opNow = 1;
        *//*if (Integer.valueOf(num.charAt(0)) == '0') {
            for (int i = 1; i < num.length(); ++i) {
                if (Integer.valueOf(num.charAt(i)) != '0') {
                    opNow = i + 1;
                }
            }
            if (opNow == 1) {
                return ans;
            }
        }
*//*


        sb.append(Integer.valueOf(num.charAt(opNow - 1)) - '0');
        helper(opNow, num, target);
        return ans;
    }

    private void helper (int opNow, String num, int target) {
        sb.append('+');
        sb.append(num.charAt(opNow));
        if (opNow + 1 == num.length()) {
            if (cal(sb.toString()) == target) {
                ans.add(sb.toString());
            }
        } else {
            helper(opNow + 1, num, target);
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);
        //=============================
        sb.append('-');
        sb.append(num.charAt(opNow));
        if (opNow + 1 == num.length()) {
            if (cal(sb.toString()) == target) {
                ans.add(sb.toString());
            }
        } else {
            helper(opNow + 1, num, target);
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);
        //=======================================
        sb.append('*');
        sb.append(num.charAt(opNow));
        if (opNow + 1 == num.length()) {
            if (cal(sb.toString()) == target) {
                ans.add(sb.toString());
            }
        } else {
            helper(opNow + 1, num, target);
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);
        //===========================================
        if (sb.length() >= 2 && !Character.isDigit(sb.charAt(sb.length() - 2))) {
            return;
        }
        if (sb.length() == 1 && sb.charAt(0) == '0') {
            return;
        }

        sb.append(num.charAt(opNow));

        if (opNow + 1 == num.length()) {
            if (cal(sb.toString()) == target) {
                ans.add(sb.toString());
            }
        } else {
            helper(opNow + 1, num, target);
        }
        sb.deleteCharAt(sb.length() - 1);

    }
    private long cal (String exp) {
        Stack<Character> staOp = new Stack<>();
        Stack<Long> staNum = new Stack<>();
        if (exp.length() == 0) {
            return 0;
        }
        StringBuilder sp = new StringBuilder();
        int pointer = 0;
        while (pointer < exp.length()) {
            char ch = exp.charAt(pointer);
            if (Character.isDigit(ch)) {
                sp.append(ch);
            } else {
                staNum.push(Long.parseLong(sp.toString()));
                sp = new StringBuilder();
                if (ch == '+' || ch == '-') {
                    if (staOp.isEmpty()) {
                        staOp.push(ch);
                    } else {
                        while (!staOp.isEmpty()) {
                            long num1 = staNum.pop();
                            long num2 = staNum.pop();
                            char ch2 = staOp.pop();
                            switch (ch2) {
                                case '+' :
                                    staNum.push(num1 + num2);
                                    break;
                                case '-' :
                                    staNum.push(num2 - num1);
                                    break;
                                case '*' :
                                    staNum.push(num2 * num1);
                                    break;
                            }
                        }
                        staOp.push(ch);
                    }
                } else {
                    staOp.push(ch);
                }
            }
            pointer++;
        }
        staNum.push(Long.parseLong(sp.toString()));

        while (!staOp.isEmpty()) {
            long num1 = staNum.pop();
            long num2 = staNum.pop();
            char ch2 = staOp.pop();
            switch (ch2) {
                case '+' :
                    staNum.push(num1 + num2);
                    break;
                case '-' :
                    staNum.push(num2 - num1);
                    break;
                case '*' :
                    staNum.push(num2 * num1);
                    break;
            }
        }
        return staNum.pop();
    }*/

    // 答案
    int n;
    String num;
    int target;
    List<String> ans;

    public List<String> addOperators2(String num, int target) {
        this.n = num.length();
        this.num = num;
        this.target = target;
        this.ans = new ArrayList<String>();
        StringBuffer expr = new StringBuffer();
        backtrack(expr, 0, 0, 0);
        return ans;
    }

    public void backtrack(StringBuffer expr, int i, long res, long mul) {
        if (i == n) {
            if (res == target) {
                ans.add(expr.toString());
            }
            return;
        }
        int signIndex = expr.length();
        if (i > 0) {
            expr.append(0); // 占位，下面填充符号
        }
        long val = 0;
        // 枚举截取的数字长度（取多少位），注意数字可以是单个 0 但不能有前导零
        for (int j = i; j < n && (j == i || num.charAt(i) != '0'); ++j) {
            val = val * 10 + num.charAt(j) - '0';
            expr.append(num.charAt(j));
            if (i == 0) { // 表达式开头不能添加符号
                backtrack(expr, j + 1, val, val);
            } else { // 枚举符号
                expr.setCharAt(signIndex, '+');
                backtrack(expr, j + 1, res + val, val);
                expr.setCharAt(signIndex, '-');
                backtrack(expr, j + 1, res - val, -val);
                expr.setCharAt(signIndex, '*');
                backtrack(expr, j + 1, res - mul + mul * val, mul * val);
            }
        }
        expr.setLength(signIndex);
    }



}
