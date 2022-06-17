public class E91_DecodeWays {
    public int numDecodings(String s) {
        int len = s.length();
        int[] dp = new int[len];
        dp[0] = s.charAt(0) - '0' == 0 ? 0 : 1;
        if (len == 1) {
            return dp[0];
        }
        if (dp[0] == 0) {
            return 0;
        }
        for (int i = 1; i < len; ++i) {
            int b = s.charAt(i) - '0';
            int f = s.charAt(i - 1) - '0';
            int sum = 0;
            if (b == 0) {
                if (f > 2 || f == 0) {
                    return 0;
                }
                sum =  i - 2 >= 0 ? dp[i - 2] : 1;
            } else {
                if (f == 0) {
                    sum = dp[i - 1];
                } else {
                    if (f * 10 + b <= 26) {
                        sum += i - 2 >= 0 ? dp[i - 2] : 1;
                    }
                    sum += dp[i - 1];
                }
            }
            dp[i] = sum;
        }
        return dp[len - 1];
    }

    public static void main(String[] args) {
        E91_DecodeWays temp = new E91_DecodeWays();
        temp.numDecodings("2611055971756562");
    }
}