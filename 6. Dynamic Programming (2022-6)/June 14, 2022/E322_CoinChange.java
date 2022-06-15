import java.util.Arrays;

public class E322_CoinChange {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, 0);
        for (int i = 1; i <= amount; ++i) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; ++j) {
                if (i < coins[j]) {
                    break;
                }

                if (i - coins[j] != 0 && dp[i - coins[j]] == -1) {
                    continue;
                } else {
                    if (min > dp[i - coins[j]] + 1) {
                        min = dp[i - coins[j]] + 1;
                    }
                }
            }
            dp[i] = min == Integer.MAX_VALUE ? -1 : min;
        }
        return dp[amount];

    }

    public static void main(String[] args) {
        E322_CoinChange temp = new E322_CoinChange();
        int[] coins = new int[] {2};
        temp.coinChange(coins, 3);
    }
}
