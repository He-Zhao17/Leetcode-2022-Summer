import java.util.Arrays;

public class E85_MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int[][] leftOne = new int[r][c];
        for (int i = 0; i < r; ++i) {
            leftOne[i][0] = matrix[i][0] - '0';
            for (int j = 1; j < c; ++j) {
                if (matrix[i][j] - '0' == 0) {
                    leftOne[i][j] = 0;
                } else {
                    leftOne[i][j] = leftOne[i][j - 1] + 1;
                }
            }
        }
        int[][] dp = new int[r][c];
        int m = 0;
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                if (leftOne[i][j] == 0) {
                    continue;
                }
                int max = 0;
                int minWide = leftOne[i][j];
                for (int k = i; k >= 0; --k) {
                    if (leftOne[k][j] < minWide) {
                        minWide = leftOne[k][j];
                    }
                    int area = (i - k + 1) * minWide;
                    if (area > max) {
                        max = area;
                    }
                }
                dp[i][j] = max;
                m = max > m ? max : m;
            }
        }
        return m;
    }

    public static void main(String[] args) {
        char[][] matrix = new char[][] {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        char[][] m1 = new char[][] {
                {'0', '1'},
                {'0', '1'}
        };
        E85_MaximalRectangle temp = new E85_MaximalRectangle();
        temp.maximalRectangle(matrix);
    }
}
