import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class E216_CombinationSumIII {
    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        if (n == 1) {
            return ans;
        }
        help(0, 1, 0, k, n);
        return ans;
    }
    private void help (int sum, int index, int ks, int k, int n) {
        for (int i = index; i <= 9; ++i) {
            path.add(i);
            if (sum + i > n) {
                path.removeLast();
                break;
            } else if (sum + i == n) {
                if (ks + 1 == k) {
                    ans.add(new ArrayList<>(path));
                } else {
                    path.removeLast();
                    break;
                }
            } else {
                if (ks + 1 < k) {
                    help(sum + i, i + 1, ks + 1, k, n);
                }
            }
            path.removeLast();
        }
    }
}
