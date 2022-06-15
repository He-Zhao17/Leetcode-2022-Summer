public class E265_PaintHouseII {
    public int minCost(int[][] costs) {
        int[][] dp = new int[costs.length][costs[0].length];
        for (int i = 0; i < costs[0].length; i++) {
            dp[0][i] = costs[0][i];
        }
        for (int i = 1; i < costs.length; ++i) {
            for (int j = 0; j < costs[0].length; ++j) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < costs[0].length; ++k) {
                    if (k == j) {
                        continue;
                    }
                    if (min > dp[i - 1][k]) {
                        min = dp[i - 1][k];
                    }
                }
                dp[i][j] = min + costs[i][j];
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < costs[0].length; ++i) {
            if (min > dp[costs.length - 1][i]) {
                min = dp[costs.length - 1][i];
            }
        }
        return min;
    }
}
