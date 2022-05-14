public class E53_MaximumSubarray {
    //贪心算法
    public int maxSubArray(int[] nums) {
        /*if (nums == null) {
            return Integer.MIN_VALUE;
        }*/

        int pre = 0;
        //max_current = nums[0]而不是0！！！因为是从第一个开始算的
        int max_current = nums[0];

        for (int i = 0; i < nums.length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            max_current = Math.max(pre, max_current);
        }
        return max_current;
    }


    //分治法  ----》 线段树
    public int maxSubArray2 (int[] nums) {
        return getStatus(nums, 0, nums.length - 1).mSum;
    }

    private Status getStatus(int[] nums, int l, int r) {
        if (l == r) {
            return new Status(nums[l], nums[l], nums[l], nums[l]);
        }
        int mid = (l + r) / 2;
        Status sl = getStatus(nums, l, mid);
        Status sr = getStatus(nums, mid + 1, r);
        int ls = Math.max(sl.lSum, sl.iSum + sr.lSum);
        int rs = Math.max(sr.rSum, sr.iSum + sl.rSum);
        int is = sl.iSum + sr.iSum;
        //!!!!!!!!!!!!!!!!!!!是mSUM不是lSum和rSUM
        int ms = Math.max(sl.mSum, sr.mSum);
        ms = Math.max(ms, sl.rSum + sr.lSum);
        return new Status(ls, rs, ms, is);
    }

    class Status {
        int lSum;
        int rSum;
        int mSum;
        int iSum;

        Status(int lSum, int rSum, int mSum, int iSum) {
            this.lSum = lSum;
            this.rSum = rSum;
            this.mSum = mSum;
            this.iSum = iSum;
        }
    }
}
