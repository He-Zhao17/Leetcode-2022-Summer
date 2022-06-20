import java.util.ArrayList;
import java.util.List;

public class E54_SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int ms = 0;
        int ns = 0;
        List<Integer> ans = new ArrayList<>();
        while (m - 2 * ms != 0 && n - 2 * ns != 0) {
            if (m - 2 * ms == 1) {
                if (n - 2 * ns == 1 ){
                    ans.add(matrix[ms][ns]);
                    return ans;
                } else {
                    for (int i = ns; i < n - ns; i ++) {
                        ans.add(matrix[ms][i]);
                    }
                    return ans;
                }
            } else {
                if (n - 2 * ns == 1) {
                    for (int i = ms; i < m - ms; i++) {
                        ans.add(matrix[ns][i]);
                    }
                    return ans;
                } else {
                    for (int i = ns; i < n - ns - 1; i++) {
                        ans.add(matrix[ms][i]);
                    }
                    for (int i = ms; i < m - ms - 1; i++) {
                        ans.add(matrix[i][n - ns - 1]);
                    }
                    for (int i = n - ns - 1; i> ns; i--) {
                        ans.add(matrix[m - ms - 1][i]);
                    }
                    for (int i = m - ms - 1; i > ms; i-- ) {
                        ans.add(matrix[i][ns]);
                    }
                    ms++;
                    ns++;
                }
            }
        }
        return ans;

    }

}
