public class E300_LOngestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; ++i) {
            int lon = 0;
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i]) {
                    lon = lon > dp[j] ? lon : dp[j];
                }
            }
            dp[i] = lon + 1;
            max = max > dp[i] ? max : dp[i];
        }
        return max;
    }

    public static void main(String[] args) {
        E300_LOngestIncreasingSubsequence temp = new E300_LOngestIncreasingSubsequence();
        temp.lengthOfLIS(new int[] {10,9,2,5,3,7,101,18});
    }
}
