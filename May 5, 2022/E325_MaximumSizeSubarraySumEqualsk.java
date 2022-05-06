import java.util.HashMap;
import java.util.Map;

public class E325_MaximumSizeSubarraySumEqualsk {
    //哈希表记录前缀
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }

        Map<Integer, Integer> preSumIndex = new HashMap<>();
        int preSum = 0;
        //!!!!!!!!!!!!!最开始前缀是-1
        preSumIndex.put(0, -1);

        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            if (!preSumIndex.containsKey(preSum)) {
                preSumIndex.put(preSum, i);
            }

            if (preSumIndex.containsKey(preSum - k)) {
                res = Math.max(res, i - preSumIndex.get(preSum - k));
            }
        }
        return res;






    }
}
