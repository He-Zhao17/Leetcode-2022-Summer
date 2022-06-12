import java.util.HashMap;

public class E96_UniqueBinarySearchTrees {
    HashMap<Integer, Integer> map = new HashMap<>();
    public int numTrees(int n) {
        return help(1, n);

    }
    private int help (int l, int r) {
        if (l == r) {
            return 1;
        }
        if (map.containsKey(r - l + 1)) {
            return map.get(r - l + 1);
        }
        int ans = 0;
        for (int i = l; i <= r; ++i) {
            if (i == l) {
                ans += help(l + 1, r);
                continue;
            }
            if (i == r) {
                ans += help(l, r - 1);
                continue;
            }
            int lTree = help (l, i - 1);
            int rTree = help (i + 1, r);
            ans += lTree * rTree;
        }
        map.put(r - l + 1, ans);
        return ans;
    }
}
