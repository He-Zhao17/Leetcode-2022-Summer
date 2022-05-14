public class E376_WiggleSubsequence {
    //某个序列被称为「上升摆动序列」，当且仅当该序列是摆动序列，且最后一个元素呈上升趋势。如序列 [1,3,2,4][1,3,2,4] 即为「上升摆动序列」。
    //
    //某个序列被称为「下降摆动序列」，当且仅当该序列是摆动序列，且最后一个元素呈下降趋势。如序列 [4,2,3,1][4,2,3,1] 即为「下降摆动序列」。
    //
    //特别地，对于长度为 11 的序列，它既是「上升摆动序列」，也是「下降摆动序列」。
    //
    //序列中的某个元素被称为「峰」，当且仅当该元素两侧的相邻元素均小于它。如序列 [1,3,2,4][1,3,2,4] 中，33 就是一个「峰」。
    //
    //序列中的某个元素被称为「谷」，当且仅当该元素两侧的相邻元素均大于它。如序列 [1,3,2,4][1,3,2,4] 中，22 就是一个「谷」。
    //
    //特别地，对于位于序列两端的元素，只有一侧的相邻元素小于或大于它，我们也称其为「峰」或「谷」。如序列 [1,3,2,4][1,3,2,4] 中，11 也是一个「谷」，44 也是一个「峰」。
    //
    //因为一段相邻的相同元素中我们最多只能选择其中的一个，所以我们可以忽略相邻的相同元素。现在我们假定序列中任意两个相邻元素都不相同，即要么左侧大于右侧，要么右侧大于左侧。对于序列中既非「峰」也非「谷」的元素，我们称其为「过渡元素」。如序列 [1,2,3,4][1,2,3,4] 中，22 和 33 都是「过渡元素」。
    //
    //正常的动态规划一般是dp[i]表示以nums[i]结尾的子数组 这里其实也可以用 每次用ans=max(ans, xxx)来处理最佳值(O(n^2)复杂度)
    //
    //题解中使用的up[i]和down[i]表示数组nums[0...i]中的最长以上升趋势结尾和下降趋势作为结尾的子数列的长度 这样的话 可能带来一个问题 我TM不知道最后子序列是以什么结尾 凭啥你答案直接nums[i]和nums[i-1]作比较？
    //
    //我们依次来分析
    //
    //nums[i-1]==nums[i] 等于是新加进来的nums[i]没有带来新信息 原来我们假如利用了nums[i-1]， 那么现在两个数持平，既没法上升也没法下降; 假如我们原来没有利用nums[i-1]那么同样nums[i]不会被用到 故 up[i]=up[i-1], down[i]=down[i-1]
    //
    //nums[i] > nums[i-1] 我们考虑 up[i]可能的来源方式 只会跟up[i-1]和down[i-1]有关
    //
    //首先会不会up[i-1]之后再up了？ 不会 因为不可以两次重复up
    //
    //down[i-1]之后可能会跳跃道nums[i]上面 但是我们担心的一个点是 谁说down[i-1]对应子序列结尾的就是nums[i-1]? 确实如此。 假设down[i-1]对应的元素叫a_k不是nums[i-1], a_k<nums[i]时候，我们同样可以让a_k跳跃到nums[i]上；假设a_k>=nums[i-1], 我们可以做交换把a_k换成nums[i-1]因为这样同样满足条件=> 总之可以跳跃到nums[i]上 =>up[i]=max(up[i-1], down[i-1]+1);
    //
    //我们考虑 down[i]可能的来源方式 只会跟up[i-1]和down[i-1]有关
    //
    //首先会不会down[i-1]之后再down了？ 不会 因为不可以两次重复down
    //
    //up[i-1]之后可能会下降道nums[i]上面 但是我们担心的一个点是 谁说up[i-1]对应子序列结尾的就是nums[i-1]? 确实如此。 假设up[i-1]对应的元素叫a_k不是nums[i-1], a_k>=nums[i]>nums[i-1]时候，我们可以让他下降到nums[i-1], 这个最大值会被包括在down[i-1]里；a_k<nums[i]时候没法下降到nums[i-1] 不满足条件 =>down[i]=max(down[i-1], down[i-1]);
    //
    //nums[i] < nums[i-1] 这种情况和情况2是对称的 不做展开
    //https://leetcode.cn/problems/wiggle-subsequence/solution/zheng-ming-wei-shi-yao-dong-tai-gui-hua-97d4m/
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length <= 2) {
            return nums.length;
        }


        int[] up = new int[nums.length];
        int[] down = new int[nums.length];
        up[0] = 1;
        down[0] = 1;

        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] == nums[i - 1]) {
                up[i] = up[i - 1];
                down[i] = down[i - 1];
            } else if (nums[i] > nums[i - 1]) {
                up[i] = Math.max(up[i - 1], down[i - 1] + 1);
                down[i] = down[i - 1];
            } else {
                down[i] = Math.max(down[i - 1], up[i - 1] + 1);
                up[i] = up[i - 1];
            }
        }
        return Math.max(up[nums.length - 1], down[nums.length - 1]);




    }


    //贪心算法
    //本题大家都很容易想到用动态规划来求解，求解的过程类似最长上升子序列，不过是需要判断两个序列。大家在实现动态规划的平方复杂度时，就会考虑如何优化到线性复杂度。
    //
    //假设 up[i] 表示 nums[0:i] 中最后两个数字递增的最长摆动序列长度，down[i] 表示 nums[0:i] 中最后两个数字递减的最长摆动序列长度，只有一个数字时默认为 1。
    //
    //接下来我们进行分类讨论：
    //
    //nums[i+1] > nums[i]
    //假设 down[i] 表示的最长摆动序列的最远末尾元素下标正好为 i，遇到新的上升元素后，up[i+1] = down[i] + 1 ，这是因为 up 一定从 down 中产生（初始除外），并且 down[i] 此时最大。
    //假设 down[i] 表示的最长摆动序列的最远末尾元素下标小于 i，设为 j，那么 nums[j:i] 一定是递增的，因为若完全递减，最远元素下标等于 i，若波动，那么 down[i] > down[j]。由于 nums[j:i] 递增，down[j:i] 一直等于 down[j] ，依然满足 up[i+1] = down[i] + 1 。
    //nums[i+1] < nums[i]，类似第一种情况
    //nums[i+1] == nums[i]，新的元素不能用于任何序列，保持不变
    //
    //作者：lgh18
    //链接：https://leetcode.cn/problems/wiggle-subsequence/solution/tan-xin-si-lu-qing-xi-er-zheng-que-de-ti-jie-by-lg/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int wiggleMaxLength2(int[] nums) {


        int up;
        int down;
        up = down = 1;

        for (int i = 1; i < nums.length; ++i) {
           if (nums[i] > nums[i - 1]) {
                up = down + 1;
            } else if (nums[i] < nums[i - 1]){
               down = up + 1;
           }
        }

        return nums.length == 0 ? 0 : Math.max(up, down);



    }

}


























