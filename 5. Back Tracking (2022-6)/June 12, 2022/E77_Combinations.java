import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class E77_Combinations {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        if (k == 0) {
            ans.add(path);
            return ans;
        }
        int used = 0;
        help(1, n, k, 0);
        return ans;
    }
    private void help (int start, int n, int k, int used) {
        for (int i = start; i <= n; ++i) {
            path.add(i);
            if (used + 1 >= k) {
                ans.add(new ArrayList<>(path));
            } else {
                help(start + 1, n, k, used + 1);
            }

            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        E77_Combinations temp = new E77_Combinations();
        int n = 4;
        int k = 2;
        List<List<Integer>> ans = temp.combine(n, k);

    }
}
