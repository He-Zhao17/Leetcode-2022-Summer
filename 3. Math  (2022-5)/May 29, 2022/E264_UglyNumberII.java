public class E264_UglyNumberII {
    //答案 动态规划 三指针
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int p2 = 1;
        int p3 = 1;
        int p5 = 1;

        for (int i = 2; i < n + 1; i++) {
            int num2 = dp[p2] * 2, num3 = dp[p3] * 3, num5 = dp[p5] * 5;
            dp[i] = Math.min(Math.min(num2, num3), num5);
            if (dp[i] == num2) {
                p2++;
                //注意不要continue 会重复的！！！
                //continue;
            }
            if (dp[i] == num3) {
                p3++;
                //注意不要continue 会重复的！！！
                //continue;
            }
            if (dp[i] == num5) {
                p5++;
                //注意不要continue 会重复的！！！
                //continue;
            }
        }
        return dp[n];
    }

}
