import org.w3c.dom.ls.LSException;

import java.util.*;

public class E90_SubsetsII {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new LinkedList<>();
    boolean[] used;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums.length == 0) {
            result.add(path);
            return result;
        }
        Arrays.sort(nums);
        used = new boolean[nums.length];
        Arrays.fill(used, false);
        help(nums, 0, used);
        return result;


    }

    private void help (int[] nums, int index, boolean[] used) {
        result.add(new ArrayList<>(path));
        if (index >= nums.length) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            help(nums, i+ 1, used);
            path.remove(path.size()-1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        E90_SubsetsII temp = new E90_SubsetsII();
        int[] nums = {1,2,2};
        List<List<Integer>> ans = temp.subsetsWithDup(nums);
    }
}
