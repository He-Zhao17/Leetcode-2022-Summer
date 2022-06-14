import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class E40_CombinationSumII {
    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return ans;
        }
        Arrays.sort(candidates);
        help(candidates, 0, 0, target);
        return ans;
    }

    private void help (int[] cadidates, int index, int sum, int target) {
        for (int i = index; i < cadidates.length; i++) {
            if (i > index && cadidates[i] == cadidates[i - 1]) {
                continue;
            }
            path.add(cadidates[i]);
            if (sum + cadidates[i] > target) {
                path.removeLast();
                break;
            } else if (sum + cadidates[i] == target) {
                ans.add(new ArrayList<>(path));
            } else {
                help(cadidates, i + 1, sum + cadidates[i], target);
            }
            path.removeLast();
        }

    }
}
