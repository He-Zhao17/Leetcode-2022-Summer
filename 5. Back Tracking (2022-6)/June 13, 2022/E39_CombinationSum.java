import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class E39_CombinationSum {
    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (target == 0) {
            ans.add(path);
            return ans;
        }

        Arrays.sort(candidates);
        int sum = 0;
        int index = 0;
        helpMethod(candidates, index, sum, target);
        return ans;
    }

    private void helpMethod(int[] cadidates, int index, int sum, int target) {
        for (int i = index; i < cadidates.length; ++i) {
            path.add(cadidates[i]);
            if (sum + cadidates[i] == target) {
                ans.add(new ArrayList<>(path));
            } else if (sum + cadidates[i] > target) {
                path.removeLast();
                break;
            } else {
                helpMethod(cadidates, i, sum + cadidates[i], target);
            }
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 6, 7};
        E39_CombinationSum temp = new E39_CombinationSum();
        temp.combinationSum(nums, 7);
    }
}
