import java.util.Arrays;

/**
 * <p></p>
 * <p></p>
 *
 * @author: He Zhao
 * @create: 2022-07-11 12:54
 */
public class E200_NumberOfIslands {
    boolean[][] isVisited;
    public int numIslands(char[][] grid) {
        isVisited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < isVisited.length; i++) {
            Arrays.fill(isVisited[i], false);
        }
        int sum = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == '0') {
                    continue;
                } else {
                    if (isVisited[i][j]) {
                        continue;
                    } else {
                        sum++;
                        help(grid, i, j);
                    }
                }
            }
        }
        return sum;
    }

    private void help (char[][] grid, int i, int j) {
        if (grid[i][j] == '1') {
            if (!isVisited[i][j]) {
                isVisited[i][j] = true;
                if (i - 1 >= 0) {
                    help(grid, i - 1, j);
                }
                if (j - 1 >= 0) {
                    help(grid, i, j - 1);
                }
                if (i + 1 < grid.length) {
                    help(grid, i + 1, j);
                }
                if (j + 1 < grid[0].length) {
                    help(grid, i, j + 1);
                }
            }
        }
    }
}
