public class E59_SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int k = 1;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                ans[i][j] = k;
                k++;
            }
            for (int j = i; j < n - i - 1; j++) {
                ans[j][n - i - 1]  = k;
                k++;
            }
            for (int j = n - i - 1; j > i; j--) {
                ans[n - i - 1][j] = k;
                k++;
            }
            for (int j = n - i - 1; j > i; j--) {
                ans[j][i] = k;
                k++;
            }
        }
        if (n % 2 == 1) {
            ans[n / 2][n / 2] = n * n;
        }
        return ans;
    }

    public static void main(String[] args) {
        E59_SpiralMatrixII temp = new E59_SpiralMatrixII();
        temp.generateMatrix(3);
    }
}
