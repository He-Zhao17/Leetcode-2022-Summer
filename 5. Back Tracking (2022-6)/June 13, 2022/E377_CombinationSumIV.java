import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class E377_CombinationSumIV {
    int res = 0;
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, 0);
        dp[0] = 1;
        for (int i = 1; i < target + 1; ++i) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] <= i) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums = {1,2};
        E377_CombinationSumIV temp = new E377_CombinationSumIV();
        temp.combinationSum4(nums, 2);
    }
}
