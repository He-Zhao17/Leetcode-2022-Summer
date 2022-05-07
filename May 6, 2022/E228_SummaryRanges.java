import java.util.ArrayList;
import java.util.List;

public class E228_SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int i = 0;
        int j = 0;
        outer1:
        while (j < nums.length) {
            for (int k = j; k < nums.length - 1; k++) {
                if (nums[k + 1] != nums[k] + 1) {
                    j = k;
                    if (j == i) {
                        res.add(String.valueOf(nums[i]));
                    } else {
                        res.add(String.valueOf(nums[i]) + "->" + String.valueOf(nums[j]));
                    }

                    i = j + 1;
                    j = j + 1;
                    continue outer1;
                }
            }


            if (j != nums.length - 1) {
                if (nums[nums.length - 1] == nums[nums.length - 2]  + 1) {
                    res.add(String.valueOf(nums[i]) + "->" + String.valueOf(nums[nums.length - 1]));
                } else {
                    res.add(String.valueOf(nums[i]) + "->" + String.valueOf(nums[nums.length - 2]));
                    res.add(String.valueOf(nums[nums.length - 1]));
                }

            } else {
                if (j == i) {
                    res.add(String.valueOf(nums[i]));
                } else {
                    res.add(String.valueOf(nums[i]) + "->" + String.valueOf(nums[nums.length - 1]));
                }
            }
            return res;
        }
        return res;

    }


}
