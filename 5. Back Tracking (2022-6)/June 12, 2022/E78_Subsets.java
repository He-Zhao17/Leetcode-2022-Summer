import java.util.ArrayList;
import java.util.List;

public class E78_Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<Integer>());
        if (len == 0) {
            return ans;
        }
        List<Integer> temp = new ArrayList<>();
        ans = new ArrayList<>();
        for (int i = 0; i < (1 << len); i++) {
            temp = new ArrayList<>();
            for (int j = 0; (1 << j) <= i; j++) {
                if ((i & (1 << j)) != 0) {
                    temp.add(nums[j]);
                }
            }
            ans.add(temp);
        }
        return ans;


    }

}
