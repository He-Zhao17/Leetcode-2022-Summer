/**
 * <p></p>
 * <p></p>
 *
 * @author: He Zhao
 * @create: 2022-07-12 19:10
 */
public class E338_CountingBIts {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; i++ ){
            if (i > 0) {
                int count = 0;
                int temp = i;
                while (temp != 0) {
                    temp = temp & (temp - 1);
                    count++;
                }
                res[i] = count;
            } else {
                res[i] = 0;
            }
        }
        return res;


    }
}
