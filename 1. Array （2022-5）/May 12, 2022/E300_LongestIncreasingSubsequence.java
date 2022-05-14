public class E300_LongestIncreasingSubsequence {
    //普通动态规划----我是傻逼
    //https://leetcode.cn/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-dong-tai-gui-hua-2/
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return  0;
        }
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            dp[i] = 1;
        }

        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }

            }
            res = Math.max (res, dp[i]);
        }
        return res;




    }

    //贪心 + 二分查找 -----我是傻逼
    //https://leetcode.cn/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-dong-tai-gui-hua-2/
    //维护一个数组 d[i]d[i] ，表示长度为 ii 的最长上升子序列的末尾元素的最小值

    public int lengthOfLIS2(int[] nums) {
        int len = 1;
        // 学到了 防止nums.length == 0
        int[] d = new int[nums.length + 1];

        if (nums.length == 0) {
            return 0;
        }

        d[1] = nums[0];
        for ( int i = 1; i < nums.length; ++i) {
            if (nums[i] > d[len]) {
                len++;
                d[len] = nums[i];
            } else {
                int l = 1;
                int r = len;
                int pos = 0;
                while (l <= r) {
                    int mid = l + (r - l) / 2;
                    if (d[mid] < nums[i]) {
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                d[pos + 1] = nums[i];

            }
        }
        return len;


    }

}
