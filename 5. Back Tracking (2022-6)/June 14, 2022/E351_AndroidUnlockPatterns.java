import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class E351_AndroidUnlockPatterns {
    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    int[][] through = new int[10][10];
    public int numberOfPatterns(int m, int n) {
        for (int i = 1; i <= 9; ++i) {
            for (int j = i; j <= 9; ++j) {
                if (j == i) {
                    through[i][j] = 0;
                }
                int rowI = (i - 1) / 3 + 1;
                int rowJ = (j - 1) / 3 + 1;
                int colI = (i % 3 == 0) ? 3 : i % 3;
                int colJ = (j % 3 == 0) ? 3 : j % 3;
                if (rowI == rowJ) {
                    if (colI - colJ == 1 || colI - colJ == -1) {
                        through[i][j] = 0;
                        through[j][i] = 0;
                    } else {
                        through[i][j] = (i + j) / 2;
                        through[j][i] = (i + j) / 2;
                    }
                } else {
                    if (colI == colJ) {
                        if (rowI - rowJ == 1 || rowI - rowJ == -1) {
                            through[i][j] = 0;
                            through[j][i] = 0;
                        } else {
                            through[i][j] = (i + j) / 2;
                            through[j][i] = (i + j) / 2;
                        }
                    } else {
                        int r = Math.abs(rowI - rowJ);
                        int c = Math.abs(colI - colJ);
                        if (r == 1 && c == 1) {
                            through[i][j] = 0;
                            through[j][i] = 0;
                        } else if ((r == 1 && c == 2) || (r == 2 && c== 1)) {
                            through[i][j] = 0;
                            through[j][i] = 0;
                        } else {
                            through[i][j] = 5;
                            through[j][i] = 5;
                        }
                    }
                }
            }
        }
        boolean[] used = new boolean[10];
        Arrays.fill(used, false);
        helper(m, n, used, 0);
        return ans.size();
    }
    private void helper (int m, int n, boolean[] used, int prev) {
        for (int i = 1; i <= 9; i++) {
            if (!used[i]) {
                int thro = through[prev][i];
                if (thro == 0 || path.contains(thro)) {
                    used[i] = true;
                    path.add(i);
                    int len = path.size();
                    if (len >= m && len <= n) {
                        ans.add(new ArrayList<>(path));
                        if (len < n) {
                            helper(m, n, used, i);
                        }
                    } else {
                        helper(m, n, used, i);
                    }
                    path.removeLast();
                    used[i] = false;
                }
            }
        }
    }
}
