import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class E254_FactorCombinations {
    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> getFactors(int n) {
        if (n < 2) {
            return ans;
        }
        help(2, n, n);
        return ans;
    }

    private void help (int index, int now, int n) {
        for (int i = index; i <= Math.pow(now, 0.5); ++i) {
            if (now % i == 0) {
                path.add(i);
                if (now / i == 1) {
                    ans.add(new ArrayList<>(path));
                } else {
                    if (now / i < i) {
                        path.removeLast();
                        break;
                    } else {
                        help(i, now / i, n);
                    }
                }
                path.removeLast();
            }
        }
        if (now < n) {
            path.add(now);
            ans.add(new ArrayList<>(path));
            path.removeLast();
        }

    }

    public static void main(String[] args) {
        int n = 12;
        E254_FactorCombinations temp = new E254_FactorCombinations();
        temp.getFactors(12);
    }
}


