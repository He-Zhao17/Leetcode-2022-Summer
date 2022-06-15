import java.util.Arrays;

public class E375_GuessNumberHigherOrLowerII {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 0; i <= n; ++i) {
            Arrays.fill(dp[i], 0);
        }


        for (int i = 2; i <= n; ++i) {
            for (int j = i; j <= n; ++j) {
                int max = Integer.MAX_VALUE;
                for (int k = j - i + 1; k <= j; ++k) {
                    int l = k == j - i + 1 ? 0 : dp[j - i + 1][k - 1];
                    int r = k == j ? 0 : dp[k + 1][j];
                    int sum = Math.max(l, r);
                    max = max <= k + sum ? max : k + sum;
                }
                dp[j - i + 1][j] = max;
            }
        }
        return dp[1][n];


    }
}
