import java.util.ArrayList;
import java.util.List;

public class E163_MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {

        int l = lower;
        int r = upper;
        int currentPointer = 0;
        List<String> res = new ArrayList<>();
        if (nums.length == 0) {
            if (lower == upper) {
                res.add(String.valueOf(lower));
            } else {
                res.add(String.valueOf(lower) + "->" + String.valueOf(upper));
            }
            return res;
        }

        if (lower < nums[0] - 1) {
            res.add(String.valueOf(lower) + "->" + String.valueOf(nums[0] - 1));
        } else {
            if (lower == nums[0] - 1) {
                res.add(String.valueOf(lower));
            }
        }
        l = nums[0];
        currentPointer++;
        while (currentPointer < nums.length) {
            if (nums[currentPointer] == nums[currentPointer - 1] + 1) {
                currentPointer++;
                continue;
            } else {
                if (nums[currentPointer] == nums[currentPointer - 1] + 2) {
                    res.add(String.valueOf(nums[currentPointer] - 1));
                    currentPointer++;
                } else {
                    res.add(String.valueOf(nums[currentPointer - 1] + 1) +
                            "->" + String.valueOf(nums[currentPointer] - 1));
                    currentPointer++;
                }
            }
        }
        if (nums[currentPointer - 1] < upper) {
            if (nums[currentPointer - 1] == upper - 1) {
                res.add(String.valueOf(upper));
            } else {
                res.add(String.valueOf(nums[currentPointer - 1] + 1) +
                        "->" + String.valueOf(upper));
            }
            return res;
        } else {
            return res;
        }
    }

    //如果前后两个数 num - 1 > prev + 1， 说明缺失一个区间 prev + 1 -> num - 1
    //如果前后两个数 num - 1 == prev + 1， 说明缺失一个数值 num - 1
    //否者当前值比 lower 还小, 不需要处理
    //
    //........相差无几
    public List<String> findMissingRanges2 (int[] nums, int lower, int upper) {
        int curr = 1;
        List<String> res = new ArrayList<>();
        if (nums.length == 0) {
            if (upper == lower) {
                res.add(String.valueOf(lower));
            } else {
                res.add(String.valueOf(lower) + "->" + String.valueOf(upper));
            }
            return res;
        }


        if (nums[0] > lower + 1) {
            res.add(String.valueOf(lower) + "->" + String.valueOf(nums[0] - 1));
        } else if (nums[0] == lower + 1) {
            res.add(String.valueOf(lower));
        }


        while (curr < nums.length) {
            if (nums[curr] - 1 > nums[curr - 1] + 1) {
                res.add(String.valueOf(nums[curr - 1] + 1) +
                        "->" + String.valueOf(nums[curr] - 1));
            } else if (nums[curr] - 1 == nums[curr - 1] + 1) {
                res.add(String.valueOf(nums[curr] - 1));
            }
            curr++;
        }

        if (nums[nums.length - 1] + 1 < upper) {
            res.add(String.valueOf(nums[nums.length - 1] + 1) + "->" + String.valueOf(upper));
        } else if (nums[nums.length - 1] + 1 == upper) {
            res.add(String.valueOf(upper));
        }
        return res;
    }

}
