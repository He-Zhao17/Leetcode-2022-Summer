import java.util.Arrays;

public class E256_PaintHouse {
    public int minCost(int[][] costs) {
        int[][] dp = new int[costs.length][3];
        for (int i = 0; i < 3; i++) {
            dp[0][i] = costs[0][i];
        }
        for (int i = 1; i < costs.length; ++i) {
            for (int j = 0; j < 3; ++j) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < 3; ++k) {
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
        return Math.min(dp[costs.length - 1][0],Math.min(dp[costs.length - 1][1], dp[costs.length - 1][2]));
    }

}
