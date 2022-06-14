import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class E60_PermutationSequence {
    public String getPermutation(int n, int k) {
        int t = 1;
        for (int i = n - 1; i >= 1; i--) {
            t *= i;
        }
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 1; i <= n; ++i) {
            set.add(i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int min = 0;
            if (k % t == 0) {
                min = k / t;
            } else {
                min = k / t + 1;
            }
            //sort
            int[] now = new int[set.size()];
            int index = 0;
            for (int j : set) {
                now[index] = j;
                index++;
            }
            Arrays.sort(now);

            sb.append(now[min - 1]);
            set.remove(now[min - 1]);
            k -= t * (min - 1);
            t = t > 1 ? (t / (n - i - 1)) : 1;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        E60_PermutationSequence temp = new E60_PermutationSequence();
        temp.getPermutation(3, 3);
    }
}
