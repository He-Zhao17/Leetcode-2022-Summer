import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class E46_Permutations {
    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        int remain = nums.length;
        help(used, remain, nums);
        return ans;
    }
    private void help (boolean[] used, int remain, int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            if (!used[i]) {
                path.add(nums[i]);
                remain--;
                used[i] = true;
                if (remain == 0) {
                    ans.add(new ArrayList<>(path));
                } else if (remain > 0) {
                    help(used, remain, nums);
                }
                used[i] = false;
                remain++;
                path.removeLast();
            }
        }
    }
}
