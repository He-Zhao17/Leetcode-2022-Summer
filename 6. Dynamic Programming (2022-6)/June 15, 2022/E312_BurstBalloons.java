import java.util.ArrayList;
import java.util.Arrays;

public class E312_BurstBalloons {
    public int maxCoins(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len + 2][len + 2];
        for (int i = 0; i < len + 2; ++i) {
            Arrays.fill(dp[i], 0);
        }
        int[] val = new int[len + 2];
        val[0] = val[len + 1] = 1;
        for (int i = 1; i <= len; ++i) {
            val[i] = nums[i - 1];
        }
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 2; j <= len + 1; j++) {
                for (int k = i + 1; k < j; k++) {
                    int sum = val[i] * val[k] * val[j];
                    sum += dp[i][k] + dp[k][j];
                    dp[i][j] = Math.max(dp[i][j], sum);
                }
            }
        }
        return dp[0][len + 1];
    }

}
