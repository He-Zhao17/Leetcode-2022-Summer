public class E311_SparseMatrixMultiplication {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int m = mat1.length;
        int k = mat2.length;
        int n = mat2[0].length;
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int sum = 0;
                for (int a = 0; a < k; a++) {
                    sum += mat1[i][a] * mat2[a][j];
                }
                ans[i][j] = sum;
            }
        }
        return ans;

    }
}
