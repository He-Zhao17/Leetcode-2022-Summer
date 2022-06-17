public class E276_PaintFence {
    public int numWays(int n, int k) {
        if (n == 1) {
            return k;
        }
        if (n == 2) {
            if (k < 2) {
                return 1;
            }
            return n * k;
        }
        int[][] dp = new int[n + 1][k];
        for (int i = 0; i < k; i++) {
            dp[1][i] = 1;
        }
        for (int i = 0; i < k; ++i) {
            dp[2][i] = k;
        }
        for (int i = 3; i <= n; ++i) {
            for (int j = 0; j < k; j++) {
                int sum = 0;
                for (int q = 0; q < k; q++) {
                    sum += q == j ? 0 : dp[i - 1][q];
                    sum += q == j ? 0 : dp[i - 2][q];
                }
                dp[i][j] = sum;
            }
        }
        int sum = 0;
        for (int i = 0; i < k; ++i) {
            sum += dp[n][i];
        }
        return sum;
    }

}
