import java.util.ArrayList;

public class E8_StringToInteger {
    public int myAtoi(String s) {
        if (s.length() == 0) {
            return 0;
        }

        //2^31 = 2147483648
        int curr = 0;
        boolean start = false;
        boolean startDigit = false;
        boolean isPositive = true;
        ArrayList<Integer> nums = new ArrayList<>();
        while (curr < s.length()) {
            char ch = s.charAt(curr);
            if (start) {
                if (!Character.isDigit(ch)) {
                    break;
                } else {
                    if (startDigit) {
                        nums.add(ch - '0');
                        if (nums.size() > 10) {
                            return isPositive ? 2147483647 : -2147483648;
                        }
                    } else {
                        if (ch - '0' != 0) {
                            startDigit = true;
                            nums.add(ch - '0');
                            if (nums.size() > 10) {
                                return isPositive ? 2147483647 : -2147483648;
                            }
                        }
                    }

                    curr++;
                }

            } else {
                if (ch == ' ') {
                    curr++;
                } else if (ch == '+') {
                    isPositive = true;
                    start = true;
                    curr++;
                } else if (ch == '-') {
                    isPositive = false;
                    start = true;
                    curr++;
                } else if (Character.isDigit(ch)) {
                    if (ch - '0' == 0) {
                        start = true;
                        curr++;
                    } else {
                        isPositive = true;
                        start = true;
                        startDigit = true;
                        nums.add(ch - '0');
                        curr++;
                    }
                } else {
                    return 0;
                }
            }
        }
        if (nums.size() < 10) {
            if (nums.size() == 0) {
                return 0;
            } else {
                int res = 0;
                for (int i = nums.size() - 1; i >= 0; --i) {
                    res += nums.get(i) * Math.pow(10, nums.size() - 1 - i);
                }
                return isPositive ? res :-1 * res;
            }
        } else {
            int[] border = {2,1,4,7,4,8,3,6,4,8};
            border[9] = isPositive ? 7 : 8;
            for (int i = 0; i < 10; ++i) {
                int digit = nums.get(i);
                if (digit < border[i]) {
                    int res = 0;
                    for (int k = nums.size() - 1; k >= 0; --k) {
                        res += nums.get(k) * Math.pow(10, nums.size() - 1 - k);
                    }
                    return isPositive ? res :-1 * res;
                } else if (digit > border[i]) {
                    return isPositive ? 2147483647 : -2147483648;
                }
            }
            return isPositive ? 2147483647 : -2147483648;
        }
    }

    public static void main(String[] args) {
        String s = "20000000000000000000";
        E8_StringToInteger temp = new E8_StringToInteger();
        int res = temp.myAtoi(s);
        System.out.println(res);

    }
}
