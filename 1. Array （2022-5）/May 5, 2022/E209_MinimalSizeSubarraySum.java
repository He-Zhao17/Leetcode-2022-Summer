import java.util.HashMap;
import java.util.Map;

public class E209_MinimalSizeSubarraySum {
    public int minSubArrayLen (int target, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int[] preSumIndex = new int[nums.length + 1];
        preSumIndex[0] = 0;


        int preSum = 0;
        //不能为0
        int res = Integer.MAX_VALUE;

        outer1:
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            preSumIndex[i + 1] = preSum;

            if (preSum - target < 0) {
                continue;
            } else {
                for (int j = 0; j <= i + 1; j++) {
                    if (preSumIndex[j] < preSum - target) {
                        if (preSumIndex[j + 1] > preSum - target) {
                            res = Math.min(res, i - j + 1);
                            continue outer1;
                        } else {
                            continue;
                        }
                    } else if (preSumIndex[j] == preSum - target) {
                        res = Math.min(res, i - j + 1);
                        continue outer1;
                    }
                }
            }

        }

        //没找到需要重置为0
        if (res == Integer.MAX_VALUE) {
            return 0;
        }
        return res;
    }

    //Better： 滑动窗口法 by me
    public int minSubArrayLen2 (int target, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int l = 0;
        int r = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;

        /*  最优写法 很优雅
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum >= s) {
                    ans = Math.min(ans, j - i + 1);
                    break;
                }
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
        * */
        while (r < nums.length) {
            while (sum < target && r < nums.length) {
                sum += nums[r];
                r++;
            }
            //!!!!!!!!!!!!!!!!!注意边界问题！！！！

            if (sum >= target) {
                res = Math.min(res, r - l);
                while (sum >= target) {
                    sum -= nums[l];
                    l++;
                }
                res = Math.min(res, r - l + 1);
            }


        }
        if (res == Integer.MAX_VALUE) {
            return 0;
        }
        return res;
    }



    public static void main(String[] args) {
        E209_MinimalSizeSubarraySum temp = new E209_MinimalSizeSubarraySum();
        int[] nums = {2,3,1,2,4,3};
        int res = temp.minSubArrayLen(7, nums);
    }
}
