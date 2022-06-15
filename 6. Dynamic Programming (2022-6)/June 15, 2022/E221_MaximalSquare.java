public class E221_MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int[][] dp = new int[r][c];
        int max = 0;
        for (int i = 0; i < r; ++i) {
            dp[i][0] = matrix[i][0] - '0';
            max = dp[i][0] > max ? dp[i][0] :max;
        }
        for (int i = 0; i < c; ++i) {
            dp[0][i] = matrix[0][i] - '0';
            max = dp[0][i] > max ? dp[0][i] :max;
        }

        for (int i = 1; i < r; ++i) {
            for (int j = 1; j < c; ++j) {
                if (matrix[i][j] - '0' == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i -1][j - 1], dp[i][j - 1])) + 1;
                    if (dp[i][j] > max) {
                        max = dp[i][j];
                    }
                }
            }
        }
        return max * max;
    }

    public static void main(String[] args) {
        char[][] matrix = new char[][] {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        E221_MaximalSquare temp = new E221_MaximalSquare();
        temp.maximalSquare(matrix);



    }
}
