import java.util.Arrays;

public class E329_LongestIncreasePathInMatrix {
    int[][] dp;
    public int longestIncreasingPath(int[][] matrix) {
        dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; ++i) {
            Arrays.fill(dp[i], -1);
        }
        int max = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; ++j) {
                int temp = help(i, j, matrix);
                max = max > temp ? max : temp;
            }
        }
        return max;
    }

    private int help(int i, int j, int[][] matrix) {
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int max = 1;
        if (i - 1 >= 0 && matrix[i - 1][j] > matrix[i][j]) {
            int temp = help(i - 1, j, matrix);
            max = max > temp + 1 ? max : temp + 1;
        }
        if (j + 1 < matrix[0].length && matrix[i][j + 1] > matrix[i][j]) {
            int temp = help(i, j + 1, matrix);
            max = max > temp + 1 ? max : temp + 1;
        }
        if (i + 1 < matrix.length && matrix[i + 1][j] > matrix[i][j]) {
            int temp = help(i + 1, j, matrix);
            max = max > temp + 1 ? max : temp + 1;
        }
        if (j - 1 >= 0 && matrix[i][j - 1] > matrix[i][j]) {
            int temp = help(i, j - 1, matrix);
            max = max > temp + 1 ? max : temp + 1;
        }
        dp[i][j] = max;
        return max;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {{9,9,4},{6,6,8},{2,1,1}};
        E329_LongestIncreasePathInMatrix temp = new E329_LongestIncreasePathInMatrix();
        temp.longestIncreasingPath(matrix);
    }
}
