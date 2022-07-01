import java.util.ArrayList;
import java.util.Arrays;

public class E296_BestMeetingPoint {
    public int minTotalDistance(int[][] grid) {
        int[] x = new int[grid[0].length];
        int[] y = new int[grid.length];
        Arrays.fill(x, 0);
        Arrays.fill(y, 0);
        int sum = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 1) {
                    x[j]++;
                    y[i]++;
                    sum++;
                }
            }
        }
        if (sum % 2 == 0) {
            int left = sum / 2;
            int k = 0;
            int q = 0;
            int out = 0;
            int in = 0;
            for (int t = 0; t < grid[0].length; t++) {
                k += x[t];
                if (k >= left) {
                    in = t;
                    break;
                }
            }
            for (int i = 0; i < grid[0].length; i++) {
                q += y[i];
                if (q >= left) {
                    out = i;
                    break;
                }
            }
            int res = 0;
            if (k == left) {
                int sumx = 0;
                if (x[in + 1] != 0) {
                    in = x[in + 1] > x[in] ? in + 1 : in;
                } else {
                    in++;
                }
                for (int i = 0; i < grid[0].length; i++) {
                    sumx += x[i] * Math.abs(in - i);
                }
                res += sumx;
            } else {
                int sumx = 0;
                for (int i = 0; i < grid[0].length; i++) {
                    sumx += x[i] * Math.abs(in - i);
                }
                res += sumx;

            }
            if (q == left) {
                int sumy = 0;
                if (y[out + 1] != 0) {
                    out = y[out + 1] > y[out] ? out + 1 : out;
                } else {
                    out++;
                }
                for (int i = 0; i < grid.length; ++i) {
                    sumy += y[i] * Math.abs(out - i);
                }
                res += sumy;

            } else {
                int sumy = 0;
                for (int i = 0; i < grid.length; ++i) {
                    sumy += y[i] * Math.abs(out - i);
                }
                res += sumy;

            }
            return res;
        } else {
            int left = sum / 2;
            int xin = 0;
            int xk = 0;
            int yin = 0;
            int yk = 0;
            for (int i = 0; i < grid[0].length; ++i) {
                xk += x[i];
                if (xk > left) {
                    xin = i;
                    break;
                }
            }
            for (int i = 0; i < grid.length; ++i) {
                yk += y[i];
                if (yk > left) {
                    yin = i;
                    break;
                }
            }
            int sumx = 0;
            for (int i = 0; i < grid[0].length; ++i) {
                sumx += x[i] * Math.abs(xin - i);
            }
            int sumy = 0;
            for (int i = 0; i < grid.length; ++i) {
                sumy += y[i] * Math.abs(yin - i);
            }
            return sumx + sumy;

        }


    }
}
